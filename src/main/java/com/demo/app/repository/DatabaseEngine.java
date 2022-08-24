package com.demo.app.repository;

import java.sql.SQLException;
import com.demo.app.models.entities.Customer;
import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.Order;
import com.demo.app.models.entities.OrderDetail;
import com.demo.app.models.entities.Product;
import com.demo.app.models.entities.Seller;
import com.demo.app.models.entities.StockDetail;
import com.demo.app.models.entities.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * DatabaseEngine
 */
public class DatabaseEngine {
	private static DatabaseEngine databaseEngine = null;
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	// XML configuration file which exists in resources folder
	private static String configFileName = "hibernate.cfg.xml";

	public static DatabaseEngine getEngine() {
		return (databaseEngine == null) ? new DatabaseEngine() : databaseEngine;
	}

	// Singleton
	private DatabaseEngine() {
		initDatabase();
	}

	// Load database configurations and build session factory
	private static void initDatabase() {
		configuration = new Configuration();
		configuration.configure(configFileName);

		// Add entities
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Invoice.class);
		configuration.addAnnotatedClass(Seller.class);
		configuration.addAnnotatedClass(OrderDetail.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(StockDetail.class);
		configuration.addAnnotatedClass(Supplier.class);

		// SessionFactory is heavy weight object(loading configuration takes time), it
		// consumes time to create.
		// Because of that we should create one for per application.
		sessionFactory = configuration.buildSessionFactory();
	}

	// Open new session with session factory
	public Session openSession() {
		return sessionFactory.openSession();
	}

	public void closeDB() {
		sessionFactory.close();
	}

	// Get current session with session factory
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// Find entity object with given entity class and id
	public <T> T findById(Class<T> entityClass, int id) throws SQLException {
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
		if (!session.isJoinedToTransaction())
			session.beginTransaction();

		Transaction transaction = session.getTransaction();
		T entity = null;

		try {
			entity = (T) session.getReference(entityClass, id);
		} catch (Exception ex) {
			handleRollback(transaction);
			System.err.printf("Couldn't findById", ex);
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}
		// commitTransaction();
		// System.out.println(((Customer) entity).getId());
		// session.close();
		return entity;
	}

	// Insert object to database
	public void persist(Object obj) throws SQLException {
		// Session is lightweight
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
		if (!session.isJoinedToTransaction())
			session.beginTransaction();

		Transaction transaction = session.getTransaction();

		try {
			// persist is jpa specification, save is not
			session.persist(obj);
		} catch (Exception ex) {
			handleRollback(transaction);
			ex.printStackTrace();
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}
		// commitTransaction();
	}

	// Update object from database
	public void merge(Object obj) throws SQLException {
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
		if (!session.isJoinedToTransaction())
			session.beginTransaction();

		Transaction transaction = session.getTransaction();

		try {
			session.merge(obj);
			transaction.commit();
			// commitTransaction();
		} catch (Exception ex) {
			handleRollback(transaction);
			ex.printStackTrace();
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	// Delete object from database
	public void delete(Object obj) throws SQLException {
		if (session == null || !session.isOpen())
			session = sessionFactory.openSession();
		if (!session.isJoinedToTransaction())
			session.beginTransaction();

		Transaction transaction = session.getTransaction();

		try {
			session.remove(obj);
			transaction.commit();
		} catch (Exception ex) {
			handleRollback(transaction);
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

		// commitTransaction();
	}

	private void handleRollback(Transaction transaction) {
		try {
			transaction.rollback();
		} catch (Exception rollbackEx) {
			System.err.printf("Couldn't roll back transaction", rollbackEx);
		}
	}

	// Commit changes
	// private void commitTransaction() {
	// session.getTransaction().commit();
	// }

}

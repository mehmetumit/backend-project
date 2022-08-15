package com.demo.app.repository;

import com.demo.app.models.entities.Customer;
import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.Order;
import com.demo.app.models.entities.OrderDetails;
import com.demo.app.models.entities.Product;
import com.demo.app.models.entities.Seller;
import com.demo.app.models.entities.StockDetails;
import com.demo.app.models.entities.Supplier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		configuration.addAnnotatedClass(OrderDetails.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(StockDetails.class);
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

	// Get current session with session factory
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// Find entity object with given entity class and id
	public <T> T findById(Class<T> entityClass, int id) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		T entity = (T) session.getReference(entityClass.getClass(), id);

		session.close();

		return entity;
	}

	// Insert object to database
	public void persist(Object obj) {
		// Session is lightweight
		session = sessionFactory.openSession();
		session.beginTransaction();
		// persist is jpa specification, save is not
		session.persist(obj);
		commitTransaction();
		session.close();
	}

	// Update object from database
	public void merge(Object obj) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.merge(obj);
		commitTransaction();
		session.close();

	}

	// Delete object from database
	public void delete(Object obj) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.remove(obj);

		commitTransaction();
		session.close();
	}

	// Commit changes
	private void commitTransaction() {
		session.getTransaction().commit();
	}

}

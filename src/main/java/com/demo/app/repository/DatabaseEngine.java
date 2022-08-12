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
// Singleton
public class DatabaseEngine {
	private static DatabaseEngine databaseEngine = null;
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static String configFileName = "hibernate.cfg.xml";

	public static DatabaseEngine getEngine() {
		return (databaseEngine == null) ? new DatabaseEngine() : databaseEngine;
	}

	private DatabaseEngine() {
		initDatabase();
	}

	private static void initDatabase() {
		configuration = new Configuration();
		configuration.configure(configFileName);

		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Invoice.class);
		configuration.addAnnotatedClass(Seller.class);
		configuration.addAnnotatedClass(OrderDetails.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(StockDetails.class);
		configuration.addAnnotatedClass(Supplier.class);

		// SessionFactory is heavy weight object(because of applying properties), it
		// consumes time to create.
		// Because of that we should crate one time for per application.
		sessionFactory = configuration.buildSessionFactory();
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

	public void delete(Object obj) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.remove(obj);

		commitTransaction();
		session.close();
	}

	private void commitTransaction() {
		session.getTransaction().commit();
	}

}

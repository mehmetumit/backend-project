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
		Customer customer = new Customer("DemoName", "demo surname", "5345323459", "demo@demo.com", 20, true);

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

	public static void saveToDatabase(Object obj) {
		// Session is lightweight
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
		session.close();
	}

}

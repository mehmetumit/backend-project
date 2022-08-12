package com.demo.app;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.demo.app.models.entities.Customer;
import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.Order;
import com.demo.app.models.entities.OrderDetails;
import com.demo.app.models.entities.Product;
import com.demo.app.models.entities.Seller;
import com.demo.app.models.entities.StockDetails;
import com.demo.app.models.entities.Supplier;
import com.demo.app.repository.dao.CustomerDAO;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Invoice.class);
		configuration.addAnnotatedClass(Seller.class);
		configuration.addAnnotatedClass(OrderDetails.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(StockDetails.class);
		configuration.addAnnotatedClass(Supplier.class);

		// SessionFactory is heavy weight object, it will consume time to create.
		// Because of that we should crate one time for per application
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Customer customer = new Customer("DemoName", "demo surname", "5345323459", "demo@demo.com", 20, true);

		session.beginTransaction();
		session.persist(customer);
		session.getTransaction().commit();
		// session.close();

	}
}

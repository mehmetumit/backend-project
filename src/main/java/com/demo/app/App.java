package com.demo.app;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;
import com.demo.app.services.abstracts.CustomerService;
import com.demo.app.services.abstracts.OrderService;
import com.demo.app.services.implementations.CustomerServiceImpl;
import com.demo.app.services.implementations.OrderServiceImpl;
import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.models.entities.*;

import org.hibernate.Session;
import org.hibernate.sql.Delete;

class App {

	public static void main(String[] args) {
		DatabaseEngine dbEngine = DatabaseEngine.getEngine();
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		OrderServiceImpl orderService = new OrderServiceImpl();
		List<CustomerDTO> customers = customerService.getAll();
		// customers.forEach(c -> System.out.println(c));

		System.out.println(orderService.getById(1).getOrderDetails());

		// dbEngine.closeDB();

		// Fix mvn exec plugin thread issue
		// Also we can add "<cleanupDaemonThreads>false</cleanupDaemonThreads>" option
		// to fix the issue instead of System.exit(0)
		// System.exit(0);
	}
}

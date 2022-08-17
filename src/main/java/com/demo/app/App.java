package com.demo.app;

import java.sql.SQLException;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;
import com.demo.app.services.abstracts.CustomerService;
import com.demo.app.services.implementations.CustomerServiceImpl;
import com.demo.app.models.entities.*;

import org.hibernate.Session;
import org.hibernate.mapping.List;

class App {

	public static void main(String[] args) {
		DatabaseEngine dbEngine = DatabaseEngine.getEngine();
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.getAll().forEach(c -> System.out.println(c));
		dbEngine.closeDB();
		// Fix mvn exec plugin thread issue
		// Also we can add "<cleanupDaemonThreads>false</cleanupDaemonThreads>"" option
		// to fix the issue instead of System.exit(0)
		System.exit(0);
	}
}

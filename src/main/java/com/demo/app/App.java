package com.demo.app;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.demo.app.dao.CustomerDAO;
import com.demo.app.daoImpl.CustomerDAOImpl;

class App {

	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		try {
			int id = 0;

		} catch (Exception ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

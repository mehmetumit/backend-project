package com.demo.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.demo.app.dao.CategoryDAO;
import com.demo.app.daoImpl.CategoryDAOImpl;
import com.demo.app.models.Category;

class App {

	public static void main(String[] args) {
		// try {
		// Connection conn = DatabaseController.getConnection();
		// Statement st = conn.createStatement();
		// } catch (SQLException ex) {
		// Logger logger = Logger.getLogger(App.class.getName());
		// logger.log(Level.SEVERE, ex.getMessage(), ex);
		// }
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		try {
			Category category = categoryDAO.get(3);
			System.out.println(category);
		} catch (Exception ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

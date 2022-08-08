package com.demo.app;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.demo.app.dao.CategoryDAO;
import com.demo.app.daoImpl.CategoryDAOImpl;
import com.demo.app.models.Category;

class App {

	public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		try {
			Category category = categoryDAO.get(2);
			System.out.println(category);
			List<Category> catList = categoryDAO.getAll();
			for (Category cat : catList) {
				System.out.println(cat);
			}

		} catch (Exception ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

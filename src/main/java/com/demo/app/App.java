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
			int id = 10;
			System.out.println("Before update id=" + id);
			// Get one
			Category category = categoryDAO.get(id);
			System.out.println(category);
			// Get all
			List<Category> catList = categoryDAO.getAll();
			for (Category cat : catList) {
				System.out.println(cat);
			}
			// Update category
			category.setName("Updated Category");
			categoryDAO.update(category);
			// Get updated one
			category = categoryDAO.get(id);
			System.out.println("After update id=" + id);
			System.out.println(category);

		} catch (Exception ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

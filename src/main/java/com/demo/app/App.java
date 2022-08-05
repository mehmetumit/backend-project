package com.demo.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.demo.app.controllers.DatabaseController;

class App {

	public static void main(String[] args) {
		try {
			Connection conn = DatabaseController.getConnection();
			Statement st = conn.createStatement();
		} catch (SQLException ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
}

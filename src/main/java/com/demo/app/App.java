package com.demo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class App {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://0.0.0.0:54320/DemoDB";
		String user = "demo";
		String password = "demo1234";

		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER")) {
			if (rs.next()) {
				System.out.println(rs);
			}
		} catch (SQLException ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

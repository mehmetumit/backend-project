package com.demo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

class App {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://0.0.0.0:54320/DemoDB";
		String user = "demo";
		String password = "demo1234";
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		// props.setProperty("ssl", "true");
		String testQuery = "SELECT * FROM CUSTOMER";

		try (Connection con = DriverManager.getConnection(url, props);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(testQuery)) {
			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("customer_name");
				String surname = rs.getString("surname");
				String phoneNum = rs.getString("phone_num");
				String email = rs.getString("email");
				int discountRate = rs.getShort("discount_rate");
				boolean isActive = rs.getBoolean("is_active");

				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("surname: " + surname);
				System.out.println("phone_num: " + phoneNum);
				System.out.println("email: " + email);
				System.out.println("discount_rate: " + discountRate);
				System.out.println("is_active: " + isActive);

			}
		} catch (SQLException ex) {
			Logger logger = Logger.getLogger(App.class.getName());
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
}

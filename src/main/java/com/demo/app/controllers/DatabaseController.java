package com.demo.app.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseController {
	private static String dbName = "demodb";
	private static String url = "jdbc:postgresql://localhost:54320/" + dbName;
	private static String user = "demo";
	private static String password = "demo1234";
	private static Properties props = new Properties();

	public static Connection getConnection() throws SQLException {
		props.setProperty("user", user);
		props.setProperty("password", password);
		// props.setProperty("ssl", "true");
		Connection conn = DriverManager.getConnection(url, props);
		// Statement st = conn.createStatement();
		return conn;
	}

}

package com.demo.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseService {
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

	// We should close Statements, ResultSets, PreparedStatements and Connection
	// when we no longer need them
	public static void closePreparedStatement(PreparedStatement ps) throws SQLException {
		ps.close();
	}

	public static void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		rs.close();
	}

	public static void closeStatement(Statement st) throws SQLException {
		st.close();
	}

}

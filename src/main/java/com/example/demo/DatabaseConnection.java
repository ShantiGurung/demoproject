package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection getConnetion() throws Exception {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/systemdemo", "postgres",
					"postgres");
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
		return connection;

	}

}

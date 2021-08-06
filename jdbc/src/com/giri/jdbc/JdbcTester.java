package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";
		String fqnOfDriverImple = "com.mysql.cj.jdbc.driver";
		try {

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
			String query = "insert into insurance_table values (10,'darshan','health',10,'LIC',34567)";
			Statement statement = connection.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

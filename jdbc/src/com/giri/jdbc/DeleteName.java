package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteName {

	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println(connection);
			String query = "delete from scam_table   where scam_name='The Hawala Scandal'";
			Statement statement = connection.createStatement();
			statement.execute(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

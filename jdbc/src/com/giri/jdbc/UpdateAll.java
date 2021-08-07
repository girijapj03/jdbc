package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAll {

	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println(connection);
			String query = "update scam_table set scam_amount='135000cr',scam_location='newdelhi',scam_type='finacial' where s_id=119";
			Statement statement = connection.createStatement();
			statement.execute(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateName {

	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";
	
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println(connection);
			String query = "update scam_table set  scam_amount='124000cr' where scam_name ='CommonWealthGamesScam'";
			Statement statement = connection.createStatement();
			statement.execute(query);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

}
}

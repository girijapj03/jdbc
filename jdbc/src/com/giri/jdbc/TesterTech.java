package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterTech {
	static Connection connection;

	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";
		String fqnOfDriverImple = "com.mysql.cj.jdbc.driver";
		try {

			 connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
			String query = "insert into tech_table values (10,'January',1996,'JDK 1.0'),(12,'February',1997,'JDK 1.1'),(13,'December ',1998,'J2SE 1.2'),(14,'May',2000,'J2SE 1.3'),(15,'May',2000,'J2SE 1.3'),(16,'February',2002,'J2SE 1.4')";
			Statement statement = connection.createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

package com.giri.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.giri.scam.constants.JdbcConstants;
import com.giri.scam.dto.ScamDTO;

public class TotalScams {

	public static void main(String[] args) {
		try (Connection connect = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			String query = "select count(s_name) from scam";
			Statement st = connect.createStatement();
			st.execute(query);
			ResultSet result = st.getResultSet();

			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("Number of Scams : " + count);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

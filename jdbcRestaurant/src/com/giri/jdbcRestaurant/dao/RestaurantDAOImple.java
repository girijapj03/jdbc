package com.giri.jdbcRestaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.giri.jdbcRestaurant.constant.JdbcConstants;
import com.giri.jdbcRestaurant.dto.RestaurantDTO;

public class RestaurantDAOImple implements RestaurantDAO {

	@Override
	public int Save(RestaurantDTO dto) {
		System.out.println("saving dto in db" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table values(1,'" + dto.getName() + "','" + dto.getLocation() + "','" + dto.getSpecial() + "'," + dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return 0;
	}

}

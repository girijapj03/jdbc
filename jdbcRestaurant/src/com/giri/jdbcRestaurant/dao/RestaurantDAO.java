package com.giri.jdbcRestaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.giri.jdbcRestaurant.constant.*;
import com.giri.jdbcRestaurant.dto.RestaurantDTO;

public interface RestaurantDAO {
	int Save(RestaurantDTO dto);

	RestaurantDTO findByName(String name);

	default boolean updateTypeByName(TypeEnum newType, String name) {

		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			connection.setAutoCommit(false);
			String query = "update  restaurant_table set r_type='" + TypeEnum.CAFE + "' where r_name ='" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet rs = statement.getResultSet();
			connection.commit();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	default boolean deleteTypeByName(TypeEnum newType, String name) {
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			connection.setAutoCommit(false);
			String query = "delete from  restaurant_table  where r_type='" + newType + "' AND r_name ='" + name + "'  ";
			Statement statement = connection.createStatement();
			statement.execute(query);
			int check = statement.executeUpdate(query);
			System.out.println(check);
			if (check == 0) {
				System.out.println("nothing to delete");
			}

			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}

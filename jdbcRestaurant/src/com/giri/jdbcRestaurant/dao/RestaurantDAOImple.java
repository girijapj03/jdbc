package com.giri.jdbcRestaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.giri.jdbcRestaurant.constant.*;
import com.giri.jdbcRestaurant.dto.RestaurantDTO;

public class RestaurantDAOImple implements RestaurantDAO {
	static int aiID;

	@Override
	public int Save(RestaurantDTO dto) {
		System.out.println("saving dto in db" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table(r_name,r_location,r_special,r_best,r_type) values('"
					+ dto.getName() + "','" + dto.getLocation() + "','" + dto.getSpecial() + "'," + dto.isBest() + ",'"
					+ dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				int aiID = rs.getInt(1);
				System.out.println(aiID);
			}
			connection.commit();
			return aiID;
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

	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			String query = "select * from  restaurant_table where r_name ='" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet rs=statement.getResultSet();
			if (rs.next()) {
				int id = rs.getInt("r_id");
				String resName = rs.getString("r_name");
				String location = rs.getString("r_location");
				String special = rs.getString("r_special");
				String type = rs.getString("r_type");
				boolean best = rs.getBoolean("r_best");
				System.out.println("typr to enum by using valueOf" + type);
				RestaurantDTO dto = new RestaurantDTO(resName, location, special, TypeEnum.valueOf(type), best);
				dto.setId(id);
				return dto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
         return null;
	}
	@Override
	public Collection<RestaurantDTO> findByType(TypeEnum type) {
		Collection<RestaurantDTO> collection = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT * FROM restaurant WHERE r_type = '" + type + "'";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String name = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String special = resultSet.getString("r_specialFood");
				boolean best = resultSet.getBoolean("r_best");
				String resType = resultSet.getString("r_type");
				System.out.println("Find By Type " + type);
				RestaurantDTO dto = new RestaurantDTO(name, location, special, best, RestaurantType.valueOf(resType));
				dto.setId(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

}

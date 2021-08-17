package com.giri.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import com.giri.customer.constant.Education;
import com.giri.customer.constant.JdbcConstants;
import com.giri.customer.dto.CustomerDTO;

public class CustomerDAOImple implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		int aiId = 0;
		System.out.println("*****saving dto ******" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer_table(customer_name,customer_from,customer_to,customer_addr,customer_married,customer_pasportno,customer_edu) values(?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			setValues(dto, pre);
			ResultSet resultSet = pre.getGeneratedKeys();
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
			}
			dto.setId(aiId);
			connection.commit();
			System.out.println(dto);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return aiId;
	}

	private void setValues(CustomerDTO dto, PreparedStatement pre) throws SQLException {
		pre.setString(1, dto.getName());
		pre.setString(2, dto.getFrom());
		pre.setString(3, dto.getTo());
		pre.setString(4, dto.getAddress());
		pre.setBoolean(5, dto.isMarried());
		pre.setInt(6, dto.getPassportNo());
		pre.setString(7, dto.getType().toString());
		pre.execute();
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		System.out.println("save all");
		collection.stream().forEach(dto->save(dto));
		
	}

	

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from customer_table";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from customer_table ";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "SELECT *FROM customer_table  ORDER BY  customer_name DESC";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public int total() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select count(id) from customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			//String dupli="SELECT customer_pasportno,COUNT(*) FROM customer_table GROUP BY customer_pasportno HAVING count(*)>1";
			//ResultSet result =createdFromPreparedStatement(connection, dupli);
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();
		ResultSet result = prepare.getResultSet();
		return result;
	}

	private CustomerDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("customer_name");
		String from = result.getString("customer_from");
		String to = result.getString("customer_to");
		String address = result.getString("customer_addr");
		boolean married = result.getBoolean("customer_married");
		int passport = result.getInt("customer_pasportno");
		String edu = result.getString("customer_edu");
		CustomerDTO dto = new CustomerDTO(name, from, to, address, passport, married, Education.valueOf(edu));
//Education type-enum type so need to convert in into string		
//customer_name,customer_from,customer_to,customer_addr,customer_married,customer_passportno,customer_edu
		dto.setId(id);
		return dto;
	}

}

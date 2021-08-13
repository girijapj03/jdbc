package com.girija.webseries.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Optional;
import java.util.function.Predicate;

import com.girija.webseries.constant.*;
import com.girija.webseries.dto.WebSeriesDTO;

public class WebSeriesDAOImpl implements WebSeriesDAO {
	@Override

	public int save(WebSeriesDTO dto) {
		int aiId = 0;
		System.out.println("*****saving dto ******" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries_table(web_name,web_noOfEp,web_totalseason,streaming,web_type,web_ageLimit) values(?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1, dto.getWebName());
			pre.setInt(2, dto.getNoOfEpisodes());
			pre.setInt(3, dto.getTotalSeasons());
			pre.setString(4, dto.getStreaming().toString());
			pre.setString(5, dto.getWebType().toString());
			pre.setInt(6, dto.getYestAgeIndNodBahudu());
			pre.execute();
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

	@Override
	public int total() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select count(id) from webseries_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public int findMaxSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select max(web_totalseason) from webseries_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	@Override
	public int findMinSeason() {
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select MIN(web_totalseason) from webseries_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			if (result.next()) {
				temp = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	@Override
	public Collection<WebSeriesDTO> findAllSortByNameDesc() {
		Collection<WebSeriesDTO> collection = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from webseries_table  order by web_name desc";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				WebSeriesDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate) {
		Optional<WebSeriesDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from webseries_table";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				WebSeriesDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();
		ResultSet result = prepare.getResultSet();
		return result;
	}

	private WebSeriesDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("web_name");
		int episodes = result.getInt("web_noOfEp");
		int season = result.getInt("web_totalseason");
		String streamed = result.getString("streaming");
		String genre = result.getString("web_type");
		int yestAgeIndaNodbohudu = result.getInt("web_ageLimit");
//int id, String webName, int noOfEpisodes, int totalSeasons, int yestAgeIndNodBahudu,
		// StreamedIN streaming, GenreType webType
		WebSeriesDTO dto = new WebSeriesDTO(name, episodes, season, yestAgeIndaNodbohudu, StreamedIN.valueOf(streamed),
				GenreType.valueOf(genre));
		dto.setId(id);
		return dto;
	}

	@Override
	public boolean saveAll(Collection<WebSeriesDTO> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<WebSeriesDTO> findAll() {
		Collection<WebSeriesDTO> collection = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from webseries_table ";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				WebSeriesDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate) {
		Collection<WebSeriesDTO> collection = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {
			String query = "select * from webseries_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				WebSeriesDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}
}

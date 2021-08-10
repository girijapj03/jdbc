package com.giri.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.giri.scam.constants.JdbcConstants;
import com.giri.scam.dto.ScamDTO;

public class GetLatestscam {

	public static void main(String[] args) {
		try (Connection connect = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			String query = "SELECT * FROM scam WHERE s_year = (SELECT MAX(s_year) FROM scam)";

			Statement st = connect.createStatement();
			st.execute(query);
			ResultSet result = st.getResultSet();
			ScamDTO dto = null;
			List<ScamDTO> dt = new ArrayList<ScamDTO>();
			while (result.next()) {
				ScamDTO def = new ScamDTO();
				def.setYear(result.getDate("s_year"));
				int id = result.getInt("s_id");
				String name = result.getString("s_name");
				Date year = result.getDate("s_year");
				String by = result.getString("s_by");
				String location = result.getString("s_location");
				String descr = result.getString("s_description");
				Double amount = result.getDouble("s_amount");
                System.out.println(name);
                 dto = new ScamDTO(id, name, year, by, location, descr, amount);
				System.out.println(dto);
				System.out.println(dto.hashCode());
				dt.add(def);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

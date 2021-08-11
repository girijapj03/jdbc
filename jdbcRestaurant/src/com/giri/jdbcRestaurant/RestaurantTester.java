package com.giri.jdbcRestaurant;

import com.giri.jdbcRestaurant.ENUMCONstant.TypeEnum;
import com.giri.jdbcRestaurant.dao.RestaurantDAO;
import com.giri.jdbcRestaurant.dao.RestaurantDAOImple;
import com.giri.jdbcRestaurant.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {
		RestaurantDTO dto=new RestaurantDTO("Second Wife", "Mudhol", "Chicken-lollipop", TypeEnum.DINER, true);
		RestaurantDAO dao=new RestaurantDAOImple();
		dao.Save(dto);

	}

}

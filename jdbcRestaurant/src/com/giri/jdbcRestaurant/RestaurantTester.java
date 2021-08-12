package com.giri.jdbcRestaurant;

import com.giri.jdbcRestaurant.constant.*;
import com.giri.jdbcRestaurant.dao.RestaurantDAO;
import com.giri.jdbcRestaurant.dao.RestaurantDAOImple;
import com.giri.jdbcRestaurant.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {
		RestaurantDTO dto=new RestaurantDTO("The Park", "Mudhol", "Dhum Biryani", TypeEnum.FAST_CASUAL, true);
		
		RestaurantDAO dao=new RestaurantDAOImple();
		dao.Save(dto);
		RestaurantDTO dto1=dao.findByName("Niyaaz");
		System.out.println(dto1);
		boolean check=dao.updateTypeByName(TypeEnum.FAST_FOOD,"Niyaaz");
		
		System.out.println("found :"+check);
		
		boolean del=dao.deleteTypeByName(TypeEnum.CAFE,"");
	
		System.out.println("deleted :"+ del );
		
	}

}

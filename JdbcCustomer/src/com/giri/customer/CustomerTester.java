package com.giri.customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.giri.customer.constant.Education;
import com.giri.customer.dao.CustomerDAO;
import com.giri.customer.dao.CustomerDAOImple;
import com.giri.customer.dto.CustomerDTO;
import com.giri.customer.service.CustomerService;
import com.giri.customer.service.CustomerServiceValid;

public class CustomerTester {

	public static void main(String[] args) {
		CustomerDTO dto = new CustomerDTO("Abi", "Banglore", "SwizerLand", "Mudhol", 12345, false, Education.BE);
		CustomerDTO dto1 = new CustomerDTO("Mutturaj", "Delhi", "VArnasi", "Banglore", 45678, true, Education.BE);
		CustomerDTO dto2 = new CustomerDTO("Pooja", "Banglore", "OOTy", "Jamkhandi", 89870, true, Education.B_COM);
		CustomerService service = new CustomerServiceValid();
		service.validateAndSave(dto);
		service.validateAndSave(dto1);
		service.validateAndSave(dto2);
		CustomerDAO dao = new CustomerDAOImple();//no need to call dao ,validate using service
		Collection<CustomerDTO> collection =service.findAll();
		service.valindateAndSaveAll(collection);
		Optional<CustomerDTO> findOne = service.findOne((g) -> g.getName().equalsIgnoreCase("abi"));
		if (findOne.isPresent()) {
			CustomerDTO temp = findOne.get();
		System.out.println(" optional findOne():" + temp);
		}
		Collection<CustomerDTO> collection1 = service.findAllSortByNameDesc();
		collection1.forEach((desc) -> System.out.println("sorting name in descending order:" + desc));

		Collection<CustomerDTO> findAll = service.findAll((g) -> g.isMarried() == true);
		findAll.forEach((pre) -> System.out.println(" predicate:" + pre));

		
		dao.saveAll(collection);
		System.out.println(service.total());
		
	}

}

package com.giri.customer.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.giri.customer.dto.CustomerDTO;

public interface CustomerService {
	int validateAndSave(CustomerDTO dto);

	boolean valindateAndSaveAll(Collection<CustomerDTO> collection);
	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAll();

	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAllSortByNameDesc();

	int total();
}

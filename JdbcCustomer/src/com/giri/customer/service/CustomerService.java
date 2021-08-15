package com.giri.customer.service;

import java.util.Collection;

import com.giri.customer.dto.CustomerDTO;

public interface CustomerService {
	int validateAndSave(CustomerDTO dto);

	boolean valindateAndSaveAll(Collection<CustomerDTO> collection);
}

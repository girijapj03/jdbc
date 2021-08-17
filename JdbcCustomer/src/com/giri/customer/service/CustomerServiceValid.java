package com.giri.customer.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.giri.customer.dao.CustomerDAO;
import com.giri.customer.dao.CustomerDAOImple;
import com.giri.customer.dto.CustomerDTO;

public class CustomerServiceValid implements CustomerService {
	private CustomerDAO dao = new CustomerDAOImple();
	boolean nameVAlidate = false;
	boolean fromVAlidate = false;
	boolean toVAlidate = false;
	boolean addressValidate = false;
	boolean allValidate = false;

	@Override
	public int validateAndSave(CustomerDTO dto) {
		System.out.println("Checking ...");

		if (dto != null) {
			String name = dto.getName();
			String from = dto.getFrom();
			String to = dto.getTo();
			String addr = dto.getAddress();

			if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 50) {
				System.out.println("name is valid");
				nameVAlidate = true;
			} else {
				System.out.println("name is invalid");
				nameVAlidate = false;
			}
			if (from != null && !from.isEmpty() && from.length() > 3 && from.length() <= 50) {
				System.out.println("from is valid");
				fromVAlidate = true;
			} else {
				System.out.println("from is invalid");
				fromVAlidate = false;
			}
			if (to != null && !to.isEmpty() && to.length() > 3 && to.length() <= 50) {
				System.out.println("to is valid");
				toVAlidate = true;
			} else {
				System.out.println("to is invalid");
				toVAlidate = false;
			}
			if (addr != null && !addr.isEmpty() && addr.length() > 3 && addr.length() <= 50) {
				System.out.println("address is valid");
				addressValidate = true;
			} else {
				System.out.println("address is invalid");
				addressValidate = false;
			}

			if (fromVAlidate && toVAlidate && addressValidate && nameVAlidate) {
				System.out.println("data is valid");
				dao.save(dto);
				// return "SUCCESS";
				return 1;
			}
		}
		return 0;
	}

	@Override
	public boolean valindateAndSaveAll(Collection<CustomerDTO> collection) {

		if (!collection.isEmpty()) {
			collection.forEach(dto -> {
				this.validateAndSave(dto);
			});
		}

		return false;

	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {

		return dao.findOne(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAll() {

		return dao.findAll();
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {

		return dao.findAll(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {

		return dao.findAllSortByNameDesc();
	}

	@Override
	public int total() {

		return dao.total();
	}

}

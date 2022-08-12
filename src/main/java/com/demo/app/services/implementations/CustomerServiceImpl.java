package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.models.entities.Customer;
import com.demo.app.services.abstracts.CustomerService;

/**
 * CustomerServiceImpl
 */
public class CustomerServiceImpl implements CustomerService {

	@Override
	public int add(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO toDTO(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer toEntity(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerDTO> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getBySurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getByActive(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getByDiscountRate(int discountRate) {
		// TODO Auto-generated method stub
		return null;
	}

}

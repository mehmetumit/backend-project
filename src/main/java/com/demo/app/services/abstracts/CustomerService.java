package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.models.entities.Customer;

/**
 * CustomerService
 */
public interface CustomerService extends Service<CustomerDTO, Customer> {

	@Override
	public CustomerDTO add(CustomerDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<CustomerDTO> getAll();

	@Override
	public CustomerDTO getById(int id);

	@Override
	public CustomerDTO toDTO(Customer entity);

	@Override
	public Customer toEntity(CustomerDTO dto);

	@Override
	public CustomerDTO update(int id, CustomerDTO dto);

	@Override
	public List<CustomerDTO> findAll(HashMap<String, Object> dataMap);

	public List<CustomerDTO> getByName(String name);

	public List<CustomerDTO> getBySurname(String surname);

	public List<CustomerDTO> getByPhoneNum(String phoneNum);

	public List<CustomerDTO> getByEmail(String email);

	public List<CustomerDTO> getByActive(boolean isActive);

	public List<CustomerDTO> getByDiscountRate(int discountRate);

}

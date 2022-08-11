package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.models.entities.Customer;

/**
 * CustomerService
 */
public interface CustomerService extends Service<CustomerDTO, Customer> {

	@Override
	int add(CustomerDTO dto);

	@Override
	int delete(long id);

	@Override
	List<CustomerDTO> getAll();

	@Override
	CustomerDTO getById(long id);

	@Override
	CustomerDTO toDTO(Customer entity);

	@Override
	Customer toEntity(CustomerDTO dto);

	@Override
	int update(CustomerDTO dto);

	List<CustomerDTO> getByName(String name);

	List<CustomerDTO> getBySurname(String surname);

	CustomerDTO getByPhoneNum(String phoneNum);

	CustomerDTO getByEmail(String email);

	List<CustomerDTO> getByActive(boolean isActive);

	List<CustomerDTO> getByDiscountRate(int discountRate);
}

package com.demo.app.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.models.entities.Customer;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.CustomerDAO;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;
import com.demo.app.services.abstracts.CustomerService;
import com.demo.app.services.abstracts.OrderService;

/**
 * CustomerServiceImpl
 */
public class CustomerServiceImpl implements CustomerService {
	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static OrderService orderService = new OrderServiceImpl();

	@Override
	public int add(CustomerDTO dto) {
		try {
			dto.setOrders(dto.getOrders()
					.stream()
					.map(order -> orderService.getById(order.getId()))
					.collect(Collectors.toList()));
			customerDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Customer insertion failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			customerDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println("Customer deletion failed!");
			return 0;
		}
	}

	@Override
	public List<CustomerDTO> getAll() {
		try {
			return customerDAO.getAll().stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getAll failed!");
			return null;
		}
	}

	@Override
	public CustomerDTO getById(int id) {
		try {
			return toDTO(customerDAO.findById(id));
		} catch (Exception e) {
			System.out.println("Customer getById failed!");
			return null;
		}
	}

	@Override
	public CustomerDTO toDTO(Customer entity) {
		return Objects.nonNull(entity) ? new CustomerDTO()
				.setId(entity.getId())
				.setName(entity.getName())
				.setSurname(entity.getSurname())
				.setPhoneNum(entity.getPhoneNum())
				.setEmail(entity.getEmail())
				.setActive(entity.isActive())
				.setDiscountRate(entity.getDiscountRate())
				.setOrders(entity.getOrders()
						.stream()
						.map(order -> orderService.toDTO(order))
						.collect(Collectors.toList()))
				: null;
	}

	@Override
	public Customer toEntity(CustomerDTO dto) {
		return new Customer()
				.setId(dto.getId())
				.setName(dto.getName())
				.setSurname(dto.getSurname())
				.setPhoneNum(dto.getPhoneNum())
				.setEmail(dto.getEmail())
				.setActive(dto.isActive())
				.setDiscountRate(dto.getDiscountRate())
				.setOrders(dto.getOrders()
						.stream()
						.map(order -> orderService.toEntity(order))
						.collect(Collectors.toList()));
	}

	@Override
	public int update(int id, CustomerDTO dto) {
		try {
			dto.setOrders(dto.getOrders()
					.stream()
					.map(order -> orderService.getById(order.getId()))
					.collect(Collectors.toList()));
			customerDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Customer update failed!");
			return 0;
		}
	}

	@Override
	public List<CustomerDTO> getByName(String name) {
		try {
			return customerDAO.findByName(name)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getByName failed!");
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getBySurname(String surname) {
		try {
			return customerDAO.findBySurname(surname)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getBySurname failed!");
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getByPhoneNum(String phoneNum) {
		try {
			return customerDAO.findByPhoneNum(phoneNum)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getByPhoneNum failed!");
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getByEmail(String email) {
		try {
			return customerDAO.findByEmail(email)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getByEmail failed!");
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getByActive(boolean isActive) {
		try {
			return customerDAO.findByActive(isActive)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getByActive failed!");
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getByDiscountRate(int discountRate) {
		try {
			return customerDAO.findByDiscountRate(discountRate)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Customer getByDiscountRate failed!");
			return null;
		}
	}

	// @Override
	// public HashMap<String, Object> getDataMap() {
	// return customerDAO.generateDataMap();
	// }

	@Override
	public List<CustomerDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return customerDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Customer findAll failed!");
			return null;
		}

	}

}

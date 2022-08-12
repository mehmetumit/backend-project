package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.OrderDetailsDTO;
import com.demo.app.models.entities.OrderDetails;
import com.demo.app.services.abstracts.OrderDetailsService;

/**
 * OrderDetailsServiceImpl
 */
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Override
	public int add(OrderDetailsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDetailsDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailsDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailsDTO toDTO(OrderDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails toEntity(OrderDetailsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(OrderDetailsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDetails> getByQuantity(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}

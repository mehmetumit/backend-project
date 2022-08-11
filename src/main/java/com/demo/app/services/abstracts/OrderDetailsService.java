package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.OrderDetailsDTO;
import com.demo.app.models.entities.OrderDetails;

/**
 * OrderDetailsService
 */
public interface OrderDetailsService extends Service<OrderDetailsDTO, OrderDetails> {

	@Override
	public int add(OrderDetailsDTO dto);

	@Override
	public int delete(long id);

	@Override
	public List<OrderDetailsDTO> getAll();

	@Override
	public OrderDetailsDTO getById(long id);

	@Override
	public OrderDetailsDTO toDTO(OrderDetails entity);

	@Override
	public OrderDetails toEntity(OrderDetailsDTO dto);

	@Override
	public int update(OrderDetailsDTO dto);

	public List<OrderDetails> getByQuantity(int quantity);

}

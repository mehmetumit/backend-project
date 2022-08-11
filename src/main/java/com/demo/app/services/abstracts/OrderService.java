package com.demo.app.services.abstracts;

import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.dtos.OrderDTO;
import com.demo.app.models.entities.Order;

/**
 * OrderService
 */
public interface OrderService extends Service<OrderDTO, Order> {

	@Override
	public int add(OrderDTO dto);

	@Override
	public int delete(long id);

	@Override
	public List<OrderDTO> getAll();

	@Override
	public OrderDTO getById(long id);

	@Override
	public OrderDTO toDTO(Order entity);

	@Override
	public Order toEntity(OrderDTO dto);

	@Override
	public int update(OrderDTO dto);

	public List<Order> getByTimestamp(Timestamp timestamp);

}

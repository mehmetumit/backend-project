package com.demo.app.services.abstracts;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.OrderDTO;
import com.demo.app.models.entities.Order;

/**
 * OrderService
 */
public interface OrderService extends Service<OrderDTO, Order> {
	@Override
	public OrderDTO add(OrderDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<OrderDTO> getAll();

	@Override
	public OrderDTO getById(int id);

	@Override
	public OrderDTO toDTO(Order entity);

	@Override
	public Order toEntity(OrderDTO dto);

	@Override
	public OrderDTO update(int id, OrderDTO dto);

	public List<OrderDTO> getByTimestamp(Timestamp timestamp);

	@Override
	public List<OrderDTO> findAll(HashMap<String, Object> dataMap);

}

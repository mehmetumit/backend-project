package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.OrderDetailDTO;
import com.demo.app.models.entities.OrderDetail;

/**
 * OrderDetailsService
 */
public interface OrderDetailService extends Service<OrderDetailDTO, OrderDetail> {
	@Override
	int add(OrderDetailDTO dto);

	@Override
	int delete(int id);

	@Override
	List<OrderDetailDTO> getAll();

	@Override
	OrderDetailDTO getById(int id);

	@Override
	OrderDetailDTO toDTO(OrderDetail entity);

	@Override
	OrderDetail toEntity(OrderDetailDTO dto);

	@Override
	int update(int id, OrderDetailDTO dto);

	public List<OrderDetailDTO> getByQuantity(int quantity);
}

package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.StockDetailsDTO;
import com.demo.app.models.entities.StockDetails;

/**
 * StockDetailsService
 */
public interface StockDetailsService extends Service<StockDetailsDTO, StockDetails> {

	@Override
	int add(StockDetailsDTO dto);

	@Override
	int delete(long id);

	@Override
	List<StockDetailsDTO> getAll();

	@Override
	StockDetailsDTO getById(long id);

	@Override
	StockDetailsDTO toDTO(StockDetails entity);

	@Override
	StockDetails toEntity(StockDetailsDTO dto);

	@Override
	int update(StockDetailsDTO dto);

	public List<StockDetails> findByQuantity(int quantity);
}

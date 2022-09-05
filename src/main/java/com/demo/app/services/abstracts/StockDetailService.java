package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.StockDetailDTO;
import com.demo.app.models.entities.StockDetail;

/**
 * StockDetailService
 */
public interface StockDetailService extends Service<StockDetailDTO, StockDetail> {

	@Override
	StockDetailDTO add(StockDetailDTO dto);

	@Override
	int delete(int id);

	@Override
	List<StockDetailDTO> getAll();

	@Override
	StockDetailDTO getById(int id);

	@Override
	StockDetailDTO toDTO(StockDetail entity);

	@Override
	StockDetail toEntity(StockDetailDTO dto);

	@Override
	StockDetailDTO update(int id, StockDetailDTO dto);

	public List<StockDetailDTO> getByQuantity(int quantity);

	@Override
	public List<StockDetailDTO> findAll(HashMap<String, Object> dataMap);
}

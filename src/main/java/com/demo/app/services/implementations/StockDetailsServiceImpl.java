package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.StockDetailsDTO;
import com.demo.app.models.entities.StockDetails;
import com.demo.app.services.abstracts.StockDetailsService;

/**
 * StockDetailsServiceImpl
 */
public class StockDetailsServiceImpl implements StockDetailsService {

	@Override
	public int add(StockDetailsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StockDetailsDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDetailsDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDetailsDTO toDTO(StockDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDetails toEntity(StockDetailsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(StockDetailsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StockDetails> findByQuantity(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}

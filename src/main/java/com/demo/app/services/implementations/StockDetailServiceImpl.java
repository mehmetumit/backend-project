package com.demo.app.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.StockDetailDTO;
import com.demo.app.models.entities.StockDetail;
import com.demo.app.repository.dao.StockDetailDAO;
import com.demo.app.repository.daoImpl.StockDetailDAOImpl;
import com.demo.app.services.abstracts.StockDetailService;

/**
 * StockDetailServiceImpl
 */
public class StockDetailServiceImpl implements StockDetailService {
	StockDetailDAO stockDetailDAO = new StockDetailDAOImpl();

	@Override
	public int add(StockDetailDTO dto) {
		try {
			stockDetailDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			System.out.println("StockDetail add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			stockDetailDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("StockDetail delete failed!");
			return 0;
		}
	}

	@Override
	public List<StockDetailDTO> getAll() {
		try {
			return stockDetailDAO.getAll()
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("StockDetail getAll failed!");
			return null;
		}
	}

	@Override
	public StockDetailDTO getById(int id) {
		try {
			return toDTO(stockDetailDAO.findById(id));
		} catch (Exception e) {
			System.out.println("StockDetail getById failed!");
			return null;
		}
	}

	@Override
	public StockDetailDTO toDTO(StockDetail entity) {
		return new StockDetailDTO()
				.setQuantity(entity.getQuantity());
	}

	@Override
	public StockDetail toEntity(StockDetailDTO dto) {
		return new StockDetail()
				.setQuantity(dto.getQuantity());
	}

	@Override
	public int update(int id, StockDetailDTO dto) {
		try {
			stockDetailDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			System.out.println("StockDetail update failed!");
			return 0;
		}
	}

	@Override
	public List<StockDetailDTO> getByQuantity(int quantity) {
		try {
			return stockDetailDAO.findByQuantity(quantity)
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("StockDetail getByQuantity failed!");
			return null;
		}
	}

	@Override
	public List<StockDetailDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return stockDetailDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("StockDetail findAll failed!");
			System.out.println(e);
			return null;
		}

	}

}

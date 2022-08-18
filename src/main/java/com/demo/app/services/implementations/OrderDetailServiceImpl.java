package com.demo.app.services.implementations;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.OrderDetailDTO;
import com.demo.app.models.entities.OrderDetail;
import com.demo.app.repository.daoImpl.OrderDetailDAOImpl;
import com.demo.app.repository.dao.OrderDetailDAO;
import com.demo.app.services.abstracts.OrderDetailService;
import com.demo.app.services.abstracts.ProductService;

/**
 * OrderDetailServiceImpl
 */
public class OrderDetailServiceImpl implements OrderDetailService {
	private static OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	private static ProductService productService = new ProductServiceImpl();

	@Override
	public int add(OrderDetailDTO dto) {
		try {
			orderDetailDAO.insert(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("OrderDetail add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			orderDetailDAO.delete(id);
			return 1;
		} catch (SQLException e) {
			System.out.println("OrderDetail delete failed!");
			return 0;
		}
	}

	@Override
	public List<OrderDetailDTO> getAll() {
		try {
			return orderDetailDAO.getAll()
					.stream()
					.map(o -> toDTO(o))
					.collect(Collectors.toList());
		} catch (SQLException e) {
			System.out.println("OrderDetail getAll failed!");
			return null;
		}
	}

	@Override
	public OrderDetailDTO getById(int id) {
		try {
			return toDTO(orderDetailDAO.findById(id));
		} catch (SQLException e) {
			System.out.println("OrderDetail getById failed!");
			return null;
		}
	}

	@Override
	public OrderDetailDTO toDTO(OrderDetail entity) {
		return new OrderDetailDTO()
				.setQuantity(entity.getQuantitiy())
				.setProduct(productService.toDTO(entity.getProduct()));
	}

	@Override
	public OrderDetail toEntity(OrderDetailDTO dto) {
		return new OrderDetail()
				.setQuantity(dto.getQuantity())
				.setProduct(productService.toEntity(dto.getProduct()));
	}

	@Override
	public int update(OrderDetailDTO dto) {
		try {
			orderDetailDAO.update(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("OrderDetail update failed!");
			return 0;
		}
	}

	@Override
	public List<OrderDetailDTO> getByQuantity(int quantity) {
		try {
			return orderDetailDAO.findByQuantity(quantity)
					.stream()
					.map(o -> toDTO(o))
					.collect(Collectors.toList());
		} catch (SQLException e) {
			System.out.println("OrderDetail getByQuantity failed!");
			return null;
		}
	}

}

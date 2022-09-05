package com.demo.app.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.OrderDetailDTO;
import com.demo.app.models.dtos.ProductDTO;
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
	public OrderDetailDTO add(OrderDetailDTO dto) {
		try {
			ProductDTO product = dto.getProduct();
			if (Objects.nonNull(product))
				dto.setProduct(productService.getById(product.getId()));
			return toDTO(orderDetailDAO.insert(toEntity(dto)));
		} catch (Exception e) {
			System.out.println("OrderDetail add failed!");
			return null;
		}
	}

	@Override
	public int delete(int id) {
		try {
			orderDetailDAO.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
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
		} catch (Exception e) {
			System.out.println("OrderDetail getAll failed!");
			return null;
		}
	}

	@Override
	public OrderDetailDTO getById(int id) {
		try {
			return toDTO(orderDetailDAO.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("OrderDetail getById failed!");
			return null;
		}
	}

	@Override
	public OrderDetailDTO toDTO(OrderDetail entity) {
		return Objects.nonNull(entity) ? new OrderDetailDTO()
				.setId(entity.getId())
				.setQuantity(entity.getQuantitiy())
				.setProduct(productService.toDTO(entity.getProduct()))
				: null;
	}

	@Override
	public OrderDetail toEntity(OrderDetailDTO dto) {
		return Objects.nonNull(dto) ? new OrderDetail()
				.setId(dto.getId())
				.setQuantity(dto.getQuantity())
				.setProduct(productService.toEntity(dto.getProduct()))
				: null;
	}

	@Override
	public OrderDetailDTO update(int id, OrderDetailDTO dto) {
		try {
			ProductDTO product = dto.getProduct();
			if (Objects.nonNull(product))
				dto.setProduct(productService.getById(product.getId()));
			return toDTO(orderDetailDAO.update(toEntity(dto).setId(id)));
		} catch (Exception e) {
			System.out.println("OrderDetail update failed!");
			return null;
		}
	}

	@Override
	public List<OrderDetailDTO> getByQuantity(int quantity) {
		try {
			return orderDetailDAO.findByQuantity(quantity)
					.stream()
					.map(o -> toDTO(o))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("OrderDetail getByQuantity failed!");
			return null;
		}
	}

	@Override
	public List<OrderDetailDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return orderDetailDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("OrderDetail findAll failed!");
			return null;
		}

	}

}

package com.demo.app.services.implementations;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.OrderDTO;
import com.demo.app.models.entities.Order;
import com.demo.app.repository.dao.OrderDAO;
import com.demo.app.repository.daoImpl.OrderDAOImpl;
import com.demo.app.services.abstracts.InvoiceService;
import com.demo.app.services.abstracts.OrderDetailService;
import com.demo.app.services.abstracts.OrderService;

/**
 * OrderServiceImpl
 */
public class OrderServiceImpl implements OrderService {

	private static OrderDAO orderDAO = new OrderDAOImpl();
	private static OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private static InvoiceService invoiceService = new InvoiceServiceImpl();

	@Override
	public int add(OrderDTO dto) {
		try {
			orderDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			System.out.println("Order add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			orderDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("Order delete failed!");
			return 0;
		}
	}

	@Override
	public List<OrderDTO> getAll() {
		try {
			return orderDAO.getAll()
					.stream()
					.map(o -> toDTO(o))
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Order getAll failed!");
			return null;
		}
	}

	@Override
	public OrderDTO getById(int id) {
		try {
			return toDTO(orderDAO.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Order getById failed!");
			return null;
		}
	}

	@Override
	public OrderDTO toDTO(Order entity) {
		return Objects.nonNull(entity) ? new OrderDTO()
				.setInvoice(invoiceService.toDTO(entity.getInvoice()))
				.setTimestamp(entity.getTimestamp())
				.setOrderDetails(entity.getOrderDetails()
						.stream()
						.map(od -> orderDetailService.toDTO(od))
						.collect(Collectors.toList()))
				: null;
	}

	@Override
	public Order toEntity(OrderDTO dto) {
		return Objects.nonNull(dto) ? new Order()
				.setInvoice(invoiceService.toEntity(dto.getInvoice()))
				.setTimestamp(dto.getTimestamp())
				.setOrderDetails(dto.getOrderDetails()
						.stream()
						.map(od -> orderDetailService.toEntity(od))
						.collect(Collectors.toList()))
				: null;
	}

	@Override
	public int update(int id, OrderDTO dto) {
		try {
			orderDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Order update failed!");
			return 0;
		}
	}

	@Override
	public List<OrderDTO> getByTimestamp(Timestamp timestamp) {
		try {
			return orderDAO.findByTimestamp(timestamp)
					.stream()
					.map(o -> toDTO(o))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Order getByTimestamp failed!");
			return null;
		}
	}

	@Override
	public List<OrderDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return orderDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Order findAll failed!");
			return null;
		}

	}

}

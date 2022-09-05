package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.OrderDetail;

public interface OrderDetailDAO extends DAO<OrderDetail> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	OrderDetail findById(int id) throws SQLException;

	@Override
	List<OrderDetail> getAll() throws SQLException;

	@Override
	OrderDetail insert(OrderDetail obj) throws SQLException;

	@Override
	OrderDetail update(OrderDetail obj) throws SQLException;

	public List<OrderDetail> findByQuantity(int quantity) throws SQLException;

	@Override
	public List<OrderDetail> findAll(HashMap<String, Object> dataMap) throws SQLException;

	// Product findOrderDetailProductById(int id) throws SQLException;

}

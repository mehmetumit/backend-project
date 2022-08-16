package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.OrderDetail;
import com.demo.app.models.entities.Product;

public interface OrderDetailDAO extends DAO<OrderDetail> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	OrderDetail findById(int id) throws SQLException;

	@Override
	List<OrderDetail> getAll() throws SQLException;

	@Override
	void insert(OrderDetail obj) throws SQLException;

	@Override
	void update(OrderDetail obj) throws SQLException;

	public List<OrderDetail> findByQuantity(int quantity) throws SQLException;

	// Product findOrderDetailProductById(int id) throws SQLException;

}

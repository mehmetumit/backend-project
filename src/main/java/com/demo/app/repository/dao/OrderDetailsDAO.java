package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.OrderDetails;

public interface OrderDetailsDAO extends DAO<OrderDetails> {
	@Override
	int delete(int id) throws SQLException;

	@Override
	OrderDetails findById(int id) throws SQLException;

	@Override
	List<OrderDetails> getAll() throws SQLException;

	@Override
	int insert(OrderDetails obj) throws SQLException;

	@Override
	int update(OrderDetails obj) throws SQLException;

	public List<OrderDetails> findByQuantity(int quantity) throws SQLException;

}

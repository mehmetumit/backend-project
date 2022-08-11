package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.entities.Order;

public interface OrderDAO extends DAO<Order> {
	@Override
	int delete(long id) throws SQLException;

	@Override
	Order findById(long id) throws SQLException;

	@Override
	List<Order> getAll() throws SQLException;

	@Override
	int insert(Order obj) throws SQLException;

	@Override
	int update(Order obj) throws SQLException;

	public List<Order> findByTimestamp(Timestamp timestamp) throws SQLException;

}

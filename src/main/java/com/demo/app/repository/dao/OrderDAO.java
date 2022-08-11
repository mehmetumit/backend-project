package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.entities.Order;

public interface OrderDAO extends DAO<Order> {
	public List<Order> findByTimestamp(Timestamp timestamp) throws SQLException;

}

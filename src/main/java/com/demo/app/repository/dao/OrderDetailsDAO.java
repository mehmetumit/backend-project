package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.OrderDetails;

public interface OrderDetailsDAO extends DAO<OrderDetails> {
	public List<OrderDetails> findByQuantity(int quantity) throws SQLException;
}

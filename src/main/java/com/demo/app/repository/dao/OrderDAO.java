package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.Order;
import com.demo.app.models.entities.OrderDetail;

public interface OrderDAO extends DAO<Order> {

	@Override
	void delete(int id) throws SQLException;

	@Override
	Order findById(int id) throws SQLException;

	@Override
	List<Order> getAll() throws SQLException;

	@Override
	String getEntityName();

	@Override
	void insert(Order obj) throws SQLException;

	@Override
	void update(Order obj) throws SQLException;

	// Invoice findOrderInvoiceById(int id) throws SQLException;

	// List<OrderDetail> findOrderOrderDetailsById(int id) throws SQLException;

	Order findByTimestamp(Timestamp timestamp) throws SQLException;

}

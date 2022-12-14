package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.Invoice;

public interface InvoiceDAO extends DAO<Invoice> {

	@Override
	void delete(int id) throws SQLException;

	@Override
	Invoice findById(int id) throws SQLException;

	@Override
	List<Invoice> getAll() throws SQLException;

	@Override
	Invoice insert(Invoice obj) throws SQLException;

	@Override
	Invoice update(Invoice obj) throws SQLException;

	public List<Invoice> findByInvoiceTimestamp(Timestamp invoiceTimestamp) throws SQLException;

	public List<Invoice> findByDueTimestamp(Timestamp dueTimestamp) throws SQLException;

	public List<Invoice> findBySubTotal(double subTotal) throws SQLException;

	public List<Invoice> findByDiscount(double discount) throws SQLException;

	public List<Invoice> findByTaxRate(int taxRate) throws SQLException;

	public List<Invoice> findByTotalTax(double totalTax) throws SQLException;

	public List<Invoice> findByTotalPrice(double totalPrice) throws SQLException;

	@Override
	public List<Invoice> findAll(HashMap<String, Object> dataMap) throws SQLException;

}

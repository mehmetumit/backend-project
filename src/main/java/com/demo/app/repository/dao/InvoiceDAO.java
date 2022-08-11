package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.entities.Invoice;

public interface InvoiceDAO extends DAO<Invoice> {
	public List<Invoice> findByInvoiceTimestamp(Timestamp invoiceTimestamp) throws SQLException;

	public List<Invoice> findByDueTimestamp(Timestamp dueTimestamp) throws SQLException;

	public List<Invoice> findBySubTotal(double subTotal) throws SQLException;

	public List<Invoice> findByDiscount(double discount) throws SQLException;

	public List<Invoice> findByTaxRate(int taxRate) throws SQLException;

	public List<Invoice> findByTotalTax(double totalTax) throws SQLException;

	public List<Invoice> findByTotalPrice(double totalPrice) throws SQLException;

}

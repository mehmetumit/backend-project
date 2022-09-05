package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.Seller;

public interface SellerDAO extends DAO<Seller> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	Seller findById(int id) throws SQLException;

	@Override
	List<Seller> getAll() throws SQLException;

	@Override
	Seller insert(Seller obj) throws SQLException;

	@Override
	Seller update(Seller obj) throws SQLException;

	public Seller findByName(String name) throws SQLException;

	public Seller findByAddress(String address) throws SQLException;

	public Seller findByPhoneNum(String phoneNum) throws SQLException;

	public Seller findByEmail(String email) throws SQLException;

	public Seller findByFax(String fax) throws SQLException;

	public List<Seller> findByActive(boolean isActive) throws SQLException;

	@Override
	public List<Seller> findAll(HashMap<String, Object> dataMap) throws SQLException;

	// public List<Invoice> findSellerInvoicesById(int id) throws SQLException;

}

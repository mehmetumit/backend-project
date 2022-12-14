package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.Supplier;

public interface SupplierDAO extends DAO<Supplier> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	Supplier findById(int id) throws SQLException;

	@Override
	List<Supplier> getAll() throws SQLException;

	@Override
	Supplier insert(Supplier obj) throws SQLException;

	@Override
	Supplier update(Supplier obj) throws SQLException;

	public Supplier findByName(String name) throws SQLException;

	public Supplier findByAddress(String address) throws SQLException;

	public Supplier findByPhoneNum(String phoneNum) throws SQLException;

	public List<Supplier> findByActive(boolean isActive) throws SQLException;

	@Override
	public List<Supplier> findAll(HashMap<String, Object> dataMap) throws SQLException;

	// public List<StockDetail> findSupplierStockDetailsById(int id) throws
	// SQLException;
}

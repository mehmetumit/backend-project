package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.StockDetail;
import com.demo.app.models.entities.Supplier;

public interface SupplierDAO extends DAO<Supplier> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	Supplier findById(int id) throws SQLException;

	@Override
	List<Supplier> getAll() throws SQLException;

	@Override
	void insert(Supplier obj) throws SQLException;

	@Override
	void update(Supplier obj) throws SQLException;

	public Supplier findByName(String name) throws SQLException;

	public Supplier findByAddress(String address) throws SQLException;

	public Supplier findByPhoneNum(String phoneNum) throws SQLException;

	public List<Supplier> findByActive(boolean isActive) throws SQLException;

	// public List<StockDetail> findSupplierStockDetailsById(int id) throws
	// SQLException;
}

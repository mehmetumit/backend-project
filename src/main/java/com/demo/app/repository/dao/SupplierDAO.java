package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Supplier;

public interface SupplierDAO extends DAO<Supplier> {
	@Override
	int delete(long id) throws SQLException;

	@Override
	Supplier findById(long id) throws SQLException;

	@Override
	List<Supplier> getAll() throws SQLException;

	@Override
	int insert(Supplier obj) throws SQLException;

	@Override
	int update(Supplier obj) throws SQLException;

	public Supplier findByAddress(String address) throws SQLException;

	public Supplier findByPhoneNum(String phoneNum) throws SQLException;

	public List<Supplier> findByActive(boolean isActive) throws SQLException;

}

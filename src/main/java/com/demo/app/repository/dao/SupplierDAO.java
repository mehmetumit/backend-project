package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Supplier;

public interface SupplierDAO extends DAO<Supplier> {
	public Supplier findByAddress(String address) throws SQLException;

	public Supplier findByPhoneNum(String phoneNum) throws SQLException;

	public List<Supplier> findByActive(boolean isActive) throws SQLException;

}

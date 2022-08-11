package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Seller;

public interface SellerDAO extends DAO<Seller> {
	@Override
	int delete(long id) throws SQLException;

	@Override
	Seller findById(long id) throws SQLException;

	@Override
	List<Seller> getAll() throws SQLException;

	@Override
	int insert(Seller obj) throws SQLException;

	@Override
	int update(Seller obj) throws SQLException;

	public Seller findByAddress(String address) throws SQLException;

	public Seller findByPhoneNum(String phoneNum) throws SQLException;

	public Seller findByEmail(String email) throws SQLException;

	public Seller findByFax(String fax) throws SQLException;

	public List<Seller> findByActive(boolean isActive) throws SQLException;

}

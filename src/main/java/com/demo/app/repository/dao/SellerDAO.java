package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Seller;

public interface SellerDAO extends DAO<Seller> {
	public Seller findByAddress(String address) throws SQLException;

	public Seller findByPhoneNum(String phoneNum) throws SQLException;

	public Seller findByEmail(String email) throws SQLException;

	public Seller findByFax(String fax) throws SQLException;

	public List<Seller> findByActive(boolean isActive) throws SQLException;
}

package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Customer;

public interface CustomerDAO extends DAO<Customer> {
	@Override
	int delete(long id) throws SQLException;

	@Override
	Customer findById(long id) throws SQLException;

	@Override
	List<Customer> getAll() throws SQLException;

	@Override
	int insert(Customer obj) throws SQLException;

	@Override
	int update(Customer obj) throws SQLException;

	public List<Customer> findByName(String name) throws SQLException;

	public List<Customer> findBySurname(String surname) throws SQLException;

	public List<Customer> findByPhoneNum(String phoneNum) throws SQLException;

	public List<Customer> findByEmail(String email) throws SQLException;

	public List<Customer> findByActive(boolean isActive) throws SQLException;

	public List<Customer> findByDiscountRate(int discountRate) throws SQLException;

}

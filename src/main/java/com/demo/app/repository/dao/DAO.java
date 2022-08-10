package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	// CRUD operations
	T getById(long id) throws SQLException;

	List<T> getAll() throws SQLException;

	int insert(T obj) throws SQLException;

	int update(T obj) throws SQLException;

	int delete(T obj) throws SQLException;

}
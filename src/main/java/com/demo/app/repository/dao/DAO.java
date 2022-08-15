package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	String getEntityName();

	// CRUD operations
	T findById(int id) throws SQLException;

	List<T> getAll() throws SQLException;

	void insert(T obj) throws SQLException;

	void update(T obj) throws SQLException;

	void delete(int id) throws SQLException;

}

package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface DAO<T> {
	String getEntityName();

	// CRUD operations
	T findById(int id) throws SQLException;

	List<T> getAll() throws SQLException;

	T insert(T obj) throws SQLException;

	T update(T obj) throws SQLException;

	void delete(int id) throws SQLException;

	List<T> findAll(HashMap<String, Object> dataMap) throws SQLException;

}

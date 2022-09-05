package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.Product;

public interface ProductDAO extends DAO<Product> {
	@Override
	void delete(int id) throws SQLException;

	@Override
	Product findById(int id) throws SQLException;

	@Override
	List<Product> getAll() throws SQLException;

	@Override
	Product insert(Product obj) throws SQLException;

	@Override
	Product update(Product obj) throws SQLException;

	public Product findByName(String name) throws SQLException;

	public List<Product> findByCategory(String categoryName) throws SQLException;

	public List<Product> findByUnitPrice(double unitPrice) throws SQLException;

	public List<Product> findByActive(boolean isActive) throws SQLException;

	@Override
	public List<Product> findAll(HashMap<String, Object> dataMap) throws SQLException;

	// public StockDetail findProductStockDetailById(int id) throws SQLException;
}

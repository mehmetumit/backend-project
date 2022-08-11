package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Product;

public interface ProductDAO extends DAO<Product> {
	@Override
	int delete(long id) throws SQLException;

	@Override
	Product findById(long id) throws SQLException;

	@Override
	List<Product> getAll() throws SQLException;

	@Override
	int insert(Product obj) throws SQLException;

	@Override
	int update(Product obj) throws SQLException;

	public Product findByName(String name) throws SQLException;

	public List<Product> findByCategory(String category) throws SQLException;

	public List<Product> findByUnitPrice(double unitPrice) throws SQLException;

	public List<Product> findByActive(boolean isActive) throws SQLException;

}

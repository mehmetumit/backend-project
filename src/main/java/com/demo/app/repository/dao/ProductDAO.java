package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Product;

public interface ProductDAO extends DAO<Product> {
	public Product findByName(String name) throws SQLException;

	public List<Product> findByUnitPrice(double unitPrice) throws SQLException;

	public List<Product> findByActive(boolean isActive) throws SQLException;

}

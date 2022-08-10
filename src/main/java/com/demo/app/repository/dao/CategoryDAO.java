package com.demo.app.repository.dao;

import java.sql.SQLException;

import com.demo.app.models.entities.Category;

public interface CategoryDAO extends DAO<Category> {
	public Category getByName(String name) throws SQLException;
}

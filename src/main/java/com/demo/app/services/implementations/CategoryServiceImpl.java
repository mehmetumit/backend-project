package com.demo.app.services.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.CategoryDTO;
import com.demo.app.models.entities.Category;
import com.demo.app.repository.dao.CategoryDAO;
import com.demo.app.repository.daoImpl.CategoryDAOImpl;
import com.demo.app.services.abstracts.CategoryService;

/**
 * CategoryServiceImpl
 */
public class CategoryServiceImpl implements CategoryService {
	CategoryDAO categoryDAO = new CategoryDAOImpl();

	@Override
	public int add(CategoryDTO categoryDTO) {
		int result = 0;
		try {
			result = categoryDAO.insert(toEntity(categoryDTO));
		} catch (SQLException ex) {

		}
		return result;
	}

	@Override
	public int delete(long id) {
		int result = 0;
		try {
			result = categoryDAO.delete(id);
		} catch (SQLException ex) {

		}
		return result;

	}

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		try {
			for (Category category : categoryDAO.getAll()) {
				categoryDTOs.add(toDTO(category));
			}
		} catch (SQLException ex) {

		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getById(long id) {
		try {
			return toDTO(categoryDAO.findById(id));
		} catch (SQLException ex) {

		}
		return null;
	}

	@Override
	public CategoryDTO getByName(String name) {
		try {
			return toDTO(categoryDAO.findByName(name));
		} catch (SQLException ex) {

		}
		return null;
	}

	@Override
	public int update(CategoryDTO category) {
		try {
			categoryDAO.update(toEntity(category));
		} catch (SQLException ex) {

		}
		return 0;
	}

	@Override
	public Category toEntity(CategoryDTO dto) {
		// ID will be auto generated
		return new Category(dto.getName());
	}

	@Override
	public CategoryDTO toDTO(Category entity) {
		// ID property is not exists in DTO class
		return new CategoryDTO(entity.getName());
	}

}

package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.CategoryDTO;
import com.demo.app.models.entities.Category;

public interface CategoryService extends Service<CategoryDTO, Category> {

	@Override
	int add(CategoryDTO category);

	@Override
	int delete(long id);

	@Override
	List<CategoryDTO> getAll();

	@Override
	CategoryDTO getById(long id);

	CategoryDTO getByName(String name);

	@Override
	int update(CategoryDTO category);

	@Override
	CategoryDTO toDTO(Category entity);

	@Override
	Category toEntity(CategoryDTO dto);

}

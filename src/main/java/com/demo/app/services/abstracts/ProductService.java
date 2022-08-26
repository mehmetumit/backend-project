package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.ProductDTO;
import com.demo.app.models.entities.Product;

/**
 * ProductService
 */
public interface ProductService extends Service<ProductDTO, Product> {

	@Override
	public int add(ProductDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<ProductDTO> getAll();

	@Override
	public ProductDTO getById(int id);

	@Override
	public ProductDTO toDTO(Product entity);

	@Override
	public Product toEntity(ProductDTO dto);

	@Override
	public int update(int id, ProductDTO dto);

	public Product getByName(String name);

	public Product getByCategory(String name);

	public List<ProductDTO> getByUnitPrice(double unitPrice);

	public List<ProductDTO> getByActive(boolean isActive);

	@Override
	public List<ProductDTO> findAll(HashMap<String, Object> dataMap);
}

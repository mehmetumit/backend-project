package com.demo.app.services.abstracts;

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
	public int delete(long id);

	@Override
	public List<ProductDTO> getAll();

	@Override
	public ProductDTO getById(long id);

	@Override
	public ProductDTO toDTO(Product entity);

	@Override
	public Product toEntity(ProductDTO dto);

	@Override
	public int update(ProductDTO dto);

	public Product getByName(String name);

	public Product getByCategory(String name);

	public List<Product> getByUnitPrice(double unitPrice);

	public List<Product> getByActive(boolean isActive);
}

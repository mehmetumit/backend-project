package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.ProductDTO;
import com.demo.app.models.entities.Product;
import com.demo.app.services.abstracts.ProductService;

/**
 * ProductServiceImpl
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public int add(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO toDTO(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product toEntity(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getByCategory(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByUnitPrice(double unitPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByActive(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.demo.app.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.ProductDTO;
import com.demo.app.models.entities.Product;
import com.demo.app.repository.dao.ProductDAO;
import com.demo.app.repository.daoImpl.ProductDAOImpl;
import com.demo.app.services.abstracts.ProductService;
import com.demo.app.services.abstracts.StockDetailService;

/**
 * ProductServiceImpl
 */
public class ProductServiceImpl implements ProductService {
	private static ProductDAO productDAO = new ProductDAOImpl();
	private static StockDetailService stockDetailService = new StockDetailServiceImpl();

	@Override
	public int add(ProductDTO dto) {
		try {
			productDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			System.out.println("Product add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			productDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("Product delete failed!");
			return 0;
		}
	}

	@Override
	public List<ProductDTO> getAll() {
		try {
			return productDAO.getAll()
					.stream()
					.map(p -> toDTO(p))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Product getAll failed!");
			return null;
		}
	}

	@Override
	public ProductDTO getById(int id) {
		try {
			return toDTO(productDAO.findById(id));
		} catch (Exception e) {
			System.out.println("Product getById failed!");
			return null;
		}
	}

	@Override
	public ProductDTO toDTO(Product entity) {
		return new ProductDTO()
				.setCategoryName(entity.getCategoryName())
				.setName(entity.getName())
				.setStockDetail(stockDetailService.toDTO(entity.getStockDetail()))
				.setUnitPrice(entity.getUnitPrice())
				.setActive(entity.isActive());
	}

	@Override
	public Product toEntity(ProductDTO dto) {
		return new Product()
				.setCategoryName(dto.getCategoryName())
				.setName(dto.getName())
				.setStockDetail(stockDetailService.toEntity(dto.getStockDetail()))
				.setUnitPrice(dto.getUnitPrice())
				.setActive(dto.isActive());
	}

	@Override
	public int update(int id, ProductDTO dto) {
		try {
			productDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			System.out.println("Product update failed!");
			return 0;
		}
	}

	@Override
	public Product getByName(String name) {
		try {
			return productDAO.findByName(name);
		} catch (Exception e) {
			System.out.println("Product getByName failed!");
			return null;
		}
	}

	@Override
	public Product getByCategory(String name) {
		try {
			return productDAO.findByName(name);
		} catch (Exception e) {
			System.out.println("Product getByCategory failed!");
			return null;
		}
	}

	@Override
	public List<ProductDTO> getByUnitPrice(double unitPrice) {
		try {
			return productDAO.findByUnitPrice(unitPrice)
					.stream()
					.map(p -> toDTO(p))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Product getByUnitPrice failed!");
			return null;
		}
	}

	@Override
	public List<ProductDTO> getByActive(boolean isActive) {
		try {
			return productDAO.findByActive(isActive)
					.stream()
					.map(p -> toDTO(p))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Product getByActive failed!");
			return null;
		}
	}

}

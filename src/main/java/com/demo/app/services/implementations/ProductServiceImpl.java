package com.demo.app.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.ProductDTO;
import com.demo.app.models.entities.Product;
import com.demo.app.repository.dao.ProductDAO;
import com.demo.app.repository.daoImpl.ProductDAOImpl;
import com.demo.app.services.abstracts.ProductService;

/**
 * ProductServiceImpl
 */
public class ProductServiceImpl implements ProductService {
	private static ProductDAO productDAO = new ProductDAOImpl();

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
		return Objects.nonNull(entity) ? new ProductDTO()
				.setCategoryName(entity.getCategoryName())
				.setName(entity.getName())
				.setUnitPrice(entity.getUnitPrice())
				.setActive(entity.isActive())
				: null;
	}

	@Override
	public Product toEntity(ProductDTO dto) {
		return Objects.nonNull(dto) ? new Product()
				.setCategoryName(dto.getCategoryName())
				.setName(dto.getName())
				.setUnitPrice(dto.getUnitPrice())
				.setActive(dto.isActive())
				: null;
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

	@Override
	public List<ProductDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return productDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Product findAll failed!");
			return null;
		}

	}

}

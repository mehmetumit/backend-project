package com.demo.app.services.implementations;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.SupplierDTO;
import com.demo.app.models.entities.Supplier;
import com.demo.app.repository.dao.SupplierDAO;
import com.demo.app.repository.daoImpl.SupplierDAOImpl;
import com.demo.app.services.abstracts.SupplierService;

/**
 * SupplierServiceImpl
 */
public class SupplierServiceImpl implements SupplierService {
	SupplierDAO supplierDAO = new SupplierDAOImpl();

	@Override
	public int add(SupplierDTO dto) {
		try {
			supplierDAO.insert(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("Supplier add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			supplierDAO.delete(id);
			return 1;
		} catch (SQLException e) {
			System.out.println("Supplier delete failed!");
			return 0;
		}
	}

	@Override
	public List<SupplierDTO> getAll() {
		try {
			return supplierDAO.getAll()
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (SQLException e) {
			System.out.println("Supplier getAll failed!");
			return null;
		}
	}

	@Override
	public SupplierDTO getById(int id) {
		try {
			return toDTO(supplierDAO.findById(id));
		} catch (SQLException e) {
			System.out.println("Supplier getById failed!");
			return null;
		}
	}

	@Override
	public SupplierDTO toDTO(Supplier entity) {
		return new SupplierDTO()
				.setAddress(entity.getAddress())
				.setPhoneNum(entity.getPhoneNum())
				.setActive(entity.isActive())
				.setStockDetails(entity.getStockDetails());
	}

	@Override
	public Supplier toEntity(SupplierDTO dto) {
		return new Supplier()
				.setAddress(dto.getAddress())
				.setPhoneNum(dto.getPhoneNum())
				.setActive(dto.isActive())
				.setStockDetails(dto.getStockDetails());
	}

	@Override
	public int update(SupplierDTO dto) {
		try {
			supplierDAO.update(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("Supplier update failed!");
			return 0;
		}
	}

	@Override
	public SupplierDTO getByName(String name) {
		try {
			return toDTO(supplierDAO.findByName(name));
		} catch (SQLException e) {
			System.out.println("Supplier getByName failed!");
			return null;
		}
	}

	@Override
	public SupplierDTO getByAddress(String address) {
		try {
			return toDTO(supplierDAO.findByAddress(address));
		} catch (SQLException e) {
			System.out.println("Supplier getByAddress failed!");
			return null;
		}
	}

	@Override
	public SupplierDTO getByPhoneNum(String phoneNum) {
		try {
			return toDTO(supplierDAO.findByAddress(phoneNum));
		} catch (SQLException e) {
			System.out.println("Supplier getByPhoneNum failed!");
			return null;
		}
	}

	@Override
	public List<SupplierDTO> findByActive(boolean isActive) {
		try {
			return supplierDAO.findByActive(isActive)
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (SQLException e) {
			System.out.println("Supplier isActive failed!");
			return null;
		}
	}
}

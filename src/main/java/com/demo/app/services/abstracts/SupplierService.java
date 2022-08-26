package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.SupplierDTO;
import com.demo.app.models.entities.Supplier;

/**
 * SupplierService
 */
public interface SupplierService extends Service<SupplierDTO, Supplier> {

	@Override
	public int add(SupplierDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<SupplierDTO> getAll();

	@Override
	public SupplierDTO getById(int id);

	@Override
	public SupplierDTO toDTO(Supplier entity);

	@Override
	public Supplier toEntity(SupplierDTO dto);

	@Override
	public int update(int id, SupplierDTO dto);

	public SupplierDTO getByName(String name);

	public SupplierDTO getByAddress(String address);

	public SupplierDTO getByPhoneNum(String phoneNum);

	public List<SupplierDTO> findByActive(boolean isActive);

	@Override
	public List<SupplierDTO> findAll(HashMap<String, Object> dataMap);
}

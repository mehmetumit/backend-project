package com.demo.app.services.abstracts;

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
	public int delete(long id);

	@Override
	public List<SupplierDTO> getAll();

	@Override
	public SupplierDTO getById(long id);

	@Override
	public SupplierDTO toDTO(Supplier entity);

	@Override
	public Supplier toEntity(SupplierDTO dto);

	@Override
	public int update(SupplierDTO dto);

	public Supplier findByAddress(String address);

	public Supplier findByPhoneNum(String phoneNum);

	public List<Supplier> findByActive(boolean isActive);
}
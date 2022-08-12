package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.SupplierDTO;
import com.demo.app.models.entities.Supplier;
import com.demo.app.services.abstracts.SupplierService;

/**
 * SupplierServiceImpl
 */
public class SupplierServiceImpl implements SupplierService {

	@Override
	public int add(SupplierDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SupplierDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDTO toDTO(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier toEntity(SupplierDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(SupplierDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Supplier findByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier findByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> findByActive(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

}

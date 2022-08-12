package com.demo.app.services.implementations;

import java.util.List;

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.models.entities.Seller;
import com.demo.app.services.abstracts.SellerService;

/**
 * SellerServiceImpl
 */
public class SellerServiceImpl implements SellerService {

	@Override
	public int add(SellerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SellerDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellerDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellerDTO toDTO(Seller entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller toEntity(SellerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(SellerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seller getByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller getByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller getByFax(String fax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> getByActive(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

}

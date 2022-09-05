package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.models.entities.Seller;

/**
 * SellerService
 */
public interface SellerService extends Service<SellerDTO, Seller> {

	@Override
	public SellerDTO add(SellerDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<SellerDTO> getAll();

	@Override
	public SellerDTO getById(int id);

	@Override
	public SellerDTO toDTO(Seller entity);

	@Override
	public Seller toEntity(SellerDTO dto);

	@Override
	public SellerDTO update(int id, SellerDTO dto);

	public SellerDTO getByName(String name);

	public SellerDTO getByAddress(String address);

	public SellerDTO getByPhoneNum(String phoneNum);

	public SellerDTO getByEmail(String email);

	public SellerDTO getByFax(String fax);

	public List<SellerDTO> getByActive(boolean isActive);

	@Override
	public List<SellerDTO> findAll(HashMap<String, Object> dataMap);
}

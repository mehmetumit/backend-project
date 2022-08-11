package com.demo.app.services.abstracts;

import java.util.List;

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.models.entities.Seller;

/**
 * SellerService
 */
public interface SellerService extends Service<SellerDTO, Seller> {

	@Override
	public int add(SellerDTO dto);

	@Override
	public int delete(long id);

	@Override
	public List<SellerDTO> getAll();

	@Override
	public SellerDTO getById(long id);

	@Override
	public SellerDTO toDTO(Seller entity);

	@Override
	public Seller toEntity(SellerDTO dto);

	@Override
	public int update(SellerDTO dto);

	public Seller getByAddress(String address);

	public Seller getByPhoneNum(String phoneNum);

	public Seller getByEmail(String email);

	public Seller getByFax(String fax);

	public List<Seller> getByActive(boolean isActive);
}

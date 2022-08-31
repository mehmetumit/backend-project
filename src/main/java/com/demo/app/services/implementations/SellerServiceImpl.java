package com.demo.app.services.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.models.entities.Seller;
import com.demo.app.repository.dao.SellerDAO;
import com.demo.app.repository.daoImpl.SellerDAOImpl;
import com.demo.app.services.abstracts.InvoiceService;
import com.demo.app.services.abstracts.SellerService;

/**
 * SellerServiceImpl
 */
public class SellerServiceImpl implements SellerService {
	private static SellerDAO sellerDAO = new SellerDAOImpl();
	private static InvoiceService invoiceService = new InvoiceServiceImpl();

	@Override
	public int add(SellerDTO dto) {
		try {
			sellerDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			System.out.println("Seller add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			sellerDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("Seller delete failed!");
			return 0;
		}
	}

	@Override
	public List<SellerDTO> getAll() {
		try {
			return sellerDAO.getAll()
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Seller getAll failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getById(int id) {
		try {
			return toDTO(sellerDAO.findById(id));
		} catch (Exception e) {
			System.out.println("Seller getById failed!");
			return null;
		}
	}

	@Override
	public SellerDTO toDTO(Seller entity) {
		return Objects.nonNull(entity) ? new SellerDTO()
				.setAddress(entity.getAddress())
				.setPhoneNum(entity.getPhoneNum())
				.setEmail(entity.getEmail())
				.setFax(entity.getFax())
				.setActive(entity.isActive())
				.setInvoices(entity.getInvoices()
						.stream()
						.map(inv -> invoiceService.toDTO(inv))
						.collect(Collectors.toList()))
				: null;
	}

	@Override
	public Seller toEntity(SellerDTO dto) {
		return Objects.nonNull(dto) ? new Seller()
				.setAddress(dto.getAddress())
				.setPhoneNum(dto.getPhoneNum())
				.setEmail(dto.getEmail())
				.setFax(dto.getFax())
				.setActive(dto.isActive())
				.setInvoices(dto.getInvoices()
						.stream()
						.map(inv -> invoiceService.toEntity(inv))
						.collect(Collectors.toList()))
				: null;
	}

	@Override
	public int update(int id, SellerDTO dto) {
		try {
			sellerDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			System.out.println("Seller update failed!");
			return 0;
		}
	}

	@Override
	public SellerDTO getByName(String name) {
		try {
			return toDTO(sellerDAO.findByName(name));
		} catch (Exception e) {
			System.out.println("Seller getByName failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByAddress(String address) {
		try {
			return toDTO(sellerDAO.findByAddress(address));
		} catch (Exception e) {
			System.out.println("Seller getByAddress failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByPhoneNum(String phoneNum) {
		try {
			return toDTO(sellerDAO.findByPhoneNum(phoneNum));
		} catch (Exception e) {
			System.out.println("Seller getByPhoneNum failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByEmail(String email) {
		try {
			return toDTO(sellerDAO.findByEmail(email));
		} catch (Exception e) {
			System.out.println("Seller getByEmail failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByFax(String fax) {
		try {
			return toDTO(sellerDAO.findByFax(fax));
		} catch (Exception e) {
			System.out.println("Seller getByFax failed!");
			return null;
		}
	}

	@Override
	public List<SellerDTO> getByActive(boolean isActive) {
		try {
			return sellerDAO.getAll()
					.stream()
					.map(s -> toDTO(s))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Seller getByActive failed!");
			return null;
		}
	}

	@Override
	public List<SellerDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return sellerDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Seller findAll failed!");
			return null;
		}

	}

}

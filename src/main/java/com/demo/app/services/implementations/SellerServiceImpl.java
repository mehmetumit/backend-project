package com.demo.app.services.implementations;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.models.entities.Seller;
import com.demo.app.repository.dao.SellerDAO;
import com.demo.app.repository.daoImpl.SellerDAOImpl;
import com.demo.app.services.abstracts.SellerService;

/**
 * SellerServiceImpl
 */
public class SellerServiceImpl implements SellerService {
	SellerDAO sellerDAO = new SellerDAOImpl();

	@Override
	public int add(SellerDTO dto) {
		try {
			sellerDAO.insert(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("Seller add failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			sellerDAO.delete(id);
			return 1;
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			System.out.println("Seller getAll failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getById(int id) {
		try {
			return toDTO(sellerDAO.findById(id));
		} catch (SQLException e) {
			System.out.println("Seller getById failed!");
			return null;
		}
	}

	@Override
	public SellerDTO toDTO(Seller entity) {
		return new SellerDTO()
				.setAddress(entity.getAddress())
				.setPhoneNum(entity.getPhoneNum())
				.setEmail(entity.getEmail())
				.setFax(entity.getFax())
				.setActive(entity.isActive());
	}

	@Override
	public Seller toEntity(SellerDTO dto) {
		return new Seller()
				.setAddress(dto.getAddress())
				.setPhoneNum(dto.getPhoneNum())
				.setEmail(dto.getEmail())
				.setFax(dto.getFax())
				.setActive(dto.isActive());
	}

	@Override
	public int update(SellerDTO dto) {
		try {
			sellerDAO.update(toEntity(dto));
			return 1;
		} catch (SQLException e) {
			System.out.println("Seller update failed!");
			return 0;
		}
	}

	@Override
	public SellerDTO getByName(String name) {
		try {
			return toDTO(sellerDAO.findByName(name));
		} catch (SQLException e) {
			System.out.println("Seller getByName failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByAddress(String address) {
		try {
			return toDTO(sellerDAO.findByAddress(address));
		} catch (SQLException e) {
			System.out.println("Seller getByAddress failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByPhoneNum(String phoneNum) {
		try {
			return toDTO(sellerDAO.findByPhoneNum(phoneNum));
		} catch (SQLException e) {
			System.out.println("Seller getByPhoneNum failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByEmail(String email) {
		try {
			return toDTO(sellerDAO.findByEmail(email));
		} catch (SQLException e) {
			System.out.println("Seller getByEmail failed!");
			return null;
		}
	}

	@Override
	public SellerDTO getByFax(String fax) {
		try {
			return toDTO(sellerDAO.findByFax(fax));
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			System.out.println("Seller getByActive failed!");
			return null;
		}
	}

}

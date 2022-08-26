package com.demo.app.services.implementations;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.app.models.dtos.InvoiceDTO;
import com.demo.app.models.entities.Invoice;
import com.demo.app.repository.dao.InvoiceDAO;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;
import com.demo.app.repository.daoImpl.InvoiceDAOImpl;
import com.demo.app.services.abstracts.InvoiceService;

/**
 * InvoiceServiceImpl
 */
public class InvoiceServiceImpl implements InvoiceService {
	private static InvoiceDAO invoiceDAO = new InvoiceDAOImpl();

	@Override
	public int add(InvoiceDTO dto) {
		try {
			invoiceDAO.insert(toEntity(dto));
			return 1;
		} catch (Exception e) {
			System.out.println("Customer insertion failed!");
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			invoiceDAO.delete(id);
			return 1;
		} catch (Exception e) {
			System.out.println("Customer deletion failed!");
			return 0;
		}
	}

	@Override
	public List<InvoiceDTO> getAll() {
		try {
			return invoiceDAO.getAll()
					.stream()
					.map(i -> toDTO(i))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getAll failed!");
			return null;
		}
	}

	@Override
	public InvoiceDTO getById(int id) {
		try {
			return toDTO(invoiceDAO.findById(id));
		} catch (Exception e) {
			System.out.println("Invoice getById failed!");
			return null;
		}
	}

	@Override
	public InvoiceDTO toDTO(Invoice entity) {
		return new InvoiceDTO()
				.setInvoiceTimestamp(entity.getInvoiceTimestamp())
				.setDueTimestamp(entity.getDueTimestamp())
				.setSubTotal(entity.getSubTotal())
				.setDiscount(entity.getDiscount())
				.setTaxRate(entity.getTaxRate())
				.setTotalTax(entity.getTotalTax())
				.setTotalPrice(entity.getTotalPrice());
	}

	@Override
	public Invoice toEntity(InvoiceDTO dto) {
		return new Invoice()
				.setInvoiceTimestamp(dto.getInvoiceTimestamp())
				.setDueTimestamp(dto.getDueTimestamp())
				.setSubTotal(dto.getSubTotal())
				.setDiscount(dto.getDiscount())
				.setTaxRate(dto.getTaxRate())
				.setTotalTax(dto.getTotalTax())
				.setTotalPrice(dto.getTotalPrice());
	}

	@Override
	public int update(int id, InvoiceDTO dto) {
		try {
			invoiceDAO.update(toEntity(dto).setId(id));
			return 1;
		} catch (Exception e) {
			System.out.println("Invoice getAll failed!");
			return 0;
		}
	}

	@Override
	public List<InvoiceDTO> getByInvoiceTimestamp(Timestamp invoiceTimestamp) {
		try {
			return invoiceDAO.findByInvoiceTimestamp(invoiceTimestamp)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByInvoiceTimestamp failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getByDueTimestamp(Timestamp dueTimestamp) {
		try {
			return invoiceDAO.findByDueTimestamp(dueTimestamp)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByDueTimestamp failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getBySubTotal(double subTotal) {
		try {
			return invoiceDAO.findBySubTotal(subTotal)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getBySubtotal failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getByDiscount(double discount) {
		try {
			return invoiceDAO.findByDiscount(discount)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByDiscount failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getByTaxRate(int taxRate) {
		try {
			return invoiceDAO.findByTaxRate(taxRate)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByTaxRate failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getByTotalTax(double totalTax) {
		try {
			return invoiceDAO.findByTotalTax(totalTax)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByTotalTax failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getByTotalPrice(double totalPrice) {
		try {
			return invoiceDAO.findByTotalPrice(totalPrice)
					.stream()
					.map(inv -> toDTO(inv))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice getByTotalPrice failed!");
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> findAll(HashMap<String, Object> dataMap) {
		try {
			return invoiceDAO.findAll(dataMap)
					.stream()
					.map(c -> toDTO(c))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Invoice findAll failed!");
			return null;
		}

	}

}

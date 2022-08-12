package com.demo.app.services.implementations;

import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.dtos.InvoiceDTO;
import com.demo.app.models.entities.Invoice;
import com.demo.app.services.abstracts.InvoiceService;

/**
 * InvoiceServiceImpl
 */
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public int add(InvoiceDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InvoiceDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDTO toDTO(Invoice entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice toEntity(InvoiceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(InvoiceDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InvoiceDTO> getByInvoiceTimestamp(Timestamp invoiceTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getByDueTimestamp(Timestamp dueTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getBySubTotal(double subTotal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getByDiscount(double discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getByTaxRate(int taxRate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getByTotalTax(double totalTax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDTO> getByTotalPrice(double totalPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}

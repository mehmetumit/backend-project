package com.demo.app.services.abstracts;

import java.sql.Timestamp;
import java.util.List;

import com.demo.app.models.dtos.InvoiceDTO;
import com.demo.app.models.entities.Invoice;

/**
 * InvoiceService
 */
public interface InvoiceService extends Service<InvoiceDTO, Invoice> {

	@Override
	public int add(InvoiceDTO dto);

	@Override
	public int delete(int id);

	@Override
	public List<InvoiceDTO> getAll();

	@Override
	public InvoiceDTO getById(int id);

	@Override
	public InvoiceDTO toDTO(Invoice entity);

	@Override
	public Invoice toEntity(InvoiceDTO dto);

	@Override
	public int update(int id, InvoiceDTO dto);

	public List<InvoiceDTO> getByInvoiceTimestamp(Timestamp invoiceTimestamp);

	public List<InvoiceDTO> getByDueTimestamp(Timestamp dueTimestamp);

	public List<InvoiceDTO> getBySubTotal(double subTotal);

	public List<InvoiceDTO> getByDiscount(double discount);

	public List<InvoiceDTO> getByTaxRate(int taxRate);

	public List<InvoiceDTO> getByTotalTax(double totalTax);

	public List<InvoiceDTO> getByTotalPrice(double totalPrice);

}

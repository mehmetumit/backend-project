package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.Invoice;

/**
 * SellerDTO
 */
public class SellerDTO {
	private String address;
	private String phoneNum;
	private String email;
	private String fax;
	private boolean isActive;
	private List<InvoiceDTO> invoices = new ArrayList<InvoiceDTO>();

	public String getAddress() {
		return address;
	}

	public SellerDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public SellerDTO setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public SellerDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public SellerDTO setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public SellerDTO setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public List<InvoiceDTO> getInvoices() {
		return invoices;
	}

	public SellerDTO setInvoices(List<InvoiceDTO> invoices) {
		this.invoices = invoices;
		return this;
	}

	@Override
	public String toString() {
		return "SellerDTO [address=" + address + ", email=" + email + ", fax=" + fax + ", invoices=" + invoices
				+ ", isActive=" + isActive + ", phoneNum=" + phoneNum + "]";
	}

}

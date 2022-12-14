package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * SellerDTO
 */
public class SellerDTO {
	private Integer id;
	private String name;
	private String address;
	private String phoneNum;
	private String email;
	private String fax;
	private Boolean isActive;
	private List<InvoiceDTO> invoices = new ArrayList<InvoiceDTO>();

	public Integer getId() {
		return id;
	}

	public SellerDTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public SellerDTO setName(String name) {
		this.name = name;
		return this;
	}

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

	public Boolean isActive() {
		return isActive;
	}

	public SellerDTO setActive(Boolean isActive) {
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
		return "SellerDTO [address=" + address + ", email=" + email + ", fax=" + fax + ", id=" + id + ", invoices="
				+ invoices + ", isActive=" + isActive + ", name=" + name + ", phoneNum=" + phoneNum + "]";
	}

}

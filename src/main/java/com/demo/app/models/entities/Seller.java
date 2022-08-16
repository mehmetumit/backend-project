package com.demo.app.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private List<Invoice> invoices = new ArrayList<Invoice>();
	@Column(name = "address")
	private String address;
	@Column(name = "phone_num")
	private String phoneNum;
	@Column(name = "email")
	private String email;
	@Column(name = "fax")
	private String fax;
	@Column(name = "is_active")
	private boolean isActive;

	public Seller(int id, String address, String phoneNum, String email, String fax, boolean isActive) {
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.fax = fax;
		this.isActive = isActive;
	}

	public Seller(String address, String phoneNum, String email, String fax, boolean isActive) {
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.fax = fax;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Seller [address=" + address + ", email=" + email + ", fax=" + fax + ", id=" + id + ", invoices="
				+ invoices + ", isActive=" + isActive + ", phoneNum=" + phoneNum + "]";
	}

}

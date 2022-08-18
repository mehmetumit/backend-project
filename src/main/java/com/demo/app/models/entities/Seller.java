package com.demo.app.models.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Proxy;

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
@Proxy(lazy = false)
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

	public Seller() {

	}

	public long getId() {
		return id;
	}

	public Seller setId(int id) {
		this.id = id;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Seller setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public Seller setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Seller setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public Seller setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public Seller setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public Seller setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
		return this;
	}

	@Override
	public String toString() {
		return "Seller [address=" + address + ", email=" + email + ", fax=" + fax + ", id=" + id + ", invoices="
				+ invoices + ", isActive=" + isActive + ", phoneNum=" + phoneNum + "]";
	}

}

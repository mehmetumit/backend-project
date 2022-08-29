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
@Table(name = "supplier")
@Proxy(lazy = false)
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
	List<StockDetail> stockDetails = new ArrayList<StockDetail>();
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_num")
	private String phoneNum;
	@Column(name = "is_active")
	private Boolean isActive;

	public int getId() {
		return id;
	}

	public Supplier setId(int id) {
		this.id = id;
		return this;
	}

	public List<StockDetail> getStockDetails() {
		return stockDetails;
	}

	public Supplier setStockDetails(List<StockDetail> stockDetails) {
		this.stockDetails = stockDetails;
		return this;
	}

	public String getName() {
		return name;
	}

	public Supplier setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Supplier setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public Supplier setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public Boolean isActive() {
		return isActive;
	}

	public Supplier setActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	@Override
	public String toString() {
		return "Supplier [address=" + address + ", id=" + id + ", isActive=" + isActive + ", name=" + name
				+ ", phoneNum=" + phoneNum + ", stockDetails=" + stockDetails + "]\n";
	}

}

package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * SupplierDTO
 */
public class SupplierDTO {
	private Integer id;
	List<StockDetailDTO> stockDetails = new ArrayList<StockDetailDTO>();
	private String name;
	private String address;
	private String phoneNum;
	private Boolean isActive;

	public Integer getId() {
		return id;
	}

	public SupplierDTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public SupplierDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public SupplierDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public SupplierDTO setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public Boolean isActive() {
		return isActive;
	}

	public SupplierDTO setActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public List<StockDetailDTO> getStockDetails() {
		return stockDetails;
	}

	public SupplierDTO setStockDetails(List<StockDetailDTO> stockDetails) {
		this.stockDetails = stockDetails;
		return this;
	}

	@Override
	public String toString() {
		return "SupplierDTO [address=" + address + ", id=" + id + ", isActive=" + isActive + ", name=" + name
				+ ", phoneNum=" + phoneNum + ", stockDetails=" + stockDetails + "]";
	}

}

package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * SupplierDTO
 */
public class SupplierDTO {
	List<StockDetailDTO> stockDetails = new ArrayList<StockDetailDTO>();
	private String address;
	private String phoneNum;
	private Boolean isActive;

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
		return "SupplierDTO [address=" + address + ", isActive=" + isActive + ", phoneNum=" + phoneNum
				+ ", stockDetails=" + stockDetails + "]\n";
	}

}

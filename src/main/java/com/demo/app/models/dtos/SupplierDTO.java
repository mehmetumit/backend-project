package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.StockDetail;

/**
 * SupplierDTO
 */
public class SupplierDTO {
	List<StockDetail> stockDetails = new ArrayList<StockDetail>();
	private String address;
	private String phoneNum;
	private boolean isActive;

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

	public boolean isActive() {
		return isActive;
	}

	public SupplierDTO setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public List<StockDetail> getStockDetails() {
		return stockDetails;
	}

	public SupplierDTO setStockDetails(List<StockDetail> stockDetails) {
		this.stockDetails = stockDetails;
		return this;
	}

	@Override
	public String toString() {
		return "SupplierDTO [address=" + address + ", isActive=" + isActive + ", phoneNum=" + phoneNum
				+ ", stockDetails=" + stockDetails + "]";
	}

}

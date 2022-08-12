package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.StockDetails;

/**
 * SupplierDTO
 */
public class SupplierDTO {
	List<StockDetails> stockDetails = new ArrayList<StockDetails>();
	private String address;
	private String phoneNum;
	private boolean isActive;

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<StockDetails> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(List<StockDetails> stockDetails) {
		this.stockDetails = stockDetails;
	}

	@Override
	public String toString() {
		return "SupplierDTO [address=" + address + ", isActive=" + isActive + ", phoneNum=" + phoneNum
				+ ", stockDetails=" + stockDetails + "]";
	}

}

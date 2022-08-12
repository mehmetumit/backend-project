package com.demo.app.models.dtos;

import com.demo.app.models.entities.StockDetails;

/**
 * ProductDTO
 */
public class ProductDTO {
	private String categoryName;
	private String name;
	private StockDetails stockDetails;
	private double unitPrice;
	private boolean isActive;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public StockDetails getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(StockDetails stockDetails) {
		this.stockDetails = stockDetails;
	}

	@Override
	public String toString() {
		return "ProductDTO [categoryName=" + categoryName + ", isActive=" + isActive + ", name=" + name
				+ ", stockDetails=" + stockDetails + ", unitPrice=" + unitPrice + "]";
	}

}

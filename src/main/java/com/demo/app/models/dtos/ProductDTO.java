package com.demo.app.models.dtos;

import com.demo.app.models.entities.StockDetail;

/**
 * ProductDTO
 */
public class ProductDTO {
	private String categoryName;
	private String name;
	private StockDetail stockDetail;
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

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
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

	@Override
	public String toString() {
		return "ProductDTO [categoryName=" + categoryName + ", isActive=" + isActive + ", name=" + name
				+ ", stockDetail=" + stockDetail + ", unitPrice=" + unitPrice + "]";
	}

}

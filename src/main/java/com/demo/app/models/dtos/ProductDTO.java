package com.demo.app.models.dtos;

/**
 * ProductDTO
 */
public class ProductDTO {
	private String categoryName;
	private String name;
	private StockDetailDTO stockDetail;
	private double unitPrice;
	private boolean isActive;

	public String getCategoryName() {
		return categoryName;
	}

	public ProductDTO setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductDTO setName(String name) {
		this.name = name;
		return this;
	}

	public StockDetailDTO getStockDetail() {
		return stockDetail;
	}

	public ProductDTO setStockDetail(StockDetailDTO stockDetail) {
		this.stockDetail = stockDetail;
		return this;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public ProductDTO setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public ProductDTO setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	@Override
	public String toString() {
		return "ProductDTO [categoryName=" + categoryName + ", isActive=" + isActive + ", name=" + name
				+ ", stockDetail=" + stockDetail + ", unitPrice=" + unitPrice + "]";
	}

}

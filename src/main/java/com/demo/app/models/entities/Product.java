package com.demo.app.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private StockDetail stockDetail;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "name")
	private String name;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "is_active")
	private boolean isActive;

	public Product(int id, StockDetail stockDetail, String categoryName, String name, double unitPrice,
			boolean isActive) {
		this.id = id;
		this.stockDetail = stockDetail;
		this.categoryName = categoryName;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public Product(StockDetail stockDetail, String categoryName, String name, double unitPrice,
			boolean isActive) {
		this.stockDetail = stockDetail;
		this.categoryName = categoryName;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StockDetail getStockDetails() {
		return stockDetail;
	}

	public void setStockDetails(StockDetail stockDetails) {
		this.stockDetail = stockDetails;
	}

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

	@Override
	public String toString() {
		return "Product [categoryName=" + categoryName + ", id=" + id + ", isActive=" + isActive + ", name=" + name
				+ ", stockDetails=" + stockDetail + ", unitPrice=" + unitPrice + "]";
	}

}

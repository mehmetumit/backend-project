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
	private StockDetails stockDetails;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "name")
	private String name;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "is_active")
	private boolean isActive;

	public Product(int id, StockDetails stockDetails, String categoryName, String name, double unitPrice,
			boolean isActive) {
		this.id = id;
		this.stockDetails = stockDetails;
		this.categoryName = categoryName;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public Product(StockDetails stockDetails, String categoryName, String name, double unitPrice,
			boolean isActive) {
		this.id = id;
		this.stockDetails = stockDetails;
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

	public StockDetails getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(StockDetails stockDetails) {
		this.stockDetails = stockDetails;
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
				+ ", stockDetails=" + stockDetails + ", unitPrice=" + unitPrice + "]";
	}

}

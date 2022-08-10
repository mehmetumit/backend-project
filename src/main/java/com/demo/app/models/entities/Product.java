package com.demo.app.models.entities;

public class Product {
	private long id;
	private long orderDetails;
	private long categoryId;
	private String name;
	private double unitPrice;
	private boolean isActive;

	public Product(long id, long orderDetails, long categoryId, String name, double unitPrice, boolean isActive) {
		super();
		this.id = id;
		this.orderDetails = orderDetails;
		this.categoryId = categoryId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public Product(long orderDetails, long categoryId, String name, double unitPrice, boolean isActive) {
		super();
		this.orderDetails = orderDetails;
		this.categoryId = categoryId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(long orderDetails) {
		this.orderDetails = orderDetails;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
		return "Product [id=" + id + ", orderDetails=" + orderDetails + ", categoryId=" + categoryId + ", name=" + name
				+ ", unitPrice=" + unitPrice + ", isActive=" + isActive + "]";
	}

}

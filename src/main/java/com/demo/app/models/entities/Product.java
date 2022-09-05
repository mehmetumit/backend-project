package com.demo.app.models.entities;

import org.hibernate.annotations.Proxy;

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
@Proxy(lazy = false)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "name")
	private String name;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "is_active")
	private Boolean isActive;

	public Product(Integer id, String categoryName, String name, Double unitPrice,
			Boolean isActive) {
		this.id = id;
		this.categoryName = categoryName;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public Product(String categoryName, String name, Double unitPrice,
			Boolean isActive) {
		this.categoryName = categoryName;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
	}

	public Product() {

	}

	public Integer getId() {
		return id;
	}

	public Product setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Product setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public Product setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public Boolean isActive() {
		return isActive;
	}

	public Product setActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	@Override
	public String toString() {
		return "Product [categoryName=" + categoryName + ", id=" + id + ", isActive=" + isActive + ", name=" + name
				+ ", unitPrice=" + unitPrice + "]\n";
	}

}

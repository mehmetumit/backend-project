package com.demo.app.models.dtos;

/**
 * ProductDTO
 */
public class ProductDTO {
	private Integer id;
	private String categoryName;
	private String name;
	private Double unitPrice;
	private Boolean isActive;

	public Integer getId() {
		return id;
	}

	public ProductDTO setId(Integer id) {
		this.id = id;
		return this;
	}

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

	public Double getUnitPrice() {
		return unitPrice;
	}

	public ProductDTO setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public Boolean isActive() {
		return isActive;
	}

	public ProductDTO setActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	@Override
	public String toString() {
		return "ProductDTO [categoryName=" + categoryName + ", id=" + id + ", isActive=" + isActive + ", name=" + name
				+ ", unitPrice=" + unitPrice + "]";
	}

}

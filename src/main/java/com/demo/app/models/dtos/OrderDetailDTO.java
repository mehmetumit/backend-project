package com.demo.app.models.dtos;

/**
 * OrderDetailDTO
 */
public class OrderDetailDTO {
	private Integer id;
	private Integer quantity;
	private ProductDTO product;

	public Integer getId() {
		return id;
	}

	public OrderDetailDTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public OrderDetailDTO setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public OrderDetailDTO setProduct(ProductDTO product) {
		this.product = product;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}

}

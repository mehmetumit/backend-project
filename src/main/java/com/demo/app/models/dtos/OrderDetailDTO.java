package com.demo.app.models.dtos;

/**
 * OrderDetailDTO
 */
public class OrderDetailDTO {
	private int quantity;
	private ProductDTO product;

	public int getQuantity() {
		return quantity;
	}

	public OrderDetailDTO setQuantity(int quantity) {
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
		return "OrderDetailDTO [product=" + product + ", quantity=" + quantity + "]";
	}

}

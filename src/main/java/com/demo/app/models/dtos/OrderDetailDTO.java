package com.demo.app.models.dtos;

import com.demo.app.models.entities.Product;

/**
 * OrderDetailDTO
 */
public class OrderDetailDTO {
	private int quantity;
	private Product product;

	public int getQuantity() {
		return quantity;
	}

	public OrderDetailDTO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public OrderDetailDTO setProduct(Product product) {
		this.product = product;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [product=" + product + ", quantity=" + quantity + "]";
	}

}

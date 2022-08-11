package com.demo.app.models.dtos;

/**
 * OrderDetailsDTO
 */
public class OrderDetailsDTO {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [quantity=" + quantity + "]";
	}

}

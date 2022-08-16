package com.demo.app.models.dtos;

/**
 * StockDetailDTO
 */
public class StockDetailDTO {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public StockDetailDTO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "StockDetailsDTO [quantity=" + quantity + "]";
	}

}

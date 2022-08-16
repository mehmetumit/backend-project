package com.demo.app.models.dtos;

/**
 * StockDetailDTO
 */
public class StockDetailDTO {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockDetailsDTO [quantity=" + quantity + "]";
	}

}

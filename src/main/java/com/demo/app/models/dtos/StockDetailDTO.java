package com.demo.app.models.dtos;

/**
 * StockDetailDTO
 */
public class StockDetailDTO {
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public StockDetailDTO setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "StockDetailDTO [quantity=" + quantity + "]\n";
	}

}

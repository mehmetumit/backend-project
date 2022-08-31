package com.demo.app.models.dtos;

/**
 * StockDetailDTO
 */
public class StockDetailDTO {
	private ProductDTO product;
	private Integer quantity;

	public ProductDTO getProduct() {
		return product;
	}

	public StockDetailDTO setProduct(ProductDTO product) {
		this.product = product;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public StockDetailDTO setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "StockDetailDTO [product=" + product + ", quantity=" + quantity + "]";
	}

}

package com.demo.app.models;
public class StockDetails {
	private long id;
	private long productId;
	private long supplierId;
	private long quantity;

	public StockDetails(long id, long productId, long supplierId, long quantity) {
		this.id = id;
		this.productId = productId;
		this.supplierId = supplierId;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "StockDetails [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", supplierId="
				+ supplierId + "]";
	}

}

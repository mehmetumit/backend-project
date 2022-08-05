package com.demo.app.models;
public class OrderDetails {
	private long id;
	private long orderId;
	private long quantitiy;
	public OrderDetails(long id, long orderId, long quantitiy) {
		this.id = id;
		this.orderId = orderId;
		this.quantitiy = quantitiy;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(long quantitiy) {
		this.quantitiy = quantitiy;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", quantitiy=" + quantitiy + "]";
	}

}

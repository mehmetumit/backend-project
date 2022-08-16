package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.OrderDetail;

/**
 * OrderDetailDTO
 */
public class OrderDetailDTO {
	private int quantity;
	private Invoice invoice;
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public int getQuantity() {
		return quantity;
	}

	public OrderDetailDTO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public OrderDetailDTO setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetails;
	}

	public OrderDetailDTO setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [invoice=" + invoice + ", orderDetails=" + orderDetails + ", quantity=" + quantity
				+ "]";
	}

}

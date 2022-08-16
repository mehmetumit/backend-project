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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [invoice=" + invoice + ", orderDetails=" + orderDetails + ", quantity=" + quantity
				+ "]";
	}

}

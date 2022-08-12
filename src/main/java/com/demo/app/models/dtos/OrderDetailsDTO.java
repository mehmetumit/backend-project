package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.OrderDetails;

/**
 * OrderDetailsDTO
 */
public class OrderDetailsDTO {
	private int quantity;
	private Invoice invoice;
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

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

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [invoice=" + invoice + ", orderDetails=" + orderDetails + ", quantity=" + quantity
				+ "]";
	}

}

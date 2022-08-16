package com.demo.app.models.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.OrderDetail;

/**
 * OrderDTO
 */
public class OrderDTO {
	private Invoice invoice;
	private Timestamp orderTimeStamp;
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public Invoice getInvoice() {
		return invoice;
	}

	public OrderDTO setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public Timestamp getOrderTimeStamp() {
		return orderTimeStamp;
	}

	public OrderDTO setOrderTimeStamp(Timestamp orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
		return this;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public OrderDTO setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDTO [invoice=" + invoice + ", orderDetails=" + orderDetails + ", orderTimeStamp=" + orderTimeStamp
				+ "]";
	}

}

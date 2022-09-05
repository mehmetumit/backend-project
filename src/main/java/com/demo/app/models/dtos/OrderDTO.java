package com.demo.app.models.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OrderDTO
 */
public class OrderDTO {
	private Integer id;
	private InvoiceDTO invoice;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp timestamp;
	private List<OrderDetailDTO> orderDetails = new ArrayList<OrderDetailDTO>();

	public Integer getId() {
		return id;
	}

	public OrderDTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public InvoiceDTO getInvoice() {
		return invoice;
	}

	public OrderDTO setInvoice(InvoiceDTO invoice) {
		this.invoice = invoice;
		return this;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public OrderDTO setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	public OrderDTO setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", invoice=" + invoice + ", orderDetails=" + orderDetails + ", timestamp="
				+ timestamp + "]";
	}

}

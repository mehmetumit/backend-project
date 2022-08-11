package com.demo.app.models.dtos;

import java.sql.Timestamp;

/**
 * OrderDTO
 */
public class OrderDTO {
	private Timestamp orderTimeStamp;

	public Timestamp getOrderTimeStamp() {
		return orderTimeStamp;
	}

	public void setOrderTimeStamp(Timestamp orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderTimeStamp=" + orderTimeStamp + "]";
	}
}

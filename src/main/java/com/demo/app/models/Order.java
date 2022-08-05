package com.demo.app.models;
import java.security.Timestamp;

public class Order {
	private long id;
	private long customerId;
	private Timestamp timestamp;

	public Order(long id, long customerId, Timestamp timestamp) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", timestamp=" + timestamp + "]";
	}

}

package com.demo.app.models.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Proxy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"order\"")
@Proxy(lazy = false)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", referencedColumnName = "order_id")
	private Invoice invoice;
	// @JoinColumn(name = "order_id", referencedColumnName = "id")

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	@Column(name = "order_timestamp")
	private Timestamp timestamp;

	public Order(int id, Timestamp timestamp) {
		super();
		this.id = id;
		this.timestamp = timestamp;
	}

	public Order(Timestamp timestamp) {
		super();
		this.timestamp = timestamp;
	}

	public Order() {

	}

	public long getId() {
		return id;
	}

	public Order setId(int id) {
		this.id = id;
		return this;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public Order setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Order setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public Order setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", invoice=" + invoice + ", orderDetails=" + orderDetails + ", timestamp="
				+ timestamp + "]\n";
	}

}

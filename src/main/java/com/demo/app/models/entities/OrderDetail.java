package com.demo.app.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "quantity")
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_detail_id", referencedColumnName = "id")
	private Product product;

	public OrderDetail(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public OrderDetail(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public OrderDetail setId(int id) {
		this.id = id;
		return this;
	}

	public int getQuantitiy() {
		return quantity;
	}

	public OrderDetail setQuantitiy(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + "]";
	}

}

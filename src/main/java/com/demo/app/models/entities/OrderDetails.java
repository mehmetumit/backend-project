package com.demo.app.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "quantity")
	private long quantitiy;

	public OrderDetails(long id, long quantitiy) {
		this.id = id;
		this.quantitiy = quantitiy;
	}

	public OrderDetails(long quantitiy) {
		this.quantitiy = quantitiy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(long quantitiy) {
		this.quantitiy = quantitiy;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantitiy=" + quantitiy + "]";
	}

}

package com.demo.app.models.entities;

import org.hibernate.annotations.Proxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_detail")
@Proxy(lazy = false)
public class StockDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "quantity")
	private int quantity;

	public StockDetail(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public StockDetail(int quantity) {
		this.quantity = quantity;
	}

	public StockDetail() {

	}

	public int getId() {
		return id;
	}

	public StockDetail setId(int id) {
		this.id = id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public StockDetail setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "StockDetails [id=" + id + ", quantity=" + quantity + "]";
	}

}

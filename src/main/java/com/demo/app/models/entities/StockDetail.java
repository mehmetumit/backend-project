package com.demo.app.models.entities;

import org.hibernate.annotations.Proxy;

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
@Table(name = "stock_detail")
@Proxy(lazy = false)
public class StockDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", referencedColumnName = "stock_detail_id")
	private Product product;

	@Column(name = "quantity")
	private Integer quantity;

	public StockDetail(int id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public StockDetail(Integer quantity) {
		this.quantity = quantity;
	}

	public StockDetail() {

	}

	public int getId() {
		return id;
	}

	public StockDetail setId(Integer id) {
		this.id = id;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public StockDetail setProduct(Product product) {
		this.product = product;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public StockDetail setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "StockDetail [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}

}

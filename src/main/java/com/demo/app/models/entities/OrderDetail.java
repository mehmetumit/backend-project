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
@Table(name = "order_detail")
@Proxy(lazy = false)
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quantity")
	private Integer quantity;

	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	public OrderDetail(Integer id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public OrderDetail(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderDetail() {

	}

	public Integer getId() {
		return id;
	}

	public OrderDetail setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getQuantitiy() {
		return quantity;
	}

	public OrderDetail setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public OrderDetail setProduct(Product product) {
		this.product = product;
		return this;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", product=" + product + ", quantity=" + quantity + "]\n";
	}

}

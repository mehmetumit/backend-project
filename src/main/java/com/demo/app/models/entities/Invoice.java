package com.demo.app.models.entities;

import java.sql.Timestamp;

import org.hibernate.annotations.Proxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
@Proxy(lazy = false)
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "invoice_timestamp")
	private Timestamp invoiceTimestamp;
	@Column(name = "due_timestamp")
	private Timestamp dueTimestamp;
	@Column(name = "sub_total")
	private double subTotal;
	@Column(name = "discount")
	private double discount;
	@Column(name = "tax_rate")
	private int taxRate;
	@Column(name = "total_tax")
	private double totalTax;
	@Column(name = "total_price")
	private double totalPrice;

	public Invoice(int id, Timestamp invoiceTimestamp, Timestamp dueTimestamp,
			double subTotal, double discount, int taxRate, double totalTax, double totalPrice) {
		super();
		this.id = id;
		this.invoiceTimestamp = invoiceTimestamp;
		this.dueTimestamp = dueTimestamp;
		this.subTotal = subTotal;
		this.discount = discount;
		this.taxRate = taxRate;
		this.totalTax = totalTax;
		this.totalPrice = totalPrice;
	}

	public Invoice(Timestamp invoiceTimestamp, Timestamp dueTimestamp,
			double subTotal, double discount, int taxRate, double totalTax, double totalPrice) {
		super();
		this.invoiceTimestamp = invoiceTimestamp;
		this.dueTimestamp = dueTimestamp;
		this.subTotal = subTotal;
		this.discount = discount;
		this.taxRate = taxRate;
		this.totalTax = totalTax;
		this.totalPrice = totalPrice;
	}

	public Invoice() {
	}

	public long getId() {
		return id;
	}

	public Invoice setId(int id) {
		this.id = id;
		return this;
	}

	public Timestamp getInvoiceTimestamp() {
		return invoiceTimestamp;
	}

	public Invoice setInvoiceTimestamp(Timestamp invoiceTimestamp) {
		this.invoiceTimestamp = invoiceTimestamp;
		return this;
	}

	public Timestamp getDueTimestamp() {
		return dueTimestamp;
	}

	public Invoice setDueTimestamp(Timestamp dueTimestamp) {
		this.dueTimestamp = dueTimestamp;
		return this;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public Invoice setSubTotal(double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public double getDiscount() {
		return discount;
	}

	public Invoice setDiscount(double discount) {
		this.discount = discount;
		return this;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public Invoice setTaxRate(int taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public Invoice setTotalTax(double totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Invoice setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	@Override
	public String toString() {
		return "Invoice [discount=" + discount + ", dueTimestamp=" + dueTimestamp + ", id=" + id + ", invoiceTimestamp="
				+ invoiceTimestamp + ", subTotal=" + subTotal + ", taxRate=" + taxRate + ", totalPrice=" + totalPrice
				+ ", totalTax=" + totalTax + "]";
	}

}

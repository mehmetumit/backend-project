package com.demo.app.models.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// private long orderId;
	// private long sellerId;

	@Column(name = "invoiceTimeStamp")
	private Timestamp invoiceTimestamp;
	@Column(name = "dueTimeStamp")
	private Timestamp dueTimestamp;
	@Column(name = "subTotal")
	private double subTotal;
	@Column(name = "discount")
	private double discount;
	@Column(name = "taxRate")
	private int taxRate;
	@Column(name = "totalTax")
	private double totalTax;
	@Column(name = "totalPrice")
	private double totalPrice;

	public Invoice(long id, Timestamp invoiceTimestamp, Timestamp dueTimestamp,
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getInvoiceTimestamp() {
		return invoiceTimestamp;
	}

	public void setInvoiceTimestamp(Timestamp invoiceTimestamp) {
		this.invoiceTimestamp = invoiceTimestamp;
	}

	public Timestamp getDueTimestamp() {
		return dueTimestamp;
	}

	public void setDueTimestamp(Timestamp dueTimestamp) {
		this.dueTimestamp = dueTimestamp;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Invoice [discount=" + discount + ", dueTimestamp=" + dueTimestamp + ", id=" + id + ", invoiceTimestamp="
				+ invoiceTimestamp + ", subTotal=" + subTotal + ", taxRate=" + taxRate + ", totalPrice=" + totalPrice
				+ ", totalTax=" + totalTax + "]";
	}

}

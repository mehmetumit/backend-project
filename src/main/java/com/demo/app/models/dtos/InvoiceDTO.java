package com.demo.app.models.dtos;

import java.sql.Timestamp;

/**
 * InvoiceDTO
 */
public class InvoiceDTO {
	private Timestamp invoiceTimestamp;
	private Timestamp dueTimestamp;
	private double subTotal;
	private double discount;
	private int taxRate;
	private double totalTax;
	private double totalPrice;

	public Timestamp getInvoiceTimestamp() {
		return invoiceTimestamp;
	}

	public InvoiceDTO setInvoiceTimestamp(Timestamp invoiceTimestamp) {
		this.invoiceTimestamp = invoiceTimestamp;
		return this;
	}

	public Timestamp getDueTimestamp() {
		return dueTimestamp;
	}

	public InvoiceDTO setDueTimestamp(Timestamp dueTimestamp) {
		this.dueTimestamp = dueTimestamp;
		return this;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public InvoiceDTO setSubTotal(double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public double getDiscount() {
		return discount;
	}

	public InvoiceDTO setDiscount(double discount) {
		this.discount = discount;
		return this;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public InvoiceDTO setTaxRate(int taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public InvoiceDTO setTotalTax(double totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public InvoiceDTO setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [discount=" + discount + ", dueTimestamp=" + dueTimestamp + ", invoiceTimestamp="
				+ invoiceTimestamp + ", subTotal=" + subTotal + ", taxRate=" + taxRate + ", totalPrice=" + totalPrice
				+ ", totalTax=" + totalTax + "]";
	}

}

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
		return "InvoiceDTO [discount=" + discount + ", dueTimestamp=" + dueTimestamp + ", invoiceTimestamp="
				+ invoiceTimestamp + ", subTotal=" + subTotal + ", taxRate=" + taxRate + ", totalPrice=" + totalPrice
				+ ", totalTax=" + totalTax + "]";
	}

}

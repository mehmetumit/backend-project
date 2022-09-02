package com.demo.app.models.dtos;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * InvoiceDTO
 */
public class InvoiceDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp invoiceTimestamp;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp dueTimestamp;
	private Double subTotal;
	private Double discount;
	private Integer taxRate;
	private Double totalTax;
	private Double totalPrice;

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

	public Double getSubTotal() {
		return subTotal;
	}

	public InvoiceDTO setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public Double getDiscount() {
		return discount;
	}

	public InvoiceDTO setDiscount(Double discount) {
		this.discount = discount;
		return this;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public InvoiceDTO setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public InvoiceDTO setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public InvoiceDTO setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [discount=" + discount + ", dueTimestamp=" + dueTimestamp + ", invoiceTimestamp="
				+ invoiceTimestamp + ", subTotal=" + subTotal + ", taxRate=" + taxRate + ", totalPrice=" + totalPrice
				+ ", totalTax=" + totalTax + "]\n";
	}

}

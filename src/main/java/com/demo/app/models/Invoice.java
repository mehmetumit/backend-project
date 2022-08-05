package com.demo.app.models;
import java.sql.Timestamp;

public class Invoice {
	private long id;
	private long orderId;
	private long sellerId;
	private Timestamp invoiceTimestamp;
	private Timestamp dueTimestamp;
	private double subTotal;
	private double discount;
	private int taxRate;
	private double totalTax;
	private double totalPrice;

	public Invoice(long id, long orderId, long sellerId, Timestamp invoiceTimestamp, Timestamp dueTimestamp,
			double subTotal, double discount, int taxRate, double totalTax, double totalPrice) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.sellerId = sellerId;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
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
		return "Invoice [id=" + id + ", orderId=" + orderId + ", sellerId=" + sellerId + ", invoiceTimestamp="
				+ invoiceTimestamp + ", dueTimestamp=" + dueTimestamp + ", subTotal=" + subTotal + ", discount="
				+ discount + ", taxRate=" + taxRate + ", totalTax=" + totalTax + ", totalPrice=" + totalPrice + "]";
	}

}

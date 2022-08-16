package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.demo.app.models.entities.Order;

public class CustomerDTO {
	private String name;
	private String surname;
	private String phoneNum;
	private String email;
	private boolean isActive;
	private double discountRate;
	private List<Order> orders = new ArrayList<Order>();

	public String getName() {
		return name;
	}

	public CustomerDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public CustomerDTO setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public CustomerDTO setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CustomerDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public CustomerDTO setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public CustomerDTO setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
		return this;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public CustomerDTO setOrders(List<Order> orders) {
		this.orders = orders;
		return this;
	}

	@Override
	public String toString() {
		return "CustomerDTO [discountRate=" + discountRate + ", email=" + email + ", isActive=" + isActive + ", name="
				+ name + ", orders=" + orders + ", phoneNum=" + phoneNum + ", surname=" + surname + "]";
	}

}

package com.demo.app.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
	private String name;
	private String surname;
	private String phoneNum;
	private String email;
	private Boolean isActive;
	private Integer discountRate;
	private List<OrderDTO> orders = new ArrayList<OrderDTO>();

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

	public Boolean isActive() {
		return isActive;
	}

	public CustomerDTO setActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public Integer getDiscountRate() {
		return discountRate;
	}

	public CustomerDTO setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
		return this;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public CustomerDTO setOrders(List<OrderDTO> orders) {
		this.orders = orders;
		return this;
	}

	@Override
	public String toString() {
		return "CustomerDTO [discountRate=" + discountRate + ", email=" + email + ", isActive=" + isActive + ", name="
				+ name + ", orders=" + orders + ", phoneNum=" + phoneNum + ", surname=" + surname + "]\n";
	}

}

package com.demo.app.models;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String phoneNum;
	private String email;
	private boolean isActive;
	private int discountRate;

	public Customer(int id, String name, String surname, String phoneNum, String email, boolean isActive,
			int discountRate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.isActive = isActive;
		this.discountRate = discountRate;
	}

	public Customer(String name, String surname, String phoneNum, String email, boolean isActive,
			int discountRate) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.isActive = isActive;
		this.discountRate = discountRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", phoneNum=" + phoneNum + ", email="
				+ email + ", isActive=" + isActive + ", discountRate=" + discountRate + "]";
	}
}

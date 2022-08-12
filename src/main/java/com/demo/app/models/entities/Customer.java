package com.demo.app.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "customer_id")
	private List<Order> orders = new ArrayList<Order>();
	@Column(name = "customer_name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "phone_num")
	private String phoneNum;
	@Column(name = "email")
	private String email;
	@Column(name = "discount_rate")
	private int discountRate;
	@Column(name = "is_active")
	private boolean isActive;

	public Customer(long id, String name, String surname, String phoneNum, String email, int discountRate,
			boolean isActive) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.discountRate = discountRate;
		this.isActive = isActive;
	}

	public Customer(String name, String surname, String phoneNum, String email, int discountRate, boolean isActive) {
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.discountRate = discountRate;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Customer [discountRate=" + discountRate + ", email=" + email + ", id=" + id + ", isActive=" + isActive
				+ ", name=" + name + ", orders=" + orders + ", phoneNum=" + phoneNum + ", surname=" + surname + "]";
	}

}

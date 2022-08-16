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
	@Column(name = "id")
	private int id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Order> orders = new ArrayList<Order>();
	@Column(name = "name")
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

	public Customer(int id, String name, String surname, String phoneNum, String email, int discountRate,
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

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public Customer setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Customer setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public Customer setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isActive() {
		return isActive;
	}

	public Customer setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public Customer setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
		return this;
	}

	public Customer setOrders(List<Order> orders) {
		this.orders = orders;
		return this;
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

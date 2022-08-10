package com.demo.app.models.entities;

public class Supplier {
	private long id;
	private String address;
	private String phoneNum;
	private boolean isActive;

	public Supplier(long id, String address, String phoneNum, boolean isActive) {
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
		this.isActive = isActive;
	}

	public Supplier(String address, String phoneNum, boolean isActive) {
		this.address = address;
		this.phoneNum = phoneNum;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Supplier [address=" + address + ", id=" + id + ", isActive=" + isActive + ", phoneNum=" + phoneNum
				+ "]";
	}

}

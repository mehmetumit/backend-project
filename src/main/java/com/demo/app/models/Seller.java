package com.demo.app.models;

public class Seller {
	private long id;
	private String address;
	private String phoneNum;
	private String email;
	private String fax;
	private boolean isActive;

	public Seller(long id, String address, String phoneNum, String email, String fax, boolean isActive) {
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.fax = fax;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Seller [address=" + address + ", email=" + email + ", fax=" + fax + ", id=" + id + ", isActive="
				+ isActive + ", phoneNum=" + phoneNum + "]";
	}

}

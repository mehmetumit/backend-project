package com.demo.app.models.dtos;

/**
 * SellerDTO
 */
public class SellerDTO {
	private String address;
	private String phoneNum;
	private String email;
	private String fax;
	private boolean isActive;

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
		return "SellerDTO [address=" + address + ", email=" + email + ", fax=" + fax + ", isActive=" + isActive
				+ ", phoneNum=" + phoneNum + "]";
	}

}

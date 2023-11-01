package com.azshop.models;

import java.io.Serializable;

public class AddressShippingModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private String recipientName;
    private String address;
    private String phone;
    
	public AddressShippingModel() {
	}

	public AddressShippingModel(int id, int userId, String recipientName, String address, String phone) {
		super();
		this.id = id;
		this.userId = userId;
		this.recipientName = recipientName;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AddressShippingModels [id=" + id + ", userId=" + userId + ", recipientName=" + recipientName
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
	
    
    
    
	
}

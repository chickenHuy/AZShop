package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;;

public class OrderModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private int storeId;
    private int deliveryId;
    private String recipientName;
    private String address;
    private String phone;
    private String status;
    private boolean isPaidBefore;
    private BigDecimal amountFromUser;
    private BigDecimal amountFromStore;
    private BigDecimal amountToStore;
    private BigDecimal amountToAZShop;
    private Date createAt;
    private Date updateAt;
    
	public OrderModel() {
		super();
	}
	
	public OrderModel(int id, int userId, int storeId, int deliveryId, String recipientName, String address,
			String phone, String status, boolean isPaidBefore, BigDecimal amountFromUser, BigDecimal amountFromStore,
			BigDecimal amountToStore, BigDecimal amountToAZShop, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.recipientName = recipientName;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToAZShop = amountToAZShop;
		this.createAt = createAt;
		this.updateAt = updateAt;
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

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPaidBefore() {
		return isPaidBefore;
	}

	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}

	public BigDecimal getAmountFromUser() {
		return amountFromUser;
	}

	public void setAmountFromUser(BigDecimal amountFromUser) {
		this.amountFromUser = amountFromUser;
	}

	public BigDecimal getAmountFromStore() {
		return amountFromStore;
	}

	public void setAmountFromStore(BigDecimal amountFromStore) {
		this.amountFromStore = amountFromStore;
	}

	public BigDecimal getAmountToStore() {
		return amountToStore;
	}

	public void setAmountToStore(BigDecimal amountToStore) {
		this.amountToStore = amountToStore;
	}

	public BigDecimal getAmountToAZShop() {
		return amountToAZShop;
	}

	public void setAmountToAZShop(BigDecimal amountToAZShop) {
		this.amountToAZShop = amountToAZShop;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", deliveryId=" + deliveryId
				+ ", recipientName=" + recipientName + ", address=" + address + ", phone=" + phone + ", status="
				+ status + ", isPaidBefore=" + isPaidBefore + ", amountFromUser=" + amountFromUser
				+ ", amountFromStore=" + amountFromStore + ", amountToStore=" + amountToStore + ", amountToAZShop="
				+ amountToAZShop + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    
    
    

}

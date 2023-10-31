package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private int storeId;
    private boolean isUp;
    private BigDecimal amount;
    private Date createAt;
    private Date updateAt;
    
	public TransactionModel() {
		super();
	}

	public TransactionModel(int id, int userId, int storeId, boolean isUp, BigDecimal amount, Date createAt,
			Date updateAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.isUp = isUp;
		this.amount = amount;
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

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
		return "TransactionModel [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", isUp=" + isUp
				+ ", amount=" + amount + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
    
	
    
    
    
	
}

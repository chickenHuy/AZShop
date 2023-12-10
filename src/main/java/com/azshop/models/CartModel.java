package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class CartModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private int storeId;
    private Date createAt;
    private Date updateAt;
    private String nameStore;
    
	public CartModel() {
	}

	public CartModel(int id, int userId, int storeId, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
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

	public String getNameStore() {
		return nameStore;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
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

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}

	@Override
	public String toString() {
		return "CartModel [id=" + id + ", userId=" + userId + ", storeId=" + storeId  + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    
    
    
	
}

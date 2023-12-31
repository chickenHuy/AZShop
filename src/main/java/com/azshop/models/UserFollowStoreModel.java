package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class UserFollowStoreModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private int storeId;
	private Date createAt;
	private Date updateAt;

	public UserFollowStoreModel() {
	}

	public UserFollowStoreModel(int id, int userId, int storeId, Date createAt, Date updateAt) {
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

	@Override
	public String toString() {
		return "UserFollowStore [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}

}

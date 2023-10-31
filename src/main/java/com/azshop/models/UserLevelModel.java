package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class UserLevelModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private int minPoint;
    private int discount;
    private boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    
	public UserLevelModel() {
		super();
	}

	public UserLevelModel(int id, String name, int minPoint, int discount, boolean isDeleted, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(int minPoint) {
		this.minPoint = minPoint;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserLevelModels [id=" + id + ", name=" + name + ", minPoint=" + minPoint + ", discount=" + discount
				+ ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
	
	
	
    
    
    

}

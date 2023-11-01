package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class StoreLevelModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private int minPoint;
    private int discount;
    private Date createAt;
    private Date updateAt;
    
	public StoreLevelModel() {
	}

	public StoreLevelModel(int id, String name, int minPoint, int discount, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
		this.createAt = createAt;
		this.updateAt = updateAt;
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
		return "StoreLevelModel [id=" + id + ", name=" + name + ", minPoint=" + minPoint + ", discount=" + discount
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    

}

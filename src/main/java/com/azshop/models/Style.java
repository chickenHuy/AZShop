package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class Style implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private int categoryId;
    private boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    
	public Style() {
		super();
	}

	public Style(int id, String name, int categoryId, boolean isDeleted, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.isDeleted = isDeleted;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", isDeleted=" + isDeleted
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
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
	
	
    
    

}

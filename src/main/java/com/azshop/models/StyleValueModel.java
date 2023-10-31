package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class StyleValueModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private int styleId;
    private boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    
	public StyleValueModel() {
		super();
	}

	public StyleValueModel(int id, String name, int styleId, boolean isDeleted, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.styleId = styleId;
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

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
		return "StyleValueModel [id=" + id + ", name=" + name + ", styleId=" + styleId + ", isDeleted=" + isDeleted
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    

}

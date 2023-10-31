package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliveryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private BigDecimal price;
    private String description;
    private boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    
	public DeliveryModel() {
		super();
	}
	
	public DeliveryModel(int id, String name, BigDecimal price, String description, boolean isDeleted, Date createAt,
			Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "DeliveryModel [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", isDeleted=" + isDeleted + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
    
    

}

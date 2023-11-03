package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class OrderItemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int orderId;
    private int productId;
    private int count;
    private boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    
	public OrderItemModel() {
	}
	
	public OrderItemModel(int id, int orderId, int productId, int count, boolean isDeleted, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateAt() {
		return createAt;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
		return "OrderItemModel [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", count=" + count
				+ ", isDelete=" + isDeleted + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
    
    

}

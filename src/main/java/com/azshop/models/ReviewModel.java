package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class ReviewModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int userId;
    private int productId;
    private int storeId;
    private int orderId;
    private String content;
    private int rating;
    private Date createAt;
    private Date updateAt;
    
	public ReviewModel() {
	}
	
	public ReviewModel(int id, int userId, int productId, int storeId, int orderId, String content, int rating,
			Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.orderId = orderId;
		this.content = content;
		this.rating = rating;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
		return "ReviewModel [id=" + id + ", userId=" + userId + ", productId=" + productId + ", storeId=" + storeId
				+ ", orderId=" + orderId + ", content=" + content + ", rating=" + rating + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}
    
    
    
    

}

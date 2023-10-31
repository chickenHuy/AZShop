package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class CartItemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int cartId;
	private int productId;
	private int styleValueId;
	private int count;
	private Date createAt;
	private Date updateAt;
    
	public CartItemModel() {
		super();
	}

	public CartItemModel(int id, int cartId, int productId, int styleValueId, int count, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.styleValueId = styleValueId;
		this.count = count;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getStyleValueId() {
		return styleValueId;
	}

	public void setStyleValueId(int styleValueId) {
		this.styleValueId = styleValueId;
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
		return "CartItemModel [id=" + id + ", cartId=" + cartId + ", productId=" + productId + ", styleValueId="
				+ styleValueId + ", count=" + count + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    
    
    

}

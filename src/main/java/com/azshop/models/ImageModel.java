package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class ImageModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int productId;
    private String image;
    private Date createAt;
    private Date updateAt;
    
	public ImageModel() {
		super();
	}
	
	public ImageModel(int id, int productId, String image, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.productId = productId;
		this.image = image;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
		return "ImageModel [id=" + id + ", productId=" + productId + ", image=" + image + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}
    
    

}

package com.azshop.models;

import java.io.Serializable;

public class ImageModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int productId;
    private String image;
    
	public ImageModel() {
		super();
	}

	public ImageModel(int id, int productId, String image) {
		super();
		this.id = id;
		this.productId = productId;
		this.image = image;
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

	@Override
	public String toString() {
		return "ImageModel [id=" + id + ", productId=" + productId + ", image=" + image + "]";
	}

}

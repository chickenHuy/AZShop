package com.azshop.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class ProductModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private String slug;
    private String description;
    private BigDecimal price;
    private int quantity;
    private int sold;
    private boolean isDeleted;
    private boolean isActive;
    private String video;
    private int categoryId;
    private int styleValueId;
    private int storeId;
    private BigDecimal rating;
    private Date createAt;
    private Date updateAt;
    
	public ProductModel() {
	}

	public ProductModel(int id, String name, String slug, String description, BigDecimal price, int quantity, int sold,
			boolean isActive, boolean isDeleted, String video, int categoryId, int styleValueId, int storeId, BigDecimal rating,
			Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.video = video;
		this.categoryId = categoryId;
		this.styleValueId = styleValueId;
		this.storeId = storeId;
		this.rating = rating;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public ProductModel(String name2, String slug2, String description2, BigDecimal price2, int quantity2,
			boolean isActive2, int categoryId2, int styleValueId2, int storeId2, String videoLink) {
		name = name2;
		slug = slug2;
		description = description2;
		price = price2;
		quantity = quantity2;
		isActive = isActive2;
		categoryId = categoryId2;
		styleValueId = styleValueId2;
		storeId = styleValueId2;
		video = videoLink;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public boolean isActive() {
		return isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getStyleValueId() {
		return styleValueId;
	}

	public void setStyleValueId(int styleValueId) {
		this.styleValueId = styleValueId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
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
		return "ProductModel [id=" + id + ", name=" + name + ", slug=" + slug + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", sold=" + sold+ ", isDeleted=" + isDeleted + ", isActive=" + isActive
				+ ", video=" + video + ", categoryId=" + categoryId + ", styleValueId=" + styleValueId + ", storeId="
				+ storeId + ", rating=" + rating + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
    
    
    
    

}

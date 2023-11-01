package com.azshop.models;

import java.io.Serializable;
import java.util.Date;

public class CategoryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int id;
    private int categoryId; 
    private String name;
    private String slug;
    private String image;
    private boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    
	public CategoryModel() {
	}

	public CategoryModel(int id, int categoryId, String name, String slug, String image, boolean isDeleted,
			Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.slug = slug;
		this.image = image;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		return "CategoryModel [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", slug=" + slug
				+ ", image=" + image + ", isDeleted=" + isDeleted + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ "]";
	}

}

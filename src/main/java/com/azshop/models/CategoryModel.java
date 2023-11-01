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

}

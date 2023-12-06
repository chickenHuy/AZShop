package com.azshop.services;

import java.util.List;

import com.azshop.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);

	CategoryModel getById(int id);

	List<CategoryModel> getAll();

	List<CategoryModel> getChildCategory(int parentId);
	
	List<CategoryModel> getParentCategory();
	
	CategoryModel getParentCategory(int id);

	void update(CategoryModel category);

	void delete(int id);
	CategoryModel getCategoryBySlug(String slug);
}

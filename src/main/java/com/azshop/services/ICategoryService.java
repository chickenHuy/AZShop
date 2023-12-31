package com.azshop.services;

import java.util.List;

import com.azshop.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);

	CategoryModel getById(int id);
	List<CategoryModel> FindCategory(String keyword);
	List<CategoryModel> getAll();

	List<CategoryModel> getChildCategory(int parentId);
	
	List<CategoryModel> getParentCategory();
	
	CategoryModel getParentCategory(int id);

	void update(CategoryModel category);

	void deleteBySlug(String slug);
	CategoryModel getCategoryBySlug(String slug);

	List<CategoryModel> getAllAdmin();

	void restoreBySlug(String slug);
}

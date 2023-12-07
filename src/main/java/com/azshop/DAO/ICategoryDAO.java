package com.azshop.DAO;

import java.util.List;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;

public interface ICategoryDAO {
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

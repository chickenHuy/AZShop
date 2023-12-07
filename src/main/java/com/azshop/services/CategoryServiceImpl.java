package com.azshop.services;

import java.util.List;

import com.azshop.DAO.CategoryDAOImpl;
import com.azshop.DAO.ICategoryDAO;
import com.azshop.models.CategoryModel;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDAO categoryDAO = new CategoryDAOImpl();
	@Override
	public void insert(CategoryModel category) {
		categoryDAO.insert(category);
	}

	@Override
	public List<CategoryModel> getAllAdmin() {
		return categoryDAO.getAllAdmin();
	}
	
	@Override
	public CategoryModel getById(int id) {
		return categoryDAO.getById(id);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDAO.getAll();
	}

	@Override
	public List<CategoryModel> getChildCategory(int parentId) {
		return categoryDAO.getChildCategory(parentId);
	}

	@Override
	public void update(CategoryModel category) {
		categoryDAO.update(category);
	}

	@Override
	public void deleteBySlug(String slug) {
		categoryDAO.deleteBySlug(slug);
	}

	@Override
	public CategoryModel getCategoryBySlug(String slug) {
		return categoryDAO.getCategoryBySlug(slug);
	}

	@Override
	public List<CategoryModel> getParentCategory() {
		return categoryDAO.getParentCategory();
	}

	@Override
	public CategoryModel getParentCategory(int id) {
		return categoryDAO.getParentCategory(id);
	}
	
	@Override
	public void restoreBySlug(String slug) {
		categoryDAO.restoreBySlug(slug);
	}

	@Override
	public List<CategoryModel> FindCategory(String keyword) {
		return categoryDAO.FindCategory(keyword);
	}

}

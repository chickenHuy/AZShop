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
	public void delete(int id) {
		categoryDAO.delete(id);
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

}

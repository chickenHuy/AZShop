package com.azshop.services;

import java.util.List;

import com.azshop.DAO.CategoryDAOImpl;
import com.azshop.DAO.ICategoryDAO;
import com.azshop.models.CategoryModel;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDAO categoryDAO = new CategoryDAOImpl();
	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDAO.getAll();
	}

	@Override
	public List<CategoryModel> getChildCategory(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

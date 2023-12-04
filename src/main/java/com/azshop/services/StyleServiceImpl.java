package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IStyleDAO;
import com.azshop.DAO.StyleDAOImpl;
import com.azshop.models.StyleModel;

public class StyleServiceImpl implements IStyleService {

	IStyleDAO styleDAO = new StyleDAOImpl();
	@Override
	public void insert(StyleModel style) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StyleModel getById(int id) {
		return styleDAO.getById(id);
	}

	@Override
	public List<StyleModel> getAll() {
		return styleDAO.getAll();
	}

	@Override
	public List<StyleModel> getByCategoryId(int categoryId) {
		return styleDAO.getByCategoryId(categoryId);
	}

	@Override
	public void update(StyleModel style) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

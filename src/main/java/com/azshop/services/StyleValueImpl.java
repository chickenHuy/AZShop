package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IStyleValueDAO;
import com.azshop.DAO.StyleValueDAOImpl;
import com.azshop.models.StyleValueModel;

public class StyleValueImpl implements IStyleValueService {

	IStyleValueDAO styleValueDAO = new StyleValueDAOImpl();
	@Override
	public void insert(StyleValueModel styleValue) {
		styleValueDAO.insert(styleValue);
	}

	@Override
	public StyleValueModel getById(int id) {
		return styleValueDAO.getById(id);
	}
	
	@Override
	public StyleValueModel getByIdAdmin(int id) {
		return styleValueDAO.getByIdAdmin(id);
	}

	@Override
	public List<StyleValueModel> getAll() {
		return styleValueDAO.getAll();
	}

	@Override
	public List<StyleValueModel> getByStyleId(int styleId) {
		return styleValueDAO.getByStyleId(styleId);
	}

	@Override
	public void update(StyleValueModel styleValue) {
		styleValueDAO.update(styleValue);
	}

	@Override
	public void delete(int id) {
		styleValueDAO.delete(id);
	}
	
	@Override
	public void restore(int id) {
		styleValueDAO.restore(id);
	}

	@Override
	public List<StyleValueModel> getByStyleIdAmin(int id) {
		return styleValueDAO.getByStyleIdAmin(id);
	}

}

package com.azshop.DAO;

import java.util.List;

import com.azshop.models.StyleValueModel;

public interface IStyleValueDAO {

	void insert(StyleValueModel styleValue);
	StyleValueModel getById(int id);
	List<StyleValueModel> getAll();
	List<StyleValueModel> getByStyleId(int styleId);
	void update(StyleValueModel styleValue);
	void delete(int id);
}

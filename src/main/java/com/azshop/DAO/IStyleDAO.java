package com.azshop.DAO;

import java.util.List;

import com.azshop.models.StyleModel;


public interface IStyleDAO {
	void insert(StyleModel style);
	StyleModel getById(int id);
	List<StyleModel> getAll();
	List<StyleModel> getByCategoryId(int categoryId);
	void update(StyleModel style);
	void delete(int id);
}

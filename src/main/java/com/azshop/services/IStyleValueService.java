package com.azshop.services;

import java.util.List;

import com.azshop.models.StyleValueModel;

public interface IStyleValueService {
	void insert(StyleValueModel styleValue);

	StyleValueModel getById(int id);

	List<StyleValueModel> getAll();

	List<StyleValueModel> getByStyleId(int styleId);

	void update(StyleValueModel styleValue);

	void delete(int id);

	List<StyleValueModel> getByStyleIdAmin(int id);

	void restore(int id);
}

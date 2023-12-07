package com.azshop.services;

import java.util.List;

import com.azshop.models.StoreLevelModel;

public interface IStoreLevelService {
	void insert(StoreLevelModel storeLevel);

	StoreLevelModel getById(int id);

	List<StoreLevelModel> getAll();

	void update(StoreLevelModel storeLevel);

	void delete(int id);
	int getDefaultLevel();
	boolean checkName(String name);
	List<StoreLevelModel> getAllDeleted();
}

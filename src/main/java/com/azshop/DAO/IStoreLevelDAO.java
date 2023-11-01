package com.azshop.DAO;

import java.util.List;

import com.azshop.models.StoreLevelModel;

public interface IStoreLevelDAO {
	void insert(StoreLevelModel storeLevel);
	StoreLevelModel getById(int id);
	List<StoreLevelModel> getAll();
	void update(StoreLevelModel storeLevel);
	void delete(int id);
}

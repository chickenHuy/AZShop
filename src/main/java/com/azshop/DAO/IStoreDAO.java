package com.azshop.DAO;

import java.util.List;

import com.azshop.models.StoreModel;

public interface IStoreDAO {
	void insert(StoreModel store);
	StoreModel getById(int id);
	List<StoreModel> getAll();
	List<StoreModel> getByStoreLevelId(int storeLevelId);
	void update(StoreModel store);
	void delete(int id);
	StoreModel getBySlug(String slug);
}

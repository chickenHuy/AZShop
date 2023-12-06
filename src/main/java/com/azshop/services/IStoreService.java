package com.azshop.services;

import java.util.List;

import com.azshop.models.StoreModel;

public interface IStoreService {
	void insert(StoreModel store);

	StoreModel getById(int id);

	List<StoreModel> getAll();

	List<StoreModel> getByStoreLevelId(int storeLevelId);

	void update(StoreModel store);

	void delete(int id);
	
	StoreModel getBySlug(String slug);
	
	boolean isUserStoreOwner(int userId);
	
    StoreModel getByOwnerId(int userId);
}

package com.azshop.services;

import java.util.Date;
import java.util.List;

import com.azshop.models.ProductModel;
import com.azshop.models.StoreModel;

public interface IStoreService {
	void insert(StoreModel store);

	StoreModel getById(int id);
	
	List<StoreModel> FindStore(String keyword);

	List<StoreModel> getAll();

	List<StoreModel> getByStoreLevelId(int storeLevelId);

	void update(StoreModel store);

	void delete(int id);
	
	StoreModel getBySlug(String slug);
	
	boolean isUserStoreOwner(int userId);
	
    StoreModel getByOwnerId(int userId);
    List<StoreModel> searchByKey(String key, int storeLevelId);
    
    int countNewStores(Date datetime);
    
    int getTotalStores();
}

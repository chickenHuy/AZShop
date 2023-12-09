package com.azshop.DAO;

import java.util.Date;
import java.util.List;

import com.azshop.models.ProductModel;
import com.azshop.models.StoreModel;

public interface IStoreDAO {
	void insert(StoreModel store);
	StoreModel getById(int id);
	List<StoreModel> getAll();
	List<StoreModel> getByStoreLevelId(int storeLevelId);
	List<StoreModel> FindStore(String keyword);
	void update(StoreModel store);
	void delete(int id);
	StoreModel getBySlug(String slug);
    boolean isUserStoreOwner(int userId);
    StoreModel getByOwnerId(int userId);
    List<StoreModel> searchByKey(String key, int storeLevelId);
    int countNewStores(Date datetime);
    int getTotalStores();
    
}

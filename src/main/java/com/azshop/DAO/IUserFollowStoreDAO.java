package com.azshop.DAO;

import java.util.List;

import com.azshop.models.UserFollowStoreModel;

public interface IUserFollowStoreDAO {
	void insert(UserFollowStoreModel userFollowStore);
	void update(UserFollowStoreModel userFollowStore);
	void delete(int id);
	List<UserFollowStoreModel> getAll();
	List<UserFollowStoreModel> getByUserId(int userId);
	List<UserFollowStoreModel> getByStoreId(int storeId);
	int countByStore(int storeId);
	int getTotalFollow();
}

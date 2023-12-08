package com.azshop.services;

import java.util.List;

import com.azshop.models.UserFollowStoreModel;

public interface IUserFollowStoreService {
	void insert(UserFollowStoreModel userFollowStore);

	void update(UserFollowStoreModel userFollowStore);

	void delete(int id);

	List<UserFollowStoreModel> getAll();

	List<UserFollowStoreModel> getByUserId(int userId);

	List<UserFollowStoreModel> getByStoreId(int storeId);
	int countByStore(int storeId);
}

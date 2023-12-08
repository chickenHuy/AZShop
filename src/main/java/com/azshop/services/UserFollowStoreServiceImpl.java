package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IUserFollowStoreDAO;
import com.azshop.DAO.UserFollowStoreDAOImpl;
import com.azshop.models.UserFollowStoreModel;

public class UserFollowStoreServiceImpl implements IUserFollowStoreService{
	IUserFollowStoreDAO userFollowStoreDAO = new UserFollowStoreDAOImpl();
	@Override
	public void insert(UserFollowStoreModel userFollowStore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserFollowStoreModel userFollowStore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserFollowStoreModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserFollowStoreModel> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserFollowStoreModel> getByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByStore(int storeId) {
		return userFollowStoreDAO.countByStore(storeId);
	}

}

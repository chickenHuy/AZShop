package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IUserLevelDAO;
import com.azshop.DAO.UserLevelDAOImpl;
import com.azshop.models.UserLevelModel;

public class UserLevelServiceImpl implements IUserLevelService {

	IUserLevelDAO userLevelDAO = new UserLevelDAOImpl();
	@Override
	public void insert(UserLevelModel userLevel) {
		// TODO Auto-generated method stub
		userLevelDAO.insert(userLevel);
	}

	@Override
	public void update(UserLevelModel userLevel) {
		// TODO Auto-generated method stub
		userLevelDAO.update(userLevel);
	}

	@Override
	public void delete(UserLevelModel userLevel) {
		// TODO Auto-generated method stub
		userLevelDAO.delete(userLevel);
	}

	@Override
	public UserLevelModel getById(int id) {
		// TODO Auto-generated method stub
		return userLevelDAO.getById(id);
	}

	@Override
	public List<UserLevelModel> getAll() {
		// TODO Auto-generated method stub
		return userLevelDAO.getAll();
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		return userLevelDAO.checkName(name);
	}

	@Override
	public List<UserLevelModel> getAllDeleted() {
		// TODO Auto-generated method stub
		return userLevelDAO.getAllDeleted();
	}

}

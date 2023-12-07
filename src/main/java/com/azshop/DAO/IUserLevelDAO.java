package com.azshop.DAO;

import java.util.List;

import com.azshop.models.UserLevelModel;

public interface IUserLevelDAO {
	void insert(UserLevelModel userLevel);
	void update(UserLevelModel userLevel);
	void delete(UserLevelModel userLevel);
	UserLevelModel getById(int id);
	List<UserLevelModel> getAll();
	boolean checkName(String name);
	List<UserLevelModel> getAllDeleted();
}

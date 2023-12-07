package com.azshop.services;

import java.util.List;

import com.azshop.models.UserLevelModel;

public interface IUserLevelService {
	void insert(UserLevelModel userLevel);

	void update(UserLevelModel userLevel);

	void delete(UserLevelModel userLevel);

	UserLevelModel getById(int id);

	List<UserLevelModel> getAll();
	boolean checkName(String name);
}

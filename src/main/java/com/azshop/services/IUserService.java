package com.azshop.services;

import java.util.List;

import com.azshop.models.UserModel;

public interface IUserService {
	void insert(UserModel user);

	void update(UserModel user);

	void delete(int id);

	List<UserModel> getAll();

	UserModel getById(int id);
}

package com.azshop.DAO;

import java.util.Date;
import java.util.List;

import com.azshop.models.UserModel;

public interface IUserDAO {
	void insert(UserModel user);

	void update(UserModel user);

	void delete(int id);

	List<UserModel> getAll();

	UserModel getById(int id);

	boolean checkExistEmial(String email);

	void insertRegister(UserModel user);

	void updateStatusEmail(UserModel user);

	UserModel getByEmail(String email);

	void updatePassword(UserModel user, String newPassword);

	int countUser(Date datetime);

	int getTotalUsers();

	void updateVendor(UserModel userModel);

	List<UserModel> getUserWithinDays(int days);

}

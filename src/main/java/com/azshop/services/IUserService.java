package com.azshop.services;

import java.util.Date;
import java.util.List;

import com.azshop.models.UserModel;

public interface IUserService {
	void insert(UserModel user);

	void update(UserModel user);

	void delete(int id);

	List<UserModel> getAll();

	UserModel getById(int id);
	
	boolean checkExistEmial(String email);

	boolean insertRegister(String firstName, String lastName, String email, String password);

	void updateStatusEmail(UserModel user);
	
	UserModel getByEmail(String email);
	
	UserModel login(String email, String password);
	
	void updatePassword(UserModel user, String newPassword);
<<<<<<< HEAD
	
	int countUser(Date datetime);
=======
	void updateVendor(UserModel userModel);
>>>>>>> branch 'master' of https://github.com/chickenHuy/AZShop
}

package com.azshop.services;

import java.util.List;

import com.azshop.models.CartModel;

public interface ICartService {
	void insert(CartModel cart);

	CartModel getById(int id);

	List<CartModel> getAll();

	List<CartModel> getByStoreId(int storeId);

	List<CartModel> getByUserId(int userId);

	void update(CartModel cart);

	void delete(int id);
}

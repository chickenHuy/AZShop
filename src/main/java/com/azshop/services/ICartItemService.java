package com.azshop.services;

import java.util.List;

import com.azshop.models.CartItemModel;

public interface ICartItemService {
	void insert(CartItemModel cartItem);

	CartItemModel getById(int id);

	List<CartItemModel> getAll();

	List<CartItemModel> getByCartId(int cartId);

	void update(CartItemModel cartItem);

	void delete(int id);
}

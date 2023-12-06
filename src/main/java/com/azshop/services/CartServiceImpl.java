package com.azshop.services;

import java.util.List;

import com.azshop.DAO.CartDAOImpl;
import com.azshop.DAO.ICartDAO;
import com.azshop.models.CartModel;

public class CartServiceImpl implements ICartService{
	ICartDAO cartDAO = new CartDAOImpl();

	@Override
	public void insert(CartModel cart) {
		cartDAO.insert(cart);
	}

	@Override
	public CartModel getById(int id) {
		return cartDAO.getById(id);
	}

	@Override
	public List<CartModel> getAll() {
		return cartDAO.getAll();
	}

	@Override
	public List<CartModel> getByStoreId(int storeId) {
		return cartDAO.getByStoreId(storeId);
	}

	@Override
	public List<CartModel> getByUserId(int userId) {
		return cartDAO.getByUserId(userId);
	}

	@Override
	public void update(CartModel cart) {
		cartDAO.update(cart);
	}

	@Override
	public void delete(int id) {
		cartDAO.delete(id);
	}

}

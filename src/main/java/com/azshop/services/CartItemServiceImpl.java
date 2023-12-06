package com.azshop.services;

import java.util.List;

import com.azshop.DAO.CartItemDAOImpl;
import com.azshop.DAO.ICartItemDAO;
import com.azshop.models.CartItemModel;

public class CartItemServiceImpl implements ICartItemService{
	
	ICartItemDAO cartItemDAO = new CartItemDAOImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		cartItemDAO.insert(cartItem);
	}

	@Override
	public CartItemModel getById(int id) {
		return cartItemDAO.getById(id);
	}

	@Override
	public List<CartItemModel> getAll() {
		return cartItemDAO.getAll();
	}

	@Override
	public List<CartItemModel> getByCartId(int cartId) {
		return cartItemDAO.getByCartId(cartId);
	}

	@Override
	public void update(CartItemModel cartItem) {
		cartItemDAO.update(cartItem);
	}

	@Override
	public void delete(int id) {
		cartItemDAO.delete(id);
	}

}

package com.azshop.DAO;

import java.util.List;

import com.azshop.models.CartModel;

public interface ICartDAO {
	void insert(CartModel cart);
    CartModel getById(int id);
    List<CartModel> getAll();
    List<CartModel> getByStoreId(int storeId);
    List<CartModel> getByUserId(int userId);
    void update(CartModel cart);
    void delete(int id);
}

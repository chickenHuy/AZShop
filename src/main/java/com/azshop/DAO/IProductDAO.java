package com.azshop.DAO;

import java.util.List;

import com.azshop.models.ProductModel;

public interface IProductDAO {
	void insert(ProductModel product);
    ProductModel getById(int id);
    List<ProductModel> getAll();
    void update(ProductModel product);
    void delete(int id);
}

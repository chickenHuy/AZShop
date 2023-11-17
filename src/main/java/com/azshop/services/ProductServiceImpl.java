package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IProductDAO;
import com.azshop.DAO.ProductDAOImpl;
import com.azshop.models.ProductModel;

public class ProductServiceImpl implements IProductService{

	IProductDAO productDAO = new ProductDAOImpl();
	@Override
	public void insert(ProductModel product) {
		productDAO.insert(product);
	}

	@Override
	public ProductModel getById(int id) {
		return productDAO.getById(id);
	}

	@Override
	public List<ProductModel> getAll() {
		return productDAO.getAll();
	}

	@Override
	public List<ProductModel> getByCategoryId(int categoryId) {
		return productDAO.getByCategoryId(categoryId);
	}

	@Override
	public List<ProductModel> getByStyleValueId(int styleValueId) {
		return productDAO.getByStyleValueId(styleValueId);
	}

	@Override
	public List<ProductModel> getByStoreId(int storeId) {
		return productDAO.getByStoreId(storeId);
	}

	@Override
	public void update(ProductModel product) {
		productDAO.update(product);
	}

	@Override
	public void delete(int id) {
		productDAO.delete(id);
	}

	@Override
	public ProductModel getBySlug(String slug) {
		return productDAO.getBySlug(slug);
	}

	@Override
	public List<ProductModel> FindProduct(String keyword) {
		return productDAO.FindProduct(keyword);
	}

}

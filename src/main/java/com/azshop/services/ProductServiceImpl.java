package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IProductDAO;
import com.azshop.DAO.ProductDAOImpl;
import com.azshop.models.CategoryModel;
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

	@Override
	public int countDraftByStore(int storeId) {
		return productDAO.countDraftByStore(storeId);
	}

	@Override
	public int countPublishByStore(int storeId) {
		return productDAO.countPublishByStore(storeId);
	}

	@Override
	public int countAllByStore(int storeId) {
		return productDAO.countAllByStore(storeId);
	}

	
	@Override
	public List<ProductModel> getBySearch(int categoryId, int storeId, String isActive, String content)
	{
		return productDAO.getBySearch(categoryId, storeId, isActive, content);
	}

	@Override
	public List<ProductModel> getProductbyQuantity(List<ProductModel> productList, int quantity) {
		return productDAO.getProductbyQuantity(productList, quantity);
	}

	@Override
	public List<ProductModel> SortingProductbyPriceAscending(List<ProductModel> productList) {
		return productDAO.SortingProductbyPriceAscending(productList);
	}

	@Override
	public List<ProductModel> SortingProductbyPriceDecending(List<ProductModel> productList) {
		return productDAO.SortingProductbyPriceDecending(productList);
	}

}

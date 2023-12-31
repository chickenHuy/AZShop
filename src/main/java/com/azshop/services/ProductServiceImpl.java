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
	public int countSaleByStore(int storeId) {
		return productDAO.countSaleByStore(storeId);
	}

	@Override
	public ProductModel getBestSellerProduct(int storeId) {
		return productDAO.getBestSellerProduct(storeId);
	}

	@Override
	public List<ProductModel> getHotProduct(int storeId) {
		return productDAO.getHotProduct(storeId);
	}

	@Override
	public int countInDayByStore(int storeId) {
		return productDAO.countInDayByStore(storeId);
	}
	
	
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

	@Override
	public List<ProductModel> GetTopSellerProduct(List<ProductModel> productList, int k) {
		return productDAO.GetTopSellerProduct(productList, k);
	}

	@Override
	public List<ProductModel> search(String key, int categoryId, int storeId, int styleValueId, int styleId, int page, int pageSize) {
		return productDAO.search(key, categoryId, storeId, styleValueId, styleId, page, pageSize);
	}

	@Override
	public List<ProductModel> getNewestProduc(List<ProductModel> productList) {
		return productDAO.getNewestProduc(productList);
	}

	@Override
	public List<ProductModel> getAllProductActive() {
		return productDAO.getAllProductActive();
	}

}

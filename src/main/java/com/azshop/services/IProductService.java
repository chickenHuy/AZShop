package com.azshop.services;

import java.util.List;

import com.azshop.models.ProductModel;

public interface IProductService {
	void insert(ProductModel product);

	ProductModel getById(int id);
	ProductModel getBySlug(String slug);
	
	List<ProductModel> FindProduct(String keyword);

	List<ProductModel> getAll();

	List<ProductModel> getByCategoryId(int categoryId);

	List<ProductModel> getByStyleValueId(int styleValueId);

	List<ProductModel> getByStoreId(int storeId);
	
	List<ProductModel> getProductbyQuantity(List<ProductModel> productList, int quantity);
	
    List<ProductModel> SortingProductbyPriceAscending(List<ProductModel> productList, int categoryId);
    
    List<ProductModel> SortingProductbyPriceDecending(List<ProductModel> productList, int categoryId);

    List<ProductModel> GetTopSellerProduct(List<ProductModel> productList, int k);

	void update(ProductModel product);

	void delete(int id);
	int countDraftByStore(int storeId);
    int countPublishByStore(int storeId);
    int countAllByStore(int storeId);
    int countInDayByStore(int storeId);
    List<ProductModel> getBySearch(int categoryId, int storeId, String isActive, String content);
    int countSaleByStore(int storeId);
    ProductModel getBestSellerProduct(int storeId);
    List<ProductModel> getHotProduct(int storeId);
}

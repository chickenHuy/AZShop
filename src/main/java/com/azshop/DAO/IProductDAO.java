package com.azshop.DAO;

import java.util.List;

import com.azshop.models.ProductModel;

public interface IProductDAO {
	void insert(ProductModel product);
    ProductModel getById(int id);
    ProductModel getBySlug(String slug);
    List<ProductModel> FindProduct(String keyword);
    List<ProductModel> getAll();
    List<ProductModel> getByCategoryId(int categoryId);
    List<ProductModel> getByStyleValueId(int styleValueId);
    List<ProductModel> getByStoreId(int storeId);
    List<ProductModel> getBySearch(int categoryId, int storeId, String isActive, String content);
    void update(ProductModel product);
    void delete(int id);
    int countDraftByStore(int storeId);
    int countPublishByStore(int storeId);
    int countAllByStore(int storeId);
    int countSaleByStore(int storeId);
    int countInDayByStore(int storeId);
    ProductModel getBestSellerProduct(int storeId);
    List<ProductModel> getHotProduct(int storeId);
    
}

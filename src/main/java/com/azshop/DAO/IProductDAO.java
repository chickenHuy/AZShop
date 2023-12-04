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
    List<ProductModel> getByStoreIdAndDraft(int storeId);
    List<ProductModel> getByStoreIdAndPublish(int storeId);
    List<ProductModel> getByCategoryIdAndStoreId(int categoryId, int storeId);
    List<ProductModel> getByCategoryIdAndStoreIdAndDraft(int categoryId, int storeId);
    List<ProductModel> getByCategoryIdAndStoreIdAndPublish(int categoryId, int storeId);
    void update(ProductModel product);
    void delete(int id);
    int countDraftByStore(int storeId);
    int countPublishByStore(int storeId);
    int countAllByStore(int storeId);
    
}

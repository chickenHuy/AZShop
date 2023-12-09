package com.azshop.services;

import java.math.BigDecimal;
import java.util.List;

import com.azshop.models.ReviewModel;

public interface IReviewService {
	void insert(ReviewModel review);

	ReviewModel getById(int id);

	List<ReviewModel> getAll();

	List<ReviewModel> getByUserId(int userId);

	List<ReviewModel> getByProductId(int productId);

	List<ReviewModel> getByStoreId(int storeId);

	List<ReviewModel> getByOrderId(int orderId);

	void update(ReviewModel review);

	void delete(int id);

	int countByStore(int storeId);

	int countNewByStore(int storeId);
	
	BigDecimal avgRating(int productId);
	
	int countStar(int productId, int rating);
	
	List<ReviewModel> getByProductIdPage(int productId, int offset, int limit);
}

package com.azshop.DAO;

import java.math.BigDecimal;
import java.util.List;

import com.azshop.models.ReviewModel;

public interface IReviewDAO {
<<<<<<< HEAD
	void insert(ReviewModel review);

	ReviewModel getById(int id);

	List<ReviewModel> getAll();

	List<ReviewModel> getByUserId(int userId);

	List<ReviewModel> getByProductId(int productId);

	List<ReviewModel> getByStoreId(int storeId);

	List<ReviewModel> getByOrderId(int orderId);

	void update(ReviewModel review);

	void delete(int id);
	
	BigDecimal avgRating (int productId);
=======
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
>>>>>>> fe47ff8323fadbad2fba660ee85ea76466e65e70
}

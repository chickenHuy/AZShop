package com.azshop.services;

import java.math.BigDecimal;
import java.util.List;

import com.azshop.DAO.IReviewDAO;
import com.azshop.DAO.ReviewDAOImpl;
import com.azshop.models.ReviewModel;

public class ReviewServiceImpl implements IReviewService{

	IReviewDAO reviewDAO = new ReviewDAOImpl();
	@Override
	public void insert(ReviewModel review) {
		reviewDAO.insert(review);
	}

	@Override
	public ReviewModel getById(int id) {
		return reviewDAO.getById(id);
	}

	@Override
	public List<ReviewModel> getAll() {
		return reviewDAO.getAll();
	}

	@Override
	public List<ReviewModel> getByUserId(int userId) {
		return reviewDAO.getByUserId(userId);
	}

	@Override
	public List<ReviewModel> getByProductId(int productId) {
		return reviewDAO.getByProductId(productId);
	}

	@Override
	public List<ReviewModel> getByStoreId(int storeId) {
		return reviewDAO.getByStoreId(storeId);
	}

	@Override
	public List<ReviewModel> getByOrderId(int orderId) {
		return reviewDAO.getByOrderId(orderId);
	}

	@Override
	public void update(ReviewModel review) {
		reviewDAO.update(review);
		
	}

	@Override
	public void delete(int id) {
		reviewDAO.delete(id);
		
	}

	@Override
	public BigDecimal avgRating(int productId) {
		return reviewDAO.avgRating(productId);
	}
	public int countByStore(int storeId) {
		 return reviewDAO.countByStore(storeId);
	}

	@Override
	public int countNewByStore(int storeId) {
		return reviewDAO.countNewByStore(storeId);
	}

	@Override
	public int countStar(int productId, int rating) {
		return reviewDAO.countStar(productId, rating);
	}


}

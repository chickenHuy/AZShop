package com.azshop.DAO;

import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.ReviewModel;

public class ReviewDAOImpl implements IReviewDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(ReviewModel review) {
		try {
			String sql = "INSERT INTO Review (userId, productId, storeId, orderId, content, rating, createAt) VALUES (?, ?, ?, ?, ?, ?, GETDATE())";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, review.getUserId());
			ps.setInt(2, review.getProductId());
			ps.setInt(3, review.getStoreId());
			ps.setInt(4, review.getOrderId());
			ps.setString(5, review.getContent());
			ps.setInt(6, review.getRating());

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ReviewModel getById(int id) {
		ReviewModel reviewModel = new ReviewModel();
		try {
			String sql = "Select * from Review where id=?";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModel;
	}

	@Override
	public List<ReviewModel> getAll() {
		List<ReviewModel> reviewModelList = new ArrayList<ReviewModel>();
		try {
			String sql = "Select * from Review";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewModel reviewModel = new ReviewModel();

				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));

				reviewModelList.add(reviewModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModelList;
	}

	@Override
	public List<ReviewModel> getByUserId(int userId) {
		List<ReviewModel> reviewModelList = new ArrayList<ReviewModel>();
		try {
			String sql = "Select * from Review where userId = ?";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewModel reviewModel = new ReviewModel();

				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));

				reviewModelList.add(reviewModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModelList;
	}

	@Override
	public List<ReviewModel> getByProductId(int productId) {
		List<ReviewModel> reviewModelList = new ArrayList<ReviewModel>();
		try {
			String sql = "Select * from Review where productId = ?";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewModel reviewModel = new ReviewModel();

				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));

				reviewModelList.add(reviewModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModelList;
	}

	@Override
	public List<ReviewModel> getByStoreId(int storeId) {
		List<ReviewModel> reviewModelList = new ArrayList<ReviewModel>();
		try {
			String sql = "Select * from Review where storeId = ? ORDER BY updateAt DESC, createAt DESC ";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewModel reviewModel = new ReviewModel();

				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));

				reviewModelList.add(reviewModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModelList;
	}

	@Override
	public List<ReviewModel> getByOrderId(int orderId) {
		List<ReviewModel> reviewModelList = new ArrayList<ReviewModel>();
		try {
			String sql = "Select * from Review where orderId = ?";

			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewModel reviewModel = new ReviewModel();

				reviewModel.setId(rs.getInt("id"));
				reviewModel.setUserId(rs.getInt("userId"));
				reviewModel.setProductId(rs.getInt("productId"));
				reviewModel.setStoreId(rs.getInt("storeId"));
				reviewModel.setOrderId(rs.getInt("orderId"));
				reviewModel.setContent(rs.getString("content"));
				reviewModel.setRating(rs.getInt("rating"));
				reviewModel.setCreateAt(rs.getDate("createAt"));
				reviewModel.setUpdateAt(rs.getDate("updateAt"));

				reviewModelList.add(reviewModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewModelList;
	}

	@Override
	public void update(ReviewModel review) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE Review SET userId = ?, productId = ?, storeId = ?, orderId = ?, content = ?, rating = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, review.getUserId());
			ps.setInt(2, review.getProductId());
			ps.setInt(3, review.getStoreId());
			ps.setInt(4, review.getOrderId());
			ps.setString(5, review.getContent());
			ps.setInt(6, review.getRating());
			ps.setInt(7, review.getId());
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "DELETE Review WHERE id=?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BigDecimal avgRating(int productId) {
		try {
			String sql = "SELECT AVG(CAST(rating AS FLOAT)) AS averageRating FROM Review WHERE productId = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId); 
			rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getBigDecimal("averageRating");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
}

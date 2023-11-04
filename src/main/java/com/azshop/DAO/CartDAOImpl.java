package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.CartModel;

public class CartDAOImpl implements ICartDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(CartModel cart) {
		try {
			String sql = "INSERT INTO [Cart] (userId, storeId, createAt) "
					+ "VALUES (?, ?, GETDATE())";
			
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			
			ps.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CartModel getById(int id) {
		CartModel cart = new CartModel();
		try {
			String sql = "Select * from [Cart] where id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreateAt(rs.getDate("createAt"));
				cart.setUpdateAt(rs.getDate("updateAt"));
				
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<CartModel> getAll() {
		List<CartModel> cartModelList = new ArrayList<CartModel>();
		
		try {
			String sql = "Select * from [Cart]";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreateAt(rs.getDate("createAt"));
				cart.setUpdateAt(rs.getDate("updateAt"));
				
				cartModelList.add(cart);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartModelList;
	}

	@Override
	public List<CartModel> getByStoreId(int storeId) {
		List<CartModel> cartModelList = new ArrayList<CartModel>();
		
		try {
			String sql = "Select * from [Cart] where storeId = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreateAt(rs.getDate("createAt"));
				cart.setUpdateAt(rs.getDate("updateAt"));
				
				cartModelList.add(cart);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartModelList;
	}

	@Override
	public List<CartModel> getByUserId(int userId) {
List<CartModel> cartModelList = new ArrayList<CartModel>();
		
		try {
			String sql = "Select * from [Cart] where userId = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreateAt(rs.getDate("createAt"));
				cart.setUpdateAt(rs.getDate("updateAt"));
				
				cartModelList.add(cart);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartModelList;
	}

	@Override
	public void update(CartModel cart) {
		try {
			String sql = "UPDATE [Cart] SET userId = ?, storeId = ?, updateAt = GETDATE() where id=?";
			
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.setInt(3, cart.getId());
			
			ps.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "DELETE [Cart] WHERE id=?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			
			conn.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

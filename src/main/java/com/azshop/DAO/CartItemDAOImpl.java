package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.CartItemModel;

public class CartItemDAOImpl implements ICartItemDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(CartItemModel cartItem) {
		try {
			String sql = "INSERT INTO [CartItem] (cartId, productID, styleValueId, count, createAt) VALUES (?, ?, ?, ?, GETDATE())";
			
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getStyleValueId());
			ps.setInt(4, cartItem.getCount());
			
			ps.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CartItemModel getById(int id) {
		CartItemModel cartItemModel = new CartItemModel();
		
		try {
			String sql = "Select * from CartItem where id = ?";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);		
		
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				cartItemModel.setId(rs.getInt("id"));
				cartItemModel.setCartId(rs.getInt("cartID"));
				cartItemModel.setProductId(rs.getInt("productId"));
				cartItemModel.setProductId(rs.getInt("styleValueIds"));
				cartItemModel.setCount(rs.getInt("count"));
				cartItemModel.setCreateAt(rs.getDate("createAt"));
				cartItemModel.setUpdateAt(rs.getDate("updateAt"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartItemModel;
	}

	@Override
	public List<CartItemModel> getAll() {
		List<CartItemModel> cartItemModelList = new ArrayList<CartItemModel>();
		
		try {
			String sql = "Select * from CartItem";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);		
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItemModel = new CartItemModel();
				cartItemModel.setId(rs.getInt("id"));
				cartItemModel.setCartId(rs.getInt("cartId"));
				cartItemModel.setProductId(rs.getInt("productId"));
				cartItemModel.setStyleValueId(rs.getInt("styleValueId"));
				cartItemModel.setCount(rs.getInt("count"));
				cartItemModel.setCreateAt(rs.getDate("createAt"));
				cartItemModel.setUpdateAt(rs.getDate("updateAt"));
				
				cartItemModelList.add(cartItemModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartItemModelList;
	}

	@Override
	public List<CartItemModel> getByCartId(int cartId) {
		List<CartItemModel> cartItemModelList = new ArrayList<CartItemModel>();
		
		try {
			String sql = "Select * from CartItem where cartID = ?";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cartId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItemModel = new CartItemModel();
				cartItemModel.setId(rs.getInt("id"));
				cartItemModel.setCartId(rs.getInt("cartId"));
				cartItemModel.setProductId(rs.getInt("productId"));
				cartItemModel.setStyleValueId(rs.getInt("styleValueId"));
				cartItemModel.setCount(rs.getInt("count"));
				cartItemModel.setCreateAt(rs.getDate("createAt"));
				cartItemModel.setUpdateAt(rs.getDate("updateAt"));
				
				cartItemModelList.add(cartItemModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartItemModelList;
	}

	@Override
	public void update(CartItemModel cartItem) {
		try {
			String sql = "UPDATE CartItem SET cartId = ?, productId = ?, styleValueId = ?, count = ?, updateAt = GETDATE() where id=?";
			
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
						
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getStyleValueId());
			ps.setInt(4, cartItem.getCount());
			ps.setInt(5, cartItem.getId());
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "DELETE CartItem WHERE id=?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			conn.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.OrderItemModel;

public class OrderItemDAOImpl implements IOrderItemDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(OrderItemModel orderItem) {
		try {
			String sql = "INSERT INTO OrderItem (orderID, productId, count, createAt)"
					+ "VALUES (?, ?, ?, GETDATE())";
			
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, orderItem.getOrderId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderItemModel getById(int id) {
		OrderItemModel orderItemModel = new OrderItemModel();
		
		try {
			String sql = "Select *from OrderItem where id = ? and isDeleted = 0";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);		
		
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				orderItemModel.setId(rs.getInt("id"));
				orderItemModel.setOrderId(rs.getInt("orderID"));
				orderItemModel.setProductId(rs.getInt("productId"));
				orderItemModel.setCount(rs.getInt("count"));
				orderItemModel.setCreateAt(rs.getDate("createAt"));
				orderItemModel.setUpdateAt(rs.getDate("updateAt"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemModel;
	}

	@Override
	public List<OrderItemModel> getAll() {
		List<OrderItemModel> orderItemModelList = new ArrayList<OrderItemModel>();
		
		try {
			String sql = "Select *from OrderItem where isDeleted = 0";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);		
			
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderItemModel orderItemModel = new OrderItemModel();
				orderItemModel.setId(rs.getInt("id"));
				orderItemModel.setOrderId(rs.getInt("orderID"));
				orderItemModel.setProductId(rs.getInt("productId"));
				orderItemModel.setCount(rs.getInt("count"));
				orderItemModel.setCreateAt(rs.getDate("createAt"));
				orderItemModel.setUpdateAt(rs.getDate("updateAt"));
				
				orderItemModelList.add(orderItemModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemModelList;
	}

	@Override
	public List<OrderItemModel> getByOrderId(int orderId) {
		List<OrderItemModel> orderItemModelList = new ArrayList<OrderItemModel>();
		
		try {
			String sql = "Select *from OrderItem where orderID = ? and isDeleted = 0";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, orderId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderItemModel orderItemModel = new OrderItemModel();
				orderItemModel.setId(rs.getInt("id"));
				orderItemModel.setOrderId(rs.getInt("orderID"));
				orderItemModel.setProductId(rs.getInt("productId"));
				orderItemModel.setCount(rs.getInt("count"));
				orderItemModel.setCreateAt(rs.getDate("createAt"));
				orderItemModel.setUpdateAt(rs.getDate("updateAt"));
				
				orderItemModelList.add(orderItemModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemModelList;
	}

	@Override
	public List<OrderItemModel> getByProductId(int productId) {
		List<OrderItemModel> orderItemModelList = new ArrayList<OrderItemModel>();
		
		try {
			String sql = "Select *from OrderItem where productId = ? and isDeleted = 0";
			
			conn = new DBConnection().getConnection();			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, productId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderItemModel orderItemModel = new OrderItemModel();
				orderItemModel.setId(rs.getInt("id"));
				orderItemModel.setOrderId(rs.getInt("orderID"));
				orderItemModel.setProductId(rs.getInt("productId"));
				orderItemModel.setCount(rs.getInt("count"));
				orderItemModel.setCreateAt(rs.getDate("createAt"));
				orderItemModel.setUpdateAt(rs.getDate("updateAt"));
				
				orderItemModelList.add(orderItemModel);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderItemModelList;
	}

	@Override
	public void update(OrderItemModel orderItem) {
		try {
			String sql = "UPDATE OrderItem SET orderID = ?, productId = ?, count = ?, updateAt = GETDATE() where id=?";
			
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
						
			ps.setInt(1, orderItem.getOrderId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			ps.setInt(4, orderItem.getId());
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "UPDATE OrderItem SET isDeleted = 1 WHERE id = ?";
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

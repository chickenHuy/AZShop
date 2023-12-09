package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.DeliveryModel;

public class DeliveryDAOImpl implements IDeliveryDAO{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(DeliveryModel delivery) {
		try {
			String sql = "INSERT INTO Delivery (name, price, description, createAt) VALUES (?, ?, ?, GETDATE())";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, delivery.getName());
			ps.setBigDecimal(2, delivery.getPrice());
			ps.setString(3, delivery.getDescription());
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
	}

	@Override
	public DeliveryModel getById(int id) {
		DeliveryModel deliveryModel = new DeliveryModel();
		try {
			 String sql = "SELECT * FROM Delivery WHERE id = ? and isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	deliveryModel.setId(rs.getInt("id"));
		        	deliveryModel.setName(rs.getString("name"));
		        	deliveryModel.setPrice(rs.getBigDecimal("price"));
		        	deliveryModel.setDescription(rs.getString("description"));
		        	deliveryModel.setCreateAt(rs.getDate("createAt"));
		        	deliveryModel.setUpdateAt(rs.getDate("updateAt"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deliveryModel;
	}

	@Override
	public List<DeliveryModel> getAll() {
		List<DeliveryModel> deliveryList = new ArrayList<DeliveryModel>();
	    try {
	        String sql = "SELECT * FROM Delivery where isDeleted = 0";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            DeliveryModel deliveryModel = new DeliveryModel();
	            deliveryModel.setId(rs.getInt("id"));
	        	deliveryModel.setName(rs.getString("name"));
	        	deliveryModel.setPrice(rs.getBigDecimal("price"));
	        	deliveryModel.setDescription(rs.getString("description"));
	        	deliveryModel.setCreateAt(rs.getDate("createAt"));
	        	deliveryModel.setUpdateAt(rs.getDate("updateAt"));
	            
	            deliveryList.add(deliveryModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return deliveryList;
	}

	@Override
	public void update(DeliveryModel delivery) {
		try {
			String sql =  "UPDATE Delivery SET name = ?, price = ?, description = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, delivery.getName());
			ps.setBigDecimal(2, delivery.getPrice());
			ps.setString(3, delivery.getDescription());
			ps.setInt(4, delivery.getId());
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
	}

	@Override
	public void delete(int id) {
		try {
			String sql =  "UPDATE Delivery SET isDeleted = 1 WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
	}
	

}

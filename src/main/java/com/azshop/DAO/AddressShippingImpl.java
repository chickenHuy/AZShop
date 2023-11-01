package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.AddressShippingModel;


public class AddressShippingImpl implements IAddressShippingDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(AddressShippingModel addressShipping) {
		try {
			String sql = "INSERT INTO AddressShipping (userId, recipientName, address, phone) VALUES (?, ?, ?, ?)";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, addressShipping.getUserId());
			ps.setString(2, addressShipping.getRecipientName());
			ps.setString(3, addressShipping.getAddress());
			ps.setString(4, addressShipping.getPhone());
			
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public AddressShippingModel getById(int id) {
		AddressShippingModel addressShippingModel = new AddressShippingModel();
		try {
			 String sql = "SELECT * FROM AddressShipping WHERE id = ?";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		            addressShippingModel.setId(rs.getInt("id"));
		            addressShippingModel.setUserId(rs.getInt("userId"));
		            addressShippingModel.setRecipientName(rs.getString("recipientName"));
		            addressShippingModel.setAddress(rs.getString("address"));
		            addressShippingModel.setPhone(rs.getString("phone"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressShippingModel;
	}

	@Override
	public List<AddressShippingModel> getByUserId(int userId) {
		List<AddressShippingModel> addressShippingList = new ArrayList<AddressShippingModel>();
	    try {
	        String sql = "SELECT * FROM AddressShipping WHERE userId = ?";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, userId);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            AddressShippingModel addressShippingModel = new AddressShippingModel();
	            addressShippingModel.setId(rs.getInt("id"));
	            addressShippingModel.setUserId(rs.getInt("userId"));
	            addressShippingModel.setRecipientName(rs.getString("recipientName"));
	            addressShippingModel.setAddress(rs.getString("address"));
	            addressShippingModel.setPhone(rs.getString("phone"));
	            
	            addressShippingList.add(addressShippingModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return addressShippingList;
	}

	@Override
	public List<AddressShippingModel> getAll() {
		List<AddressShippingModel> addressShippingList = new ArrayList<AddressShippingModel>();
	    try {
	        String sql = "SELECT * FROM AddressShipping";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            AddressShippingModel addressShippingModel = new AddressShippingModel();
	            addressShippingModel.setId(rs.getInt("id"));
	            addressShippingModel.setUserId(rs.getInt("userId"));
	            addressShippingModel.setRecipientName(rs.getString("recipientName"));
	            addressShippingModel.setAddress(rs.getString("address"));
	            addressShippingModel.setPhone(rs.getString("phone"));
	            
	            addressShippingList.add(addressShippingModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return addressShippingList;
	}

	@Override
	public void update(AddressShippingModel addressShipping) {
		try {
			String sql =  "UPDATE AddressShipping SET userId = ?, recipientName = ?, address = ?, phone = ? WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, addressShipping.getUserId());
			ps.setString(2, addressShipping.getRecipientName());
			ps.setString(3, addressShipping.getAddress());
			ps.setString(4, addressShipping.getPhone());
			
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
			String sql = "DELETE AddressShipping WHERE id=?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			conn.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	

}

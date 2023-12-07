package com.azshop.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.StyleValueModel;

public class StyleValueDAOImpl implements IStyleValueDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void insert(StyleValueModel styleValue) {
		try {
			String sql = "INSERT INTO StyleValue (name, styleId, isDeleted, createAt) VALUES (?, ?, ?, GETDATE() )";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
		
            ps.setString(1, styleValue.getName());
            ps.setInt(2, styleValue.getStyleId());
            ps.setBoolean(3, false);
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public StyleValueModel getById(int id) {
		StyleValueModel styleValueModel = new StyleValueModel();
		try {
			 String sql = "SELECT * FROM StyleValue WHERE id = ? AND isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	styleValueModel.setId(rs.getInt("id"));
		        	styleValueModel.setName(rs.getString("name"));
		            styleValueModel.setStyleId(rs.getInt("styleId"));
		            styleValueModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleValueModel.setCreateAt(rs.getDate("createAt"));
		            styleValueModel.setUpdateAt(rs.getDate("updateAt"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleValueModel;
	}

	@Override
	public List<StyleValueModel> getAll() {
		List<StyleValueModel> styleValueModels = new ArrayList<StyleValueModel>();
		try {
			 String sql = "SELECT * FROM StyleValue WHERE isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		        	StyleValueModel styleValueModel = new StyleValueModel();
		        	styleValueModel.setId(rs.getInt("id"));
		        	styleValueModel.setName(rs.getString("name"));
		            styleValueModel.setStyleId(rs.getInt("styleId"));
		            styleValueModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleValueModel.setCreateAt(rs.getDate("createAt"));
		            styleValueModel.setUpdateAt(rs.getDate("updateAt"));
		            
		            styleValueModels.add(styleValueModel);
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleValueModels;
	}
	
	@Override
	public List<StyleValueModel> getByStyleIdAmin(int id) {
		List<StyleValueModel> styleValueModels = new ArrayList<StyleValueModel>();
		try {
			 String sql = "SELECT * FROM StyleValue WHERE styleId = ?";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        while (rs.next()) {
		        	StyleValueModel styleValueModel = new StyleValueModel();
		        	styleValueModel.setId(rs.getInt("id"));
		        	styleValueModel.setName(rs.getString("name"));
		            styleValueModel.setStyleId(rs.getInt("styleId"));
		            styleValueModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleValueModel.setCreateAt(rs.getDate("createAt"));
		            styleValueModel.setUpdateAt(rs.getDate("updateAt"));
		            
		            styleValueModels.add(styleValueModel);
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleValueModels;
	}

	@Override
	public List<StyleValueModel> getByStyleId(int styleId) {
		List<StyleValueModel> styleValueModels = new ArrayList<StyleValueModel>();
		try {
			 String sql = "SELECT * FROM StyleValue WHERE styleId = ? AND isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, styleId);
		        
		        rs = ps.executeQuery();
		        while (rs.next()) {
		        	StyleValueModel styleValueModel = new StyleValueModel();
		        	styleValueModel.setId(rs.getInt("id"));
		        	styleValueModel.setName(rs.getString("name"));
		            styleValueModel.setStyleId(rs.getInt("styleId"));
		            styleValueModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleValueModel.setCreateAt(rs.getDate("createAt"));
		            styleValueModel.setUpdateAt(rs.getDate("updateAt"));
		            
		            styleValueModels.add(styleValueModel);
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleValueModels;
	}

	@Override
	public void update(StyleValueModel styleValue) {
		try {
			String sql = "UPDATE StyleValue SET name = ?, styleId = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
		
            ps.setString(1, styleValue.getName());
            ps.setInt(2, styleValue.getStyleId());
            ps.setInt(3, styleValue.getId());
            
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
			String sql = "UPDATE StyleValue SET isDeleted = 1, updateAt = GETDATE() WHERE id = ?";
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
	
	@Override
	public void restore(int id) {
		try {
			String sql = "UPDATE StyleValue SET isDeleted = 0, updateAt = GETDATE() WHERE id = ?";
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

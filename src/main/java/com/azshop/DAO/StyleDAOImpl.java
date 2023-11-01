package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.StyleModel;

public class StyleDAOImpl implements IStyleDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(StyleModel style) {
		try {
			String sql = "INSERT INTO styles (id, name, categoryId, isDeleted, createAt) VALUES (?, ?, ?, ?, GETDATE())";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, style.getId());
			ps.setString(2, style.getName());
			ps.setInt(3, style.getCategoryId());
			ps.setBoolean(4, false);
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public StyleModel getById(int id) {
		StyleModel styleModel = new StyleModel();
		try {
			 String sql = "SELECT * FROM Style WHERE id = ? AND isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	styleModel.setId(rs.getInt("id"));
		        	styleModel.setName(rs.getString("name"));
		        	styleModel.setCategoryId(rs.getInt("categoryId"));
		        	styleModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleModel.setCreateAt(rs.getDate("createAt"));
		            styleModel.setUpdateAt(rs.getDate("updateAt"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleModel;
	}

	@Override
	public List<StyleModel> getAll() {
		List<StyleModel> styleModels = new ArrayList<StyleModel>();
		try {
			 String sql = "SELECT * FROM Style WHERE isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        
		        rs = ps.executeQuery();
		        while (rs.next()) {
		        	StyleModel styleModel = new StyleModel();
		        	styleModel.setId(rs.getInt("id"));
		        	styleModel.setName(rs.getString("name"));
		        	styleModel.setCategoryId(rs.getInt("categoryId"));
		        	styleModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleModel.setCreateAt(rs.getDate("createAt"));
		            styleModel.setUpdateAt(rs.getDate("updateAt"));
		            
		            styleModels.add(styleModel);
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleModels;
	}

	@Override
	public List<StyleModel> getByCategoryId(int categoryId) {
		List<StyleModel> styleModels = new ArrayList<StyleModel>();
		try {
			 String sql = "SELECT * FROM Style WHERE categoryId = ?, isDeleted = 0";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, categoryId);
		        rs = ps.executeQuery();
		        
		        while (rs.next()) {
		        	StyleModel styleModel = new StyleModel();
		        	styleModel.setId(rs.getInt("id"));
		        	styleModel.setName(rs.getString("name"));
		        	styleModel.setCategoryId(rs.getInt("categoryId"));
		        	styleModel.setDeleted(rs.getBoolean("isDeleted"));
		            styleModel.setCreateAt(rs.getDate("createAt"));
		            styleModel.setUpdateAt(rs.getDate("updateAt"));
		            
		            styleModels.add(styleModel);
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return styleModels;
	}

	@Override
	public void update(StyleModel style) {
		try {
		    String sql = "UPDATE styles SET name = ?, categoryId = ?, updateAt = GETDATE() WHERE id = ?";
		    conn = new DBConnection().getConnection();
		    
		    ps = conn.prepareStatement(sql);
		    
		    ps.setString(1, style.getName());
		    ps.setInt(2, style.getCategoryId());
		    ps.setInt(3, style.getId());
		    ps.executeUpdate();
		    
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {
		    String sql = "UPDATE styles SET isDeleted = 1, updateAt = GETDATE() WHERE id = ?";
		    conn = new DBConnection().getConnection();
		    
		    ps = conn.prepareStatement(sql);
		    
		    ps.setInt(1, id);
		    ps.executeUpdate();
		    
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
}

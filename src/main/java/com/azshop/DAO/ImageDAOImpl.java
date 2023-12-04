package com.azshop.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.ImageModel;

public class ImageDAOImpl implements IImageDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(ImageModel image) {
		try {
			String sql = "INSERT INTO Image (productId, image) VALUES (?, ?)";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, image.getProductId());
			ps.setString(2, image.getImage());
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
	}

	@Override
	public ImageModel getById(int id) {
		ImageModel imageModel = new ImageModel();
		try {
			 String sql = "SELECT * FROM Image WHERE id = ?";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	imageModel.setId(rs.getInt("id"));
		        	imageModel.setProductId(rs.getInt("productId"));
		        	imageModel.setImage(rs.getString("image"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageModel;
	}

	@Override
	public List<ImageModel> getAll() {
		List<ImageModel> imageList = new ArrayList<ImageModel>();
	    try {
	        String sql = "SELECT * FROM Image";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            ImageModel imageModel = new ImageModel();
	            imageModel.setId(rs.getInt("id"));
	        	imageModel.setProductId(rs.getInt("productId"));
	        	imageModel.setImage(rs.getString("image"));
	            
	            imageList.add(imageModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return imageList;
	}

	@Override
	public List<ImageModel> getByProductId(int productId) {
		List<ImageModel> imageList = new ArrayList<ImageModel>();
	    try {
	        String sql = "SELECT * FROM Image WHERE productId = ?";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, productId);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	ImageModel imageModel = new ImageModel();
	            imageModel.setId(rs.getInt("id"));
	        	imageModel.setProductId(rs.getInt("productId"));
	        	imageModel.setImage(rs.getString("image"));
	            
	            imageList.add(imageModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return imageList;
	}

	@Override
	public void update(ImageModel image) {
		try {
			String sql =  "UPDATE Image SET product = ?, image = ? WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, image.getProductId());
			ps.setString(2, image.getImage());
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
			String sql =  "DELETE FROM Image WHERE id = ?";
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
	public ImageModel getImage(int productId) {
		ImageModel imageModel = new ImageModel();
		try {
			 String sql = "WITH RankedImages AS (\r\n"
			 		+ "    SELECT\r\n"
			 		+ "        id,\r\n"
			 		+ "        productId,\r\n"
			 		+ "        image,\r\n"
			 		+ "        ROW_NUMBER() OVER (PARTITION BY productId ORDER BY CAST(SUBSTRING(image, 1, 1) AS INT) ASC) AS RowNum\r\n"
			 		+ "    FROM\r\n"
			 		+ "        Image\r\n"
			 		+ "    WHERE\r\n"
			 		+ "        productId = ?\r\n"
			 		+ ")\r\n"
			 		+ "SELECT\r\n"
			 		+ "    id,\r\n"
			 		+ "    productId,\r\n"
			 		+ "    image\r\n"
			 		+ "FROM\r\n"
			 		+ "    RankedImages\r\n"
			 		+ "WHERE\r\n"
			 		+ "    RowNum = 1;\r\n"
			 		+ "";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, productId);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	imageModel.setId(rs.getInt("id"));
		        	imageModel.setProductId(rs.getInt("productId"));
		        	imageModel.setImage(rs.getString("image"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageModel;
	}
	

}

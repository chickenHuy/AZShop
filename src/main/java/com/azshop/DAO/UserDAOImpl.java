package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.UserModel;

public class UserDAOImpl implements IUserDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(UserModel user) {
		try {
			String sql = "INSERT INTO User (firstName, lastName, slug, cartId, email, phone, isEmailActive, isPhoneActive, salt, hashedPassword, role, userLevelId, avatar, coverImage, point, eWallet, createAt, updateAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GetDate(), GetDate())";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getSlug());
			ps.setString(4, user.getCartId());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setBoolean(7, user.isEmailActive());
			ps.setBoolean(8, user.isPhoneActive());
			ps.setString(9, user.getSalt());
			ps.setString(10, user.getHashedPassword());
			ps.setString(11, user.getRole());
			ps.setInt(12, user.getUserLevelId());
			ps.setString(13, user.getAvatar());
			ps.setString(14, user.getCoverImage());
			ps.setInt(15, user.getPoint());
			ps.setBigDecimal(16, user.geteWallet());
			
			
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void update(UserModel user) {
		try {
			String sql =  "UPDATE User SET firstName = ?, lastName = ?, slug = ?, cartId = ?, email = ?, phone = ?, isEmailActive = ?, isPhoneActive = ?, salt = ?, hashedPassword = ?, role = ?, userLevelId = ?, avatar = ?, coverImage = ?, point = ?, eWallet = ?, updateAt = GetDate() WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getSlug());
			ps.setString(4, user.getCartId());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setBoolean(7, user.isEmailActive());
			ps.setBoolean(8, user.isPhoneActive());
			ps.setString(9, user.getSalt());
			ps.setString(10, user.getHashedPassword());
			ps.setString(11, user.getRole());
			ps.setInt(12, user.getUserLevelId());
			ps.setString(13, user.getAvatar());
			ps.setString(14, user.getCoverImage());
			ps.setInt(15, user.getPoint());
			ps.setBigDecimal(16, user.geteWallet());
			ps.setInt(17, user.getId());
			
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
			String sql = "DELETE User WHERE id=?";
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

	@Override
	public List<UserModel> getAll() {
		List<UserModel> userModelList = new ArrayList<UserModel>();
	    try {
	        String sql = "SELECT * FROM User";
	        conn = new DBConnection().getConnection();
	        
	        ps = conn.prepareStatement(sql);
	        
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	UserModel userModel = new UserModel();
	        	userModel.setId(rs.getInt("id"));
	        	userModel.setFirstName(rs.getString("firstName"));
	        	userModel.setLastName(rs.getString("lastName"));
	        	userModel.setSlug(rs.getString("slug"));
	        	userModel.setCartId(rs.getString("cartId"));
	        	userModel.setEmail(rs.getString("email"));
	        	userModel.setPhone(rs.getString("phone"));
	        	userModel.setEmailActive(rs.getBoolean("isEmailActive"));
	        	userModel.setPhoneActive(rs.getBoolean("isPhoneActive"));
	        	userModel.setSalt(rs.getString("salt"));
	        	userModel.setHashedPassword(rs.getString("hashedPassword"));
	        	userModel.setRole(rs.getString("role"));
	        	userModel.setUserLevelId(rs.getInt("userLevelId"));
	        	userModel.setAvatar(rs.getString("avatar"));
	        	userModel.setCoverImage(rs.getString("coverImage"));
	        	userModel.setPoint(rs.getInt("point"));
	        	userModel.seteWallet(rs.getBigDecimal("eWallet"));
	        	userModel.setCreateAt(rs.getDate("createAt"));
	        	userModel.setUpdateAt(rs.getDate("updateAt"));
	            
	            userModelList.add(userModel);
	        }
	        
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return userModelList;
	}

	@Override
	public UserModel getById(int id) {
		UserModel userModel = new UserModel();
		try {
			 String sql = "SELECT * FROM User WHERE id = ?";
		        conn = new DBConnection().getConnection();
		        
		        ps = conn.prepareStatement(sql);
		        ps.setInt(1, id);
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	userModel.setId(rs.getInt("id"));
		        	userModel.setFirstName(rs.getString("firstName"));
		            userModel.setLastName(rs.getString("lastName"));
		            userModel.setSlug(rs.getString("slug"));
		            userModel.setCartId(rs.getString("cartId"));
		            userModel.setEmail(rs.getString("email"));
		            userModel.setPhone(rs.getString("phone"));
		            userModel.setEmailActive(rs.getBoolean("isEmailActive"));
		            userModel.setPhoneActive(rs.getBoolean("isPhoneActive"));
		            userModel.setSalt(rs.getString("salt"));
		            userModel.setHashedPassword(rs.getString("hashedPassword"));
		            userModel.setRole(rs.getString("role"));
		            userModel.setUserLevelId(rs.getInt("userLevelId"));
		            userModel.setAvatar(rs.getString("avatar"));
		            userModel.setCoverImage(rs.getString("coverImage"));
		            userModel.setPoint(rs.getInt("point"));
		            userModel.seteWallet(rs.getBigDecimal("eWallet"));
		            userModel.setCreateAt(rs.getDate("createAt"));
		            userModel.setUpdateAt(rs.getDate("updateAt"));
		        }
		        
		        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userModel;
	}

}

package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.UserLevelModel;

public class UserLevelDAOImpl implements IUserLevelDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(UserLevelModel userLevel) {
		try {
			String sql = "INSERT INTO UserLevel (name, minPoint, discount, isDeleted, createdAt) VALUES (?, ?, ?, 'false', GetDate())";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userLevel.getName());
			ps.setInt(2, userLevel.getMinPoint());
			ps.setInt(3, userLevel.getDiscount());
			
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void update(UserLevelModel userLevel) {
		try {
			String sql =  "UPDATE UserLevel SET name = ?, minPoint = ?, discount = ?, isDeleted = ?, updatedAt = GetDate() WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userLevel.getName());
			ps.setInt(2, userLevel.getMinPoint());
			ps.setInt(3, userLevel.getDiscount());
			ps.setBoolean(4, userLevel.isDeleted());
			ps.setInt(5, userLevel.getId());
			
			ps.executeUpdate();
			
			conn.close();
		    } 
		catch (Exception e) 
			{
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void delete(UserLevelModel userLevel) {
		try {
			String sql = "UPDATE UserLevel SET name = ?, minPoint = ?, discount = ?, isDeleted = True, updatedAt = GetDate() WHERE id = ?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);

			ps.setString(1, userLevel.getName());
			ps.setInt(2, userLevel.getMinPoint());
			ps.setInt(3, userLevel.getDiscount());
			ps.setInt(4, userLevel.getId());
			
			ps.executeUpdate();
			
			conn.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public UserLevelModel getById(int id) {
		UserLevelModel userLevel = new UserLevelModel();
		try {
		    String sql = "SELECT * FROM UserLevel WHERE id = ?";
		    conn = new DBConnection().getConnection();

		    ps = conn.prepareStatement(sql);
		    ps.setInt(1, id);

		    rs = ps.executeQuery();
		    while (rs.next()) {
		        userLevel.setId(rs.getInt("id"));
		        userLevel.setName(rs.getString("name"));
		        userLevel.setMinPoint(rs.getInt("minPoint"));
		        userLevel.setDiscount(rs.getInt("discount"));
		        userLevel.setDeleted(rs.getBoolean("isDeleted"));
		        userLevel.setCreatedAt(rs.getDate("createdAt"));
		        userLevel.setUpdatedAt(rs.getDate("updatedAt"));
		    }
		    conn.close();
		    return userLevel;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserLevelModel> getAll() {
		List<UserLevelModel> userLevelList = new ArrayList<UserLevelModel>();
		try {
		    String sql = "SELECT * FROM UserLevel WHERE isDeleted = 0";
		    conn = new DBConnection().getConnection();

		    ps = conn.prepareStatement(sql);

		    rs = ps.executeQuery();
		    while (rs.next()) {
		    	UserLevelModel userLevel = new UserLevelModel();
		        userLevel.setId(rs.getInt("id"));
		        userLevel.setName(rs.getString("name"));
		        userLevel.setMinPoint(rs.getInt("minPoint"));
		        userLevel.setDiscount(rs.getInt("discount"));
		        userLevel.setDeleted(rs.getBoolean("isDeleted"));
		        userLevel.setCreatedAt(rs.getDate("createdAt"));
		        userLevel.setUpdatedAt(rs.getDate("updatedAt"));

		        userLevelList.add(userLevel);
		    }

		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return userLevelList;
	}

	@Override
	public boolean checkName(String name) {
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement("SELECT * from UserLevel WHERE name = ?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				String temp = rs.getString("name");
				if (temp.equals(name)) {
					return true;
				}
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<UserLevelModel> getAllDeleted() {
		List<UserLevelModel> userLevelList = new ArrayList<UserLevelModel>();
		try {
		    String sql = "SELECT * FROM UserLevel WHERE isDeleted = 1";
		    conn = new DBConnection().getConnection();

		    ps = conn.prepareStatement(sql);

		    rs = ps.executeQuery();
		    while (rs.next()) {
		    	UserLevelModel userLevel = new UserLevelModel();
		        userLevel.setId(rs.getInt("id"));
		        userLevel.setName(rs.getString("name"));
		        userLevel.setMinPoint(rs.getInt("minPoint"));
		        userLevel.setDiscount(rs.getInt("discount"));
		        userLevel.setDeleted(rs.getBoolean("isDeleted"));
		        userLevel.setCreatedAt(rs.getDate("createdAt"));
		        userLevel.setUpdatedAt(rs.getDate("updatedAt"));

		        userLevelList.add(userLevel);
		    }

		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return userLevelList;
	}

}

package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.UserFollowStoreModel;

public class UserFollowStoreDAOImpl implements IUserFollowStoreDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(UserFollowStoreModel userFollowStore) {
		try {
			String sql = "INSERT INTO dbo.UserFollowStore(userId, storeId, createAt, updateAt) VALUES(?, ?, GETDATE(), NULL)";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userFollowStore.getUserId());
			ps.setInt(2, userFollowStore.getStoreId());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(UserFollowStoreModel userFollowStore) {
		try {
			String sql = "UPDATE dbo.UserFollowStore SET userId = ?, storeId = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userFollowStore.getUserId());
			ps.setInt(2, userFollowStore.getStoreId());
			ps.setInt(3, userFollowStore.getId());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			String sql = "DELETE FROM dbo.UserFollowStore WHERE id = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UserFollowStoreModel> getAll() {
		List<UserFollowStoreModel> listUserFollowStoreModels = new ArrayList<UserFollowStoreModel>();
		try {
			String sql = "SELECT * FROM dbo.UserFollowStore;";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			conn.close();

			while (rs.next()) {
				UserFollowStoreModel userFollowStore = new UserFollowStoreModel();
				userFollowStore.setId(rs.getInt("id"));
				userFollowStore.setUserId(rs.getInt("userId"));
				userFollowStore.setStoreId(rs.getInt("storeId"));
				userFollowStore.setCreateAt(rs.getDate("createAt"));
				userFollowStore.setUpdateAt(rs.getDate("updateAt"));

				listUserFollowStoreModels.add(userFollowStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUserFollowStoreModels;
	}

	@Override
	public List<UserFollowStoreModel> getByUserId(int userId) {
		List<UserFollowStoreModel> listUserFollowStoreModels = new ArrayList<UserFollowStoreModel>();
		try {
			String sql = "SELECT * FROM dbo.UserFollowStore WHERE userId = ?;";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			conn.close();

			while (rs.next()) {
				UserFollowStoreModel userFollowStore = new UserFollowStoreModel();
				userFollowStore.setId(rs.getInt("id"));
				userFollowStore.setUserId(rs.getInt("userId"));
				userFollowStore.setStoreId(rs.getInt("storeId"));
				userFollowStore.setCreateAt(rs.getDate("createAt"));
				userFollowStore.setUpdateAt(rs.getDate("updateAt"));

				listUserFollowStoreModels.add(userFollowStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUserFollowStoreModels;
	}

	@Override
	public List<UserFollowStoreModel> getByStoreId(int storeId) {
		List<UserFollowStoreModel> listUserFollowStoreModels = new ArrayList<UserFollowStoreModel>();
		try {
			String sql = "SELECT * FROM dbo.UserFollowStore WHERE storeId = ?;";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();
			conn.close();

			while (rs.next()) {
				UserFollowStoreModel userFollowStore = new UserFollowStoreModel();
				userFollowStore.setId(rs.getInt("id"));
				userFollowStore.setUserId(rs.getInt("userId"));
				userFollowStore.setStoreId(rs.getInt("storeId"));
				userFollowStore.setCreateAt(rs.getDate("createAt"));
				userFollowStore.setUpdateAt(rs.getDate("updateAt"));

				listUserFollowStoreModels.add(userFollowStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUserFollowStoreModels;
	}

}

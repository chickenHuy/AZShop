package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.StoreModel;

public class StoreDAOImpl implements IStoreDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void insert(StoreModel store) {
        try {
            String sql = "INSERT INTO Store (name, bio, slug, ownerId, storeLevelId, isActive, isDeleted, avatar, cover, featuredImage, point, rating, eWallet, createAt) " +
                         "VALUES (?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?, GETDATE())";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, store.getName());
            ps.setString(2, store.getBio());
            ps.setString(3, store.getSlug());
            ps.setInt(4, store.getOwnerId());
            ps.setInt(5, store.getStoreLevelId());
            ps.setBoolean(6, store.isActive());
            ps.setString(7, store.getAvatar());
            ps.setString(8, store.getCover());
            ps.setString(9, store.getFeaturedImage());
            ps.setInt(10, store.getPoint());
            ps.setBigDecimal(11, store.getRating());
            ps.setBigDecimal(12, store.geteWallet());

            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StoreModel store) {
        try {
            String sql = "UPDATE Store SET name = ?, bio = ?, ownerId = ?, storeLevelId = ?, isActive = ?, isDeleted = ?, avatar = ?, cover = ?, featuredImage = ?, point = ?, rating = ?, eWallet = ?, updateAt = GETDATE() " +
                         "WHERE id = ?";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, store.getName());
            ps.setString(2, store.getBio());
            ps.setInt(3, store.getOwnerId());
            ps.setInt(4, store.getStoreLevelId());
            ps.setBoolean(5, store.isActive());
            ps.setBoolean(6, store.isDeleted());
            ps.setString(7, store.getAvatar());
            ps.setString(8, store.getCover());
            ps.setString(9, store.getFeaturedImage());
            ps.setInt(10, store.getPoint());
            ps.setBigDecimal(11, store.getRating());
            ps.setBigDecimal(12, store.geteWallet());
            ps.setInt(13, store.getId());

            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Store WHERE id=?";
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
    public StoreModel getById(int id) {
        StoreModel store = new StoreModel();
        try {
            String sql = "SELECT * FROM Store WHERE id = ? AND isDeleted = 0";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                store.setId(rs.getInt("id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStoreLevelId(rs.getInt("storeLevelId"));
                store.setActive(rs.getBoolean("isActive"));
                store.setDeleted(rs.getBoolean("isDeleted"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setFeaturedImage(rs.getString("featuredImage"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getBigDecimal("rating"));
                store.seteWallet(rs.getBigDecimal("eWallet"));
                store.setCreateAt(rs.getDate("createAt"));
                store.setUpdateAt(rs.getDate("updateAt"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return store;
    }

    @Override
    public List<StoreModel> getAll() {
        List<StoreModel> storeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Store WHERE isDeleted = 0";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                StoreModel store = new StoreModel();
                store.setId(rs.getInt("id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStoreLevelId(rs.getInt("storeLevelId"));
                store.setActive(rs.getBoolean("isActive"));
                store.setDeleted(rs.getBoolean("isDeleted"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setFeaturedImage(rs.getString("featuredImage"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getBigDecimal("rating"));
                store.seteWallet(rs.getBigDecimal("eWallet"));
                store.setCreateAt(rs.getDate("createAt"));
                store.setUpdateAt(rs.getDate("updateAt"));

                storeList.add(store);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeList;
    }

    @Override
    public List<StoreModel> getByStoreLevelId(int storeLevelId) {
        List<StoreModel> storeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Store WHERE storeLevelId = ?";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, storeLevelId);

            rs = ps.executeQuery();
            while (rs.next()) {
                StoreModel store = new StoreModel();
                store.setId(rs.getInt("id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStoreLevelId(rs.getInt("storeLevelId"));
                store.setActive(rs.getBoolean("isActive"));
                store.setDeleted(rs.getBoolean("isDeleted"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setFeaturedImage(rs.getString("featuredImage"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getBigDecimal("rating"));
                store.seteWallet(rs.getBigDecimal("eWallet"));
                store.setCreateAt(rs.getDate("createAt"));
                store.setUpdateAt(rs.getDate("updateAt"));

                storeList.add(store);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeList;
    }

	@Override
	public StoreModel getBySlug(String slug) {
		StoreModel store = new StoreModel();
        try {
            String sql = "SELECT * FROM Store WHERE slug = ? AND isDeleted = 0 ";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, slug);

            rs = ps.executeQuery();
            while (rs.next()) {
                store.setId(rs.getInt("id"));
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerId(rs.getInt("ownerId"));
                store.setStoreLevelId(rs.getInt("storeLevelId"));
                store.setActive(rs.getBoolean("isActive"));
                store.setDeleted(rs.getBoolean("isDeleted"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setFeaturedImage(rs.getString("featuredImage"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getBigDecimal("rating"));
                store.seteWallet(rs.getBigDecimal("eWallet"));
                store.setCreateAt(rs.getDate("createAt"));
                store.setUpdateAt(rs.getDate("updateAt"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return store;
	}
}

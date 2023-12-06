package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.StoreLevelModel;

public class StoreLevelDAOImpl implements IStoreLevelDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void insert(StoreLevelModel storeLevel) {
        try {
            String sql = "INSERT INTO StoreLevel (name, isDeleted, minPoint, discount, createAt) VALUES (?, 0, ?, ?, GETDATE())";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, storeLevel.getName());
            ps.setBoolean(2,storeLevel.isDeleted());
            ps.setInt(3, storeLevel.getMinPoint());
            ps.setInt(4, storeLevel.getDiscount());

            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StoreLevelModel storeLevel) {
        try {
            String sql = "UPDATE StoreLevel SET name = ?, isDeleted = ?, minPoint = ?, discount = ?, updateAt = GETDATE() WHERE id = ?";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            ps.setString(1, storeLevel.getName());
            ps.setBoolean(2, storeLevel.isDeleted());
            ps.setInt(3, storeLevel.getMinPoint());
            ps.setInt(4, storeLevel.getDiscount());
            ps.setInt(5, storeLevel.getId());

            ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM StoreLevel WHERE id=?";
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
    public StoreLevelModel getById(int id) {
        StoreLevelModel storeLevel = new StoreLevelModel();
        try {
            String sql = "SELECT * FROM StoreLevel WHERE id = ?";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                storeLevel.setId(rs.getInt("id"));
                storeLevel.setName(rs.getString("name"));
                storeLevel.setMinPoint(rs.getInt("minPoint"));
                storeLevel.setDiscount(rs.getInt("discount"));
                storeLevel.setDeleted(rs.getBoolean("isDeleted"));
                storeLevel.setCreateAt(rs.getDate("createAt"));
                storeLevel.setUpdateAt(rs.getDate("updateAt"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeLevel;
    }

    @Override
    public List<StoreLevelModel> getAll() {
        List<StoreLevelModel> storeLevelList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM StoreLevel";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                StoreLevelModel storeLevel = new StoreLevelModel();
                storeLevel.setId(rs.getInt("id"));
                storeLevel.setName(rs.getString("name"));
                storeLevel.setMinPoint(rs.getInt("minPoint"));
                storeLevel.setDiscount(rs.getInt("discount"));
                storeLevel.setDeleted(rs.getBoolean("isDeleted"));
                storeLevel.setCreateAt(rs.getDate("createAt"));
                storeLevel.setUpdateAt(rs.getDate("updateAt"));

                storeLevelList.add(storeLevel);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeLevelList;
    }

	@Override
	public int getDefaultLevel() {
        try {
            String sql = "SELECT * FROM StoreLevel WHERE minPoint = 0";
            conn = new DBConnection().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
	}
}

package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.CategoryModel;

public class CategoryDAOImpl implements ICategoryDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CategoryModel category) {
		try {
			String sql = "INSERT INTO Category(categoryId, name, slug, image, isDeleted, createAt) VALUES ( ?, ?, ?, ?, ?, GETDATE() )";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, category.getCategoryId());
			ps.setString(2, category.getName());
			ps.setString(3, category.getSlug());
			ps.setString(4, category.getImage());
			ps.setBoolean(5, false);
			
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel getById(int id) {
		CategoryModel category = new CategoryModel();
		try {
			String sql = "SELECT * FROM Category WHERE id = ? AND isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				category.setId(rs.getInt("id"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setImage(rs.getString("image"));
				category.setDeleted(rs.getBoolean("isDeleted"));
				category.setCreateAt(rs.getDate("createAt"));
				category.setUpdateAt(rs.getDate("updateAt"));
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
		try {
			String sql = "SELECT * FROM Category WHERE isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			if (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setImage(rs.getString("image"));
				category.setDeleted(rs.getBoolean("isDeleted"));
				category.setCreateAt(rs.getDate("createAt"));
				category.setUpdateAt(rs.getDate("updateAt"));
				categoryList.add(category);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public List<CategoryModel> getChildCategory(int parentId) {
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
		try {
			String sql = "SELECT * FROM Category WHERE categoryId = ? AND isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, parentId);

			rs = ps.executeQuery();
			if (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setImage(rs.getString("image"));
				category.setDeleted(rs.getBoolean("isDeleted"));
				category.setCreateAt(rs.getDate("createAt"));
				category.setUpdateAt(rs.getDate("updateAt"));
				categoryList.add(category);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public void update(CategoryModel category) {
		try {
			String sql = "UPDATE Category SET categoryId = ?, name = ?, slug = ?, image = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, category.getCategoryId());
			ps.setString(2, category.getName());
			ps.setString(3, category.getSlug());
			ps.setString(4, category.getImage());
			ps.setInt(5, category.getId());

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "UPDATE Category SET  isDeleted = 1 , updateAt = GETDATE() WHERE id = ?";
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

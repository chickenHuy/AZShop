package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;

public class CategoryDAOImpl implements ICategoryDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(CategoryModel category) {
		try {
			if (category.getCategoryId() == 0) {
				String sql = "INSERT INTO Category(name, slug, image, isDeleted, createAt) VALUES ( ?, ?, ?, ?, GETDATE() )";
				conn = new DBConnection().getConnection();

				ps = conn.prepareStatement(sql);

				ps.setString(1, category.getName());
				ps.setString(2, category.getSlug());
				ps.setString(3, category.getImage());
				ps.setBoolean(4, false);

				ps.executeUpdate();

				conn.close();
			} else {
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
			}
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
			while (rs.next()) {
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
	public List<CategoryModel> getAllAdmin() {
		List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
		try {
			String sql = "SELECT * FROM Category";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
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
			while (rs.next()) {
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
			if (category.getCategoryId() != 0) {

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
			} else {
				String sql = "UPDATE Category SET name = ?, slug = ?, image = ?, updateAt = GETDATE() WHERE id = ?";
				conn = new DBConnection().getConnection();

				ps = conn.prepareStatement(sql);

				ps.setString(1, category.getName());
				ps.setString(2, category.getSlug());
				ps.setString(3, category.getImage());
				ps.setInt(4, category.getId());

				ps.executeUpdate();

				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBySlug(String slug) {
		try {
			String sql = "UPDATE Category SET isDeleted = 1, updateAt = GETDATE() WHERE slug = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, slug);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel getCategoryBySlug(String slug) {
		CategoryModel category = new CategoryModel();
		try {
			String sql = "SELECT * FROM Category WHERE slug = ? AND isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, slug);

			rs = ps.executeQuery();
			while (rs.next()) {
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
	public List<CategoryModel> getParentCategory() {
	    List<CategoryModel> categoryList = new ArrayList<>();
	    try {
	        String sql = "SELECT c.id, c.name, COALESCE(COUNT(p.id), 0) AS product_count, c.categoryId, c.slug, c.image, c.isDeleted, c.createAt, c.updateAt \r\n"
	        		+ "	                     FROM Category c LEFT JOIN Product p ON c.id = p.categoryId AND p.isDeleted = 0 \r\n"
	        		+ "	                     WHERE c.categoryId IS NULL AND c.isDeleted = 0 and (isActive = 1 OR isActive is null)\r\n"
	        		+ "	                     GROUP BY c.id, c.name, c.categoryId, c.slug, c.image, c.isDeleted, c.createAt, c.updateAt\r\n"
	        		+ "	                     ORDER BY c.id";

	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            CategoryModel category = new CategoryModel();
	            category.setId(rs.getInt("id"));
	            category.setName(rs.getString("name"));
	            category.setCategoryId(rs.getInt("categoryId"));
	            category.setSlug(rs.getString("slug"));
	            category.setImage(rs.getString("image"));
	            category.setDeleted(rs.getBoolean("isDeleted"));
	            category.setCreateAt(rs.getDate("createAt"));
	            category.setUpdateAt(rs.getDate("updateAt"));
	            category.setCountProduct(rs.getInt("product_count"));;
	            categoryList.add(category);
	        }

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return categoryList;
	}

	@Override
	public CategoryModel getParentCategory(int id) {
		CategoryModel category = new CategoryModel();
		try {
			String sql = "SELECT * FROM Category WHERE id = ? AND categoryId is null AND isDeleted = 0";
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
	public void restoreBySlug(String slug) {
		try {
			String sql = "UPDATE Category SET isDeleted = 0, updateAt = GETDATE() WHERE slug = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, slug);

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> FindCategory(String keyword) {
		List<CategoryModel> listCategory = new ArrayList<CategoryModel>();
		try {
			String sql = "SELECT * FROM Category WHERE (Category.name LIKE N'%" + keyword
					+ "%' OR N'Category.slug' LIKE N'%" + keyword + "%') AND isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoryModel category = new CategoryModel();

				category.setId(rs.getInt("id"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setImage(rs.getString("image"));
				category.setDeleted(rs.getBoolean("isDeleted"));
				category.setCreateAt(rs.getDate("createAt"));
				category.setUpdateAt(rs.getDate("updateAt"));

				listCategory.add(category);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCategory;
	}
	

}

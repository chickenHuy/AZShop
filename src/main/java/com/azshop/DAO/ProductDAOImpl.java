package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(ProductModel product) {
		try {
			String sql = "INSERT INTO dbo.Product(name, slug, description, price, quantiny, sold, isActive, video, categoryId, styleValueId, storeId, rating, createAt, updateAt) VALUES (?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, NULL, GETDATE(), NULL);";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, product.getSlug());
			ps.setString(3, product.getDescription());
			ps.setBigDecimal(4, product.getPrice());
			ps.setInt(5, product.getQuantity());
			ps.setBoolean(6, product.isActive());
			ps.setString(7, product.getVideo());
			ps.setInt(8, product.getCategoryId());
			ps.setInt(9, product.getStyleValueId());
			ps.setInt(10, product.getStoreId());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ProductModel getById(int id) {

		ProductModel product = new ProductModel();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE id = ? AND isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<ProductModel> getAll() {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductModel product = new ProductModel();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));

				listProduct.add(product);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public List<ProductModel> getByCategoryId(int categoryId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE categoryId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductModel product = new ProductModel();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));

				listProduct.add(product);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public List<ProductModel> getByStyleValueId(int styleValueId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE styleValueId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, styleValueId);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductModel product = new ProductModel();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));

				listProduct.add(product);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public List<ProductModel> getByStoreId(int storeId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE storeId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductModel product = new ProductModel();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));

				listProduct.add(product);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public void update(ProductModel product) {
		try {
			String sql = "UPDATE dbo.Product SET name = ?, slug = ?, description = ?, price = ?, quantiny = ?, sold = ?, isActive = ?, video = ?, categoryId = ?, styleValueId = ?, storeId = ?, rating = ?, updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, product.getSlug());
			ps.setString(3, product.getDescription());
			ps.setBigDecimal(4, product.getPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setBoolean(7, product.isActive());
			ps.setString(8, product.getVideo());
			ps.setInt(9, product.getCategoryId());
			ps.setInt(10, product.getStyleValueId());
			ps.setInt(11, product.getStoreId());
			ps.setBigDecimal(12, product.getRating());
			ps.setInt(13, product.getId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "UPDATE dbo.Product SET isDeleted = 1 WHERE id = ?";
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
	public ProductModel getBySlug(String slug) {
		ProductModel product = new ProductModel();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE slug = ? AND isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, slug);
			rs = ps.executeQuery();

			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setQuantity(rs.getInt("quantiny"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setVideo(rs.getString("video"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStyleValueId(rs.getInt("styleValueId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getBigDecimal("rating"));
				product.setCreateAt(rs.getDate("createAt"));
				product.setUpdateAt(rs.getDate("updateAt"));
				conn.close();
			}
			else {
				conn.close();
				return null;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
}

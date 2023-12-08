package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.CategoryModel;
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
			ps.setBoolean(6, product.getIsActive());
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
			ps.setBoolean(7, product.getIsActive());
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

	@Override
	public List<ProductModel> FindProduct(String keyword) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM Product WHERE (Product.name LIKE N'%" + keyword + "%' OR N'Product.slug' LIKE N'%" + keyword + "%') AND isDeleted = 0";
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
	public int countDraftByStore(int storeId) {
		try {
			String sql = "SELECT COUNT(*) as sumDraft FROM dbo.[Product] WHERE storeId = ? and isActive = 0 and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
			 return rs.getInt("sumDraft");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	@Override
	public int countPublishByStore(int storeId) {
		try {
			String sql = "SELECT COUNT(*) as sumPublish FROM dbo.[Product] WHERE storeId = ? and isActive = 1 and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
			 return rs.getInt("sumPublish");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	@Override
	public int countAllByStore(int storeId) {
		try {
			String sql = "SELECT COUNT(*) as sumAll FROM dbo.[Product] WHERE storeId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
			 return rs.getInt("sumAll");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	@Override
	public List<ProductModel> getBySearch(int categoryId, int storeId, String isActive, String content) {
	    List<ProductModel> listProduct = new ArrayList<ProductModel>();

	    try {
	        String sql = "SELECT * FROM dbo.[Product] WHERE storeId = ? AND isDeleted = 0";

	        if (categoryId != -1) {
	            sql += " AND categoryId = ?";
	        }

	        if (isActive != null) {
	        	if (isActive.equals("draft"))
	        		sql += " AND isActive = 0";
	        	if (isActive.equals("publish")) {
	        		sql += " AND isActive = 1";
				}
	        }
	        if (content != null && !content.isEmpty()) {
	            sql += " AND (name LIKE ? OR description LIKE ?)";
	        }

	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);

	        int parameterIndex = 1;
	        ps.setInt(parameterIndex++, storeId);

	        if (categoryId != -1) {
	            ps.setInt(parameterIndex++, categoryId);
	        }

	        if (content != null && !content.isEmpty()) {
	            ps.setString(parameterIndex++, "%" + content + "%");
	            ps.setString(parameterIndex++, "%" + content + "%");
	        }

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
	public List<ProductModel> getProductbyQuantity(List<ProductModel> productList, int quantity) {
		List<ProductModel> result = new ArrayList<ProductModel>();
        for (int i = 0; i < quantity && i < productList.size(); i++) {
            result.add(productList.get(i));
        }
        return result;
	}

	@Override
	public List<ProductModel> SortingProductbyPriceAscending(List<ProductModel> productList, int categoryId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
        try {
            String sql = "SELECT * FROM dbo.[Product] WHERE categoryId = ? and isDeleted = 0 ORDER BY price ASC";
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
	public List<ProductModel> SortingProductbyPriceDecending(List<ProductModel> productList, int categoryId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
        try {
            String sql = "SELECT * FROM dbo.[Product] WHERE categoryId = ? and isDeleted = 0 ORDER BY price DESC";
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
	public List<ProductModel> GetTopSellerProduct(List<ProductModel> productList, int k) {
		List<ProductModel> topSellerList = new ArrayList<ProductModel>();
        try {
            // Tạo một câu lệnh SQL để sắp xếp các sản phẩm theo số lượng đã bán giảm dần và giới hạn số lượng sản phẩm trả về là k
            String sql = "SELECT * FROM Product ORDER BY sold DESC LIMIT ?";
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            // Thiết lập tham số k cho câu lệnh SQL
            ps.setInt(1, k);
            // Thực thi câu lệnh SQL và trả về một đối tượng ResultSet chứa kết quả truy vấn
            rs = ps.executeQuery();

            // Duyệt qua các dòng của đối tượng ResultSet và tạo ra các đối tượng ProductModel tương ứng
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

                // Thêm đối tượng ProductModel vào danh sách
                topSellerList.add(product);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Trả về danh sách các sản phẩm bán được nhiều nhất
        return topSellerList;
	}


}

package com.azshop.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
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
	public int countSaleByStore(int storeId) {
		try {
			String sql = "select sum([OrderItem].count) as sumSaleProduct from [Order] join [OrderItem] on [OrderItem].orderID = [Order].id where [Order].storeId = ? and [Order].status = 'Completed' ";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
			 return rs.getInt("sumSaleProduct");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public ProductModel getBestSellerProduct(int storeId) {
		try {
			String sql = "SELECT TOP 1\r\n"
					+ "    P.id AS id,\r\n"
					+ "    P.name AS name,\r\n"
					+ "    P.price,\r\n"
					+ "    SUM(OI.count) AS totalSold,\r\n"
					+ "	P.slug\r\n"
					+ "FROM\r\n"
					+ "    [Order] AS O\r\n"
					+ "JOIN\r\n"
					+ "    [OrderItem] AS OI ON O.id = OI.orderID\r\n"
					+ "JOIN\r\n"
					+ "    [Product] AS P ON OI.productId = P.id\r\n"
					+ "WHERE\r\n"
					+ "    O.status = 'Completed'\r\n"
					+ "    AND O.storeId = ? \r\n"
					+ "    AND P.isDeleted = 0\r\n"
					+ "GROUP BY\r\n"
					+ "    P.id, P.name, P.price, P.slug\r\n"
					+ "ORDER BY\r\n"
					+ "    totalSold DESC;";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setSold(rs.getInt("totalSold"));
				return product;
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductModel> getHotProduct(int storeId) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT TOP 10\r\n"
					+ "    P.id AS id,\r\n"
					+ "    P.name AS name,\r\n"
					+ "    P.price,\r\n"
					+ "    SUM(OI.count) AS totalSold,\r\n"
					+ "	P.slug\r\n"
					+ "FROM\r\n"
					+ "    [Order] AS O\r\n"
					+ "JOIN\r\n"
					+ "    [OrderItem] AS OI ON O.id = OI.orderID\r\n"
					+ "JOIN\r\n"
					+ "    [Product] AS P ON OI.productId = P.id\r\n"
					+ "WHERE\r\n"
					+ "    O.status = 'Completed'\r\n"
					+ "    AND O.storeId = ? \r\n"
					+ "    AND P.isDeleted = 0\r\n"
					+ "GROUP BY\r\n"
					+ "    P.id, P.name, P.price, P.slug\r\n"
					+ "ORDER BY\r\n"
					+ "    totalSold DESC;";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			while (rs.next()) {
				ProductModel product = new ProductModel();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setSold(rs.getInt("totalSold"));
				listProduct.add(product);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public int countInDayByStore(int storeId) {
		try {
			String sql = "	SELECT SUM([OrderItem].count) AS sumSaleProduct \r\n"
					+ "FROM [Order]\r\n"
					+ "JOIN [OrderItem] ON [OrderItem].orderID = [Order].id\r\n"
					+ "WHERE [Order].storeId = ?\r\n"
					+ "    AND [Order].status = 'Completed'\r\n"
					+ "    AND CONVERT(DATE, [Order].updateAt) = CONVERT(DATE, GETDATE());";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			rs = ps.executeQuery();

			if (rs.next()) {
			 return rs.getInt("sumSaleProduct");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	public List<ProductModel> getProductbyQuantity(List<ProductModel> productList, int quantity) {
		List<ProductModel> result = new ArrayList<ProductModel>();
        for (int i = 0; i < quantity && i < productList.size(); i++) {
            result.add(productList.get(i));
        }
        return result;
	}

	@Override
	public List<ProductModel> SortingProductbyPriceAscending(List<ProductModel> productList) {
		int n = productList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh giá tiền kiểu BigDecimal
                BigDecimal price1 = productList.get(j).getPrice();
                BigDecimal price2 = productList.get(j + 1).getPrice();

                if (price1.compareTo(price2) > 0) {
                    // Hoán đổi vị trí của hai sản phẩm nếu giá tăng dần
                    ProductModel temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }

        return productList;
	}

	@Override
	public List<ProductModel> SortingProductbyPriceDecending(List<ProductModel> productList) {
		int n = productList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh giá tiền kiểu BigDecimal
                BigDecimal price1 = productList.get(j).getPrice();
                BigDecimal price2 = productList.get(j + 1).getPrice();

                if (price1.compareTo(price2) < 0) {
                    // Hoán đổi vị trí của hai sản phẩm nếu giá giảm dần
                    ProductModel temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }

        return productList;
	}

	@Override
	public List<ProductModel> GetTopSellerProduct(List<ProductModel> productList, int k) {
		int n = productList.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// So sánh số lượng đã bán của hai sản phẩm
				int sold1 = productList.get(j).getSold();
				int sold2 = productList.get(j + 1).getSold();
				if (sold1 < sold2) {
					// Đổi chỗ hai sản phẩm nếu thứ tự không đúng
					ProductModel temp = productList.get(j);
					productList.set(j, productList.get(j + 1));
					productList.set(j + 1, temp);
				}
			}
		}
		
		// Lấy ra một danh sách con gồm k sản phẩm bán được nhiều nhất
        List<ProductModel> topSellerList = new ArrayList<>();

        // Đảm bảo không vượt quá số lượng sản phẩm trong danh sách
        int limit = Math.min(k, productList.size());

        for (int i = 0; i < limit; i++) {
            topSellerList.add(productList.get(i));
        }

        // Trả về danh sách con đó
        return topSellerList;
	}

	@Override
	public void updateRating(ProductModel product) {
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
	public List<ProductModel> search(String key, int categoryId, int storeId, int styleValueId, int styleId, int page, int pageSize) {
	    List<ProductModel> listProduct = new ArrayList<ProductModel>();
	    try {
	        String sql = "SELECT Product.*, " +
	                     "Category.name AS categoryName, " +
	                     "Style.name AS styleName, " +
	                     "StyleValue.name AS styleValueName " +
	                     "FROM Product " +
	                     "INNER JOIN Category ON Product.categoryId = Category.id " +
	                     "INNER JOIN StyleValue ON Product.styleValueId = StyleValue.id " +
	                     "INNER JOIN Style ON StyleValue.styleId = Style.id " +
	                     "WHERE " +
	                     "(LOWER(Product.name) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%' " +
	                     "OR LOWER(Product.description) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%' " +
	                     "OR LOWER(Product.slug) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%' " +
	                     "OR LOWER(Category.name) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%' " +
	                     "OR LOWER(Style.name) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%' " +
	                     "OR LOWER(StyleValue.name) COLLATE SQL_Latin1_General_CP1_CI_AI LIKE N'%' + LOWER(?) + '%') " +
	                     "AND Product.isActive = 1 " +
	                     "AND Product.isDeleted = 0 ";

	        String category = " AND Product.categoryId = ? ";
	        String store = " AND Product.storeId = ? ";
	        String styleValue = " AND Product.styleValueId = ? ";
	        String style = " AND Style.id = ? ";

	        if (categoryId != -1) {
	            sql += category;
	        }
	        if (storeId != -1) {
	            sql += store;
	        }
	        if (styleValueId != -1) {
	            sql += styleValue;
	        }
	        if (styleId != -1) {
	            sql += style;
	        }

	        sql += "ORDER BY Product.updateAt DESC, Product.createAt DESC " +
	               "OFFSET ? ROWS " +
	               "FETCH NEXT ? ROWS ONLY";

	        int index = 1;
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(index++, key);
	        ps.setString(index++, key);
	        ps.setString(index++, key);
	        ps.setString(index++, key);
	        ps.setString(index++, key);
	        ps.setString(index++, key);

	        if (categoryId != -1) {
	            ps.setInt(index++, categoryId);
	        }
	        if (storeId != -1) {
	            ps.setInt(index++, storeId);
	        }
	        if (styleValueId != -1) {
	            ps.setInt(index++, styleValueId);
	        }
	        if (styleId != -1) {
	            ps.setInt(index++, styleId);
	        }

	        int offset = (page - 1) * pageSize;
	        ps.setInt(index++, offset);
	        ps.setInt(index++, pageSize);

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
	public List<ProductModel> getNewestProduc(List<ProductModel> productList) {
		 int n = productList.size();

		    for (int i = 0; i < n - 1; i++) {
		        for (int j = 0; j < n - i - 1; j++) {
		            // So sánh theo createAt
		            Date createAt1 = productList.get(j).getCreateAt();
		            Date createAt2 = productList.get(j + 1).getCreateAt();

		            if (createAt1.before(createAt2)) {
		                // Hoán đổi vị trí của hai sản phẩm nếu createAt giảm dần (mới nhất đầu tiên)
		                ProductModel temp = productList.get(j);
		                productList.set(j, productList.get(j + 1));
		                productList.set(j + 1, temp);
		            }
		        }
		    }

		    return productList;
	}

	@Override
	public List<ProductModel> getAllProductActive() {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			String sql = "SELECT * FROM dbo.[Product] WHERE isDeleted = 0 and isActive = 1 and quantiny > 0";
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

}

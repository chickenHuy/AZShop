package com.azshop.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.OrderModel;

public class OrderDAOImpl implements IOrderDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(OrderModel order) {
		try {
			String sql = "INSERT INTO [Order] (userId, storeId, deliveryId, recipientName, address, phone, status, isDeleted, isPaidBefore, "
					+ "amountFromUser, amountFromStore, amountToStore, amountToAZShop, createAt) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, GETDATE())";

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getStoreId());
			ps.setInt(3, order.getDeliveryId());
			ps.setString(4, order.getRecipientName());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getPhone());
			ps.setString(7, order.getStatus());
			ps.setBoolean(8, order.isPaidBefore());
			ps.setBigDecimal(9, order.getAmountFromUser());
			ps.setBigDecimal(10, order.getAmountFromStore());
			ps.setBigDecimal(11, order.getAmountToStore());
			ps.setBigDecimal(12, order.getAmountToAZShop());

			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderModel getById(int id) {
		OrderModel order = new OrderModel();
		try {
			String sql = "Select * from [Order] where id = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<OrderModel> getAll() {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

	@Override
	public List<OrderModel> getByUserId(int userId) {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where userId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

	@Override
	public List<OrderModel> getByStoreId(int storeId) {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where storeId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

	@Override
	public List<OrderModel> getByDeliveryId(int deliveryId) {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where deliveryId = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, deliveryId);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

	@Override
	public void update(OrderModel order) {
		try {
			String sql = "UPDATE [Order] SET userId = ?, storeId = ?, deliveryId = ?, recipientName = ?, address = ?, phone = ?, status = ?, isPaidBefore = ?, "
					+ "amountFromUser = ?, amountFromStore = ?, amountToStore = ?, amountToAZShop = ?, updateAt = GETDATE() where id=?";

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getStoreId());
			ps.setInt(3, order.getDeliveryId());
			ps.setString(4, order.getRecipientName());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getPhone());
			ps.setString(7, order.getStatus());
			ps.setBoolean(8, order.isPaidBefore());
			ps.setBigDecimal(9, order.getAmountFromUser());
			ps.setBigDecimal(10, order.getAmountFromStore());
			ps.setBigDecimal(11, order.getAmountToStore());
			ps.setBigDecimal(12, order.getAmountToAZShop());
			ps.setInt(13, order.getId());

			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "UPDATE [Order] SET isDeleted = 1 WHERE id = ?";
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
	public Boolean changeStatus(int id, String status) {
		try {
			String sql = "UPDATE [Order] SET status = ? , updateAt = GETDATE() where id = ?";

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ps.setInt(2, id);

			ps.executeUpdate();

			conn.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<OrderModel> getByStatusAndStore(String status, int storeId) {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where storeId = ? and isDeleted = 0 and status = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ps.setString(2, status);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

	@Override
	public List<BigDecimal> GetRevenueLastNDays(int nDay, int storeId) {
		List<BigDecimal> revenueList = new ArrayList<BigDecimal>();
		String nDayString = String.valueOf(nDay);
		try {
			String sql = "WITH AllDates AS (\r\n" + "    SELECT TOP " + nDayString + " "
					+ "        DATEADD(DAY, -ROW_NUMBER() OVER (ORDER BY (SELECT NULL)), CONVERT(DATE, GETDATE())) AS RecentDate\r\n"
					+ "    FROM master.dbo.spt_values\r\n" + ")\r\n" + "\r\n" + "SELECT \r\n"
					+ "    AllDates.RecentDate AS OrderDate,\r\n"
					+ "    ISNULL(SUM(amountToStore), 0) AS TotalAmount\r\n" + "FROM AllDates\r\n"
					+ "LEFT JOIN [Order] ON AllDates.RecentDate = CONVERT(DATE, [Order].createAt) AND storeId = ? AND status = 'Completed'\r\n"
					+ "GROUP BY AllDates.RecentDate\r\n" + "ORDER BY AllDates.RecentDate DESC;";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);

			rs = ps.executeQuery();
			while (rs.next()) {
				BigDecimal totalAmount = rs.getBigDecimal("TotalAmount");
				revenueList.add(totalAmount);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return revenueList;

	}

	@Override
	public BigDecimal getSumRevenueByStore(int storeId) {
		BigDecimal resultBigDecimal = null;
		try {
			String sql = "SELECT SUM(amountToStore) AS TotalAmountToStore FROM [Order] WHERE isDeleted = 0 and storeId = ? and status='Completed'";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);

			rs = ps.executeQuery();
			if (rs.next()) {
				resultBigDecimal = rs.getBigDecimal("TotalAmountToStore");
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultBigDecimal;
	}

	@Override
	public List<OrderModel> getByUserIdAndStoreId(int userId, int storeId) {
		List<OrderModel> oderModelList = new ArrayList<OrderModel>();

		try {
			String sql = "Select *from [Order] where userId = ? and storeID = ? and isDeleted = 0";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, storeId);

			rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setRecipientName(rs.getString("recipientName"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getBigDecimal("amountFromUser"));
				order.setAmountFromStore(rs.getBigDecimal("amountFromStore"));
				order.setAmountToStore(rs.getBigDecimal("amountToStore"));
				order.setAmountToAZShop(rs.getBigDecimal("amountToAZShop"));
				order.setCreateAt(rs.getDate("createAt"));
				order.setUpdateAt(rs.getDate("updateAt"));

				oderModelList.add(order);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oderModelList;
	}

}

package com.azshop.DAO;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.azshop.models.OrderModel;

public class OrderDAOImpl implements IOrderDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(OrderModel order) {
		try {
			String sql = "INSERT INTO Order (id, userId, storeId, deliveryId, recipientName, address, phone, status, isPaidBefore, "
					+ "amountFromUser, amountFromStore, amountToStore, amountToAZShop, createAt, updateAt) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getId());
			ps.setInt(2, order.getUserId());
			ps.setInt(3, order.getStoreId());
			ps.setInt(4, order.getDeliveryId());
			ps.setString(5, order.getRecipientName());
			ps.setString(6, order.getAddress());
			ps.setString(7, order.getPhone());
			ps.setString(8, order.getStatus());
			ps.setBoolean(9, order.isPaidBefore());
			ps.setBigDecimal(10, order.getAmountFromUser());
			ps.setBigDecimal(11, order.getAmountFromStore());
			ps.setBigDecimal(12, order.getAmountToStore());
			ps.setBigDecimal(13, order.getAmountToAZShop());
			ps.setDate(14, (Date)order.getCreateAt());
			ps.setDate(15, (Date)order.getUpdateAt());
			
			ps.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getByDeliveryId(int deliveryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderModel order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}

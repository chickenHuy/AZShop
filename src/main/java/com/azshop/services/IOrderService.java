package com.azshop.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.azshop.DAO.DBConnection;
import com.azshop.models.OrderModel;

public interface IOrderService {
	void insert(OrderModel order);

	OrderModel getById(int id);

	List<OrderModel> getAll();

	List<OrderModel> getByUserId(int userId);

	List<OrderModel> getByStoreId(int storeId);

	List<OrderModel> getByDeliveryId(int deliveryId);

	void update(OrderModel order);

	void delete(int id);

	List<String> statusForVendor();

	Boolean changeStatus(int id, String status);

	List<OrderModel> getCancelled(int storeId);

	List<OrderModel> getProcessing(int storeId);

	List<OrderModel> getProcessed(int storeId);

	BigDecimal calculateOrderTotal(int id);
	
	OrderModel getByStatus(String status);

	List<BigDecimal> GetRevenueLastNDays(int nDay, int storeId);

	BigDecimal getSumRevenueByStore(int storeId);

	List<OrderModel> getByUserIdAndStoreId(int userId, int storeId);

	int countCompletedByStore(int storeId);

	int countOrderByStore(int storeId);

	List<OrderModel> getAllAdmin();

	// Thêm phương thức mới vào OrderDAOImpl
	int getTotalShopRevenueByDate(Date Date);

	int getTotalShopRevenue();

	List<OrderModel> getByUserIdandStatus(int userId, String status);
}

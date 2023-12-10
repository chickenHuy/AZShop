package com.azshop.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.azshop.models.OrderModel;

public interface IOrderDAO {
	void insert(OrderModel order);

	OrderModel getById(int id);

	List<OrderModel> getAll();

	List<OrderModel> getByUserId(int userId);

	List<OrderModel> getByStoreId(int storeId);

	List<OrderModel> getByDeliveryId(int deliveryId);

	void update(OrderModel order);

	void delete(int id);

	Boolean changeStatus(int id, String status);

	List<OrderModel> getByStatusAndStore(String status, int storeId);

	List<BigDecimal> GetRevenueLastNDays(int nDay, int storeId);

	BigDecimal getSumRevenueByStore(int storeId);

	List<OrderModel> getByUserIdAndStoreId(int userId, int storeId);

	int countCompletedByStore(int storeId);

	int countOrderByStore(int storeId);

	List<OrderModel> getAllAdmin();

	int getTotalShopRevenueByDate(Date Date);

	int getTotalShopRevenue();

	List<OrderModel> getByUserIdandStatus(int userId, String status);

	boolean resoreQuantityProduct(int orderId);
}
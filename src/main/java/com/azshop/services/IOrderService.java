package com.azshop.services;

import java.math.BigDecimal;
import java.util.List;

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
	List<BigDecimal> GetRevenueLast10Days(int storeId);
}

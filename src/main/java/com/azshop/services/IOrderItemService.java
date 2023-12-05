package com.azshop.services;

import java.util.List;

import com.azshop.models.OrderItemModel;

public interface IOrderItemService {
	void insert(OrderItemModel orderItem);

	OrderItemModel getById(int id);

	List<OrderItemModel> getAll();

	List<OrderItemModel> getByOrderId(int orderId);

	List<OrderItemModel> getByProductId(int productId);

	void update(OrderItemModel orderItem);

	void delete(int id);
}

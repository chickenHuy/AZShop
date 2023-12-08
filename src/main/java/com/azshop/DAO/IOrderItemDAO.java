package com.azshop.DAO;

import java.util.List;

import com.azshop.models.OrderItemModel;

public interface IOrderItemDAO {

	void insert(OrderItemModel orderItem);
    OrderItemModel getById(int id);
    List<OrderItemModel> getAll();
    List<OrderItemModel> getByOrderId(int orderId);
    List<OrderItemModel> getByProductId(int productId);
    void update(OrderItemModel orderItem);
    void delete(int id);
    int countByOrder(int orderId);
    List<OrderItemModel> getByOrderIdAndProductId(int orderId, int productId);
}

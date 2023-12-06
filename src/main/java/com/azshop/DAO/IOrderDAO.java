package com.azshop.DAO;

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
    List<OrderModel> getByStatusAndStore(String status, int storeId );
}

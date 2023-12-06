package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IOrderDAO;
import com.azshop.DAO.OrderDAOImpl;
import com.azshop.models.OrderModel;

public class OrderServiceImpl implements IOrderService {

	IOrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public void insert(OrderModel order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderModel getById(int id) {
		return orderDAO.getById(id);
	}

	@Override
	public List<OrderModel> getAll() {
		return orderDAO.getAll();
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
		orderDAO.update(order);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

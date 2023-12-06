package com.azshop.services;

import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public List<OrderModel> getByUserId(int userId) {
		return null;
	}

	@Override
	public List<OrderModel> getByStoreId(int storeId) {
		return orderDAO.getByStoreId(storeId);
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
	
	@Override
	public List<String> statusForVendor() {
		List<String> staList = new ArrayList<String>();
		staList.add("Processing");
		staList.add("Pending pickup");
		staList.add("Cancelced");
		return staList;
	}

	@Override
	public Boolean changeStatus(int id, String status) {
		return orderDAO.changeStatus(id, status);
	}

	@Override
	public List<OrderModel> getCancelled(int storeId) {
		return orderDAO.getByStatusAndStore("Cancelled", storeId);
	}

	@Override
	public List<OrderModel> getProcessing(int storeId) {
		return orderDAO.getByStatusAndStore("Cancelled", storeId);
	}

	@Override
	public List<OrderModel> getProcessed(int storeId) {
		return orderDAO.getByStatusAndStore("Completed", storeId);
	}

}

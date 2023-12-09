package com.azshop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.azshop.DAO.IOrderDAO;
import com.azshop.DAO.OrderDAOImpl;
import com.azshop.models.DeliveryModel;
import com.azshop.models.OrderItemModel;
import com.azshop.models.OrderModel;
import com.azshop.models.UserLevelModel;
import com.azshop.models.UserModel;

public class OrderServiceImpl implements IOrderService {

	IOrderDAO orderDAO = new OrderDAOImpl();
	IOrderItemService orderItemService = new OrderItemServiceImpl();
	IUserService userService = new UserServiceImpl();
	IUserLevelService userLevelService = new UserLevelServiceImpl();
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	
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
	public List<OrderModel> getAllAdmin() {
		return orderDAO.getAllAdmin();
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
		orderDAO.update(order);
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
		staList.add("Cancelled");
		return staList;
	}

	@Override
	public Boolean changeStatus(int id, String status) {
		OrderModel orderModel = orderDAO.getById(id);
		if (orderModel.getStatus().equals("Cancelled") || orderModel.getStatus().equals("Completed") ) {
			return false;
		}
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

	@Override
	public BigDecimal calculateOrderTotal(int id) {
		OrderModel order = orderDAO.getById(id);
		List<OrderItemModel> orderItems = orderItemService.getByOrderId(id);
		UserModel user = userService.getById(order.getUserId());
		UserLevelModel userLevel = userLevelService.getById(user.getUserLevelId());
		DeliveryModel delivery = deliveryService.getById(order.getDeliveryId());
		
		BigDecimal orderTotal = BigDecimal.ZERO;
		
		for (OrderItemModel orderItem : orderItems) {
			BigDecimal orderItemTotal = orderItemService.calculateOrderItemTotal(orderItem.getId());
	        orderTotal = orderTotal.add(orderItemTotal);
        }
		
		orderTotal = orderTotal.add(delivery.getPrice());
		if (userLevel.getDiscount() != 0) {
			BigDecimal discount = BigDecimal.valueOf(userLevel.getDiscount()/100.0).multiply(orderTotal);
			orderTotal = orderTotal.subtract(discount);
		}
        return orderTotal;
	}

	@Override
	public List<BigDecimal> GetRevenueLastNDays(int nDay,int storeId) {
		return orderDAO.GetRevenueLastNDays(nDay, storeId);
	}

	@Override
	public BigDecimal getSumRevenueByStore(int storeId) {
		return orderDAO.getSumRevenueByStore(storeId);
	}

	@Override
	public List<OrderModel> getByUserIdAndStoreId(int userId, int storeId) {
		return orderDAO.getByUserIdAndStoreId(userId, storeId);
	}

	@Override
	public int countCompletedByStore(int storeId) {
		return orderDAO.countCompletedByStore(storeId);
	}

	@Override
	public int countOrderByStore(int storeId) {
		return orderDAO.countOrderByStore(storeId);
	}

	@Override
	public int getTotalShopRevenueByDate(Date Date) {
		return orderDAO.getTotalShopRevenueByDate(Date);
	}
}

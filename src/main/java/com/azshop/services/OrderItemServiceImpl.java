package com.azshop.services;

import java.math.BigDecimal;
import java.util.List;

import com.azshop.DAO.IOrderItemDAO;
import com.azshop.DAO.OrderItemDAOImpl;
import com.azshop.models.OrderItemModel;
import com.azshop.models.ProductModel;

public class OrderItemServiceImpl implements IOrderItemService {

	IOrderItemDAO orderItemDAO = new OrderItemDAOImpl();
	IProductService productService = new ProductServiceImpl();

	@Override
	public void insert(OrderItemModel orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderItemModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getByOrderId(int orderId) {
		return orderItemDAO.getByOrderId(orderId);
	}

	@Override
	public List<OrderItemModel> getByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderItemModel orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countByOrder(int orderId) {
		return orderItemDAO.countByOrder(orderId);
	}

	@Override
	public BigDecimal calculateOrderItemTotal(int id) {
		OrderItemModel orderItem = orderItemDAO.getById(id);
		ProductModel product = productService.getById(orderItem.getProductId());
		BigDecimal orderItemTotal = BigDecimal.valueOf(orderItem.getCount()).multiply(product.getPrice());

		return orderItemTotal;
	}

	@Override
	public List<OrderItemModel> getByOrderIdAndProductId(int orderId, int productId) {
		return orderItemDAO.getByOrderIdAndProductId(orderId, productId);
	}
}

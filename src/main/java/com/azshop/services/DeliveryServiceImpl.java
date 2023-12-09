package com.azshop.services;

import java.util.List;

import com.azshop.DAO.DeliveryDAOImpl;
import com.azshop.DAO.IDeliveryDAO;
import com.azshop.models.DeliveryModel;

public class DeliveryServiceImpl implements IDeliveryService {
	
	IDeliveryDAO deliveryDAO = new DeliveryDAOImpl();
	@Override
	public void insert(DeliveryModel delivery) {
		deliveryDAO.insert(delivery);
	}

	@Override
	public DeliveryModel getById(int id) {
		return deliveryDAO.getById(id);
	}

	@Override
	public List<DeliveryModel> getAll() {
		return deliveryDAO.getAll();
	}

	@Override
	public void update(DeliveryModel delivery) {
		deliveryDAO.update(delivery);
	}

	@Override
	public void delete(int id) {
		deliveryDAO.delete(id);
	}

}

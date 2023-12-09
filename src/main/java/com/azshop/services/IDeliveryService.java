package com.azshop.services;

import java.util.List;

import com.azshop.models.DeliveryModel;

public interface IDeliveryService {
	void insert(DeliveryModel delivery);

	DeliveryModel getById(int id);

	List<DeliveryModel> getAll();

	void update(DeliveryModel delivery);

	void delete(int id);
	
	boolean checkName(String name);
}

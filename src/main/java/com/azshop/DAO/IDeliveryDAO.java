package com.azshop.DAO;

import java.util.List;

import com.azshop.models.DeliveryModel;

public interface IDeliveryDAO {
	void insert(DeliveryModel delivery);
    DeliveryModel getById(int id);
    List<DeliveryModel> getAll();
    void update(DeliveryModel delivery);
    void delete(int id);
}

package com.azshop.DAO;

import java.util.List;

import com.azshop.models.DeliveryModel;

public interface IDeliveryDAO {
	void insert(DeliveryModel delivery);
	void update(DeliveryModel delivery);
    DeliveryModel getById(int id);
    List<DeliveryModel> getAll();
    void delete(int id);
    boolean checkName(String name);
}

package com.azshop.services;

import java.util.List;

import com.azshop.models.AddressShippingModel;

public interface IAddressShippingService {
	void insert(AddressShippingModel addressShipping);

	AddressShippingModel getById(int id);

	List<AddressShippingModel> getByUserId(int userId);

	List<AddressShippingModel> getAll();

	void update(AddressShippingModel addressShipping);

	void delete(int id);
}

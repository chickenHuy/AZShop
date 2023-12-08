package com.azshop.services;

import java.util.List;

import com.azshop.DAO.AddressShippingDAOImpl;
import com.azshop.DAO.IAddressShippingDAO;
import com.azshop.models.AddressShippingModel;

public class AddressShippingServiceImpl implements IAddressShippingService {

	IAddressShippingDAO  addressShippingDAO = new AddressShippingDAOImpl();
	@Override
	public void insert(AddressShippingModel addressShipping) {
		addressShippingDAO.insert(addressShipping);
		
	}

	@Override
	public AddressShippingModel getById(int id) {
		return addressShippingDAO.getById(id);
	}

	@Override
	public List<AddressShippingModel> getByUserId(int userId) {
		return addressShippingDAO.getByUserId(userId);
	}

	@Override
	public List<AddressShippingModel> getAll() {
		return addressShippingDAO.getAll();
	}

	@Override
	public void update(AddressShippingModel addressShipping) {
		addressShippingDAO.update(addressShipping);
		
	}

	@Override
	public void delete(int id) {
		addressShippingDAO.delete(id);
		
	}

}

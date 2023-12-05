package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IStoreDAO;
import com.azshop.DAO.StoreDAOImpl;
import com.azshop.models.StoreModel;

public class StoreServiceImpl implements IStoreService {

	IStoreDAO storeDAO = new StoreDAOImpl();
	
	@Override
	public void insert(StoreModel store) {
		storeDAO.insert(store);
	}

	@Override
	public StoreModel getById(int id) {
		return storeDAO.getById(id);
	}

	@Override
	public List<StoreModel> getAll() {
		return storeDAO.getAll();
	}

	@Override
	public List<StoreModel> getByStoreLevelId(int storeLevelId) {
		return storeDAO.getByStoreLevelId(storeLevelId);
	}

	@Override
	public void update(StoreModel store) {
		storeDAO.update(store);
	}

	@Override
	public void delete(int id) {
		storeDAO.delete(id);
	}

	@Override
	public StoreModel getBySlug(String slug) {
		return storeDAO.getBySlug(slug);
	}

}

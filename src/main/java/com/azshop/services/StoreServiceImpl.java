package com.azshop.services;

import java.util.Date;
import java.util.List;

import com.azshop.DAO.IStoreDAO;
import com.azshop.DAO.StoreDAOImpl;
import com.azshop.models.StoreModel;
import com.azshop.utils.SlugUtil;

public class StoreServiceImpl implements IStoreService {

	IStoreDAO storeDAO = new StoreDAOImpl();
	
	@Override
	public void insert(StoreModel store) {
		store.setActive(true);
		store.setSlug(SlugUtil.toSlug(store.getName()));
		store.setPoint(0);
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

	@Override
	public boolean isUserStoreOwner(int userId) {
		return storeDAO.isUserStoreOwner(userId);
	}

	@Override
	public StoreModel getByOwnerId(int userId) {
		if (storeDAO.isUserStoreOwner(userId)) {
			return storeDAO.getByOwnerId(userId);
		}
		return null;
	}

	@Override
	public List<StoreModel> FindStore(String keyword) {
		return storeDAO.FindStore(keyword);
	}

	@Override
	public List<StoreModel> searchByKey(String key, int storeLevelId) {
		return storeDAO.searchByKey(key, storeLevelId);
	}

	@Override
	public int countNewStores(Date datetime) {
		return storeDAO.countNewStores(datetime);
	}

	@Override
	public int getTotalStores() {
		// TODO Auto-generated method stub
		return storeDAO.getTotalStores();
	}

	@Override
	public List<StoreModel> getStoreWithinDays(int days) {
		// TODO Auto-generated method stub
		return storeDAO.getStoreWithinDays(days);
	}

}

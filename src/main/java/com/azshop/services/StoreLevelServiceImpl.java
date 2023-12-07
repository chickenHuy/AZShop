package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IStoreLevelDAO;
import com.azshop.DAO.StoreLevelDAOImpl;
import com.azshop.models.StoreLevelModel;

public class StoreLevelServiceImpl implements IStoreLevelService{

	IStoreLevelDAO storeLevelDAO = new StoreLevelDAOImpl();
	@Override
	public void insert(StoreLevelModel storeLevel) {
		storeLevelDAO.insert(storeLevel);
		
	}

	@Override
	public StoreLevelModel getById(int id) {
		return storeLevelDAO.getById(id);
	}

	@Override
	public List<StoreLevelModel> getAll() {
		return storeLevelDAO.getAll();
	}

	@Override
	public void update(StoreLevelModel storeLevel) {
		
		storeLevelDAO.update(storeLevel);
	}

	@Override
	public void delete(int id) {
		storeLevelDAO.delete(id);
	}

	@Override
	public int getDefaultLevel() {
		return storeLevelDAO.getDefaultLevel();
	}

	@Override
	public boolean checkName(String name) {
		return storeLevelDAO.checkName(name);
	}

	@Override
	public List<StoreLevelModel> getAllDeleted() {
		// TODO Auto-generated method stub
		return storeLevelDAO.getAllDeleted();
	}

}

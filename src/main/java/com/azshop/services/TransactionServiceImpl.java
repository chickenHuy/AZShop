package com.azshop.services;

import java.util.List;

import com.azshop.DAO.ITransactionDAO;
import com.azshop.DAO.TransactionDAOImpl;
import com.azshop.models.TransactionModel;



public class TransactionServiceImpl implements ITransactionService{
	
	ITransactionDAO TransactionDAO = new TransactionDAOImpl();

	@Override
	public void insert(TransactionModel transaction) {
		TransactionDAO.insert(transaction);
	}

	@Override
	public void update(TransactionModel transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TransactionModel> getAll() {
		// TODO Auto-generated method stub
		return TransactionDAO.getAll();
	}

	@Override
	public TransactionModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> getByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
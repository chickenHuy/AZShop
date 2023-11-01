package com.azshop.DAO;

import java.util.List;

import com.azshop.models.TransactionModel;

public interface ITransactionDAO {
	void insert(TransactionModel transaction);
	void update(TransactionModel transaction);
	void delete(int id);
	List<TransactionModel> getAll();
	List<TransactionModel> getById(int id);
	List<TransactionModel> getByUserId(int userId);
	List<TransactionModel> getByStoreId(int storeId);
}

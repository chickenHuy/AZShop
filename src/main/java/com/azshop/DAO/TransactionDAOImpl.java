package com.azshop.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.TransactionModel;

public class TransactionDAOImpl implements ITransactionDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void insert(TransactionModel transaction) {
		try {
			String sql = "INSERT INTO Transaction(id, userId, storeId, isUp, amount, createAt, updateAt) VALUES (?, ?, ?, 'false', ?, '(GETDATE)', '(GETDATE)')";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, transaction.getId());
			ps.setInt(2, transaction.getUserId());
			ps.setInt(3, transaction.getStoreId());
			ps.setBoolean(4, transaction.isUp());
			ps.setBigDecimal(5, transaction.getAmount());
			ps.setDate(6, (Date)transaction.getCreateAt());
			ps.setDate(7, (Date)transaction.getUpdateAt());

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(TransactionModel transaction) {
		try {
			String sql = "UPDATE Transaction SET userId = ?, storeId = ?, isUp = ?, amount = ?,  updateAt = GETDATE() WHERE id = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, transaction.getUserId());
			ps.setInt(2, transaction.getStoreId());
			ps.setBoolean(3, transaction.isUp());
			ps.setBigDecimal(4, transaction.getAmount());
			ps.setInt(5, transaction.getId());

			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "DELETE Transaction WHERE id=?";
			conn = new DBConnection().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			conn.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TransactionModel> getAll() {
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		try {
			String sql = "SELECT * FROM Transaction";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			if (rs.next()) {
				TransactionModel transaction = new TransactionModel();
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("storeId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getBigDecimal("amount"));
				transaction.setCreateAt(rs.getDate("createAt"));
				transaction.setUpdateAt(rs.getDate("updateAt"));
				transactionList.add(transaction);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public TransactionModel getById(int id) {
		TransactionModel transaction = new TransactionModel();
		try {
			String sql = "SELECT * FROM Transaction Where id = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("storeId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getBigDecimal("amount"));
				transaction.setCreateAt(rs.getDate("createAt"));
				transaction.setUpdateAt(rs.getDate("updateAt"));
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransactionModel> getByUserId(int userId) {
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		try {
			String sql = "SELECT * FROM Transaction Where userId = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			rs = ps.executeQuery();
			if (rs.next()) {
				TransactionModel transaction = new TransactionModel();
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("storeId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getBigDecimal("amount"));
				transaction.setCreateAt(rs.getDate("createAt"));
				transaction.setUpdateAt(rs.getDate("updateAt"));
				transactionList.add(transaction);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public List<TransactionModel> getByStoreId(int storeId) {
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		try {
			String sql = "SELECT * FROM Transaction Where storeId = ?";
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);

			rs = ps.executeQuery();
			if (rs.next()) {
				TransactionModel transaction = new TransactionModel();
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("storeId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getBigDecimal("amount"));
				transaction.setCreateAt(rs.getDate("createAt"));
				transaction.setUpdateAt(rs.getDate("updateAt"));
				transactionList.add(transaction);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}

}

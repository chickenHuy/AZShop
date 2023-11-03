package com.azshop.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.TransactionModel;

public class TransactionDAOImpl implements ITransactionDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(TransactionModel transaction) {
		try {
			String sql = "INSERT INTO dbo.[Transaction] (userId, storeId, isUp, amount, createAt) VALUES (?, ?, ?, ?, GETDATE());";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, transaction.getUserId());
			ps.setInt(2, transaction.getStoreId());
			ps.setBoolean(3, transaction.isUp());
			ps.setBigDecimal(4, transaction.getAmount());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(TransactionModel transaction) {
		try {
			String sql = "UPDATE dbo.[Transaction] SET userId = ?, storeId = ?, isUp = ?, amount = ?,  updateAt = GETDATE() WHERE id = ?";
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
			String sql = "UPDATE dbo.[Transaction] SET isDeleted = 1 WHERE id = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TransactionModel> getAll() {
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		try {
			String sql = "SELECT * FROM dbo.[Transaction] WHERE isDeleted = 0";
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
			String sql = "SELECT * FROM dbo.[Transaction] WHERE id = ? AND isDeleted = 0";
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
		return transaction;
	}

	@Override
	public List<TransactionModel> getByUserId(int userId) {
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		try {
			String sql = "SELECT * FROM dbo.[Transaction] WHERE userId = ? AND isDeleted = 0";
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
			String sql = "SELECT * FROM dbo.[Transaction] Where storeId = ? AND isDeleted = 0";
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

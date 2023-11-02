package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.azshop.models.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	
	@Override
	public void insert(ProductModel product) {
		try {
//			String sqlString = "INSERT INTO "
			connection = new DBConnection().getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ProductModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getByStyleValueId(int styleValueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProductModel product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

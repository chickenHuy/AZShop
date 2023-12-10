package com.azshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azshop.models.StyleModel;


public interface IStyleDAO {
	void insert(StyleModel style);
	StyleModel getById(int id);
	List<StyleModel> getAll();
	List<StyleModel> getByCategoryId(int categoryId);
	
	public List<StyleModel> getByCateId(int categoryId);
	
	void update(StyleModel style);
	void delete(int id);
	List<StyleModel> getAllAdmin();
	void restore(int id);
}

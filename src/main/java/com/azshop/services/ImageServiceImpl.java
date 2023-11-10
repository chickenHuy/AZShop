package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IImageDAO;
import com.azshop.DAO.ImageDAOImpl;
import com.azshop.models.ImageModel;

public class ImageServiceImpl implements IImageService{
	IImageDAO imageDAO = new ImageDAOImpl();
	@Override
	public void insert(ImageModel image) {
		imageDAO.insert(image);
	}

	@Override
	public ImageModel getById(int id) {
		return imageDAO.getById(id);
	}

	@Override
	public List<ImageModel> getAll() {
		return imageDAO.getAll();
	}

	@Override
	public List<ImageModel> getByProductId(int productId) {
		return imageDAO.getByProductId(productId);
	}

	@Override
	public void update(ImageModel image) {
		imageDAO.update(image);
	}

	@Override
	public void delete(int id) {
		imageDAO.delete(id);
	}

}

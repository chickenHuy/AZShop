package com.azshop.services;

import java.util.List;

import com.azshop.DAO.IImageDAO;
import com.azshop.DAO.ImageDAOImpl;
import com.azshop.models.ImageModel;
import com.azshop.utils.ImageUtil;

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

	@Override
	public int deletedByIndex(int index, int productId) {
		List<ImageModel> imageModels = imageDAO.getByProductId(productId);
		for (ImageModel imageModel : imageModels) {
			if (Integer.parseInt(imageModel.getImage().substring(0, 1)) == index) {
				ImageUtil.deleteImage(imageModel.getImage());
				imageDAO.delete(imageModel.getId());
			}
		}
		return 1;
	}

	@Override
	public ImageModel getImage(int productId) {
		return imageDAO.getImage(productId);
	}

}

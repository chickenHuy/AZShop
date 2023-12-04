package com.azshop.services;

import java.util.List;

import javax.mail.Store;

import com.azshop.models.ImageModel;

public interface IImageService {
	void insert(ImageModel image);

	ImageModel getById(int id);

	List<ImageModel> getAll();

	List<ImageModel> getByProductId(int userId);

	void update(ImageModel image);

	void delete(int id);
	
	int deletedByIndex(int index, int productId);
	ImageModel getImage(int productId);
	
	
}

package com.azshop.services;

import java.util.List;

import com.azshop.models.ImageModel;

public interface IImageService {
	void insert(ImageModel image);

	ImageModel getById(int id);

	List<ImageModel> getAll();

	List<ImageModel> getByProductId(int userId);

	void update(ImageModel image);

	void delete(int id);
}

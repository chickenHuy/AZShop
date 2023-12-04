package com.azshop.DAO;

import java.util.List;

import com.azshop.models.ImageModel;

public interface IImageDAO {
 	void insert(ImageModel image);
    ImageModel getById(int id);
    List<ImageModel> getAll();
    List<ImageModel> getByProductId(int productId);
    void update(ImageModel image);
    void delete(int id);
    ImageModel getImage(int productId);
}

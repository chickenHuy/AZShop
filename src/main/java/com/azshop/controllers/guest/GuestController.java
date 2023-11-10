package com.azshop.controllers.guest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.services.IImageService;
import com.azshop.services.IProductService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.ProductServiceImpl;

@WebServlet(urlPatterns = {"/guest-home"})
public class GuestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("guest-home")) {
			try {
				getAllProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.getAll();
		
		// Tạo một Map để lưu trữ danh sách ảnh của từng sản phẩm.
		Map<Long, List<ImageModel>> productImagesMap = new HashMap<>();
		
		for (ProductModel product : productList) {
			List<ImageModel> productImages = imageService.getByProductId(product.getId());
		    productImagesMap.put((long) product.getId(), productImages);
		}
		
		req.setAttribute("listproduct", productList);
		req.setAttribute("productImagesMap", productImagesMap);
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/home.jsp");
		rd.forward(req, resp);
	}
}
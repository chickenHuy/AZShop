package com.azshop.controllers.guest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.models.UserModel;
import com.azshop.services.IImageService;
import com.azshop.services.IProductService;
import com.azshop.services.IUserService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Email;

@WebServlet(urlPatterns = {"/guest-home", "/guest-clothing"})
public class GuestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	IUserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("guest-home")) {
			try {
				getAllProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("guest-clothing")) {
			try {
				getAllClothing(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getAllClothing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.getAll();
		
//		req.setAttribute("product",product);
		req.setAttribute("productList",productList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/clothing.jsp");
		rd.forward(req, resp);
	}


	private void getAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		ProductModel product = productService.getById(3); 
		
		List<ProductModel> productList = productService.getAll();
		
//		req.setAttribute("product",product);
		req.setAttribute("productList",productList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/home.jsp");
		rd.forward(req, resp);
	}
}
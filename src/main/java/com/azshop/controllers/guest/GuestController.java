package com.azshop.controllers.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.ProductModel;
import com.azshop.services.IProductService;
import com.azshop.services.ProductServiceImpl;

@WebServlet(urlPatterns = {"/guest-home"})
public class GuestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	
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
		List<ProductModel> listProduct = productService.getAll();
		
		req.setAttribute("listproduct", listProduct);
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/home.jsp");
		rd.forward(req, resp);
	}
}
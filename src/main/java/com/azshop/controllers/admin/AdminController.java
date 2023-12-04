package com.azshop.controllers.admin;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.services.*;

@WebServlet(urlPatterns = { "/admin/dashboard", "/admin/product"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/product")) {
			getAll(req, resp);
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> listProduct = productService.getAll();
		
		List<CategoryModel> listCategory = categoryService.getAll();
		
		int countAllProduct = listProduct.size();
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("countAllProduct", countAllProduct);
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
		rDispatcher.forward(req, resp);
	}

}

package com.azshop.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.StoreModel;
import com.azshop.models.UserModel;
import com.azshop.services.IStoreService;
import com.azshop.services.IUserService;
import com.azshop.services.StoreServiceImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.services.*;


@WebServlet(urlPatterns = {"/admin/dashboard", "/admin/product", "/admin/customer", "/admin/store"})
public class AdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (url.contains("/admin/product")) {
			getAll(req, resp);
		}
		else if (url.contains("/admin/customer")) {
			getAllUser(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/customer.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (url.contains("/admin/store")) {
			getAllStore(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/store.jsp");
			rDispatcher.forward(req, resp);
		}
	}
	private void getAllStore(HttpServletRequest req, HttpServletResponse resp) {
		List<StoreModel> list = storeService.getAll();
		req.setAttribute("liststore", list);
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
	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) {
		List<UserModel> list = userService.getAll();
		req.setAttribute("listuser", list);
	}
	

}

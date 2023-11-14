package com.azshop.controllers.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.azshop.models.CategoryModel;
import com.azshop.models.StyleModel;
import com.azshop.models.StyleValueModel;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.ICategoryService;
import com.azshop.services.IStyleService;
import com.azshop.services.IStyleValueService;
import com.azshop.services.StyleServiceImpl;
import com.azshop.services.StyleValueImpl;
import com.google.gson.Gson;

@WebServlet (urlPatterns = {
				 "/vendor/dashboard"
				,"/register-shop"
				,"/vendor/product/new","/vendor/product/edit"
				,"/vendor/order/processing","/vendor/order/processed", "/vendor/order/details"
			})
public class VenderController extends HttpServlet {

	ICategoryService categoryService =  new CategoryServiceImpl();
	IStyleService styleService = new StyleServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("/vendor/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/dashboard.jsp");
			rDispatcher.forward(req, resp);
		}
		if (url.contains("/register-shop")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/createShop.jsp");
			rDispatcher.forward(req, resp);
		}
		if (url.contains("/vendor/product")) {
			String categoryIdParam = req.getParameter("categoryId");
			String styleIdParam = req.getParameter("styleId");
	        if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
	            int categoryId = Integer.parseInt(categoryIdParam);

	         List<StyleModel> styles = styleService.getByCategoryId(categoryId);

	         // Chuyển danh sách styles thành JSON và gửi về client
	         String json = new Gson().toJson(styles);
	         resp.setContentType("application/json");
	         resp.setCharacterEncoding("UTF-8");
	         resp.getWriter().write(json);
	        }
	        else if (styleIdParam != null && !styleIdParam.isEmpty()) {
		         int styleId = Integer.parseInt(styleIdParam);

		         List<StyleValueModel> styleValues = styleValueService.getByStyleId(styleId);

		         // Chuyển danh sách styles thành JSON và gửi về client
		         String json = new Gson().toJson(styleValues);
		         resp.setContentType("application/json");
		         resp.setCharacterEncoding("UTF-8");
		         resp.getWriter().write(json);
			}
	        else {
				
	            
				List<CategoryModel> categoryModels = categoryService.getAll();
				req.setAttribute("categorys", categoryModels);
				
				if (url.contains("/new")) {
					RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/product.jsp");
					rDispatcher.forward(req, resp);
				}
				if (url.contains("/edit")) {
					RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/product.jsp");
					rDispatcher.forward(req, resp);
				}
	        }
			    
		}
		if (url.contains("/vendor/order")) {
			if (url.contains("processing")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/order.jsp");
				rDispatcher.forward(req, resp);
			}
			else if (url.contains("processed")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/order.jsp");
				rDispatcher.forward(req, resp);
			}
			else if (url.contains("detail")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/orderDetails.jsp");
				rDispatcher.forward(req, resp);
			}
				
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("register-shop")) {
			RegisterShop(req,resp);
		}
	}
	private void RegisterShop(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//Chuyen Dashboard 
		resp.sendRedirect("vendor-dashboard");
		
	}
}

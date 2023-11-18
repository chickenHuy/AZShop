package com.azshop.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/admin/dashboard", "/admin/product","/admin/addproduct"})
public class AdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (url.contains("/admin/product")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
		}
		else if (url.contains("/admin/addproduct")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/addproduct.jsp");
			rDispatcher.forward(req, resp);
		}
	}
	

}

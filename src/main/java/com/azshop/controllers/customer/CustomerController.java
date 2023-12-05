package com.azshop.controllers.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/customer-home", "/customer-product"})
public class CustomerController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// Push success!!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("customer-home")) {
			try {
				getCollections(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (url.contains("customer-product")) {
			try {
				getProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/product.jsp");
		rd.forward(req, resp);
	}
	
	private void getCollections(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/home.jsp");
		rd.forward(req, resp);
	}
}

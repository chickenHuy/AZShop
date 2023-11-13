package com.azshop.controllers.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.functors.IfClosure;

@WebServlet (urlPatterns = {
				 "/vendor/dashboard"
				,"/register-shop"
				,"/vendor/product/new","/vendor/product/edit"
				,"/vendor/order/processing","/vendor/order/processed", "/vendor/order/details"
			})
public class VenderController extends HttpServlet {

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
			if (url.contains("new")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/product.jsp");
				rDispatcher.forward(req, resp);
			}
			if (url.contains("/vendor/product/edit")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/product.jsp");
				rDispatcher.forward(req, resp);
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

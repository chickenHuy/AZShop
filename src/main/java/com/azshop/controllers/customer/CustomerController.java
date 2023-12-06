package com.azshop.controllers.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.UserModel;
import com.azshop.utils.Constant;

@WebServlet(urlPatterns = { "/customer-home", "/customer-product" })
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("customer-home")) {
			try {
				HttpSession session = req.getSession();
				if (session != null) {
					Object sessionObject = session.getAttribute(Constant.userSession);
					if (sessionObject instanceof UserModel) {
						UserModel user = (UserModel) sessionObject;
						req.setAttribute("user", user);
						// Sử dụng thông tin người dùng ở đây
					}
				}

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

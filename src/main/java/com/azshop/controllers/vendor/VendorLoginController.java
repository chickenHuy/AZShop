package com.azshop.controllers.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.UserModel;
import com.azshop.services.IStoreService;
import com.azshop.services.StoreServiceImpl;
import com.azshop.utils.Constant;

@WebServlet(urlPatterns = { "/register-shop", "/store-check"})
public class VendorLoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
	    UserModel userModel = (UserModel) session.getAttribute(Constant.userSession);
		String url = req.getRequestURL().toString();
		if (url.contains("/store-check")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/createShop.jsp");
			rDispatcher.forward(req, resp);
			return;
		}
	}
	
}

package com.azshop.controllers.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.StoreModel;
import com.azshop.models.UserModel;
import com.azshop.services.IStoreService;
import com.azshop.services.StoreServiceImpl;
import com.azshop.utils.Constant;

@WebServlet(urlPatterns = { "/register-shop", "/store-check"})
public class CheckStoreController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		if (url.contains("/store-check")) {
			
		    UserModel userModel = (UserModel) session.getAttribute(Constant.userSession);
		    if (userModel == null)
		    {
		    	RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/account/login.jsp");
				rDispatcher.forward(req, resp);
		    }
		    else {
			    StoreModel storeModel = storeService.getByOwnerId(userModel.getId());
			    if (storeModel == null) {
			    	req.setAttribute("userModel", userModel);
			    	RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/createShop.jsp");
					rDispatcher.forward(req, resp);
				}
			    else {
			        session.setAttribute(Constant.storeSession, storeModel);
			    	RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/dashboard.jsp");
					rDispatcher.forward(req, resp);
					
				}
		    }
		}
	}
	
}

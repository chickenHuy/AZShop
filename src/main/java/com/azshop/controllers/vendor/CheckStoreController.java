package com.azshop.controllers.vendor;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.StoreModel;
import com.azshop.models.UserModel;
import com.azshop.services.IStoreLevelService;
import com.azshop.services.IStoreService;
import com.azshop.services.IUserService;
import com.azshop.services.StoreLevelServiceImpl;
import com.azshop.services.StoreServiceImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.CheckValid;
import com.azshop.utils.Constant;
import com.azshop.utils.SlugUtil;

@WebServlet(urlPatterns = { "/register-shop", "/store-check"})
public class CheckStoreController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IStoreService storeService = new StoreServiceImpl();
	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String error = req.getParameter("error");
		if (error != null)
		{
			req.setAttribute("error", error);
		}
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute(Constant.userSession);
	    if (userModel == null)
	    {
	    	resp.sendRedirect("login-customer");
	    	return;
	    }
		if (url.contains("/store-check")) {
		    StoreModel storeModel = storeService.getByOwnerId(userModel.getId());
		    if (storeModel == null) {
		    	resp.sendRedirect("register-shop");
			}
		    else {
		        session.setAttribute(Constant.storeSession, storeModel);
		        resp.sendRedirect("vendor/dashboard");
				
			}
		}
		if (url.contains("/register-shop")) {
			if (storeService.getByOwnerId(userModel.getId()) != null)
			{	resp.sendRedirect("vendor/dashboard");
				return;
			}
			req.setAttribute("user", userModel);
			req.getRequestDispatcher("/views/vendor/createShop.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute(Constant.userSession);
		if (url.contains("register-shop"))
		{
			try {
				StoreModel storeModel = new StoreModel();
				String name = req.getParameter("name");
				int storeLevel = storeLevelService.getDefaultLevel();
				int ownerId = userModel.getId();
				storeModel.setName(name);
				storeModel.setStoreLevelId(storeLevel);
				storeModel.setOwnerId(ownerId);
				storeModel.seteWallet(BigDecimal.valueOf(0));
				userModel = userService.getById(userModel.getId());
				String phone = req.getParameter("phoneNumber");
				String address = req.getParameter("address");
				if (phone != null && address != null) {
					userModel.setPhone(phone);
					userModel.setAddress(address);
				}
				userService.updateVendor(userModel);
				storeService.insert(storeModel);
				session.setAttribute(Constant.storeSession, storeModel);
				resp.sendRedirect("vendor/dashboard");

			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("login-customer");
			}
		}
	}
	
}

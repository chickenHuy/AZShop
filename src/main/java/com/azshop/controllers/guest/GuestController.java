package com.azshop.controllers.guest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.models.UserModel;
import com.azshop.services.IImageService;
import com.azshop.services.IProductService;
import com.azshop.services.IUserService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Email;

@WebServlet(urlPatterns = {"/guest-home", "/guest-clothing", "/register", "/VerifyCode"})
public class GuestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	IUserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("guest-home")) {
			try {
				getAllProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("guest-clothing")) {
			try {
				getAllClothing(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("register")) {
			try {
				getRegister(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("VerifyCode")) {
			try {
				getVerifyCode(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getAllClothing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/clothing.jsp");
		rd.forward(req, resp);
	}

	private void getVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/Verify1.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("register")) {
			postRegister(req, resp);
		} else if (url.contains("VerifyCode")) {
			postVerify(req, resp);
		}
	}

	private void postVerify(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter outPrintWriter = resp.getWriter()){
			
			HttpSession session = req.getSession();
			UserModel userModel = (UserModel) session.getAttribute("user");
			String codeSend = (String) session.getAttribute("code");
			
			String code = req.getParameter("verify-code");
			
			if (code.equals(codeSend)) {
				userModel.setEmail(userModel.getEmail());
				userModel.setEmailActive(true);
				
				userService.updateStatusEmail(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		
		if (userService.checkExistEmial(email)) {
			resp.sendRedirect(req.getContextPath() + "/views/account/register1.jsp");
		} else {
			Email mail = new Email();
			String code = mail.getRandom();
			
			UserModel user = new UserModel(firstName, lastName, email);
			
			boolean test = mail.sendEmail(user, code);
			if (test) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				session.setAttribute("code", code);
				
				boolean isSuccess = userService.insertRegister(firstName, lastName, email, password);
				
				if (isSuccess) {
					resp.sendRedirect(req.getContextPath() + "/VerifyCode");
				} else {
					req.getRequestDispatcher("/views/account/register1.jsp").forward(req, resp);
				}
			} else {
				PrintWriter outPrintWriter = resp.getWriter();
				outPrintWriter.println("Loi khi gui mail!");
			}
		}
	}

	private void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/register1.jsp").forward(req, resp);
	}

	private void getAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		ProductModel product = productService.getById(3); 
		
		List<ProductModel> productList = productService.getAll();
		
//		req.setAttribute("product",product);
		req.setAttribute("productList",productList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/guest/home.jsp");
		rd.forward(req, resp);
	}
}
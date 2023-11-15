package com.azshop.controllers.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.UserModel;
import com.azshop.services.IUserService;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Email;

@WebServlet(urlPatterns = {"/register-customer", "/verify-customer", "/login-customer", "/forget-customer"})
public class AccountController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("register-customer")) {
			getRegister(req, resp);
		} else if (url.contains("verify-customer")) {
			getVerify(req, resp);
		} else if (url.contains("login-customer")) {
			getLogin(req, resp);
		} else if (url.contains("forget-customer")) {
			getForget(req, resp);
		}
	}

	private void getForget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/forgetPassword.jsp").forward(req, resp);
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			UserModel user = (UserModel) session.getAttribute("account");
			req.setAttribute("username", user.getEmail());
			String result = user.getHashedPassword().split("-")[0];
			req.setAttribute("password", result);
			resp.sendRedirect(req.getContextPath() + "/login-customer");
			return;
		}
		req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
	}

	private void getVerify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/verify.jsp").forward(req, resp);
	}

	private void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("register-customer")) {
			postRegister(req, resp);
		} else if (url.contains("verify-customer")) {
			postVerify(req, resp);
		} else if (url.contains("login-customer")) {
			postLogin(req, resp);
		} else if (url.contains("forget-customer")) {
			postForget(req, resp);
		}
	}

	private void postForget(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.isEmpty() || password.isEmpty()) {
			req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
			return;
		}
		
		UserModel user = userService.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			resp.sendRedirect(req.getContextPath() + "/guest-home");
		} else {
			req.getRequestDispatcher("views/account/login.jsp").forward(req, resp);
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

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		
		if (userService.checkExistEmial(email)) {
			resp.sendRedirect(req.getContextPath() + "/views/account/register.jsp");
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
					resp.sendRedirect(req.getContextPath() + "/verify-customer");
				} else {
					req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
				}
			} else {
				PrintWriter outPrintWriter = resp.getWriter();
				outPrintWriter.println("Loi khi gui mail!");
			}
		}
	}
	
}

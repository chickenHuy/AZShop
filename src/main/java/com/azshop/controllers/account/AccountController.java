package com.azshop.controllers.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.CartModel;
import com.azshop.models.UserModel;
import com.azshop.services.IUserService;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Constant;
import com.azshop.utils.Email;
import com.azshop.utils.UploadUtils;

@WebServlet(urlPatterns = {"/login-customer", "/verify-customer", "/register-customer", "/forget-customer", "/logout-customer", "/reset-success-customer", "/information", "/update-infor", "/update-password", "/waiting"})
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50)

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
		} else if (url.contains("logout-customer")) {
			getLogout(req, resp);
		} else if (url.contains("reset-success-customer")) {
			getResetSuccess(req, resp);
		} else if (url.contains("information")) {
			getInfor(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		}
	}

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute(Constant.userSession) != null) {
			UserModel user = (UserModel) session.getAttribute(Constant.userSession);
			if ("customer".equals(user.getRole())) {
				resp.sendRedirect(req.getContextPath() + "/customer-home");
			} else if ("vendor".equals(user.getRole())) {
				resp.sendRedirect(req.getContextPath() + "/vendor/dashboard");
			} else if ("admin".equals(user.getRole())) {
				resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "login-customer");
		}
	}

	private void getInfor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null) {
			Object sessionObject = session.getAttribute(Constant.userSession);
			if (sessionObject instanceof UserModel) {
				UserModel user = (UserModel) sessionObject;
				req.setAttribute("user", user);
			}
		}
		req.getRequestDispatcher("/views/account/information.jsp").forward(req, resp);
	}

	private void getResetSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/reset-success.jsp").forward(req, resp);
	}

	private void getLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute(Constant.userSession);
		
		resp.sendRedirect("./login-customer");
	}

	private void getForget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/forget.jsp").forward(req, resp);
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute(Constant.userSession) != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
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
		} else if (url.contains("update-infor")) {
			postUpdateInfor(req, resp);
		} else if (url.contains("update-password")) {
			postUpdatePassword(req, resp);
		}
	}

	private void postUpdatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		UserModel user = new UserModel();
		String currentPass = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");
		String renewPassword = req.getParameter("renewPassword");
		HttpSession session = req.getSession();
		if (session != null) {
			Object sessionObject = session.getAttribute(Constant.userSession);
			if (sessionObject instanceof UserModel) {
				user = (UserModel) sessionObject;
			}
		}
		String hasePassword = currentPass + "-" + user.getSalt();
		if ((hasePassword).equals(user.getHashedPassword()) && newPassword.equals(renewPassword)) {
			userService.updatePassword(user, newPassword);
			resp.sendRedirect(req.getContextPath() + "/guest-home");
		} else {
			resp.sendRedirect(req.getContextPath() + "/information");
		}
	}

	private void postUpdateInfor(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		UserModel user = new UserModel();
		HttpSession session = req.getSession();
		if (session != null) {
			Object sessionObject = session.getAttribute(Constant.userSession);
			if (sessionObject instanceof UserModel) {
				user = (UserModel) sessionObject;
			}
		}
		String image = null;
		if (req.getPart("Image").getSize() != 0)
		{
			String fileName = "" + System.currentTimeMillis();
			image = UploadUtils.processUpload("Image", req, Constant.DIR, fileName);
		}
		
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		user.setEmail(user.getEmail());
		user.setPhone(req.getParameter("phone"));
		user.setAddress(req.getParameter("address"));
		user.setAvatar(image);
		userService.update(user);
		resp.sendRedirect(req.getContextPath() + "/information");
	}

	private void postForget(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String email = req.getParameter("username");
		if (userService.checkExistEmial(email)) {
			Email mail = new Email();
			String newPassword = mail.getRandom();
			
			UserModel user = userService.getByEmail(email);
			
			boolean test = mail.sendEmailForget(user, newPassword);
			if (test) {
				userService.updatePassword(user, newPassword);
				resp.sendRedirect(req.getContextPath() + "/reset-success-customer");
			} else {
				req.setAttribute("forGetError", "Lỗi khi gửi mail");
				req.getRequestDispatcher("/views/account/forget.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("forGetError", "Email không tồn tại!!!");
			req.getRequestDispatcher("/views/account/forget.jsp").forward(req, resp);
		}
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
			session.setAttribute(Constant.userSession, user);
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			// Đăng nhập không thành công, đặt thông báo lỗi vào request
	        req.setAttribute("loginError", "Thông tin đăng nhập không chính xác!");
	        // Forward lại đến trang login.jsp để hiển thị thông báo lỗi
	        req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
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
				resp.sendRedirect(req.getContextPath() + "/login-customer");
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
			req.setAttribute("registrationError", "Email đã tồn tại");
			req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
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

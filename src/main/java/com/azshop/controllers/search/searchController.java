package com.azshop.controllers.search;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.ProductModel;
import com.azshop.models.StoreModel;
import com.azshop.models.UserModel;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.ICategoryService;
import com.azshop.services.IProductService;
import com.azshop.services.IStoreService;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.StoreServiceImpl;
import com.azshop.utils.Constant;


@WebServlet(urlPatterns = {"/customer/search", "/guest/search"})
public class searchController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		IProductService productService = new ProductServiceImpl();
		IStoreService storeService = new StoreServiceImpl();
		ICategoryService categoryService = new CategoryServiceImpl();

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String url = request.getRequestURL().toString();
			
			if (url.contains("/customer/search")) {
					HttpSession session = request.getSession();
					UserModel userModel = (UserModel) session.getAttribute(Constant.userSession);
					if (userModel == null)
					{
						response.sendRedirect(request.getContextPath() + "/login-customer");
					}
			}
			
	        String keyword = request.getParameter("searchTerm");
	        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	        List<ProductModel> productModels = productService.search(keyword, categoryId, -1, -1, -1);
	        for (ProductModel productModel : productModels) {
				System.out.println(productModel.getName());
			}
	        
	        List<StoreModel> storeModels = storeService.searchByKey(keyword, -1);
	        request.setAttribute("stores", storeModels);
	        request.setAttribute("products", productModels);
	        request.setAttribute("searchTerm", keyword);
	        request.setAttribute("categoryId", categoryId);
	        request.setAttribute("categoryParentList", categoryService.getParentCategory());
	        request.getRequestDispatcher("/views/customer/search.jsp").forward(request, response);
	    }

}

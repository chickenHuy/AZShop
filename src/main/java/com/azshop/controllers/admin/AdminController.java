package com.azshop.controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.azshop.models.StoreModel;
import com.azshop.models.UserModel;
import com.azshop.services.IStoreService;
import com.azshop.services.IUserService;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Constant;
import com.azshop.utils.SlugUtil;
import com.azshop.utils.UploadUtils;
import com.google.gson.Gson;
import com.azshop.models.CategoryModel;
import com.azshop.models.OrderModel;
import com.azshop.models.ProductModel;
import com.azshop.services.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 50)

@WebServlet(urlPatterns = { "/admin/dashboard", "/admin/product", "/admin/customer", "/admin/store",
		"/admin/categories", "/admin/addcategory", "/admin/orders", "/admin/category/edit/*",
		"/admin/store/edit-status/*", "/admin/product/edit-status/*", "/admin/productsByCategory" })

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/product/edit-status")) {
			try {
				editProductStatus(req, resp);
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url.contains("/admin/productsByCategory")) {
			getProductByCategory(req, resp);
		} else if (url.contains("/admin/product")) {
			getAllProduct(req, resp);
		} else if (url.contains("/admin/categories")) {
			getAllCategory(req, resp);
		} else if (url.contains("/admin/addcategory")) {
			getAddCategory(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			getEditCategory(req, resp);
		} else if (url.contains("/admin/customer")) {
			getAllUser(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/customer.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/store/edit-status")) {
			try {
				editStatus(req, resp);
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url.contains("/admin/store")) {
			getAllStore(req, resp);
		} else if (url.contains("/admin/orders")) {
			getAllOrder(req, resp);
		}
	}

	private void getProductByCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		System.out.println("aaa" + categoryId);
		if (categoryId == -1)
		{
			System.out.println("aaa" );
			List<ProductModel> listProduct = productService.getAll();

			List<CategoryModel> listCategory = categoryService.getAll();

			int countAllProduct = listProduct.size();
			req.setAttribute("listProduct", listProduct);
			req.setAttribute("countAllProduct", countAllProduct);
			req.setAttribute("listCategory", listCategory);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
			
		} else {
			List<ProductModel> listProduct = productService.getByCategoryId((categoryId));
	        req.setAttribute("listProduct", listProduct);
	        
	        List<CategoryModel> listCategory = categoryService.getAll();
	        req.setAttribute("listCategory", listCategory);
	        
	        RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
		}
	}

	private void editProductStatus(HttpServletRequest req, HttpServletResponse resp)
			throws URISyntaxException, ServletException, IOException {

		String url = req.getRequestURL().toString();
		URI uri;
		try {
			uri = new URI(url);
			String path = uri.getPath();
			String[] parts = path.split("/");
			PrintWriter out = resp.getWriter();
			if (parts.length > 0) {
				if (url.contains("banning")) {
					String slug = parts[parts.length - 1].replace("banning-", "");
					System.out.println(slug);
					ProductModel productModel = productService.getBySlug(slug);
					if (productModel == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						productModel.setActive(false);
						productService.update(productModel);
						getAllProduct(req, resp);
					}
				} else {
					String slug = parts[parts.length - 1].replace("liencing-", "");

					ProductModel productModel = productService.getBySlug(slug);
					if (productModel == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						productModel.setActive(true);
						productService.update(productModel);
						getAllProduct(req, resp);
					}
				}

			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}
	}

	private void getEditCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);

		String url = req.getRequestURL().toString();
		URI uri;
		try {
			uri = new URI(url);
			String path = uri.getPath();
			String[] parts = path.split("/");
			PrintWriter out = resp.getWriter();
			if (parts.length > 0) {
				if (url.contains("edit")) {
					String slug = parts[parts.length - 1].replace("edit-", "");
					System.out.println("aaa" + slug);
					CategoryModel category = categoryService.getCategoryBySlug(slug);
					
					if (category == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						req.setAttribute("category", category);
						RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/addCategory.jsp");
						rDispatcher.forward(req, resp);
					}
				}
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}
		

	}

	private void getAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> listOrder = orderService.getAll();
		req.setAttribute("listOrder", listOrder);

		List<StoreModel> listStore = storeService.getAll();
		req.setAttribute("listStore", listStore);

		List<UserModel> listUser = userService.getAll();
		req.setAttribute("listUser", listUser);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/orders.jsp");
		rDispatcher.forward(req, resp);
	}

	private void editStatus(HttpServletRequest req, HttpServletResponse resp)
			throws URISyntaxException, IOException, ServletException {
		String url = req.getRequestURL().toString();
		System.out.println(url);
		URI uri;
		try {
			uri = new URI(url);
			String path = uri.getPath();
			String[] parts = path.split("/");
			PrintWriter out = resp.getWriter();
			if (parts.length > 0) {
				if (url.contains("banning")) {
					String slug = parts[parts.length - 1].replace("banning-", "");

					StoreModel storeModel = storeService.getBySlug(slug);
					if (storeModel == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						storeModel.setActive(false);
						storeService.update(storeModel);
						getAllStore(req, resp);
					}
				} else {
					String slug = parts[parts.length - 1].replace("liencing-", "");
					System.out.println("bbb" + slug);

					StoreModel storeModel = storeService.getBySlug(slug);
					if (storeModel == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						storeModel.setActive(true);
						storeService.update(storeModel);
						getAllStore(req, resp);
					}
				}

			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}

	}

	private void getAddCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/addCategory.jsp");
		rDispatcher.forward(req, resp);
	}

	private void getAllCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listCategory = categoryService.getAll();

		int countAllCategory = listCategory.size();
		req.setAttribute("countAllCategory", countAllCategory);
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/categories.jsp");
		rDispatcher.forward(req, resp);
	}

	private void getAllStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StoreModel> list = storeService.getAll();
		req.setAttribute("liststore", list);
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/store.jsp");
		rDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/addcategory")) {
			postAddCategory(req, resp);
		}
	}

	private void postAddCategory(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		CategoryModel category = new CategoryModel();

		String name = req.getParameter("categoryName");
		String slug = SlugUtil.toSlug(name);
		int indexOfDash = slug.lastIndexOf("-");
		if (indexOfDash != -1) {
			slug = slug.substring(0, indexOfDash);
		}

		String categoryId = req.getParameter("categoryId");
		try {
			category.setCategoryId(Integer.parseInt(categoryId));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Part imagePart = req.getPart("image");

		if (imagePart != null && imagePart.getSize() != 0) {
			// Tên file duy nhất
			String fileName = "image" + System.currentTimeMillis();

			// Xử lý tải lên và lưu trữ hình ảnh
			String imagePath = UploadUtils.processUpload("image", req, Constant.DIR, fileName);
			category.setImage(imagePath);
		}

		category.setName(name);
		category.setSlug(slug);

		categoryService.insert(category);
		resp.sendRedirect("categories");
	}

	private void getAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> listProduct = productService.getAll();

		List<CategoryModel> listCategory = categoryService.getAll();

		int countAllProduct = listProduct.size();
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("countAllProduct", countAllProduct);
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
		rDispatcher.forward(req, resp);
	}

	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) {
		List<UserModel> list = userService.getAll();
		req.setAttribute("listuser", list);
	}

}

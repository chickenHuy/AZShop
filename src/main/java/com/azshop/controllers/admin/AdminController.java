package com.azshop.controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.azshop.models.UserLevelModel;
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
import com.azshop.models.StoreLevelModel;
import com.azshop.services.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 50)

@WebServlet(urlPatterns = { "/admin/dashboard", "/admin/product", "/admin/customer", "/admin/store",
		"/admin/categories", "/admin/addcategory", "/admin/orders", "/admin/category/edit",
		"/admin/store/edit-status/*", "/admin/product/edit-status/*", "/admin/productsByCategory",
		"/admin/order-edit-status", "/admin/userlevel", "/admin/adduserlevel", "/admin/edituserlevel",
		"/admin/deleteuserlevel", "/admin/restoreuserlevel", "/admin/storelevel", "/admin/addstorelevel",
		"/admin/editstorelevel", "/admin/deletestorelevel", "/admin/restorestorelevel", "/admin/category/delete/*",
		"/admin/category/restore/*" })

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();
	IUserLevelService userLevelService = new UserLevelServiceImpl();
	IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			getInUser(req, resp);
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
		} else if (url.contains("/admin/category/delete")) {
			getDeleteCategory(req, resp);
		} else if (url.contains("/admin/category/restore")) {
			getRestoreCategory(req, resp);
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
		} else if (url.contains("/admin/storelevel")) {
			getAllStoreLevel(req, resp);
			getAllStoreLevelDeleted(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/storelevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/addstorelevel")) {
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/addstorelevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/editstorelevel")) {
			String id = req.getParameter("id");
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			if (id != null) {
				StoreLevelModel storeLevel = storeLevelService.getById(Integer.parseInt(id));
				req.setAttribute("storelevel", storeLevel);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editstorelevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/store")) {
			getAllStore(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/store.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/userlevel")) {
			getAllUserLevel(req, resp);
			getAllUserLevelDeleted(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/userlevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/adduserlevel")) {
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/adduserlevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/order-edit-status")) {
			editOrderStatus(req, resp);
		} else if (url.contains("/admin/orders")) {
			getAllOrder(req, resp);
		} else if (url.contains("/admin/edituserlevel")) {
			String id = req.getParameter("id");
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			if (id != null) {
				UserLevelModel userLevel = userLevelService.getById(Integer.parseInt(id));
				req.setAttribute("userlevel", userLevel);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/edituserlevel.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/restorestorelevel")) {
            restoreStoreLevel(req, resp);
        } else if (url.contains("/admin/restoreuserlevel")) {
            restoreUserLevel(req, resp);
        }
	}
	private void getAllStoreLevelDeleted(HttpServletRequest req, HttpServletResponse resp) {
		List<StoreLevelModel> list = storeLevelService.getAllDeleted();
		req.setAttribute("listdeleted", list);
	}

	private void getAllUserLevelDeleted(HttpServletRequest req, HttpServletResponse resp) {
		List<UserLevelModel> list = userLevelService.getAllDeleted();
		req.setAttribute("listdeleted", list);
	}

	private void getAllStoreLevel(HttpServletRequest req, HttpServletResponse resp) {
		List<StoreLevelModel> list = storeLevelService.getAll();
		req.setAttribute("liststorelevel", list);
	}
	private void getInUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date currentDate = new Date();

		// Count users based on the formatted date and time
		int count = userService.countUser(currentDate);
		// day du lieu ra view
		req.setAttribute("count", count);
		// view nhan du lieu
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/dashboard.jsp");
		rd.forward(req, resp);
	}

	private void getRestoreCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		URI uri;
		try {
			uri = new URI(url);
			String path = uri.getPath();
			String[] parts = path.split("/");
			PrintWriter out = resp.getWriter();
			if (parts.length > 0) {
				if (url.contains("restore")) {
					String slug = parts[parts.length - 1].replace("restore-", "");
					CategoryModel category = categoryService.getCategoryBySlug(slug);
					if (category == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						categoryService.restoreBySlug(slug);
					}
				}
				resp.sendRedirect("/AZShop/admin/categories");
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}
	}

	private void getDeleteCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		URI uri;
		try {
			uri = new URI(url);
			String path = uri.getPath();
			String[] parts = path.split("/");
			PrintWriter out = resp.getWriter();
			if (parts.length > 0) {
				if (url.contains("delete")) {
					String slug = parts[parts.length - 1].replace("delete-", "");
					CategoryModel category = categoryService.getCategoryBySlug(slug);
					if (category == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						categoryService.deleteBySlug(slug);
					}
				}
				resp.sendRedirect("/AZShop/admin/categories");
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}
	}

	private void editOrderStatus(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException, ServletException {
		String orderId = req.getParameter("orderId");

		OrderModel order = orderService.getById(Integer.parseInt(orderId));

		if ("pending Pickup".equals(order.getStatus())) {
			order.setStatus("shipping");
		} else if ("shipping".equals(order.getStatus())) {
			order.setStatus("delivered");
		} else if ("delivered".equals(order.getStatus())) {
			order.setStatus("completed");
		}

		// Update the order only once after processing all conditions
		orderService.update(order);

		// Redirect the user after updating the order status
		resp.sendRedirect("orders");
	}

	private void getProductByCategory(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		if (categoryId == -1) {

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
			int countAllProduct = listProduct.size();
			req.setAttribute("countAllProduct", countAllProduct);
			List<CategoryModel> listCategory = categoryService.getAll();
			req.setAttribute("listCategory", listCategory);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
		}
	}

	private void getAllUserLevel(HttpServletRequest req, HttpServletResponse resp) {
		List<UserLevelModel> list = userLevelService.getAll();
		req.setAttribute("listuserlevel", list);
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
					}
				} else {
					String slug = parts[parts.length - 1].replace("liencing-", "");
					System.out.println(slug);
					ProductModel productModel = productService.getBySlug(slug);
					if (productModel == null) {
						req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
					} else {
						productModel.setActive(true);
						productService.update(productModel);
					}
				}
				resp.sendRedirect("/AZShop/admin/product");
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		}
	}

	private void getEditCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String slug = req.getParameter("slug");

		CategoryModel category = categoryService.getCategoryBySlug(slug);
		req.setAttribute("category", category);

		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);
		System.out.println(category.getName());

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editCategory.jsp");
		rDispatcher.forward(req, resp);
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
				resp.sendRedirect("/AZShop/admin/store");

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
		List<CategoryModel> listCategory = categoryService.getAllAdmin();

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
		} else if (url.contains("/admin/adduserlevel")) {
			postAddUserLevel(req, resp);
		} else if (url.contains("/admin/edituserlevel")) {
			postEditUserLevel(req, resp);
		} else if (url.contains("/admin/deleteuserlevel")) {
            postDeleteUserLevel(req, resp);
        } else if (url.contains("/admin/addstorelevel")) {
			postAddStoreLevel(req, resp);
		} else if (url.contains("/admin/editstorelevel")) {
			postEditStoreLevel(req, resp);
		} else if (url.contains("/admin/deletestorelevel")) {
            postDeleteStoreLevel(req, resp);
        }

	}
	private void restoreUserLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        UserLevelModel userLevel = userLevelService.getById(Integer.parseInt(id));
        try {
            userLevel.setDeleted(false);
            userLevelService.update(userLevel);
            resp.sendRedirect("userlevel");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private void restoreStoreLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        StoreLevelModel storeLevel = storeLevelService.getById(Integer.parseInt(id));
        try {
            storeLevel.setDeleted(false);
            storeLevelService.update(storeLevel);
            resp.sendRedirect("storelevel");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private void postDeleteStoreLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        StoreLevelModel storeLevel = storeLevelService.getById(Integer.parseInt(id));
        try {
            storeLevel.setDeleted(true);
            storeLevelService.update(storeLevel);
            resp.sendRedirect("editstorelevel?message=Sucessfully");
        } catch (Exception e) {
            resp.sendRedirect("editstorelevel?message=Failed to delete the store level");
        }
	}

	private void postEditStoreLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		StoreLevelModel storeLevel = storeLevelService.getById(Integer.parseInt(id));

		String name = req.getParameter("storelevelname");
		String minPoint = req.getParameter("minpoint");
		String discount = req.getParameter("discount");

		if (name != null && minPoint != null && discount != null) {
			try {
				storeLevel.setName(name);
				storeLevel.setMinPoint(Integer.parseInt(minPoint));
				storeLevel.setDiscount(Integer.parseInt(discount));

				storeLevelService.update(storeLevel);
				resp.sendRedirect("?message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("?message=Failed to edit the store level");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
		}
	}

	private void postAddStoreLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		StoreLevelModel storeLevel = new StoreLevelModel();

		String name = req.getParameter("storelevelname");
		String minPoint = req.getParameter("minpoint");
		String discount = req.getParameter("discount");
		if (name != null && minPoint != null && discount != null) {

			if (!storeLevelService.checkName(name)) {
				try {
					storeLevel.setName(name);
					storeLevel.setMinPoint(Integer.parseInt(minPoint));
					storeLevel.setDiscount(Integer.parseInt(discount));

					storeLevelService.insert(storeLevel);
					resp.sendRedirect("?message=Successfully");
				} catch (Exception e) {
					resp.sendRedirect("?message=Failed to add the user level");
				}
			} else {
				resp.sendRedirect("?message=Name already exists");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
		}
	}
	private void postDeleteUserLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        UserLevelModel userLevel = userLevelService.getById(Integer.parseInt(id));
        try {
            userLevel.setDeleted(true);
            userLevelService.update(userLevel);
            resp.sendRedirect("edituserlevel?message=Sucessfully");
        } catch (Exception e) {
            resp.sendRedirect("edituserlevel?message=Failed to delete the user level");
        }
    }
	private void postEditUserLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		UserLevelModel userLevel = userLevelService.getById(Integer.parseInt(id));

		String name = req.getParameter("userlevelname");
		String minPoint = req.getParameter("minpoint");
		String discount = req.getParameter("discount");

		if (name != null && minPoint != null && discount != null) {
			if (!userLevelService.checkName(name)) {
				try {
					userLevel.setName(name);
					userLevel.setMinPoint(Integer.parseInt(minPoint));
					userLevel.setDiscount(Integer.parseInt(discount));

					userLevelService.insert(userLevel);
					resp.sendRedirect("?message=Successfully");
				} catch (Exception e) {
					resp.sendRedirect("?message=Failed to add the user level");
				}
			} else {
				resp.sendRedirect("?message=Name already exists");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
		}
	}

	private void postAddUserLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		UserLevelModel userLevel = new UserLevelModel();

		String name = req.getParameter("userlevelname");
		String minPoint = req.getParameter("minpoint");
		String discount = req.getParameter("discount");
		if (name != null && minPoint != null && discount != null) {
			try {
				userLevel.setName(name);
				userLevel.setMinPoint(Integer.parseInt(minPoint));
				userLevel.setDiscount(Integer.parseInt(discount));

				userLevelService.insert(userLevel);
				resp.sendRedirect("?message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("?message=Failed to add the user level");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
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
		String categoryId = req.getParameter("categoryId");

		if (categoryId == null || categoryId.isEmpty()) {

			List<ProductModel> listProduct = productService.getAll();

			List<CategoryModel> listCategory = categoryService.getAll();

			int countAllProduct = listProduct.size();
			req.setAttribute("listProduct", listProduct);
			req.setAttribute("countAllProduct", countAllProduct);
			req.setAttribute("listCategory", listCategory);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);

		} else {
			List<ProductModel> listProduct = productService.getByCategoryId(Integer.parseInt(categoryId));
			req.setAttribute("listProduct", listProduct);
			int countAllProduct = listProduct.size();
			req.setAttribute("countAllProduct", countAllProduct);
			List<CategoryModel> listCategory = categoryService.getAll();
			req.setAttribute("listCategory", listCategory);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
		}
	}

	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) {
		List<UserModel> list = userService.getAll();
		req.setAttribute("listuser", list);
	}

}

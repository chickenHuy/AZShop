package com.azshop.controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.azshop.models.StoreModel;
import com.azshop.models.StyleModel;
import com.azshop.models.StyleValueModel;
import com.azshop.models.UserLevelModel;
import com.azshop.models.UserModel;
import com.azshop.utils.Constant;
import com.azshop.utils.SlugUtil;
import com.azshop.utils.UploadUtils;
import com.google.gson.Gson;
import com.azshop.models.CategoryModel;
import com.azshop.models.DeliveryModel;
import com.azshop.models.ImageModel;
import com.azshop.models.OrderItemModel;
import com.azshop.models.OrderModel;
import com.azshop.models.ProductModel;
import com.azshop.models.RevenueData;
import com.azshop.models.ReviewModel;
import com.azshop.models.StoreLevelModel;
import com.azshop.models.TransactionModel;
import com.azshop.services.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 50)

@WebServlet(urlPatterns = { "/admin/dashboard", "/admin/product", "/admin/customer", "/admin/store",
		"/admin/categories", "/admin/addcategory", "/admin/orders", "/admin/category/edit",
		"/admin/store/edit-status/*", "/admin/product/edit-status/*", "/admin/productsByCategory",
		"/admin/order-edit-status", "/admin/userlevel", "/admin/adduserlevel", "/admin/edituserlevel",
		"/admin/deleteuserlevel", "/admin/restoreuserlevel", "/admin/storelevel", "/admin/addstorelevel",
		"/admin/editstorelevel", "/admin/deletestorelevel", "/admin/restorestorelevel", "/admin/category/delete",
		"/admin/styles", "/admin/style/delete", "/admin/style/restore", "/admin/addstyle", "/admin/style/stylevalues",
		"/admin/style/stylevalue/*", "/admin/style/addstylevalue", "/admin/style/stylevalue/edit",
		"/admin/order-detail", "/admin/UserStatic", "/admin/StoreStatic", "/admin/style/edit",
		"/admin/category/restore", "/admin/delivery", "/admin/adddelivery", "/admin/editdelivery",
		"/admin/deletedelivery", "/admin/transaction", "/admin/order/cancel-order" })

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	IStyleService styleService = new StyleServiceImpl();
	IUserFollowStoreService UserFollowStoreService = new UserFollowStoreServiceImpl();
	IUserLevelService userLevelService = new UserLevelServiceImpl();
	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	IOrderItemService orderItemService = new OrderItemServiceImpl();
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	IReviewService ReviewService = new ReviewServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	ITransactionService transactionService = new TransactionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURL().toString();

		try {
			HttpSession session = req.getSession();
			if (session != null) {
				Object sessionObject = session.getAttribute(Constant.userSession);
				if (sessionObject instanceof UserModel) {
					UserModel user = (UserModel) sessionObject;

					String name = user.getFirstName() + " " + user.getLastName();

					req.setAttribute("userName", name);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (url.contains("/admin/dashboard")) {
			GetStatisticRevenue(req, resp);
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
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/categories")) {
			getAllCategory(req, resp);
		} else if (url.contains("/admin/addcategory")) {
			getAddCategory(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			getEditCategory(req, resp);
		} else if (url.contains("/admin/category/restore")) {
			editCategoryStatus(req, resp);
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
		} else if (url.contains("/admin/style/delete")) {
			getDeleteStyle(req, resp);
		} else if (url.contains("/admin/style/restore")) {
			getRestoreStyle(req, resp);
		} else if (url.contains("/admin/style/edit")) {
			getEditStyle(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editStyle.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/styles")) {
			getAllStyle(req, resp);
		} else if (url.contains("/admin/style/stylevalues")) {
			getAllStyleValueByStyle(req, resp);
		} else if (url.contains("/admin/style/stylevalue/edit")) {
			getEditStylValue(req, resp);
		} else if (url.contains("/admin/style/stylevalue")) {
			editStylValueStatus(req, resp);
		} else if (url.contains("/admin/restorestorelevel")) {
			restoreStoreLevel(req, resp);
		} else if (url.contains("/admin/restoreuserlevel")) {
			restoreUserLevel(req, resp);
		} else if (url.contains("/admin/order-detail")) {
			getOrderDetail(req, resp);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/orderDetail.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/StoreStatic")) {
			GetStatisticsStore(req, resp);
		} else if (url.contains("/admin/UserStatic")) {
			GetStatisticsUser(req, resp);
		} else if (url.contains("/admin/delivery")) {
			getDelivery(req, resp);
		} else if (url.contains("/admin/adddelivery")) {
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/adddelivery.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/editdelivery")) {
			String id = req.getParameter("id");
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			if (id != null) {
				DeliveryModel deliveryModel = deliveryService.getById(Integer.parseInt(id));
				req.setAttribute("delivery", deliveryModel);
			}
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editdelivery.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/transaction")) {
			getTransaction(req, resp);
		}
	}

	private void getEditStyle(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String message = req.getParameter("message");
		req.setAttribute("message", message);
		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);
		if (id != null) {
			StyleModel style = styleService.getById(Integer.parseInt(id));
			req.setAttribute("style", style);
		}
	}

	private void getOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String orderId = req.getParameter("orderId");
		if (orderId != null) {
			List<OrderItemModel> listOrderItem = orderItemService.getByOrderId(Integer.parseInt(orderId));
			
			int countProduct = listOrderItem.size();
			req.setAttribute("countProduct", countProduct);
			BigDecimal totalOrder = BigDecimal.ZERO;

			for (OrderItemModel orderItem : listOrderItem) {
				totalOrder = totalOrder.add(orderItemService.calculateOrderItemTotal(orderItem.getId()));
			}
			req.setAttribute("totalOrder", totalOrder);

			OrderModel order = orderService.getById(Integer.parseInt(orderId));
			req.setAttribute("order", order);
			req.setAttribute("orderId", orderId);

			List<ProductModel> listProduct = productService.getAll();
			req.setAttribute("listProduct", listProduct);

			DeliveryModel delivery = deliveryService.getById(order.getDeliveryId());
			req.setAttribute("shipping_cost", delivery.getPrice());

			UserModel user = userService.getById(order.getUserId());
			req.setAttribute("user", user);

			order.setPrice(orderService.calculateOrderTotal(order.getId()));

			totalOrder = totalOrder.add(delivery.getPrice());

			UserLevelModel userLevel = userLevelService.getById(user.getUserLevelId());
			req.setAttribute("discount", BigDecimal.valueOf(userLevel.getDiscount() / 100.0).multiply(totalOrder));
			
			for (int i = 0; i < listOrderItem.size(); i++) {
			    for (int j = i + 1; j < listOrderItem.size(); j++) {
			        if (listOrderItem.get(i).getProductId() == listOrderItem.get(j).getProductId()) {
			        	listOrderItem.get(i).setCount(listOrderItem.get(i).getCount() + listOrderItem.get(j).getCount());
			        	orderItemService.update(listOrderItem.get(i));
			        	listOrderItem.remove(j);
			        }
			    }
			}
			req.setAttribute("listOrderItem", listOrderItem);

			String message = req.getParameter("message");
			req.setAttribute("message", message);

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

	private void GetStatisticRevenue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date currentDate = new Date();
		String selectedDateStr = req.getParameter("selectedDate");
		Date selectedDate = null;

		if (selectedDateStr != null && !selectedDateStr.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				selectedDate = dateFormat.parse(selectedDateStr);
			} catch (Exception e) {
				e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
			}
		} else {
			selectedDate = currentDate;
		}
		int count = orderService.getTotalShopRevenueByDate(selectedDate);
		int total = orderService.getTotalShopRevenue();
		int totalFL = UserFollowStoreService.getTotalFollow();
		List<ProductModel> productModels = productService.getAll(); // totalProducts
		if (productModels != null)
			req.setAttribute("totalProducts", productModels.size());
		List<OrderModel> orderModels = orderService.getAll();
		if (orderModels != null)
			req.setAttribute("totalOrders", orderModels.size());

		List<ReviewModel> ReviewModels = ReviewService.getAll();
		if (ReviewModels != null)
			req.setAttribute("totalReview", ReviewModels.size());
		req.setAttribute("total", total);
		req.setAttribute("count", count);
		req.setAttribute("totalFL", totalFL);
		// view nhan du lieu
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/dashboard.jsp");
		rd.forward(req, resp);

	}

	private void GetStatisticsUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date currentDate = new Date();
		String selectedDateStr = req.getParameter("selectedDate");
		Date selectedDate = null;

		if (selectedDateStr != null && !selectedDateStr.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				selectedDate = dateFormat.parse(selectedDateStr);
			} catch (Exception e) {
				e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
			}
		} else {
			selectedDate = currentDate;
		}
		int n;
		String dayParam = req.getParameter("quantity");
		if (dayParam != null) {
			try {
				n = Integer.parseInt(dayParam);
			} catch (NumberFormatException e) {
				e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
				n = 1; // Nếu có lỗi, sử dụng giá trị mặc định là 1
			}
		} else {
			n = 1;
		}
		List<UserModel> users = userService.getUserWithinDays(n);
		req.setAttribute("day", n);
		req.setAttribute("users", users);
		int count = userService.countUser(selectedDate);
		int total = userService.getTotalUsers();
		req.setAttribute("total", total);
		req.setAttribute("count", count);

		// view nhan du lieu
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/StaticsUser.jsp");
		rd.forward(req, resp);
	}

	private void GetStatisticsStore(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date currentDate = new Date();
		String selectedDateStr = req.getParameter("selectedDate");
		Date selectedDate = null;

		if (selectedDateStr != null && !selectedDateStr.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				selectedDate = dateFormat.parse(selectedDateStr);
			} catch (Exception e) {
				e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
			}
		} else {
			selectedDate = currentDate;
		}
		int n;
		String dayParam = req.getParameter("quantity");
		if (dayParam != null) {
			try {
				n = Integer.parseInt(dayParam);
			} catch (NumberFormatException e) {
				e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
				n = 1; // Nếu có lỗi, sử dụng giá trị mặc định là 1
			}
		} else {
			n = 1;
		}
		List<StoreModel> stores = storeService.getStoreWithinDays(n);
		
		req.setAttribute("day", n);
		req.setAttribute("stores", stores);
		int count = storeService.countNewStores(selectedDate);
		int total = storeService.getTotalStores();
		req.setAttribute("total", total);
		req.setAttribute("count", count);
		// view nhan du lieu
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/StaticsStore.jsp");
		rd.forward(req, resp);
	}

	private void getEditStylValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id != null) {
			StyleValueModel styleValue = styleValueService.getById(Integer.parseInt(id));
			req.setAttribute("styleValue", styleValue);
			String message = req.getParameter("message");
			req.setAttribute("message", message);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editStyleValue.jsp");
			rDispatcher.forward(req, resp);
		}
	}

	private void editStylValueStatus(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String url = req.getRequestURL().toString();
		String id = req.getParameter("id");
		if (url.contains("restore")) {
			if (id != null) {
				styleValueService.restore(Integer.parseInt(id));
			}
		} else if (url.contains("delete")) {
			if (id != null) {
				styleValueService.delete(Integer.parseInt(id));
			}
		}
		StyleValueModel styleValue = styleValueService.getByIdAdmin(Integer.parseInt(id));
		resp.sendRedirect("/AZShop/admin/style/stylevalues?styleid=" + styleValue.getStyleId());
	}

	private void getAllStyleValueByStyle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String styleId = req.getParameter("styleid");

		if (styleId != null) {
			List<StyleValueModel> listStyleValue = styleValueService.getByStyleIdAmin(Integer.parseInt(styleId));
			req.setAttribute("listStyleValue", listStyleValue);
			req.setAttribute("styleId", styleId);
			List<StyleModel> listStyle = styleService.getAllAdmin();
			req.setAttribute("listStyle", listStyle);

			int countAllStyleValue = listStyleValue.size();
			req.setAttribute("countAllStyleValue", countAllStyleValue);
			String message = req.getParameter("message");
			req.setAttribute("message", message);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/stylevalues.jsp");
			rDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("/AZShop/admin/styles");
		}

	}

	private void getRestoreStyle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String styleId = req.getParameter("id");
		if (styleId != null) {
			styleService.restore(Integer.parseInt(styleId));
		}
		resp.sendRedirect("/AZShop/admin/styles");
	}

	private void getDeleteStyle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String styleId = req.getParameter("id");
		if (styleId != null) {
			styleService.delete(Integer.parseInt(styleId));
		}
		resp.sendRedirect("/AZShop/admin/styles");
	}

	private void getAllStyle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StyleModel> listStyle = styleService.getAllAdmin();
		req.setAttribute("listStyle", listStyle);
		int countAllStyle = listStyle.size();
		req.setAttribute("countAllStyle", countAllStyle);
		List<CategoryModel> listCategory = categoryService.getAllAdmin();
		req.setAttribute("listCategory", listCategory);
		String message = req.getParameter("message");
		req.setAttribute("message", message);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/styles.jsp");
		rDispatcher.forward(req, resp);
	}

	private void editCategoryStatus(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String slug = req.getParameter("slug");
		CategoryModel category = categoryService.getCategoryBySlug(slug);
		if (category == null) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		} else {
			categoryService.restoreBySlug(slug);
		}
		resp.sendRedirect("/AZShop/admin/categories");
	}

	private void editOrderStatus(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException, ServletException {
		String orderId = req.getParameter("orderId");

		OrderModel order = orderService.getById(Integer.parseInt(orderId));

		if ("Pending Pickup".equals(order.getStatus())) {
			order.setStatus("Shipping");
		} else if ("Shipping".equals(order.getStatus())) {
			order.setStatus("Selivered");
		} else if ("Delivered".equals(order.getStatus())) {
			order.setStatus("Completed");
			try {
				// Cộng tiền vào cho Store
				StoreModel storeModel = storeService.getById(order.getStoreId());
				storeModel.seteWallet(storeModel.geteWallet().add(order.getAmountFromStore()));
				storeService.update(storeModel);

				// Tăng số lượng đã bán của sản phẩm
				// Lấy danh sách orderItem
				List<OrderItemModel> listOrderItem = orderItemService.getByOrderId(Integer.parseInt(orderId));
				for (OrderItemModel orderItem : listOrderItem) {
					ProductModel product = productService.getById(orderItem.getProductId());
					product.setSold(product.getSold() + orderItem.getCount());
					productService.update(product);
				}
			} catch (Exception e) {

			}

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

			getAllProduct(req, resp);

			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
			rDispatcher.forward(req, resp);

		} else {
			List<ProductModel> listProduct = productService.getByCategoryId((categoryId));
			req.setAttribute("listProduct", listProduct);
			int countAllProduct = listProduct.size();
			req.setAttribute("countAllProduct", countAllProduct);
			List<CategoryModel> listCategory = categoryService.getAll();
			req.setAttribute("listCategory", listCategory);
			List<ImageModel> lisImageModels = new ArrayList<ImageModel>();
			for (ProductModel productModel : listProduct) {
				List<ImageModel> listModelByProduct = imageService.getByProductId(productModel.getId());
				if (listModelByProduct.size() > 0)
					lisImageModels.add(listModelByProduct.get(0));
			}
			req.setAttribute("images", lisImageModels);

			List<StoreModel> listStore = storeService.getAll();
			req.setAttribute("listStore", listStore);

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
		String message = req.getParameter("message");

		req.setAttribute("message", message);

		CategoryModel category = categoryService.getCategoryBySlug(slug);
		req.setAttribute("category", category);

		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/editCategory.jsp");
		rDispatcher.forward(req, resp);
	}

	private void getAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> listOrder = orderService.getAll();
		for (OrderModel order : listOrder) {
			order.setPrice(orderService.calculateOrderTotal(order.getId()));
		}
		req.setAttribute("listOrder", listOrder);

		List<StoreModel> listStore = storeService.getAll();
		req.setAttribute("listStore", listStore);

		List<UserModel> listUser = userService.getAll();
		req.setAttribute("listUser", listUser);

		List<OrderModel> listOrderAdmin = orderService.getAllAdmin();
		int countAllOrderAdmin = listOrderAdmin.size();
		req.setAttribute("countAllOrderAdmin", countAllOrderAdmin);

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
		} else if (url.contains("/admin/addstyle")) {
			postAddStyle(req, resp);
		} else if (url.contains("/admin/deleteuserlevel")) {
			postDeleteUserLevel(req, resp);
		} else if (url.contains("/admin/style/addstylevalue")) {
			postAddStyleValue(req, resp);
		} else if (url.contains("/admin/style/stylevalue/edit")) {
			postEditStylValue(req, resp);
		} else if (url.contains("/admin/addstorelevel")) {
			postAddStoreLevel(req, resp);
		} else if (url.contains("/admin/editstorelevel")) {
			postEditStoreLevel(req, resp);
		} else if (url.contains("/admin/deletestorelevel")) {
			postDeleteStoreLevel(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			postEditCategory(req, resp);
		} else if (url.contains("/admin/category/delete")) {
			postDeleteCategory(req, resp);
		} else if (url.contains("/admin/style/edit")) {
			postEditStyle(req, resp);
		} else if (url.contains("/admin/adddelivery")) {
			postAddDelivery(req, resp);
		} else if (url.contains("/admin/editdelivery")) {
			postEditDelivery(req, resp);
		} else if (url.contains("/admin/deletedelivery")) {
			postDeleteDelivery(req, resp);
		} else if (url.contains("/admin/order/cancel-order")) {
			postCancelOrder(req, resp);
		}

	}

	private void postCancelOrder(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String id = req.getParameter("id");

		if (id != null) {
			try {
				OrderModel order = orderService.getById(Integer.parseInt(id));
				order.setStatus("Cancelled");

				List<OrderItemModel> listOrderItem = orderItemService.getByOrderId(order.getId());
				for (OrderItemModel orderItem : listOrderItem) {
					ProductModel product = productService.getById(orderItem.getProductId());
					product.setQuantity(product.getQuantity() + orderItem.getCount());
					productService.update(product);
				}
				if (order.isPaidBefore() == true) {
					UserModel user = userService.getById(order.getUserId());
					user.seteWallet(user.geteWallet().add(order.getAmountFromUser()));
					userService.update(user);
				}
				orderService.update(order);
				getOrderDetail(req, resp);
				resp.sendRedirect("/AZShop/admin/order-detail?orderId=" + id + "&&message=Successfully");
			} catch (Exception e) {
				getOrderDetail(req, resp);
				resp.sendRedirect("/AZShop/admin/order-detail?orderId=" + id + "&&message=Failed");
			}
		} else {
			getOrderDetail(req, resp);
			resp.sendRedirect("/AZShop/admin/order-detail?orderId=" + id + "&&message=Failed");
		}
	}

	private void postEditStyle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		StyleModel style = styleService.getById(Integer.parseInt(id));

		String name = req.getParameter("styleName");
		String categoryId = req.getParameter("categoryId");
		if (name != "") {
			try {
				style.setName(name);
				style.setCategoryId(Integer.parseInt(categoryId));
				styleService.update(style);

				resp.sendRedirect("/AZShop/admin/style/edit?id=" + id + "&&message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("/AZShop/admin/style/edit?id=" + id + "&&message=Failed to add the user level");
			}

		} else {
			resp.sendRedirect("/AZShop/admin/style/edit?id=" + id + "&&message=You must fill out the form");
		}
	}

	private void postDeleteCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String slug = req.getParameter("slug");
		CategoryModel category = categoryService.getCategoryBySlug(slug);
		if (category == null) {
			req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
		} else {
			categoryService.deleteBySlug(slug);
		}
		resp.sendRedirect("/AZShop/admin/categories");
	}

	private void postEditCategory(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		CategoryModel category = categoryService.getById(Integer.parseInt(id));
		String slug = null;

		String name = req.getParameter("categoryName");
		if (name != "") {

			try {
				slug = SlugUtil.toSlug(name);
				int indexOfDash = slug.lastIndexOf("-");
				if (indexOfDash != -1) {
					slug = slug.substring(0, indexOfDash);
				}

				String categoryId = req.getParameter("categoryId");

				if ("0".equals(categoryId)) {
					if (category.getCategoryId() > 0) {

					} else {
						category.setCategoryId(0);
					}
				} else {
					category.setCategoryId(Integer.parseInt(categoryId));
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
				categoryService.update(category);
				resp.sendRedirect("?slug=" + slug + "&&message=Sucessfully");
			} catch (Exception e) {
				resp.sendRedirect("?slug=" + category.getSlug() + "&&message=Failed to edit the category");
			}
		} else {
			resp.sendRedirect("?slug=" + category.getSlug() + "?message=You must fill out the form");
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

	private void postEditStylValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		StyleValueModel styleValue = styleValueService.getById(Integer.parseInt(id));

		String name = req.getParameter("styleValueName");
		if (name != "") {
			try {
				styleValue.setName(name);
				styleValueService.update(styleValue);

				resp.sendRedirect("/AZShop/admin/style/stylevalue/edit?id=" + id + "&&message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect(
						"/AZShop/admin/style/stylevalue/edit?id=" + id + "&&message=Failed to add the user level");
			}

		} else {
			resp.sendRedirect("/AZShop/admin/style/stylevalue/edit?id=" + id + "&&message=You must fill out the form");
		}
	}

	private void postAddStyleValue(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("styleValueName");
		String styleId = req.getParameter("styleId");

		StyleValueModel styleValue = new StyleValueModel();

		if (name != "" && styleId != null) {
			try {
				styleValue.setName(name);
				styleValue.setStyleId(Integer.parseInt(styleId));

				styleValueService.insert(styleValue);
				resp.sendRedirect("stylevalues?styleid=" + styleId + "&&message=Sucessfully");
			} catch (Exception e) {
				resp.sendRedirect("stylevalues?styleid=" + styleId + "&&message=Failed to add the style");
			}
		} else {
			resp.sendRedirect("stylevalues?styleid=" + styleId + "&&message=You must fill out the form");
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

	private void postAddStyle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("styleName");
		String categoryId = req.getParameter("categoryId");
		StyleModel style = new StyleModel();

		if (name != "" && categoryId != null) {
			try {
				style.setName(name);
				style.setCategoryId(Integer.parseInt(categoryId));
				styleService.insert(style);
				resp.sendRedirect("styles?message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("styles?message=Failed to add the style");
			}
		} else {
			resp.sendRedirect("styles?message=You must fill out the form");
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
			try {
				userLevel.setName(name);
				userLevel.setMinPoint(Integer.parseInt(minPoint));
				userLevel.setDiscount(Integer.parseInt(discount));

				userLevelService.update(userLevel);
				resp.sendRedirect("?message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("?message=Failed to edit the user level");
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
		List<ImageModel> lisImageModels = new ArrayList<ImageModel>();
		for (ProductModel productModel : listProduct) {
			List<ImageModel> listModelByProduct = imageService.getByProductId(productModel.getId());
			if (listModelByProduct.size() > 0)
				lisImageModels.add(listModelByProduct.get(0));
		}
		req.setAttribute("images", lisImageModels);
		int countAllProduct = listProduct.size();
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("countAllProduct", countAllProduct);
		req.setAttribute("listCategory", listCategory);

		List<StoreModel> listStore = storeService.getAll();
		req.setAttribute("listStore", listStore);

	}

	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) {
		List<UserModel> list = userService.getAll();
		req.setAttribute("listuser", list);
	}

	private void getDelivery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DeliveryModel> list = deliveryService.getAll();
		req.setAttribute("listDelivery", list);
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/delivery.jsp");
		rDispatcher.forward(req, resp);
	}

	private void postAddDelivery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		DeliveryModel deliveryModel = new DeliveryModel();

		String name = req.getParameter("deliveryname");
		String price = req.getParameter("price");
		String description = req.getParameter("description");

		if (name != null && price != null && description != null) {

			if (!deliveryService.checkName(name)) {
				try {
					deliveryModel.setName(name);
					deliveryModel.setPrice(new BigDecimal(price));
					deliveryModel.setDescription(description);
					deliveryService.insert(deliveryModel);
					resp.sendRedirect("?message=Successfully");
				} catch (Exception e) {
					resp.sendRedirect("?message=Failed to add the delivery level");
				}
			} else {
				resp.sendRedirect("?message=Name already exists");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
		}
	}

	private void postEditDelivery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		DeliveryModel deliveryModel = deliveryService.getById(Integer.parseInt(id));

		String name = req.getParameter("deliveryname");
		String price = req.getParameter("price");
		String description = req.getParameter("description");

		if (name != null && price != null && description != null) {
			try {
				deliveryModel.setName(name);
				deliveryModel.setPrice(new BigDecimal(price));
				deliveryModel.setDescription(description);

				deliveryService.update(deliveryModel);
				resp.sendRedirect("?message=Successfully");
			} catch (Exception e) {
				resp.sendRedirect("?message=Failed to edit delivery");
			}
		} else {
			resp.sendRedirect("?message=You must fill out the form");
		}
	}

	private void postDeleteDelivery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		DeliveryModel deliveryModel = deliveryService.getById(Integer.parseInt(id));
		try {
			deliveryModel.setDeleted(true);
			deliveryService.update(deliveryModel);
			resp.sendRedirect("editdelivery?message=Sucessfully");
		} catch (Exception e) {
			resp.sendRedirect("editdelivery?message=Failed to delete delivery");
		}
	}

	private void getTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TransactionModel> list = transactionService.getAll();
		req.setAttribute("listTransaction", list);
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/transaction.jsp");
		rDispatcher.forward(req, resp);
	}

}

package com.azshop.controllers.customer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azshop.models.CartItemModel;
import com.azshop.models.CartModel;
import com.azshop.models.CategoryModel;
import com.azshop.models.ImageModel;
import com.azshop.models.OrderItemModel;
import com.azshop.models.OrderModel;
import com.azshop.models.ProductModel;
import com.azshop.models.ReviewModel;
import com.azshop.models.StoreModel;
import com.azshop.models.StyleValueModel;
import com.azshop.models.UserModel;
import com.azshop.services.CartItemServiceImpl;
import com.azshop.services.CartServiceImpl;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.ICartItemService;
import com.azshop.services.ICartService;
import com.azshop.services.ICategoryService;
import com.azshop.services.IImageService;
import com.azshop.services.IOrderItemService;
import com.azshop.services.IOrderService;
import com.azshop.services.IProductService;
import com.azshop.services.IReviewService;
import com.azshop.services.IStoreService;
import com.azshop.services.IStyleService;
import com.azshop.services.IStyleValueService;
import com.azshop.services.IUserService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.OrderItemServiceImpl;
import com.azshop.services.OrderServiceImpl;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.ReviewServiceImpl;
import com.azshop.services.StoreServiceImpl;
import com.azshop.services.StyleServiceImpl;
import com.azshop.services.StyleValueImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Constant;

@WebServlet(urlPatterns = { "/customer/product/*", "/review-product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICategoryService categoryService = new CategoryServiceImpl();
	IProductService productService = new ProductServiceImpl();
	IStyleService styleService = new StyleServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	IImageService imageService = new ImageServiceImpl();
	IUserService userService = new UserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	IReviewService reviewService = new ReviewServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	IOrderItemService orderItemService = new OrderItemServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		// Hiển thị menu danh mục
		List<CategoryModel> categoryParentList = categoryService.getParentCategory();
		req.setAttribute("categoryParentList", categoryParentList);

		try {
			HttpSession session = req.getSession();
			if (session != null) {
				Object sessionObject = session.getAttribute(Constant.userSession);
				if (sessionObject instanceof UserModel) {
					UserModel user = (UserModel) sessionObject;
					List<CartModel> cartList = cartService.getByUserId(user.getId());
					List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();

					// Hiển thị item trong giỏ hàng
					for (CartModel cart : cartList) {
						List<CartItemModel> itemList = cartItemService.getByCartId(cart.getId());
						cartItemList.addAll(itemList);
					}

					// Lấy thông tin danh sách product có trong giỏ hàng
					List<ProductModel> productsInCart = new ArrayList<ProductModel>();

					for (CartItemModel cartItem : cartItemList) {
						ProductModel productInCart = productService.getById(cartItem.getProductId());
						productsInCart.add(productInCart);
					}

					List<ImageModel> imageProductsInCart = new ArrayList<ImageModel>();

					for (ProductModel productModel : productsInCart) {
						ImageModel image = imageService.getImage(productModel.getId());
						imageProductsInCart.add(image);
					}

					req.setAttribute("quantity", cartItemList.size());
					req.setAttribute("user", user);
					req.setAttribute("imageProductsInCart", imageProductsInCart);
					req.setAttribute("cartItemList", cartItemList);
					req.setAttribute("productsInCart", productsInCart);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (url.contains("customer/product")) {
			try {
				getProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("review-product")) {
			try {
				postReviewProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void postReviewProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute(Constant.userSession);
		int orderId = 0;

		ProductModel product = (ProductModel) session.getAttribute("productsession");
		StoreModel store = (StoreModel) session.getAttribute("storesession");

		List<OrderModel> order = orderService.getByUserIdAndStoreId(user.getId(), store.getId());

		for (OrderModel orderModel : order) {
			List<OrderItemModel> orderItemModels = orderItemService.getByOrderIdAndProductId(orderModel.getId(),
					product.getId());
			if (orderItemModels != null && "Completed".equals(orderModel.getStatus())) {
				orderId = orderModel.getId();
				String content = req.getParameter("review");
				String start = req.getParameter("rating");
				int rating = 0;
				if (start != null) {
					rating = Integer.parseInt(start);
				}
				ReviewModel reviewModel = new ReviewModel();
				reviewModel.setUserId(user.getId());
				reviewModel.setStoreId(store.getId());
				reviewModel.setProductId(product.getId());
				reviewModel.setOrderId(orderId);
				reviewModel.setContent(content);
				reviewModel.setRating(rating);
				reviewService.insert(reviewModel);
				product.setRating(reviewService.avgRating(product.getId()));
				
				req.setAttribute("message", "Review submitted successfully!");
				resp.sendRedirect(req.getContextPath() + "/customer/product/" + product.getSlug());
				return;
			}
		}
		req.setAttribute("error", "Review submission failed!");
		resp.sendRedirect(req.getContextPath() + "/customer/product/" + product.getSlug());
	}

	private void getProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		String pageCurrent = "category";
		URI uri;
		try {

			uri = new URI(url);
			String path = uri.getPath();

			String[] parts = path.split("/");

			if (parts.length > 0) {
				String slug = parts[parts.length - 1];
				req.setAttribute("slug", slug);
				pageCurrent = pageCurrent + slug;

				try {
					ProductModel product = productService.getBySlug(slug);
					CategoryModel category = categoryService.getById(product.getCategoryId());
					StyleValueModel styleValue = styleValueService.getById(product.getStyleValueId());
					List<ImageModel> imageList = imageService.getByProductId(product.getId());
					StoreModel store = storeService.getById(product.getStoreId());
					List<ReviewModel> reviewModels = reviewService.getByProductId(product.getId());
					List<UserModel> userList = new ArrayList<UserModel>();

					// san pham lien quan
					List<ProductModel> productRelateds = productService.getByCategoryId(product.getCategoryId());
					List<ImageModel> imageRelateds = new ArrayList<ImageModel>();
					for (ProductModel productRelated : productRelateds) {
						ImageModel imageRelate = imageService.getImage(productRelated.getId());
						imageRelateds.add(imageRelate);
					}

					req.setAttribute("product", product);
					req.setAttribute("store", store);
					HttpSession session = req.getSession(true);
					session.setAttribute("productsession", product);
					session.setAttribute("storesession", store);
					req.setAttribute("productRelateds", productRelateds);
					req.setAttribute("category", category);
					req.setAttribute("styleValue", styleValue);
					req.setAttribute("imageList", imageList);
					req.setAttribute("imageRelateds", imageRelateds);
					req.setAttribute("review", reviewModels);
					req.setAttribute("countReview", reviewModels.size());

					for (ReviewModel reviewModel : reviewModels) {
						UserModel userModel = userService.getById(reviewModel.getUserId());
						userList.add(userModel);
					}
					req.setAttribute("userList", userList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/product.jsp");
		rd.forward(req, resp);
	}
}

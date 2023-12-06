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
import com.azshop.models.ProductModel;
import com.azshop.models.UserModel;
import com.azshop.services.CartItemServiceImpl;
import com.azshop.services.CartServiceImpl;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.ICartItemService;
import com.azshop.services.ICartService;
import com.azshop.services.ICategoryService;
import com.azshop.services.IImageService;
import com.azshop.services.IProductService;
import com.azshop.services.IStoreService;
import com.azshop.services.IStyleService;
import com.azshop.services.IStyleValueService;
import com.azshop.services.IUserService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.StoreServiceImpl;
import com.azshop.services.StyleServiceImpl;
import com.azshop.services.StyleValueImpl;
import com.azshop.services.UserServiceImpl;
import com.azshop.utils.Constant;

@WebServlet(urlPatterns = {"/customer/add-to-cart/*", "/customer/checkout"})
public class CartController extends HttpServlet{

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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		// Hiển thị menu danh mục
		List<CategoryModel> categoryParentList = categoryService.getParentCategory();
		req.setAttribute("categoryParentList", categoryParentList);

		// Hiển thị item trong giỏ hàng
		List<CartItemModel> cartItemList = cartItemService.getAll();

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

		req.setAttribute("imageProductsInCart", imageProductsInCart);
		req.setAttribute("cartItemList", cartItemList);
		req.setAttribute("productsInCart", productsInCart);
		
		if (url.contains("customer/add-to-cart")) {
			try {
				addProductToCart(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if (url.contains("customer/checkout")) {
			try {
				getInforCart(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getInforCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartItemModel> cartItemList = cartItemService.getAll();
		req.setAttribute("cartItemList", cartItemList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/checkout.jsp");
		rd.forward(req, resp);
	}

	private void addProductToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ma hoa UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = req.getSession();
			if (session != null) {
				Object sessionObject = session.getAttribute(Constant.userSession);
				if (sessionObject instanceof UserModel) {
					UserModel user = (UserModel) sessionObject;
					req.setAttribute("user", user);
					
					//Sử dụng thông tin người dùng ở đây
					String url = req.getRequestURL().toString();
					URI uri;
					try {

						uri = new URI(url);
						String path = uri.getPath();

						String[] parts = path.split("/");

						if (parts.length > 0) {
							String slug = parts[parts.length - 1];
							try {
								
								ProductModel product = productService.getBySlug(slug);														
								
								//Lấy thử danh sách cart
								List<CartModel> cartList = cartService.getAll();
								boolean isExistCart = false;
								CartModel cart = new CartModel();
								for (CartModel cartModel : cartList) {
									//Kiểm tra xem store id của product được thêm vào có trong cart nào chưa
									if (product.getStoreId() == cartModel.getStoreId()) {
										isExistCart = true;
										cart = cartModel;
									}
								}
								
								//nếu đã có thì sẽ tiếp tục thêm sản phẩm vào
								if (isExistCart == true) {
									//Thêm item cho cart
									CartItemModel cartItem = new CartItemModel();
									cartItem.setCartId(cart.getId());
									cartItem.setProductId(product.getId());
									cartItem.setStyleValueId(product.getStyleValueId());
									cartItem.setCount(Integer.parseInt(req.getParameter("count")));
									cartItemService.insert(cartItem);
								}
								
								//nếu chưa có thì tạo cart mới cho store id này
								else {
									CartModel newCart = new CartModel();
									newCart.setUserId(user.getId());
									newCart.setStoreId(product.getStoreId());
									cartService.insert(newCart);
									
									cartList = cartService.getAll();
									
									for (CartModel cartModel : cartList) {										
										if (product.getStoreId() == cartModel.getStoreId()) {
											cart = cartModel;
										}
									}
									
									//Thêm item cho cart
									CartItemModel cartItem = new CartItemModel();
									cartItem.setCartId(cart.getId());
									cartItem.setProductId(product.getId());
									cartItem.setStyleValueId(product.getStyleValueId());
									cartItem.setCount(Integer.parseInt(req.getParameter("count")));
									cartItemService.insert(cartItem);
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}				
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/home.jsp");
		rd.forward(req, resp);
	}

}

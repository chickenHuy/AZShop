package com.azshop.controllers.customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.metadata.IIOMetadataFormat;
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
import com.azshop.models.DeliveryModel;
import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.models.UserModel;
import com.azshop.services.CartItemServiceImpl;
import com.azshop.services.CartServiceImpl;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.DeliveryServiceImpl;
import com.azshop.services.ICartItemService;
import com.azshop.services.ICartService;
import com.azshop.services.ICategoryService;
import com.azshop.services.IDeliveryService;
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

@WebServlet(urlPatterns = {"/customer/add-to-cart/*", "/customer/delete-item-cart", "/customer/cart/checkout", "/customer/cart/checkout-comfirm"})
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
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		HttpSession session = req.getSession();
		
		UserModel user = (UserModel) session.getAttribute(Constant.userSession);
		req.setAttribute("user", user);
		if (user == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login-customer");
			return;
		}
		
		List<CartModel> cartList = cartService.getByUserId(user.getId());
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		
		if (cartList.size() != 0) {
			//Lấy danh sách cart item
			for (CartModel cart : cartList) {
				List<CartItemModel> itemList = cartItemService.getByCartId(cart.getId());
				cartItemList.addAll(itemList);
			}		
		}
		
		//Lấy thông tin danh sách product có trong giỏ hàng
		List<ProductModel> productsInCart = new ArrayList<ProductModel>();
		
		for (CartItemModel cartItem : cartItemList) {
			ProductModel  productInCart = productService.getById(cartItem.getProductId());
			productInCart.setPrice(productInCart.getPrice().setScale(0));
			productsInCart.add(productInCart);
		}
		
		BigDecimal sum = BigDecimal.ZERO;

		for (int i = 0; i < cartItemList.size(); i++) {
		    ProductModel productModel = productService.getById(cartItemList.get(i).getProductId());
		    
		    if (productModel != null) {
		        BigDecimal productPrice = productModel.getPrice();
		        int count = cartItemList.get(i).getCount();
		        
		        sum = sum.add(productPrice.multiply(BigDecimal.valueOf(count))).setScale(0);
		    }
		}

	    req.setAttribute("sumPrice", sum);
		
		List<ImageModel> imageProductsInCart = new ArrayList<ImageModel>();

		for (ProductModel productModel : productsInCart) {
			ImageModel image = imageService.getImage(productModel.getId());
			imageProductsInCart.add(image);
		}
		
		List<DeliveryModel> deliveryList = deliveryService.getAll();
		
		req.setAttribute("deliveryList", deliveryList);
		req.setAttribute("quantity", cartItemList.size());
		req.setAttribute("user", user);
		req.setAttribute("imageProductsInCart", imageProductsInCart);	
		req.setAttribute("cartItemList", cartItemList);
		req.setAttribute("productsInCart", productsInCart);		
		
		// Hiển thị menu danh mục
		List<CategoryModel> categoryParentList = categoryService.getParentCategory();
		req.setAttribute("categoryParentList", categoryParentList);
		
		if (url.contains("customer/add-to-cart")) {
			try {
				addProductToCart(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if (url.contains("customer/cart/checkout")) {
			try {				
				req.setAttribute("cartItemList", cartItemList);
				
				RequestDispatcher rd = req.getRequestDispatcher("/views/customer/checkout.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("customer/cart/checkout-comfirm")) {
			try {			
				req.setAttribute("cartItemList", cartItemList);
				
				RequestDispatcher rd = req.getRequestDispatcher("/views/customer/checkout.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("customer/delete-item-cart")) {
			try {
				deleteCartItem(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// ma hoa UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int cartItemId = Integer.parseInt(req.getParameter("id"));
		
		cartItemService.delete(cartItemId);
		
		//chuyển tới trang trước đó
		resp.sendRedirect(req.getHeader("Referer"));
	}

	private void addProductToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ma hoa UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		UserModel user = (UserModel) session.getAttribute(Constant.userSession);
		req.setAttribute("user", user);
		if (user == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login-customer");
			return;
		}
		
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
					List<CartModel> cartList = cartService.getByUserId(user.getId());
					
					CartModel cart = new CartModel();
					boolean isExistCart = false;
					
					if (cartList.size() != 0) {												
						
						for (CartModel cartModel : cartList) {
							//Kiểm tra xem store id của product được thêm vào có trong cart nào chưa
							if (product.getStoreId() == cartModel.getStoreId()) {
								isExistCart = true;
								cart = cartModel;
							}
						}
						
						//nếu đã có thì sẽ tiếp tục thêm sản phẩm vào
						if (isExistCart == true) {
							//Kiểm tra có item trong giỏ hàng chưa
							boolean isExistItemCart = false;
							List<CartItemModel> cartItems = new ArrayList<CartItemModel>();
							for (CartModel cartModel : cartList) {	
								cartItems.addAll(cartItemService.getByCartId(cartModel.getId()));
							}
							
							CartItemModel itemInCart = new CartItemModel();
							for (CartItemModel item : cartItems) {
								if(product.getId() == item.getProductId()) {
									isExistItemCart = true;
									itemInCart = item;
								}
							}
							//Nếu chưa có item trong cart
							if (isExistItemCart == false) {
								//Thêm item mới vào cart
								CartItemModel newItem = new CartItemModel();
								newItem.setCartId(cart.getId());
								newItem.setProductId(product.getId());
								newItem.setStyleValueId(product.getStyleValueId());
								newItem.setCount(Integer.parseInt(req.getParameter("count")));
								cartItemService.insert(newItem);
							}
							//Nếu đã có thì tăng thêm số lượng
							else {
								int count = Integer.parseInt(req.getParameter("count"));
								
								itemInCart.setCount(itemInCart.getCount() + count);
								cartItemService.update(itemInCart);
							}
						}
						
						
					}
					
					if (cartList.size() == 0 || isExistCart == false) {
						//nếu chưa có thì tạo cart mới cho store id này
						CartModel newCart = new CartModel();
						newCart.setUserId(user.getId());
						newCart.setStoreId(product.getStoreId());
						cartService.insert(newCart);						
						
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
		
		//chuyển tới trang trước đó
		resp.sendRedirect(req.getHeader("Referer"));
	}

}

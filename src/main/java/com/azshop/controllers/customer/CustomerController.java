package com.azshop.controllers.customer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.azshop.DAO.CartItemDAOImpl;
import com.azshop.models.CartItemModel;
import com.azshop.models.CartModel;
import com.azshop.models.CategoryModel;
import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.models.StoreModel;
import com.azshop.models.StyleModel;
import com.azshop.models.StyleValueModel;
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

@WebServlet(urlPatterns = {"/customer-home", "/customer/category/*", "/customer/style/*", "/customer-search", "/customer-information"})
public class CustomerController extends HttpServlet {
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
		
		//Hiển thị menu danh mục
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
					
					//Hiển thị item trong giỏ hàng
					for (CartModel cart : cartList) {
						List<CartItemModel> itemList = cartItemService.getByCartId(cart.getId());
						cartItemList.addAll(itemList);
					}										
					
					//Lấy thông tin danh sách product có trong giỏ hàng
					List<ProductModel> productsInCart = new ArrayList<ProductModel>();
					
					for (CartItemModel cartItem : cartItemList) {
						ProductModel  productInCart = productService.getById(cartItem.getProductId());
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
		
		if (url.contains("customer-home")) {
			try {
				getAll(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (url.contains("customer/category")) {
			try {
				getCategory(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (url.contains("customer/style")) {
			try {
				getStyle(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("customer/product")) {
			try {
				getProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("customer-search")) {
			try {
				findProduct(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("customer-information")) {
			try {
				HttpSession session = req.getSession();
				if (session != null) {
					Object sessionObject = session.getAttribute(Constant.userSession);
					if (sessionObject instanceof UserModel) {
						UserModel user = (UserModel) sessionObject;
						req.setAttribute("user", user);
						// Sử dụng thông tin người dùng ở đây
					}
				}
				getInforCustomer(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void getStyle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		URI uri;
		try {

			uri = new URI(url);
			String path = uri.getPath();

			String[] parts = path.split("/");

			if (parts.length > 0) {
				String slug = parts[parts.length - 1];
				
				try {
					//Lấy category từ slug
	                CategoryModel category = categoryService.getCategoryBySlug(slug);	                	                
	                
	                CategoryModel categoryParent = categoryService.getById(category.getCategoryId());		                		                
	                List<CategoryModel> categoryChildList = categoryService.getChildCategory(category.getCategoryId());
	              //đếm số lượng product trong mỗi category
	                for (CategoryModel categoryChild : categoryChildList) {
						int countProduct = countProductsInCategory(categoryChild.getId());
						
						categoryChild.setCountProduct(countProduct);
					}
	                
	                List<ProductModel> productList = new ArrayList<ProductModel>();
	                List<ImageModel> imageList = new ArrayList<ImageModel>();
	                
//	              //Lấy danh sách style từ category parent
	                List<StyleModel> styleList = styleService.getByCategoryId(category.getId());
	                req.setAttribute("styleList", styleList);  
	                req.setAttribute("category", category);
	                
	                int styleId = Integer.parseInt(req.getParameter("styleId"));
	                List<StyleValueModel> styleValueList = styleValueService.getByStyleId(styleId);	              
	                
	                for (StyleValueModel styleValue : styleValueList) {
	                	List<ProductModel> productsInStyle = productService.getByStyleValueId(styleValue.getId());
	                	productList.addAll(productsInStyle);
					}	                	     	                
	                
	                
	                for (ProductModel productModel : productList) {
	        			ImageModel image = imageService.getImage(productModel.getId());
	        			imageList.add(image);
	        		}	                
	                
	                req.setAttribute("categoryChildList", categoryChildList);
	                req.setAttribute("categoryList", categoryChildList);
	                req.setAttribute("productList", productList);
	                req.setAttribute("imageList", imageList);
	                req.setAttribute("categoryParent", categoryParent);
	               	                
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
				
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/category.jsp");
        rd.forward(req, resp);
	}

	private void getInforCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/information.jsp").forward(req, resp);
	}

	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.getAll();
		List<ImageModel> imageList = new ArrayList<ImageModel>();
		
		for (ProductModel productModel : productList) {
			ImageModel image = imageService.getImage(productModel.getId());
			imageList.add(image);
		}
		
		req.setAttribute("imageList", imageList);
		req.setAttribute("productList",productList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/home.jsp");
		rd.forward(req, resp);
	}

	private void findProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ma hoa UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhan du lieu tu form
		String keyword = req.getParameter("keyword");

		List<ProductModel> productList = productService.FindProduct(keyword);

		req.setAttribute("productList", productList);

		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/home.jsp");
		rd.forward(req, resp);
	}

	private void getCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		URI uri;
		try {

			uri = new URI(url);
			String path = uri.getPath();

			String[] parts = path.split("/");

			if (parts.length > 0) {
				String slug = parts[parts.length - 1];
				
				try {
					//Lấy category từ slug
	                CategoryModel category = categoryService.getCategoryBySlug(slug);
	                
	                Boolean isCategoryOrigin = false;
	                
	                //Kiếm tra category có phải là một caetgory gốc
	                List<CategoryModel> categoryParentList = categoryService.getParentCategory();
	                for (CategoryModel categoryModel : categoryParentList) {
						if (category.getId() == categoryModel.getId()) {
							isCategoryOrigin = true;
						}
					}
	                
	                //Khai báo trong trường hợp nó là category gốc
	                CategoryModel categoryParent = categoryService.getParentCategory(category.getId());		                		                
	                List<CategoryModel> categoryChildList = categoryService.getChildCategory(category.getId());
	                List<ProductModel> productList = new ArrayList<ProductModel>();
	                List<ImageModel> imageList = new ArrayList<ImageModel>();
	                
	                //Lấy ra tất cả sản phẩm
	                for (CategoryModel categoryChild : categoryChildList) {
	                	List<ProductModel> productCategoryChilds = productService.getByCategoryId(categoryChild.getId());
	                	productList.addAll(productCategoryChilds);
					}
	                
	                //nếu không phải
	                if (isCategoryOrigin == false) {
	                	categoryChildList = categoryService.getChildCategory(category.getCategoryId());
	                	categoryParent = categoryService.getById(category.getCategoryId());
	                	productList = productService.getByCategoryId(category.getId());
	                	
	                	//Lấy danh sách style value từ category parent
		                List<StyleModel> styleList = styleService.getByCategoryId(category.getId());
		                req.setAttribute("styleList", styleList);
		                
		                req.setAttribute("categoryStyle", category);
	                }
	                
	                //đếm số lượng product trong mỗi category
	                for (CategoryModel categoryChild : categoryChildList) {
						int countProduct = countProductsInCategory(categoryChild.getId());
						
						categoryChild.setCountProduct(countProduct);
					}	
	                
	                for (ProductModel productModel : productList) {
	        			ImageModel image = imageService.getImage(productModel.getId());
	        			imageList.add(image);
	        		}
	                
	                
	                req.setAttribute("category", category);
	                req.setAttribute("categoryChildList", categoryChildList);
	                req.setAttribute("categoryList", categoryChildList);
	                req.setAttribute("productList", productList);
	                req.setAttribute("imageList", imageList);
	                req.setAttribute("categoryParent", categoryParent);
	               	                
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
				
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/category.jsp");
        rd.forward(req, resp);
	}

	public int countProductsInCategory(int categoryId) {
        // Get products by category
        List<ProductModel> productList = productService.getByCategoryId(categoryId);

        // Count the number of products
        int productCount = (productList != null) ? productList.size() : 0;

        return productCount;
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
					
					//san pham lien quan
					List<ProductModel> productRelateds = productService.getByCategoryId(product.getCategoryId());
					List<ImageModel> imageRelateds = new ArrayList<ImageModel>();
					for (ProductModel productRelated : productRelateds) {
						ImageModel imageRelate = imageService.getImage(productRelated.getId());
						imageRelateds.add(imageRelate);
					}
	                
					req.setAttribute("product", product);
					req.setAttribute("store", store);
					req.setAttribute("productRelateds", productRelateds);
					req.setAttribute("category", category);
					req.setAttribute("styleValue", styleValue);
					req.setAttribute("imageList", imageList);
					req.setAttribute("imageRelateds", imageRelateds);
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

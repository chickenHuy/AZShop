package com.azshop.controllers.vendor;

import java.awt.Image;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import com.azshop.models.CategoryModel;
import com.azshop.models.ImageModel;
import com.azshop.models.ProductModel;
import com.azshop.models.StyleModel;
import com.azshop.models.StyleValueModel;
import com.azshop.services.CategoryServiceImpl;
import com.azshop.services.ICategoryService;
import com.azshop.services.IImageService;
import com.azshop.services.IProductService;
import com.azshop.services.IStyleService;
import com.azshop.services.IStyleValueService;
import com.azshop.services.ImageServiceImpl;
import com.azshop.services.ProductServiceImpl;
import com.azshop.services.StyleServiceImpl;
import com.azshop.services.StyleValueImpl;
import com.azshop.utils.Constant;
import com.azshop.utils.ImageUtil;
import com.azshop.utils.SlugUtil;
import com.azshop.utils.UploadImage;
import com.azshop.utils.UploadUtils;
import com.google.gson.Gson;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 50)
@WebServlet(urlPatterns = { "/vendor/dashboard", "/vendor/update-shop-info", "/register-shop", "/vendor/product/new",
		"/vendor/product/all", "/vendor/product/error404", "/vendor/product/edit/*", "/vendor/product/detail/*",
		"/vendor/order/processing", "/vendor/order/processed", "/vendor/order/details" })
public class VenderController extends HttpServlet {

	ICategoryService categoryService = new CategoryServiceImpl();
	IStyleService styleService = new StyleServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		if (url.contains("/register-shop")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/createShop.jsp");
			rDispatcher.forward(req, resp);
			return;
		}
		if (url.contains("/vendor/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/dashboard.jsp");
			rDispatcher.forward(req, resp);
			return;
		}
		if (url.contains("/vendor/update-shop-info")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/shopInfo.jsp");
			req.setAttribute("isView", false);
			rDispatcher.forward(req, resp);
			return;
		}
		if (url.contains("/vendor/product/all")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/allProduct.jsp");
			rDispatcher.forward(req, resp);
			return;
		}
		if (url.contains("/vendor/product")) {
			doGetProduct(req, resp);
			return;
		}
		if (url.contains("/vendor/order")) {
			if (url.contains("processing")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/order.jsp");
				rDispatcher.forward(req, resp);
			} else if (url.contains("processed")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/order.jsp");
				rDispatcher.forward(req, resp);
			} else if (url.contains("detail")) {
				RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/orderDetails.jsp");
				rDispatcher.forward(req, resp);
			}
		}
	}

	private void doGetProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		String categoryIdParam = req.getParameter("categoryId");
		String styleIdParam = req.getParameter("styleId");
		if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
			int categoryId = Integer.parseInt(categoryIdParam);

			List<StyleModel> styles = styleService.getByCategoryId(categoryId);

			// Chuyển danh sách styles thành JSON và gửi về client
			String json = new Gson().toJson(styles);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);
		} else if (styleIdParam != null && !styleIdParam.isEmpty()) {
			int styleId = Integer.parseInt(styleIdParam);

			List<StyleValueModel> styleValues = styleValueService.getByStyleId(styleId);

			// Chuyển danh sách styles thành JSON và gửi về client
			String json = new Gson().toJson(styleValues);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);
		} else {

			String action = "";
			List<CategoryModel> categoryModels = categoryService.getAll();
			req.setAttribute("categorys", categoryModels);

			if (url.contains("/new")) {
				action = "new";

			}
			if (url.contains("/edit")) {
				action = "edit";
				URI uri;
				try {
					uri = new URI(url);
					String path = uri.getPath();
					
					String[] parts = path.split("/");
			        
			        if (parts.length > 0) {
			            String slug = parts[parts.length - 1];
			            req.setAttribute("slug", slug);
			            action = action + slug;
			            try {
			            	ProductModel productModel = productService.getBySlug(slug);
			            	if (productModel == null)
			            	{
			            		req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
			            	}
			            	else {
								req.setAttribute("product", productModel);
								
								List<ImageModel> imageModels = imageService.getByProductId(productModel.getId());
								for (ImageModel imageModel : imageModels) {
									req.setAttribute("image" + imageModel.getImage().charAt(0), imageModel.getImage());
								}
			            	}
								
								
								StyleValueModel styleValueModel = styleValueService.getById(productModel.getStyleValueId());
								StyleModel styleModel = styleService.getById(styleValueModel.getStyleId());
								req.setAttribute("styleModelId", styleModel.getId());
								
							} catch (Exception e) {
								req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
							}
						} else {
							req.getRequestDispatcher("/views/vendor/404.jsp").forward(req, resp);
						}
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}

			req.setAttribute("action", action);
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/vendor/product.jsp");
			rDispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (url.contains("register-shop")) {
			RegisterShop(req, resp);
			return;
		}
		if (url.contains("/vendor/product/new")) {
			NewProduct(req, resp);
			return;
		}
		if (url.contains("/vendor/update-shop-info")) {
			UpdateShopInfo(req, resp);
			return;
		}
		if (url.contains("vendor/product/edit"))
		{
			EditProduct(req,resp, url);
		}
	}

	private void EditProduct(HttpServletRequest req, HttpServletResponse resp, String url)throws ServletException, IOException  {
		try {
			
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			BigDecimal price = new BigDecimal(req.getParameter("price"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
			int categoryId = Integer.parseInt(req.getParameter("categoryId"));
			int styleValueId = Integer.parseInt(req.getParameter("styleValueId"));
			int storeId = 0;
			
			URI uri;
			uri = new URI(url);
			String path = uri.getPath();
			
			String[] parts = path.split("/");
	        
	        String slug = parts[parts.length - 1];
	        slug = slug.substring(4); 
			
	        ProductModel productModel = productService.getBySlug(slug);
	        productModel.setName(name);
	        productModel.setDescription(description);
	        productModel.setPrice(price);
	        productModel.setQuantity(quantity);
	        productModel.setActive(isActive);
			String video = "";
	        if (req.getPart("video").getSize() != 0)
			{
				String fileName = "" + System.currentTimeMillis();
				video = UploadUtils.processUpload("video", req, Constant.DIR, fileName);
			}
	        if (video != null && video != "")
	        {
	        	ImageUtil.deleteImage(productModel.getVideo());
	        	productModel.setVideo(video);
	        }
			productModel.setCategoryId(categoryId);
			productModel.setStyleValueId(styleValueId);
			productService.update(productModel);
			
			String imageName = "image";
			
			for (int i = 1; i <= 6; i++) {
			    String thumbnail = req.getParameter("deletethumbnail" + String.valueOf(i));
			    System.out.println(thumbnail);
			    if (thumbnail.equals("1")) {
			        imageService.deletedByIndex(i, productModel.getId());
			    }
			}
			
			for (int i = 1; i <= 6; i++) {
				
				imageName += String.valueOf(i);
				
				
				if (req.getPart(imageName).getSize() != 0)
				{
					ImageModel imageModel = new ImageModel();
					String fileName = String.valueOf(i);
					
					fileName +=  System.currentTimeMillis();
					imageModel.setImage(UploadUtils.processUpload(imageName, req, Constant.DIR, fileName));
					imageModel.setProductId(productModel.getId());
					imageService.deletedByIndex(i, productModel.getId());
					imageService.insert(imageModel);
				}
				imageName = "image";
				
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			
			}
	}

	private void UpdateShopInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String shopName = req.getParameter("shopName").toString();
		String shopBio = req.getParameter("shopBio").toString();
		String storageLocation = "D:\\uploads";
		String coverImage = UploadImage.UploadImageToLocal("coverImage", req, storageLocation);
		String avatarImage = UploadImage.UploadImageToLocal("avatarImage", req, storageLocation);
		String featuredImage = UploadImage.UploadImageToLocal("featuredImage", req, storageLocation);

//		JsonObject responseStatus = new JsonObject();
//		responseStatus.addProperty("status", "success");
//		responseStatus.addProperty("message", "Dữ liệu đã được xử lý thành công");

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("1: " + shopName);
		resp.getWriter().println("2: " + shopBio);
		resp.getWriter().println("3: " + coverImage);
		resp.getWriter().println("4: " + avatarImage);
		resp.getWriter().println("5: " + featuredImage);
	}

	private void RegisterShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// Chuyen Dashboard
		resp.sendRedirect("vendor-dashboard");

	}

	private void NewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					try {
						
					String name = req.getParameter("name");
					String slug = SlugUtil.toSlug(name);
					String description = req.getParameter("description");
					BigDecimal price = new BigDecimal(req.getParameter("price"));
					int quantity = Integer.parseInt(req.getParameter("quantity"));
					boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
					String video = req.getParameter("video");
					int categoryId = Integer.parseInt(req.getParameter("categoryId"));
					int styleValueId = Integer.parseInt(req.getParameter("styleValueId"));
					int storeId = 0;
					
					
					ProductModel productModel = new ProductModel(name, slug, description, price, quantity, isActive, categoryId, styleValueId,storeId, video);
					if (req.getPart("video").getSize() != 0)
					{
						String fileName = "" + System.currentTimeMillis();
						productModel.setVideo(UploadUtils.processUpload("video", req, Constant.DIR, fileName));
					}
					
					
					productService.insert(productModel);
					
					productModel = productService.getBySlug(slug);
					String imageName = "image";
					for (int i = 1; i <= 6; i++) {
						
						imageName += String.valueOf(i);
						
						
						if (req.getPart(imageName).getSize() != 0)
						{
							ImageModel imageModel = new ImageModel();
							String fileName = String.valueOf(i);
							
							fileName +=  System.currentTimeMillis();
							imageModel.setImage(UploadUtils.processUpload(imageName, req, Constant.DIR, fileName));
							imageModel.setProductId(productModel.getId());
							
							imageService.insert(imageModel);
						}
						imageName = "image";
						
					}
					} catch (Exception e) {
						e.printStackTrace();
					
					}
	}

}

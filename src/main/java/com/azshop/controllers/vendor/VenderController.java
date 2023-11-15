package com.azshop.controllers.vendor;

import java.awt.Image;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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
import com.azshop.utils.SlugUtil;
import com.azshop.utils.UploadUtils;
import com.google.gson.Gson;
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50 )
@WebServlet (urlPatterns = {
				 "/vendor/dashboard"
				,"/register-shop"
				,"/vendor/product"
				,"/vendor/product/new","/vendor/product/edit/*","/vendor/product/detail/*"
				,"/vendor/order/processing","/vendor/order/processed", "/vendor/order/details"
			})
public class VenderController extends HttpServlet {

	ICategoryService categoryService = new CategoryServiceImpl();
	IStyleService styleService = new StyleServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();
	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		} else if (url.contains("/vendor/product/new")) {
			// Lấy dữ liệu từ form
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
					String fileName = "" + System.currentTimeMillis();
					imageModel.setImage(UploadUtils.processUpload(imageName, req, Constant.DIR, fileName));
					imageModel.setProductId(productModel.getId());
					
					imageService.insert(imageModel);
				}
				imageName = imageName.substring(0, imageName.length() -1);
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private void RegisterShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// Chuyen Dashboard
		resp.sendRedirect("vendor-dashboard");

	}

}

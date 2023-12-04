package com.azshop.controllers.admin;

import java.io.IOException;

import java.text.Normalizer;
import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azshop.models.CategoryModel;
import com.azshop.models.ProductModel;
import com.azshop.models.StoreModel;
import com.azshop.models.StyleModel;
import com.azshop.models.StyleValueModel;
import com.azshop.services.*;

@WebServlet(urlPatterns = { "/admin/dashboard", "/admin/product", "/admin/addproduct" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	IStyleValueService styleValueService = new StyleValueImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURL().toString();
		if (url.contains("/admin/dashboard")) {
			RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
			rDispatcher.forward(req, resp);
		} else if (url.contains("/admin/product")) {
			getAll(req, resp);
		} else if (url.contains("/admin/addproduct")) {
			getAddProduct(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("/admin/addproduct")) {
			postAddProduct(req, resp);
		}
	}

	private static String removeAccents(String input) {
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(normalized).replaceAll("");
	}

	private void postAddProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// Lấy dữ liệu từ form
		String name = req.getParameter("productName");
		String description = req.getParameter("description");
		String priceString = req.getParameter("price");
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		BigDecimal price = new BigDecimal(priceString);

		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		int styleValueId = Integer.parseInt(req.getParameter("styleValueId"));
		int storeId = Integer.parseInt(req.getParameter("storeId"));

		ProductModel product = new ProductModel();
		product.setName(name);
		
		// Tạo slug từ tên sản phẩm
		// Chuyển đổi các ký tự tiếng Việt thành các ký tự không dấu
		name = removeAccents(name);
		/// Loại bỏ ký tự không mong muốn, chỉ giữ lại chữ cái, chữ số và khoảng trắng
		String cleanedName = name.replaceAll("[^a-zA-Z0-9\\s]", "");
		// Chuyển đổi thành chữ thường và thay thế khoảng trắng bằng dấu gạch ngang
		String slug = cleanedName.toLowerCase().trim().replaceAll("\\s+", "-");
		
		product.setSlug(slug);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setSold(0);
		product.setActive(true);
		product.setDeleted(false);
		product.setVideo(null);
		product.setCategoryId(categoryId);
		product.setStyleValueId(styleValueId);
		product.setStoreId(storeId);

		productService.insert(product);
		resp.sendRedirect("product");
	}

	private void getAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> listCategory = categoryService.getAll();
		req.setAttribute("listCategory", listCategory);

		List<StoreModel> listStore = storeService.getAll();
		req.setAttribute("listStore", listStore);

		List<StyleValueModel> listStyleValue = styleValueService.getAll();
		req.setAttribute("listStyleValue", listStyleValue);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/addproduct.jsp");
		rDispatcher.forward(req, resp);
	}

	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy danh sách tất cả sản phẩm
		List<ProductModel> listProduct = productService.getAll();
		req.setAttribute("listProduct", listProduct);

		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
		rDispatcher.forward(req, resp);
	}

}

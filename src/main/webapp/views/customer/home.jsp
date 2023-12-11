<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
			
			<!-- Products tab & slick -->
				<div class="col-md-12">
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab1" class="tab-pane active">
								<div class="products-slick" data-nav="#slick-nav-6">

									<c:forEach var="category" items="${categoryParentList}">
										<!-- shop -->
										<div class="col-md-4 col-xs-6">
					
											<div class="shop">
												<a href='<c:url value="/${role}/category/${category.slug}?sortBy=${0}"/>'>
													<div class="shop-img">
														<img src="/AZShop/image?fname=${category.image}" alt="" />
													</div>
												</a>
												<div class="shop-body">
													<h3>
														${category.name}</a><br>Danh mục
													</h3>
													<a href="#" class="cta-btn">Mua ngay <i
														class="fa fa-arrow-circle-right"></i></a>
												</div>
											</div>
										</div>
										<!-- /shop -->
									</c:forEach>
									</div>
								<div id="slick-nav-6" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- Products tab & slick -->


			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->
	
	<!-- TẤT CẢ SẢN PHẨM -->
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h3 class="title">Tất cả sản phẩm</h3>						
					</div>
				</div>
				<!-- /section title -->

				<!-- Products tab & slick -->
				<div class="col-md-12">
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab1" class="tab-pane active">
								<div class="products-slick" data-nav="#slick-nav-1">

									<c:forEach var="product" items="${productList}">
										<!-- product -->
										<div class="product">
											<a href='<c:url value="/${role}/product/${product.slug}"/>'>
												<div class="product-img">
													<!-- Use product-specific information -->
													<c:set var="hasImages" value="false" />
													<c:forEach var="image" items="${imageList}">
														<c:if test="${product.id eq image.productId}">
															<img src="/AZShop/image?fname=${image.image}" alt="" />
															<c:set var="hasImages" value="true" />
														</c:if>
													</c:forEach>

													<c:if test="${not hasImages}">
														<!-- Nếu không có hình ảnh, sử dụng hình ảnh mặc định -->
														<img
															src="${pageContext.request.contextPath}/templates/static/none.png"
															alt="" />
													</c:if>
													<div class="product-label">
														<span class="new">NEW</span>
													</div>
												</div>
											</a>
											<div class="product-body">
												<c:forEach var="category" items="${categoryList}">
													<c:if test="${product.categoryId eq category.id}">
														<p class="product-category">${category.name}</p>
													</c:if>
												</c:forEach>
												
												<h3 class="product-name">
													<a href="#">${product.name}</a>
												</h3>
												<h4 class="product-price">
													${product.price} 													
												</h4>
												<div class="product-rating">
													<!-- Your rating logic here -->
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist">
														<i class="fa fa-heart-o"></i><span class="tooltipp">add
															to wishlist</span>
													</button>
													<button class="add-to-compare">
														<i class="fa fa-exchange"></i><span class="tooltipp">add
															to compare</span>
													</button>
													<button class="quick-view">
														<i class="fa fa-eye"></i><span class="tooltipp">quick
															view</span>
													</button>
												</div>
											</div>
											<a href="<c:url value='/${role}/add-to-cart/${product.slug}?count=${1}'/>">
												<div class="add-to-cart">
													<button class="add-to-cart-btn">
														<i class="fa fa-shopping-cart"></i> add to cart
													</button>
												</div>
											</a>
										</div>
										<!-- /product -->
									</c:forEach>

								</div>
								<div id="slick-nav-1" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- Products tab & slick -->
				
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SẢN PHẨM MỚI -->
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h3 class="title">Sản phẩm mới</h3>						
					</div>
				</div>
				<!-- /section title -->

				<!-- Products tab & slick -->
				<div class="col-md-12">
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab2" class="tab-pane fade in active">
								<div class="products-slick" data-nav="#slick-nav-2">
									<c:forEach var="product" items="${productList}">
										<!-- product -->
										<div class="product">
											<a href='<c:url value="/${role}/product/${product.slug}"/>'>
												<div class="product-img">
													<!-- Use product-specific information -->
													<c:set var="hasImages" value="false" />
													<c:forEach var="image" items="${imageList}">
														<c:if test="${product.id eq image.productId}">
															<img src="/AZShop/image?fname=${image.image}" alt="" />
															<c:set var="hasImages" value="true" />
														</c:if>
													</c:forEach>

													<c:if test="${not hasImages}">
														<!-- Nếu không có hình ảnh, sử dụng hình ảnh mặc định -->
														<img
															src="${pageContext.request.contextPath}/templates/static/none.png"
															alt="" />
													</c:if>
													<div class="product-label">
														<span class="new">NEW</span>
													</div>
												</div>
											</a>
											<div class="product-body">
												<c:forEach var="category" items="${categoryList}">
													<c:if test="${product.categoryId eq category.id}">
														<p class="product-category">${category.name}</p>
													</c:if>
												</c:forEach>
												
												<h3 class="product-name">
													<a href="#">${product.name}</a>
												</h3>
												<h4 class="product-price">
													${product.price} 													
												</h4>
												<div class="product-rating">
													<!-- Your rating logic here -->
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist">
														<i class="fa fa-heart-o"></i><span class="tooltipp">add
															to wishlist</span>
													</button>
													<button class="add-to-compare">
														<i class="fa fa-exchange"></i><span class="tooltipp">add
															to compare</span>
													</button>
													<button class="quick-view">
														<i class="fa fa-eye"></i><span class="tooltipp">quick
															view</span>
													</button>
												</div>
											</div>
											<a href="<c:url value='/${role}/add-to-cart/${product.slug}?count=${1}'/>">
												<div class="add-to-cart">
													<button class="add-to-cart-btn">
														<i class="fa fa-shopping-cart"></i> add to cart
													</button>
												</div>
											</a>
										</div>
										<!-- /product -->
									</c:forEach>
								</div>
								<div id="slick-nav-2" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- /Products tab & slick -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	
</body>
</html>
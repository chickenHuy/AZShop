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
				<!-- ASIDE -->
				<div id="aside" class="col-md-3">
					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Danh mục</h3>
						<div class="checkbox-filter">
							<a href='<c:url value="/customer/category/${categoryParent.slug}?sortBy=${0}"/>'>
								<div class="input-checkbox ${category.slug}">
									<label>Tất cả</label>
								</div>
							</a>
							<c:forEach var="category" items="${categoryChildList}">	
								<a href='<c:url value="/customer/category/${categoryParent.slug}/${category.slug}?sortBy=${sortBy}"/>'>
									<div class="input-checkbox ${category.slug}">
										<label>${category.name}<small>
												(${category.countProduct})</small></label>
									</div>
								</a>
							</c:forEach>
						</div>
						
						
					</div>
					<!-- /aside Widget -->					

					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Phong cách</h3>
						<div class="checkbox-filter">
							<c:forEach var="style" items="${styleList}">	
								<a href='<c:url value="/customer/style/${category.slug}?styleId=${style.id}"/>'>
									<div class="input-checkbox">
										<div class="input-checkbox ${category.slug}">
											<label>${style.name}</label>
										</div>
									</div>
								</a>
							</c:forEach>
						</div>
					</div>
					<!-- /aside Widget -->
					
					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Price</h3>
						<div class="price-filter">
							<div id="price-slider"></div>
							<div class="input-number price-min">
								<input id="price-min" type="number"> <span
									class="qty-up">+</span> <span class="qty-down">-</span>
							</div>
							<span>-</span>
							<div class="input-number price-max">
								<input id="price-max" type="number"> <span
									class="qty-up">+</span> <span class="qty-down">-</span>
							</div>
						</div>
					</div>
					<!-- /aside Widget -->

					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Top selling</h3>
						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product01.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
							</div>
						</div>

						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product02.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
							</div>
						</div>

						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product03.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name">
									<a href="#">product name goes here</a>
								</h3>
								<h4 class="product-price">
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
							</div>
						</div>
					</div>
					<!-- /aside Widget -->
				</div>
				<!-- /ASIDE -->

				<!-- STORE -->
				<div id="store" class="col-md-9">
					<!-- store top filter -->

					<div class="store-filter clearfix">
						<h3 style="text-transform: uppercase; font-size: 18px; margin: 0px; position: absolute; bottom: 0;">${category.name}</h3>
						<div class="radio-container store-grid">
							<a href='<c:url value="/customer/category/${category.slug}?sortBy=${0}"/>'>
								<button id="buttonAscending" class="radio-button"
									onclick="redirect('ascending')">Giá tăng dần</button>
							</a> 
							<a
								href='<c:url value="/customer/category/${category.slug}?sortBy=${1}"/>'>
								<button id="buttonDescending" class="radio-button"
									onclick="redirect('descending')">Giá giảm dần</button>
							</a>

						</div>
						
					</div>

					<!-- /store top filter -->

					<!-- store products -->
					<div class="row">
					<c:forEach var="product" items="${productList}">
						<!-- product -->
							<div class="col-md-4 col-xs-6">
								<div class="product">
									<a href='<c:url value="/customer/product/${product.slug}"/>'>
										<div class="product-img">
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
												<span class="sale">-30%</span> <span class="new">NEW</span>
											</div>
										</div>
									</a>
									<div class="product-body">
										<c:forEach var="category" items="${categoryList}">
											<c:if test="${product.categoryId eq category.id}">
												<p class="product-category">${category.name}</p>
											</c:if>
										</c:forEach>
										<h3 class="product-name"><a href="#">${product.name}</a></h3>
										<h4 class="product-price">${product.price}</h4>
										<div class="product-rating">
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
										</div>
										<div class="product-btns">
											<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
										</div>
									</div>
									<a
										href="<c:url value='/customer/add-to-cart/${product.slug}?count=${1}'/>">
										<div class="add-to-cart">
											<button class="add-to-cart-btn">
												<i class="fa fa-shopping-cart"></i> add to cart
											</button>
										</div>
									</a>
								</div>
							</div>
							<!-- /product -->
						</c:forEach>
						

						<div class="clearfix visible-sm visible-xs"></div>

					</div>
					<!-- /store products -->

					<!-- store bottom filter -->
					<div class="store-filter clearfix">
						<span class="store-qty">Showing 20-100 products</span>
						<ul class="store-pagination">
							<li class="active">1</li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
						</ul>
					</div>
					<!-- /store bottom filter -->
				</div>
				<!-- /STORE -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

<style>
.radio-button {
    background-color: #D10024;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.radio-button:hover {
    background-color: #96001F;
}

    </style>

</body>
</html>
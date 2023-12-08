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
							<a href='<c:url value="/customer/category/${categoryParent.slug}?sortBy=${0}&showCount=${0}"/>'>
								<div class="input-checkbox ${category.slug}">
									<label>Tất cả</label>
								</div>
							</a>
							<c:forEach var="category" items="${categoryChildList}">	
								<a href='<c:url value="/customer/category/${categoryParent.slug}/${category.slug}?sortBy=${sortBy}&showCount=${showCount}"/>'>
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

						<div class="radio-container">
							<input type="radio" id="radioAscending" class="radio-input"
								name="sortDirection" value="ascending"> <label
								for="radioAscending" class="radio-label"> <span
								class="radio-custom"></span> Tăng dần
							</label> <input type="radio" id="radioDescending" class="radio-input"
								name="sortDirection" value="descending"> <label
								for="radioDescending" class="radio-label"> <span
								class="radio-custom"></span> Giảm dần
							</label>
						</div>

						<ul class="store-grid">
							<li class="active"><i class="fa fa-th"></i></li>
							<li><a href="#"><i class="fa fa-th-list"></i></a></li>
						</ul>
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
											<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
											<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
											<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
										</div>
									</div>
									<div class="add-to-cart">
										<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
									</div>
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
/* Reset CSS */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
}

/* Style radio container */
.radio-container {
    display: flex;
    flex-direction: column;
}

/* Style radio label */
.radio-label {
    display: flex;
    align-items: center;
    cursor: pointer;
    margin-bottom: 10px;
}

/* Style radio input */
.radio-input {
    display: none; /* Ẩn input radio mặc định */
}

/* Style custom radio button */
.radio-custom {
    position: relative;
    width: 16px;
    height: 16px;
    border-radius: 50%;
    border: 2px solid #ccc; /* Màu viền mặc định */
    margin-right: 8px;
    transition: background-color 0.3s, border-color 0.3s;
}

/* Hover effect */
.radio-label:hover .radio-custom {
    background-color: #f5f5f5;
}

/* Style when radio is checked */
.radio-input:checked + .radio-label .radio-custom {
    background-color: #D10024; /* Màu nền khi được chọn */
    border-color: #D10024; /* Màu viền khi được chọn */
}

    </style>

</body>
</html>
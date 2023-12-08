<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<header>
	<!-- TOP HEADER -->
	<div id="top-header">
		<div class="container">
			<ul class="header-links pull-left">
				<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
				<li><a href="#"><i class="fa fa-envelope-o"></i>
						email@email.com</a></li>
				<li><a href="#"><i class="fa fa-map-marker"></i> 1734
						Stonecoal Road</a></li>
			</ul>
			<ul class="header-links pull-right">
				<li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					   <i class="fa fa-user-o"></i> ${user.email} <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" style="background-color: #1E1F29; border: 1px solid #1E1F29;">
					   <li style="padding: 8px;"><a href="<c:url value='/information' />">Tài khoản của tôi</a></li>
					   <li style="padding: 8px;"><a href="<c:url value='/store-check' />">Trang cửa hàng</a></li>
					   <li style="padding: 8px;"><a href="<c:url value='/logout-customer' />">Đăng xuất</a></li>
					</ul>
				 </li>
			</ul>
		</div>
	</div>
	<!-- /TOP HEADER -->
	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO -->
				<div class="col-md-3">
					<div class="header-logo">
						<a href="#" class="logo"> <img src="./img/logo.png" alt="">
						</a>
					</div>
				</div>
				<!-- /LOGO -->
				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<form action='<c:url value="/customer/search"/>' method="GET"  accept-charset="UTF-8">
							<select class="input-select" name = "categoryId">
							<c:if test="${categoryId != null}">  
								<option value="-1" >All Categories </option>
							</c:if>
							<c:if test="${categoryId == null}">  
								<option value="-1" selected>All Categories </option>
							</c:if>
							<c:forEach var = "category" items ="${categoryParentList}">
								<c:if test="${categoryId != null && categoryId eq category.id}">  
									<option value="${category.id}" selected>${category.name}</option>
								</c:if>
								<c:if test="${categoryId == null || !(categoryId eq category.id)}">
									<option value="${category.id}">${category.name}</option>
								</c:if>
							</c:forEach>
							</select> <input class="input" name="searchTerm" placeholder="Search here" value=${searchTerm == null ? '' : searchTerm}> 
							<button type="submit" class="search-btn">Tìm kiếm</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->
				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Cart -->
						<div class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>Your
									Cart</span>
								<div class="qty">${quantity}</div>
							</a>
							<div class="cart-dropdown">
								<div class="cart-list">
									<c:forEach var="cartItem" items="${cartItemList}">
										<div class="product-widget">
											<div class="product-img">
												<!-- Use product-specific information -->
												<c:set var="hasImages" value="false" />
												<c:forEach var="image" items="${imageProductsInCart}">
													<c:if test="${cartItem.productId eq image.productId}">
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
											</div>
											<div class="product-body">
												<c:forEach var="product" items="${productsInCart}">
													<c:if test="${product.id eq cartItem.productId}">
														<h3 class="product-name">
															<a href="#">${product.name}</a>
														</h3>
														<h4 class="product-price">
															<span class="qty">${cartItem.count}x</span>${product.price}
														</h4>
													</c:if>
												</c:forEach>												
											</div>
											<a href="<c:url value='/customer/delete-item-cart?id=${cartItem.id}'/>">
												<button class="delete">
													<i class="fa fa-close"></i>
												</button>
											</a>
										</div>
									</c:forEach>
								</div>
								<div class="cart-summary">
									<small>${quantity} Item(s) selected</small>
									<h5>SUBTOTAL: $2940.00</h5>
								</div>
								<div class="cart-btns">
									<a href='<c:url value="/customer/cart"/>'>View Cart</a> <a href='<c:url value="/customer/checkout"/>'>Checkout <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
						<!-- /Cart -->
						<!-- Menu Toogle -->
						<div class="menu-toggle">
							<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
							</a>
						</div>
						<!-- /Menu Toogle -->
					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->
<!-- NAVIGATION -->
	<nav id="navigation">
		<!-- container -->
		<div class="container">
			<!-- responsive-nav -->
			<div id="responsive-nav">
				<!-- NAV -->
				<ul class="main-nav nav navbar-nav">
					<li><a href='<c:url value="/customer-home"/>'>Trang chủ</a></li>
					<li><a href='<c:url value="/customer-clothing"/>'>Sản phẩm hot</a></li>
				<c:forEach var="category" items="${categoryParentList}">
					<li><a
						href='<c:url value="/customer/category/${category.slug}?sortBy=${0}"/>'>${category.name}</a></li>
				</c:forEach>
			</ul>
				<!-- /NAV -->
			</div>
			<!-- /responsive-nav -->
		</div>
		<!-- /container -->
	</nav>
	<!-- /NAVIGATION -->
</header>
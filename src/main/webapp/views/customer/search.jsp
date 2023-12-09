<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

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
						<h3 class="aside-title">Categories</h3>
						<div class="checkbox-filter">
							<a href=''>
								<div class="input-checkbox ${category.slug}">
									<label>Tất cả</label>
								</div>
							</a>
							<c:forEach var="category" items="${categoryChildList}">	
								<a href=''>
									<div class="input-checkbox ${category.slug}">
										<label>${category.name}<small> (${category.countProduct})</small></label>
									</div>
								</a>
							</c:forEach>
						</div>
						
						
					</div>
					<!-- /aside Widget -->					

					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Style</h3>
						<div class="checkbox-filter">
							<c:forEach var="style" items="${styles}">	
								<a href=''>
									<div class="input-checkbox">
											<label>${style.name}</label>
									</div>
								</a>
							</c:forEach>
						</div>
					</div>

				</div>
				
				
				<div id="store" class="col-md-9">
				<div class="row">
					<c:forEach var="store" items="${stores}">
						<!-- shop -->
						<a href='<c:url value="/customer/store/${store.slug}"/>'>
							<div class="col-md-4 col-xs-6">
								<div class="shop">
									<div class="shop-img">
										<img id="storeImage${store.id}" alt="" />
									</div>
									<div class="shop-body">
										<h3>
											${store.name}<br>Store
										</h3>
										<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
									</div>
								</div>
							</div>
						</a>
						<!-- /shop -->
					
						<script>
							document.addEventListener("DOMContentLoaded", function () {
								var img = document.getElementById("storeImage${store.id}");
								img.onerror = function () {
									// Thay thế ảnh nếu có lỗi khi tải ảnh
									img.src ="${pageContext.request.contextPath}/templates/static/none.png";
								};
								img.src = "/AZShop/image?fname=${store.avatar}";
							});
						</script>
					</c:forEach>
					<c:forEach var="product" items="${products}">
						<!-- product -->
							<div class="col-md-4 col-xs-6">
								<div class="product">
									<a href='<c:url value="/customer/product/${product.slug}"/>'>
										<div class="product-img">
											<c:set var="hasImages" value="false" />
											<c:forEach var="image" items="${images}">
												<c:if test="${product.id eq image.productId}">
													<img src="/AZShop/image?fname=${image.image}" id="productImage${image.id}" alt="" />
													<c:set var="hasImages" value="true" />
												</c:if>
											</c:forEach>

											<c:if test="${not hasImages}">
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
										<h4 class="product-price">${product.price} VNĐ</h4>
										<div class="product-rating">
										    <script>
										        var rating = ${product.rating};
								
										        for (var i = 0; i < rating; i++) {
										            document.write('<i class="fa fa-star"></i>');
										        }
										    </script>
										</div>
									</div>
									<a href="<c:url value='/customer/add-to-cart/${product.slug}?count=${1}'/>">
										<div class="add-to-cart">
											<button class="add-to-cart-btn">
												<i class="fa fa-shopping-cart"></i> add to cart
											</button>
										</div>
									</a>
								</div>
							</div>

							<script>
								document.addEventListener("DOMContentLoaded", function () {
									var img = document.getElementById("productImage${image.id}");
									img.onerror = function () {
										// Thay thế ảnh nếu có lỗi khi tải ảnh
										img.src ="${pageContext.request.contextPath}/templates/static/none.png";
									};
									img.src = "/AZShop/image?fname=${image.image}";
								});
							</script>
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

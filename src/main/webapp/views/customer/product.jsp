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

	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb-tree">
						<li><a href="<c:url value='/customer-home' />">Home</a></li>
						<li><a href="#">All Categories</a></li>
						<li><a href="#">Accessories</a></li>
						<li><a href="#">Headphones</a></li>
						<li class="active">Product name goes here</li>
					</ul>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- Product main img -->
				<div class="col-md-5 col-md-push-2">
					<div id="product-main-img">
						<c:forEach var="image" items="${imageList}"> 
							<div class="product-preview">
								 <img src="/AZShop/image?fname=${image.image}" alt="">
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- /Product main img -->

				<!-- Product thumb imgs -->
				<div class="col-md-2  col-md-pull-5">
					<div id="product-imgs">
						<c:forEach var="image" items="${imageList}"> 
							<div class="product-preview">
								 <img src="/AZShop/image?fname=${image.image}" alt="">
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- /Product thumb imgs -->


				<!-- Product details -->
				<div class="col-md-5">
					<div class="product-details">
						<h2 class="product-name">${product.name}
						</h2>
						<div>
							<div class="product-rating">
								<c:forEach var="i" begin="1" end="5">
									<c:choose>
										<c:when test="${i <= product.rating}">
											<i class="fa fa-star"></i>
										</c:when>
										<c:otherwise>
											<i class="fa fa-star-o empty"></i>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
							<a class="review-link">${countReview} Review(s) | Add your
								review</a>
						</div>
						<div>
							<h3 class="product-price">
								${product.price}
							</h3>
							<span class="product-available">In Stock</span>
						</div>
						<p>Cửa hàng: ${store.name}</p>

						

						<form
							action="<c:url value='/customer/add-to-cart/${product.slug}'/>"
							method="get">
							<div class="add-to-cart">
								<div class="qty-label">
									Số lượng
									<div class="input-number">
										<input type="number" name="count" id="count" value="1"
											min="1"> <span class="qty-up"
											onclick="increaseValue()">+</span> <span class="qty-down"
											onclick="decreaseValue()">-</span>
									</div>
								</div>
								<button class="add-to-cart-btn" type="submit">
									<i class="fa fa-shopping-cart"></i> add to cart
								</button>
							</div>
						</form>

						<ul class="product-btns">
							<li><a href="#"><i class="fa fa-heart-o"></i> add to
									wishlist</a></li>
							<li><a href="#"><i class="fa fa-exchange"></i> add to
									compare</a></li>
						</ul>

						<ul class="product-links">
							<li>Category:</li>
							<li><a href="#">${category.name}</a></li>
							<li><a href="#">${styleValue.name}</a></li>
						</ul>

						<ul class="product-links">
							<li>Share:</li>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="fa fa-envelope"></i></a></li>
						</ul>
						
						<div>
							<!-- Thêm đoạn mã để hiển thị thông báo -->
							<c:if test="${not empty commentSuccess}">
								<div class="alert alert-success">${commentSuccess}</div>
							</c:if>
							<c:if test="${not empty commentError}">
								<div class="alert alert-danger">${commentError}</div>
							</c:if>
						</div>
					</div>
				</div>
				<!-- /Product details -->

				<!-- Product tab -->
				<div class="col-md-12">
					<div id="product-tab">
						<!-- product tab nav -->
						<ul class="tab-nav">
							<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
							<li><a data-toggle="tab" href="#tab2">Details</a></li>
							<li><a data-toggle="tab" href="#tab3">Reviews (${countReview})</a></li>
						</ul>
						<!-- /product tab nav -->

						<!-- product tab content -->
						<div class="tab-content">
							<!-- tab1  -->
							<div id="tab1" class="tab-pane fade in active">
								<div class="row">
									<div class="col-md-12">
										<p>${product.description}</p>
									</div>
								</div>
							</div>
							<!-- /tab1  -->

							<!-- tab2  -->
							<div id="tab2" class="tab-pane fade in">
								<div class="row">
									<div class="col-md-12">
										<p>${product.description}</p>
									</div>
								</div>
							</div>
							<!-- /tab2  -->

							<!-- tab3  -->
							<div id="tab3" class="tab-pane fade in">
								<div class="row">
									<!-- Rating -->
									<div class="col-md-3">
										<div id="rating">
											<div class="rating-avg">
												<span>${product.rating}</span>
												<div class="rating-stars">
													<c:forEach var="i" begin="1" end="5">
														<c:choose>
															<c:when test="${i <= product.rating}">
																<i class="fa fa-star"></i>
															</c:when>
															<c:otherwise>
																<i class="fa fa-star-o empty"></i>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</div>
											</div>
											<ul class="rating">
												<li>
													<div class="rating-stars">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i>
													</div>
													<div class="rating-progress">
														<div style="width: 80%;"></div>
													</div> <span class="sum">3</span>
												</li>
												<li>
													<div class="rating-stars">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<div class="rating-progress">
														<div style="width: 60%;"></div>
													</div> <span class="sum">2</span>
												</li>
												<li>
													<div class="rating-stars">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<div class="rating-progress">
														<div></div>
													</div> <span class="sum">0</span>
												</li>
												<li>
													<div class="rating-stars">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<div class="rating-progress">
														<div></div>
													</div> <span class="sum">0</span>
												</li>
												<li>
													<div class="rating-stars">
														<i class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
															class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<div class="rating-progress">
														<div></div>
													</div> <span class="sum">0</span>
												</li>
											</ul>
										</div>
									</div>
									<!-- /Rating -->

									<!-- Reviews -->
									<div class="col-md-6">
										<div id="reviews">
											<ul class="reviews">
												<c:forEach var="review" items="${review}">
													<li>
														<div class="review-heading">
															<c:set var="printedUserName" value="false" />
															<c:forEach var="user" items="${userList}">
																<c:if test="${review.userId eq user.id and printedUserName eq 'false'}">
																	<h5 class="name">${user.firstName} ${user.lastName}</h5>
																	<c:set var="printedUserName" value="true" />
																</c:if>
															</c:forEach>
															<p class="date">${review.createAt}</p>
															<div class="review-rating">
																<c:forEach var="i" begin="1" end="5">
																	<c:choose>
																		<c:when test="${i <= review.rating}">
																			<i class="fa fa-star"></i>
																		</c:when>
																		<c:otherwise>
																			<i class="fa fa-star-o empty"></i>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</div>
														</div>
														<div class="review-body">
															<p>${review.content}</p>
														</div>
													</li>
												</c:forEach>
											</ul>
											<ul class="reviews-pagination">
												<li class="active">1</li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
											</ul>
										</div>
									</div>
									<!-- /Reviews -->

									<!-- Review Form -->
									<div class="col-md-3">
										<div id="review-form">
											<form class="review-form" action="review-product" method="post">
												
												<textarea class="input" name="review" placeholder="Your Review"></textarea>
												<div class="input-rating">
													<span>Your Rating: </span>
													<div class="stars">
														<input id="star5" name="rating" value="5" type="radio"><label
															for="star5"></label> <input id="star4" name="rating"
															value="4" type="radio"><label for="star4"></label>
														<input id="star3" name="rating" value="3" type="radio"><label
															for="star3"></label> <input id="star2" name="rating"
															value="2" type="radio"><label for="star2"></label>
														<input id="star1" name="rating" value="1" type="radio"><label
															for="star1"></label>
													</div>
												</div>
												<button class="primary-btn">Submit</button>
											</form>
										</div>
									</div>
									<!-- /Review Form -->
								</div>
							</div>
							<!-- /tab3  -->
						</div>
						<!-- /product tab content  -->
					</div>
				</div>
				<!-- /product tab -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- Section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<div class="col-md-12">
					<div class="section-title text-center">
						<h3 class="title">Related Products</h3>
					</div>
				</div>

				<c:forEach var="product" items="${productRelateds}">
					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<a href='<c:url value="/customer/product/${product.slug}"/>'>
								<div class="product-img">
									<c:set var="hasImages" value="false" />
									<c:forEach var="image" items="${imageRelateds}">
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
										<span class="sale">-30%</span>
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
									$980.00
									<del class="product-old-price">$990.00</del>
								</h4>
								<div class="product-rating"></div>
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
							<a href="<c:url value='/customer/add-to-cart'/>">
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

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /Section -->

	<script>
		// Lấy đối tượng input
		var count = document.getElementById('count');

		// Hàm tăng giá trị
		function increaseValue() {
			count.value = parseInt(count.value) + 1;
		}

		// Hàm giảm giá trị
		function decreaseValue() {
			// Đảm bảo giá trị không âm
			if (parseInt(count.value) > 0) {
				count.value = parseInt(count.value) - 1;
			}
		}
	</script>

</body>
</html>
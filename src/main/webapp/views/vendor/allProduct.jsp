<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>

			<style>
				.form-check-input {
					width: 18px;
					height: 18px;
				}

				tbody img {
					width: 70px !important;
					height: 70px !important;
				}

				[class*="fa-star-"] {
					color: #ffce3d;
					margin-right: 7px;
					;
				}
				.table tr{
					border-color: #201c21;
				}
			</style>

		</head>

		<body>
			<!--start main content-->
			<main class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">eCommerce</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Products</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Settings</button>
							<button type="button"
								class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split"
								data-bs-toggle="dropdown">
								<span class="visually-hidden">Toggle Dropdown</span>
							</button>
							<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
								<a class="dropdown-item" href="javascript:;">Action</a> <a class="dropdown-item"
									href="javascript:;">Another action</a> <a class="dropdown-item"
									href="javascript:;">Something else here</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="javascript:;">Separated link</a>
							</div>
						</div>
					</div>
				</div>
				<!--end breadcrumb-->
				<c:if test="${message!=null}">
					<div class="alert alert-success border-0 bg-success alert-dismissible fade show">
						<div class="text-white">${message}</div>
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					  </div>
				</c:if>
				<c:if test="${error!=null}">
					<div class="alert alert-danger border-0 bg-danger alert-dismissible fade show">
						<div class="text-white">${error}</div>
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
				<div class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
					<a href="javascript:;"><span class="me-1">All</span><span class="text-secondary">(88754)</span></a>
					<a href="javascript:;"><span class="me-1">Published</span><span
							class="text-secondary">(56242)</span></a>
					<a href="javascript:;"><span class="me-1">Drafts</span><span class="text-secondary">(17)</span></a>
					<a href="javascript:;"><span class="me-1">On Discount</span><span
							class="text-secondary">(88754)</span></a>
				</div>

				<div class="row g-3">
					<div class="col-auto">
						<div class="position-relative">
							<input class="form-control px-5" type="search" placeholder="Search Products"> <span
								class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50 fs-5">search</span>
						</div>
					</div>
					<div class="col-auto flex-grow-1 overflow-auto">
						<div class="btn-group position-static">
							<div class="btn-group position-static">
								<button type="button" class="btn border btn-light dropdown-toggle px-4"
									data-bs-toggle="dropdown" aria-expanded="false">
									Category</button>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="javascript:;">Action</a></li>
									<li><a class="dropdown-item" href="javascript:;">Another
											action</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><a class="dropdown-item" href="javascript:;">Something
											else here</a></li>
								</ul>
							</div>
							<div class="btn-group position-static">
								<button type="button" class="btn border btn-light dropdown-toggle px-4"
									data-bs-toggle="dropdown" aria-expanded="false">Vendor</button>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="javascript:;">Action</a></li>
									<li><a class="dropdown-item" href="javascript:;">Another
											action</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><a class="dropdown-item" href="javascript:;">Something
											else here</a></li>
								</ul>
							</div>
							<div class="btn-group position-static">
								<button type="button" class="btn border btn-light dropdown-toggle px-4"
									data-bs-toggle="dropdown" aria-expanded="false">
									Collection</button>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="javascript:;">Action</a></li>
									<li><a class="dropdown-item" href="javascript:;">Another
											action</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><a class="dropdown-item" href="javascript:;">Something
											else here</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center gap-2 justify-content-lg-end">
							<button class="btn btn-light px-4">
								<i class="bi bi-box-arrow-right me-2"></i>Export
							</button>
							<button class="btn btn-primary px-4">
								<i class="bi bi-plus-lg me-2"></i>Add Product
							</button>
						</div>
					</div>
				</div>

				<div class="card mt-4">
					<div class="card-body">
						<div class="product-table">
							<div class="table-responsive white-space-nowrap">
								<table class="table table-bordered align-middle">
									<thead class="table-light">
										<tr>
											<th><input class="form-check-input" type="checkbox">
											</th>
											<th>Product Name</th>
											<th>Price</th>
											<th>Active</th>
											<th class="text-center">Tags</th>
											<th class="text-center">Rating</th>
											<th>Quantity</th>
											<th>Sold</th>
											<th>Date</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<td><input class="form-check-input" type="checkbox">
											</td>
											<td>
												<div class="d-flex align-items-center gap-3">
													<div class="product-box">
														<c:set var="hasImages" value="false" />
														<c:forEach var="image" items="${images}">
															<c:if test="${product.id eq image.productId}">
																<img src="/AZShop/image?fname=${image.image}" alt=""/>
																<c:set var="hasImages" value="true" />
															</c:if>
														</c:forEach>

														<c:if test="${not hasImages}">
															<!-- Nếu không có hình ảnh, sử dụng hình ảnh mặc định -->
															<img src="${pageContext.request.contextPath}/templates/static/none.png" alt=""/>
														</c:if>
													</div>
													<div class="product-info">
														<a href="javascript:;" class="product-title">${product.name}</a>
														<c:forEach var="category" items="${categorys}">
															<c:if test="${product.categoryId eq category.id}">
																<p>${category.name}</p>
															</c:if>
													</c:forEach>
													</div>
												</div>
											</td>
											<td>${product.price}</td>
											<td>
												<c:if test="${product.isActive() == true}">
												    <span class="lable-table bg-primary-subtle text-primary rounded border border-primary-subtle font-text2 fw-bold">Publish<i class="bi bi-check2-all ms-2"></i></span>
												</c:if>
												<c:if test="${product.isActive() == false}">
												    <span class="lable-table bg-warning-subtle text-warning rounded border border-warning-subtle font-text2 fw-bold">Draft<i class="bi bi-info-circle ms-2"></i></span>
												</c:if>
											</td>
											<td>
												<c:forEach var="styleValue" items="${styleValues}">
															<c:if test="${product.styleValueId eq styleValue.id}">
																<p>${styleValue.name}</p>
															</c:if>
												</c:forEach>
											</td>
											<td>
												<div class="product-rating">
													<i class="fa-solid fa-star-half-stroke"></i><span>4.8</span>
												</div>
											</td>
											<td>${product.quantity}</td>
											<td>${product.sold}</td>
											<td>${product.updateAt != null ? product.updateAt : product.createAt}</td>
											<td>
												<div class="dropdown text-center">
													<button
														class="btn btn-sm btn-light border dropdown-toggle dropdown-toggle-nocaret"
														type="button" data-bs-toggle="dropdown">
														<i class="fa-solid fa-ellipsis"></i>
													</button>
													<ul class="dropdown-menu">
														<li><a class="dropdown-item" href='<c:url value="/vendor/product/edit/${product.slug}"/>'>Edit</a></li>
														<li><a class="dropdown-item" href='<c:url value="/vendor/product/delete/${product.slug}"/>'>Delete</a></li>
													</ul>
												</div>
											</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</main>
		</body>

		</html>
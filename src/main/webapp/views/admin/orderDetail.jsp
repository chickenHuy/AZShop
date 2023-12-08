<html lang="en" data-bs-theme="dark">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order Detail</title>

<%@ include file="/common/taglib.jsp"%>

</head>
<body class="  pace-done">
	<div class="pace  pace-inactive">
		<div class="pace-progress" data-progress-text="100%"
			data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
			<div class="pace-progress-inner"></div>
		</div>
		<div class="pace-activity"></div>
	</div>

	<!--start main content-->
	<main class="page-content">
		<!--breadcrumb-->
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">eCommerce</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="javascript:;"><i
								class="bx bx-home-alt"></i></a></li>
						<li class="breadcrumb-item active" aria-current="page">Order
							Details</li>
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
						<a class="dropdown-item" href="javascript:;">Action</a> <a
							class="dropdown-item" href="javascript:;">Another action</a> <a
							class="dropdown-item" href="javascript:;">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="javascript:;">Separated link</a>
					</div>
				</div>
			</div>
		</div>
		<!--end breadcrumb-->

		<div class="card">
			<div class="card-body">
				<div
					class="d-flex flex-lg-row flex-column align-items-start align-items-lg-center justify-content-between gap-3">
					<div class="flex-grow-1">
						<h4 class="fw-bold">Order #${orderId}</h4>
						<p class="mb-0">
							Customer ID : <a href="javascript:;">${order.userId}</a>
						</p>
					</div>
					<div class="overflow-auto"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-12 col-lg-8 d-flex">
				<div class="card w-100">
					<div class="card-body">
						<h5 class="mb-3 fw-bold">
							Wishlist<span class="fw-light ms-2">(46)</span>
						</h5>
						<div class="product-table">
							<div class="table-responsive white-space-nowrap">
								<table class="table align-middle">
									<thead class="table-light">
										<tr>

											<th>Product Name</th>
											<th>Quantity</th>
											<th>Price</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="orderItem" items="${listOrderItem}">
											<c:forEach var="product" items="${listProduct}">
												<c:if test="${product.id eq orderItem.productId}">
													<tr>
														<td>${product.name}</td>
														<td>${orderItem.count}</td>
														<td>${product.price}</td>
														<td>${product.price * orderItem.count}</td>
													</tr>
												</c:if>
											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="col-12 col-lg-4 d-flex">
				<div class="w-100">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title mb-4 fw-bold">Summary</h4>
							<div>
								<div class="d-flex justify-content-between">
									<p class="fw-semi-bold">Order Total :</p>
									<p class="fw-semi-bold">${totalOrder}</p>
								</div>
								<div class="d-flex justify-content-between">
									<p class="fw-semi-bold">Shipping Cost :</p>
									<p class="fw-semi-bold">${shipping_cost}</p>
								</div>
								<div class="d-flex justify-content-between">
									<p class="fw-semi-bold">Discount :</p>
									<p class="text-danger fw-semi-bold">-${discount}</p>
								</div>
							</div>
							<div class="d-flex justify-content-between border-top pt-4">
								<h5 class="mb-0 fw-bold">Total :</h5>
								<h5 class="mb-0 fw-bold">${order.price}</h5>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="card-body">
							<h4 class="card-title mb-4 fw-bold">Order Status</h4>
							<div id="d-flex"></div>
							<label class="form-label">Completed status: </label> 
							<label class="form-label">${order.status}</label> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end row-->


		<h5 class="fw-bold mb-4">Billing Details</h5>
		<div class="card">
			<div class="card-body">
				<div class="row g-3 row-cols-1 row-cols-lg-4">
					<div class="col">
						<div class="d-flex align-items-start gap-3 border p-3 rounded">
							<div class="detail-icon fs-5">
								<i class="bi bi-person-circle"></i>
							</div>
							<div class="detail-info">
								<p class="fw-bold mb-1">Customer Name</p>
								<a href="javascript:;" class="mb-0">${user.firstName} ${user.lastName}</a>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="d-flex align-items-start gap-3 border p-3 rounded">
							<div class="detail-icon fs-5">
								<i class="bi bi-envelope-fill"></i>
							</div>
							<div class="detail-info">
								<h6 class="fw-bold mb-1">Email</h6>
								<c:if test="${user.isEmailActive() == true}">
								<a href="javascript:;" class="mb-0">${user.email}</a>
								</c:if>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="d-flex align-items-start gap-3 border p-3 rounded">
							<div class="detail-icon fs-5">
								<i class="bi bi-telephone-fill"></i>
							</div>
							<div class="detail-info">
								<h6 class="fw-bold mb-1">Phone</h6>
								<c:if test="${user.isEmailActive() == true}">
								<a href="javascript:;" class="mb-0">${user.phone}</a>
								</c:if>
							</div>
						</div>
					</div>

					

					<div class="col">
						<div class="d-flex align-items-start gap-3 border p-3 rounded">
							<div class="detail-icon fs-5">
								<i class="bi bi-house-door-fill"></i>
							</div>
							<div class="detail-info">
								<h6 class="fw-bold mb-1">Address 1</h6>
								<p class="mb-0">${user.address}</p>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="d-flex align-items-start gap-3 border p-3 rounded">
							<div class="detail-icon fs-5">
								<i class="bi bi-house-fill"></i>
							</div>
							<div class="detail-info">
								<h6 class="fw-bold mb-1">Shipping Address</h6>
								<p class="mb-0">${order.address}</p>
							</div>
						</div>
					</div>

				</div>
				<!--end row-->
			</div>
		</div>




	</main>
	<!--end main content-->


</body>
</html>
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
						<li class="breadcrumb-item"><a href="/AZShop/admin/orders">Orders</a></li>
						<li class="breadcrumb-item active" aria-current="page">Order
							Details</li>
					</ol>
				</nav>
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
							Customer : <a href="javascript:;">${user.firstName}
								${user.lastName}</a>
						</p>
						<p class="mb-0">
							Recipient : <a href="javascript:;">${order.recipientName}</a>
						</p>
						<p class="mb-0">
							Phone : <a href="javascript:;">${order.phone}</a>
						</p>
						<p class="mb-0">
							Shipping Address : <a href="javascript:;">${order.address}</a>
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
							Wishlist<span class="fw-light ms-2">(${countProduct})</span>
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
							<label class="form-label">Completed status: </label> <label
								class="form-label">${order.status}</label>
							<c:if test="${order.status != 'Completed'}"><button type="button" class="btn btn-danger px-4 ms-2"
								data-bs-toggle="modal" data-bs-target="#deleteConfirmationModal">Cancel</button></c:if>
							<p>${message}</p>
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
								<a href="javascript:;" class="mb-0">${user.firstName}
									${user.lastName}</a>
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
								<h6 class="fw-bold mb-1">Address User</h6>
								<p class="mb-0">${user.address}</p>
							</div>
						</div>
					</div>


				</div>
				<!--end row-->
			</div>
		</div>




	</main>
	<!--end main content-->
	<div class="modal fade" id="deleteConfirmationModal" tabindex="-1"
		aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteConfirmationModalLabel">Cancel Order</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to cancel this order?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<form action="/AZShop/admin/order/cancel-order" method="post">
						<input type="hidden" name="id" value="${order.id}">
						<button type="submit" class="btn btn-danger">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
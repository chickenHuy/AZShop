<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery</title>
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
						<li class="breadcrumb-item"><a href="javascript:;"><i
								class="bx bx-home-alt"></i></a></li>
						<li class="breadcrumb-item active" aria-current="page">Delivery</li>
					</ol>
				</nav>
			</div>
		</div>

		<div class="col-auto">
			<div class="d-flex align-items-center gap-2 justify-content-lg-end">
				<a class="btn btn-primary px-4" href="adddelivery"><i
					class="bi bi-plus-lg me-2"></i>New delivery</a>
			</div>
		</div>

		<div class="card mt-4">
			<div class="card-body">
				<div class="customer-table">
					<div class="table-responsive white-space-nowrap">
						<table id="example2" class="table align-middle">
							<thead class="table-light">
								<tr>
									<th>Name</th>
									<th>Price</th>
									<th>Description</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="delivery" items="${listDelivery}">
									<tr>
										<td><a class="d-flex align-items-center gap-3"
											href="javascript:;">
												<p class="mb-0 customer-name fw-bold">${delivery.name}</p>
										</a></td>
										<td>${delivery.price }</td>
										<td>${delivery.description}</td>
										<td><a href='<c:url value="/admin/editdelivery?id=${delivery.id }"/>'>Edit</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</main>
	<!--end main content-->
</body>
</html>
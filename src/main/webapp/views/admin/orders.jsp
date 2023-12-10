<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<main class="page-content">
	<!--breadcrumb-->
	<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
		<div class="breadcrumb-title pe-3">eCommerce</div>
		<div class="ps-3">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb mb-0 p-0">
					<li class="breadcrumb-item"><a href="javascript:;"><i
							class="bx bx-home-alt"></i></a></li>
					<li class="breadcrumb-item active" aria-current="page">Orders</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	<div
		class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
		<a href="javascript:;"><span class="me-1">All</span><span
			class="text-secondary">(${countAllOrderAdmin})</span></a>
	</div>


	<!--end row-->

	<div class="card mt-4">
		<div class="card-body">
			<div class="product-table">
				<div class="table-responsive white-space-nowrap">
					<table id="example2" class="table align-middle">
						<thead class="table-light">
							<tr>
								<th>Order ID</th>
								<th>Price</th>
								<th>Customer</th>
								<th>Store</th>
								<th>Status</th>
								<th>Date</th>
								<th>Action</th>
								<th>Information</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${listOrder}">
								<tr>
									<!--  -->
									<td>#${order.id}</td>
									<td>${order.price}</td>
									<!-- Tên người đặt hàng -->
									<c:forEach var="user" items="${listUser}">
										<c:if test="${user.id eq order.userId}">
											<td>${user.firstName} ${user.lastName}</td>
										</c:if>
									</c:forEach>
									<!-- Store bán hàng -->
									<c:set var="hasImages" value="false" />
									<c:forEach var="store" items="${listStore}">
										<c:if test="${store.id eq order.storeId}">
											<td>${store.name}</td>
											<c:set var="hasImages" value="true" />
										</c:if>
									</c:forEach>
									<c:if test="${not hasImages}">
										<!-- Store đã bị xoá -->
										<td><td><span
												class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Deleted</span></td>
									</c:if>

									<c:choose>
										<c:when test="${order.status == 'Completed'}">
											<td><span
												class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Completed<i
													class="bi bi-check2 ms-2"></i></span></td>
										</c:when>
										<c:when test="${order.status == 'Cancelled'}">
											<td><span
												class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Cancelled<i
													class="bi bi-x-lg ms-2"></i></span></td>
										</c:when>
										<c:when test="${order.status == 'Shipping'}">
											<td><span
												class="lable-table bg-warning-subtle text-warning rounded border border-warning-subtle font-text2 fw-bold">Shipping<i
													class="bi bi-info-circle ms-2"></i></span></td>
										</c:when>
										<c:when test="${order.status == 'Delivered'}">
											<td><span
												class="lable-table bg-primary-subtle text-primary rounded border border-primary-subtle font-text2 fw-bold">Delivered<i
													class="bi bi-check2-all ms-2"></i></span></td>
										</c:when>
										<c:when test="${order.status == 'Waiting'}">
											<td><span
												class="lable-table bg-warning-subtle text-warning rounded border border-warning-subtle font-text2 fw-bold">Waiting<i
													class="bi bi-info-circle ms-2"></i></span></td>
										</c:when>
										<c:when test="${order.status == 'Processing'}">
											<td><span
												class="lable-table bg-warning-subtle text-warning rounded border border-warning-subtle font-text2 fw-bold">Processing<i
													class="bi bi-info-circle ms-2"></i></span></td>
										</c:when>
										<c:otherwise>
											<td><span
												class="lable-table bg-warning-subtle text-warning rounded border border-warning-subtle font-text2 fw-bold">${order.status}<i
													class="bi bi-info-circle ms-2"></i></span></td>
										</c:otherwise>
									</c:choose>


									<td>${order.updateAt != null ? order.updateAt : order.createAt}</td>

									<td><c:choose>
											<c:when test="${order.status == 'Pending Pickup'}">
												<a class="dropdown-item"
													href='<c:url value="/admin/order-edit-status?orderId=${order.id}"/>'>Shipping</a>
											</c:when>
											<c:when test="${order.status == 'Shipping'}">
												<a class="dropdown-item"
													href='<c:url value="/admin/order-edit-status?orderId=${order.id}"/>'>Delivered</a>
											</c:when>
											<c:when test="${order.status == 'Delivered'}">
												<a class="dropdown-item"
													href='<c:url value="/admin/order-edit-status?orderId=${order.id}"/>'>Completed</a>
											</c:when>

										</c:choose></td>
									<td><a class="dropdown-item"
										href='<c:url value="/admin/order-detail?orderId=${order.id}"/>'>Detail</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<p>${message}</p>

</main>
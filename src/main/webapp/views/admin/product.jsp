<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<li class="breadcrumb-item active" aria-current="page">Products</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	<div
		class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
		<a href="javascript:;"><span class="me-1">All</span><span
			class="text-secondary">(${countAllProduct})</span></a> 
	</div>

	<div class="row g-3">
		<div class="col-auto flex-grow-1 overflow-auto">
			<form action="/AZShop/admin/productsByCategory" method="get"
				class="d-flex">
				<select class="form-select" id="Category" name="categoryId"
					style="width: 200px;">
					<option value="-1">-- Select Category --</option>
					<!-- Lựa chọn với giá trị null -->
					<c:forEach var="category" items="${listCategory}">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<div class="mx-2"></div>
				<!-- Khoảng trắng giữa select và button -->
				<button type="submit" class="btn btn-primary">Filter</button>
			</form>
		</div>
	</div>

	<!--end row-->

	<div class="card mt-4">
		<div class="card-body">
			<div class="product-table">
				<div class="table-responsive white-space-nowrap">
					<table id="example2" class="table align-middle">
						<thead class="table-light">
							<tr>
								<th>Product Name</th>
								<th>Description</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Sold</th>
								<th>Rating</th>
								<th>Action</th>
							</tr>
						</thead>
							<c:forEach var="product" items="${listProduct}">
								<tr>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td>${product.price}</td>
									<td>${product.quantity}</td>
									<td>${product.sold}</td>
									<td>${product.rating}</td>
									<td><c:choose>
											<c:when test="${product.isActive}">
												<a class="dropdown-item"
													href='<c:url value="/admin/product/edit-status/banning-${product.slug}"/>'>Banning</a>
											</c:when>
											<c:otherwise>
												<a class="dropdown-item"
													href='<c:url value="/admin/product/edit-status/liencing-${product.slug}"/>'>Liencing</a>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</main>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
	$(document).ready(function() {
		$("#Category").change(function() {
			loadProducts();
		});

		// Đảm bảo rằng hàm loadProducts được gọi khi trang được tải lần đầu
		loadProducts();
	});

	function loadProducts() {
		var categoryId = $("#Category").val();

		$.ajax({
			type : "GET",
			url : "product?categoryId=" + categoryId,
			success : function(data) {
				$("#productTableBody").html(data);
			},
			error : function(error) {
				console.log("Lỗi: " + error);
			}
		});
	}
</script>
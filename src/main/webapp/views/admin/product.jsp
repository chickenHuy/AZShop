<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
s
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
			class="text-secondary">( ${countAllProduct} )</span></a> <a
			href="javascript:;"><span class="me-1">Published</span><span
			class="text-secondary">(56242)</span></a> <a href="javascript:;"><span
			class="me-1">Drafts</span><span class="text-secondary">(17)</span></a> <a
			href="javascript:;"><span class="me-1">On Discount</span><span
			class="text-secondary">(88754)</span></a>
	</div>

	<div class="row g-3">
		<div class="col-auto">
			<div class="position-relative">
				<input class="form-control px-5" type="search"
					placeholder="Search Products"> <span
					class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50 fs-5">search</span>
			</div>
		</div>
		<div class="col-auto flex-grow-1 overflow-auto">
			<div class="btn-group position-static">
				<div class="btn-group position-static">
					<select
						class="form-select" id="Category" name="categoryId">
						<c:forEach var="category" items="${listCategory}">
							<option value=${category.id}>${category.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<!--end row-->

	<div class="card mt-4">
		<div class="card-body">
			<div class="product-table">
				<div class="table-responsive white-space-nowrap">
					<table class="table align-middle">
						<thead class="table-light">
							<tr>
								<th>Product Name</th>
								<th>Description</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Sold</th>
								<th>Rating</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${listProduct}">
								<tr>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td>${product.price}</td>
									<td>${product.quantity}</td>
									<td>${product.sold}</td>
									<td>${product.rating}</td>
									<td><a class="dropdown-item" href="#">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</main>
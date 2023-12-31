<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
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
					<li class="breadcrumb-item active" aria-current="page">Categories</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	<div
		class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
		<a href="javascript:;"><span class="me-1">All</span><span
			class="text-secondary">(${countAllCategory})</span></a>
	</div>

	<div class="row g-3">
		<div class="col-auto">
			<div class="d-flex align-items-center gap-2 justify-content-lg-end">
				<a class="btn btn-primary px-4" href="addcategory"><i
					class="bi bi-plus-lg me-2"></i>Add Category</a>
			</div>
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
								<th>Category Name</th>
								<th>Category Parent</th>
								<th>Active</th>
								<th>Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="category" items="${listCategory}">
								<tr>
									<td><a class="d-flex align-items-center gap-3"
										href="javascript:;">
											<div class="customer-pic">
												<img src="/AZShop/image?fname=${category.image}" width="100"
													height="100" alt="">
											</div>
											<p class="mb-0 customer-name fw-bold">${category.name}</p>
									</a></td>
									<c:set var="hasImages" value="false" />
									<c:forEach var="item" items="${listCategory}">
										<c:if test="${item.id == category.categoryId}">
											<td>${item.name}</td>
											<c:set var="hasImages" value="true" />
										</c:if>
									</c:forEach>
									<c:if test="${not hasImages}">
										<!-- Nếu không có hình ảnh, sử dụng hình ảnh mặc định -->
										<td></td>
									</c:if>
									<c:choose>
										<c:when test="${category.isDeleted() == false}">
											<td><span
												class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Activated</span></td>	
										</c:when>
										<c:otherwise>
											<td><span
												class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Deleted</span></td>
										</c:otherwise>
									</c:choose>
									<td>${category.updateAt != null ? category.updateAt : category.createAt}</td>
									<td><c:if test="${category.isDeleted() == false}">
											<a class="dropdown-item"
												href='<c:url value="/admin/category/edit?slug=${category.slug}"/>'>Edit</a>
										</c:if> <c:if test="${category.isDeleted() == true}">
											<!-- Nếu isDeleted là true, hiển thị nút Restore -->
											<a class="dropdown-item"
												href='<c:url value="/admin/category/restore?slug=${category.slug}"/>'>Restore</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</main>
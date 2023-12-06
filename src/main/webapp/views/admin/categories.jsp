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
					<li class="breadcrumb-item active" aria-current="page">Categories</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	<div
		class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
		<a href="javascript:;"><span class="me-1">All</span><span
			class="text-secondary">( ${countAllCategory} )</span></a>
	</div>

	<div class="row g-3">
		<div class="col-auto">
			<div class="position-relative">
				<input class="form-control px-5" type="search"
					placeholder="Search Products"> <span
					class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50 fs-5">search</span>
			</div>
		</div>
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
								<th>Slug</th>
								<th>Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="category" items="${listCategory}">
								<tr>
									<td><div class="customer-pic">
											<img src="${category.image }" class="rounded-circle"
												width="40" height="40" alt="">
										</div>
										<p class="mb-0 customer-name fw-bold">${category.name}</p>
									</td>
									<td>${category.slug}</td>
									<td>${category.updateAt != null ? category.updateAt : category.createAt}</td>
									<td>
										<a class="dropdown-item" href='<c:url value="/admin/category/edit?slug=${category.slug}"/>'>Edit</a>
										<a class="dropdown-item" href='<c:url value="/admin/category/delete/delete-${category.slug}"/>'>Delete</a>
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
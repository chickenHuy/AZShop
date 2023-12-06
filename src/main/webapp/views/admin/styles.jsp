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
					<li class="breadcrumb-item active" aria-current="page">Styles</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	<div
		class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
		<a href="javascript:;"><span class="me-1">All</span><span
			class="text-secondary">( ${countAllStyle} )</span></a>
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
				<a class="btn btn-primary px-4" href="addstyle"><i
					class="bi bi-plus-lg me-2"></i>Add Style</a>
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
								<th>Style Name</th>
								<th>Category</th>
								<th>Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="style" items="${listStyle}">
								<tr>
									<td>${style.name}</td>
									<c:forEach var="category" items="${listCategory}">
										<c:if test="${category.id eq style.categoryId}">
											<td>${category.name}</td>
										</c:if>
									</c:forEach>
									<td>${style.updateAt != null ? style.updateAt : style.createAt}</td>
									<td><a class="dropdown-item"
										href='<c:url value="/admin/style/edit?id=${style.id}"/>'>Edit</a>
										<c:if test="${style.isDeleted() == true}">
											<!-- Nếu isDeleted là true, hiển thị nút Restore -->
											<a class="dropdown-item"
												href='<c:url value="/admin/style/restore?id=${style.id}"/>'>Restore</a>
										</c:if> <c:if test="${style.isDeleted() == false}">
											<!-- Nếu isDeleted là false, hiển thị nút Delete -->
											<a class="dropdown-item"
												href='<c:url value="/admin/style/delete?id=${style.id}"/>'>Delete</a>
										</c:if>
									</td>
									<td>
										<a class="dropdown-item"
										href='<c:url value="/admin/style/stylevalue?styleid=${style.id}"/>'>Detail</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</main>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Style</title>
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
			class="text-secondary">(${countAllStyle})</span></a>
	</div>

	<div class="row g-3">
		<div class="col-auto">
			<form action="addstyle" method="post"
				class="d-flex align-items-center justify-content-between">
				<div class="mb-3">
					<div class="d-flex gap-2">
						<div class="col-md-6">
							<h5>Style Name</h5>
							<input type="text" class="form-control"
							placeholder="write name here...." name="styleName" required>
						</div>
						<div class="col-md-6">
							<h5>Choose Category</h5>
							<select
							class="form-select" id="Category" name="categoryId">
							<c:forEach var="category" items="${listCategory}">
								<option value=${category.id}>${category.name}</option>
							</c:forEach>
						</select>
						</div>
						<div class="d-flex col-md-6 align-items-end">
							<input type="submit" value="ADD"
								class="btn btn-primary px-4 ms-2">
						</div>
					</div>
					<p>${message }</p>
				</div>
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
								<th>Style Name</th>
								<th>Category</th>
								<th>Date</th>
								<th>Active</th>
								<th>Action</th>
								<th>Information</th>
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
									<c:choose>
										<c:when test="${style.isDeleted() == false}">
											<td><span
												class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Activated</span></td>	
										</c:when>
										<c:otherwise>
											<td><span
												class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Deleted</span></td>
										</c:otherwise>
									</c:choose>
									<td><c:if test="${style.isDeleted() == false}">
											<a class="dropdown-item"
												href='<c:url value="/admin/style/edit?id=${style.id}"/>'>Edit</a>
										</c:if> <c:if test="${style.isDeleted() == true}">
											<!-- Nếu isDeleted là true, hiển thị nút Restore -->
											<a class="dropdown-item" style="color: green;"
												href='<c:url value="/admin/style/restore?id=${style.id}"/>'>Restore</a>
										</c:if> <c:if test="${style.isDeleted() == false}">
											<!-- Nếu isDeleted là false, hiển thị nút Delete -->
											<a class="dropdown-item" style="color: red;"
												href='<c:url value="/admin/style/delete?id=${style.id}"/>'>Delete</a>
										</c:if></td>
									<td><a class="dropdown-item"
										href='<c:url value="/admin/style/stylevalues?styleid=${style.id}"/>'>Detail</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</main>
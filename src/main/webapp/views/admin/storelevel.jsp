<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Level</title>
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
						<li class="breadcrumb-item active" aria-current="page">Store
							Level</li>
					</ol>
				</nav>
			</div>
		</div>

		<div class="col-auto">
			<div class="d-flex align-items-center gap-2 justify-content-lg-end">
				<a class="btn btn-primary px-4" href="addstorelevel"><i
					class="bi bi-plus-lg me-2"></i>New level</a>
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
									<th>Min point</th>
									<th>Discount</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="store" items="${liststorelevel}">
									<tr>
										<td><a class="d-flex align-items-center gap-3"
											href="javascript:;">
												<p class="mb-0 customer-name fw-bold">${store.name }</p>
										</a></td>
										<td>${store.minPoint }</td>
										<td>${store.discount }</td>
										<td><a
											href='<c:url value="/admin/editstorelevel?id=${store.id }"/>'>Edit</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<h3>Level deleted</h3>
		<div class="card mt-4">
			<div class="card-body">
				<div class="customer-table">
					<div class="table-responsive white-space-nowrap">
						<table class="table align-middle">
							<thead class="table-light">
								<tr>
									<th>Name</th>
									<th>Min point</th>
									<th>Discount</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="store" items="${listdeleted}">
									<tr>
										<td><a class="d-flex align-items-center gap-3"
											href="javascript:;">
												<p class="mb-0 customer-name fw-bold">${store.name }</p>
										</a></td>
										<td>${store.minPoint }</td>
										<td>${store.discount }</td>
										<td><a
											href='<c:url value="/admin/restorestorelevel?id=${store.id }"/>'>Restore</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!--end main content-->
</body>
</html>
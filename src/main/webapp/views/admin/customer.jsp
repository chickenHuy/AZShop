<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
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
						<li class="breadcrumb-item active" aria-current="page">Customers</li>
					</ol>
				</nav>
			</div>
		</div>
		<div class="card mt-4">
			<div class="card-body">
				<div class="customer-table">
					<div class="table-responsive white-space-nowrap">
						<table id="example2" class="table align-middle">
							<thead class="table-light">
								<tr>
									<th><input class="form-check-input" type="checkbox">
									</th>
									<th>Customers</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Role</th>
									<th>Active Email</th>
									<th>Active Phone</th>
									<th>Point</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${listuser}">
									<tr>
										<td><input class="form-check-input" type="checkbox">
										</td>
										<td><a class="d-flex align-items-center gap-3"
											href="javascript:;">
												<div class="customer-pic">
													<img src="${user.coverImage }" class="rounded-circle"
														width="40" height="40" alt="">
												</div>
												<p class="mb-0 customer-name fw-bold">${user.firstName }
													${user.lastName }</p>
										</a></td>
										<td><a href="javascript:;" class="font-text1">${user.email }</a>
										</td>
										<td>${user.phone }</td>
										<td>${user.role }</td>
										<td><c:choose>
												<c:when test="${user.emailActive }">
													<span
														class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Activated</span>

												</c:when>
												<c:otherwise>
													<span
														class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">not
														activated</span>
												</c:otherwise>

											</c:choose></td>
										<td><c:choose>
												<c:when test="${user.phoneActive }">
													<span
														class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Activated</span>

												</c:when>
												<c:otherwise>
													<span
														class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">not
														activated</span>

												</c:otherwise>

											</c:choose></td>
										<td>${user.point }</td>
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
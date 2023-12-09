<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store</title>
</head>
<body>
	<main class="page-content">
		<!--breadcrumb-->
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">eCommerce</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="javascript:;"><i
								class="bx bx-home-alt"></i></a></li>
						<li class="breadcrumb-item active" aria-current="page">Stores</li>
					</ol>
				</nav>
			</div>

		</div>
		<!--end row-->

		<div class="card mt-4">
			<div class="card-body">
				<div class="customer-table">
					<div class="table-responsive white-space-nowrap">
						<table id="example2" class="table align-middle">
							<thead class="table-light">
								<tr>
									<th>Store</th>
									<th>Bio</th>
									<th>Store level</th>
									<th>Point</th>
									<th>Rating</th>
									<th>Date create</th>
									<th>Active</th>
									<th>Licensing/Banning</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="store" items="${liststore}">
									<tr>
										<td><a class="d-flex align-items-center gap-3"
											href="javascript:;">
												<div class="customer-pic d-flex align-items-center gap-3">
													<c:if test="${store.avatar != null }">
														<img src="/AZShop/image?fname=${store.avatar}" alt=""
															width="40" height="40" class="rounded-circle">
													</c:if>
													<c:if test="${store.avatar == null }">
														<img
															src="${pageContext.request.contextPath}/templates/static/none.png"
															alt="" width="40" height="40" class="rounded-circle">
													</c:if>
												</div>
												<p class="mb-0 customer-name fw-bold">${store.name }</p>
										</a></td>
										<td>${store.bio }</td>
										<td>${store.storeLevelId }</td>
										<td>${store.point }</td>
										<td>${store.rating }</td>
										<td>${store.createAt }</td>
										<c:choose>
											<c:when test="${store.active }">
												<td><span
													class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Activated</span></td>
												<td><a
													href='<c:url value="/admin/store/edit-status/banning-${store.slug }"/>'
													class="font-text1">Banning</a></td>
											</c:when>
											<c:otherwise>
												<td><span
													class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Banned</span></td>
												<td><a
													href='<c:url value="/admin/store/edit-status/liencing-${store.slug }"/>'
													class="font-text1">Licensing</a></td>
											</c:otherwise>

										</c:choose>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</main>
</body>
</html>
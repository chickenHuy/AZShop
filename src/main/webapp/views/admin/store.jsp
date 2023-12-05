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
			<div class="ms-auto">
				<div class="btn-group">
					<button type="button" class="btn btn-primary">Settings</button>
					<button type="button"
						class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split"
						data-bs-toggle="dropdown">
						<span class="visually-hidden">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
						<a class="dropdown-item" href="javascript:;">Action</a> <a
							class="dropdown-item" href="javascript:;">Another action</a> <a
							class="dropdown-item" href="javascript:;">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="javascript:;">Separated link</a>
					</div>
				</div>
			</div>
		</div>
		<!--end breadcrumb-->


		<div
			class="product-count d-flex align-items-center gap-3 gap-lg-4 mb-4 fw-bold flex-wrap font-text1">
			<a href="javascript:;"><span class="me-1">All</span><span
				class="text-secondary">(85472)</span></a> <a href="javascript:;"><span
				class="me-1">New</span><span class="text-secondary">(145)</span></a> <a
				href="javascript:;"><span class="me-1">Checkouts</span><span
				class="text-secondary">(89)</span></a> <a href="javascript:;"><span
				class="me-1">Locals</span><span class="text-secondary">(5872)</span></a>
			<a href="javascript:;"><span class="me-1">Subscribers</span><span
				class="text-secondary">(163)</span></a> <a href="javascript:;"><span
				class="me-1">Top Reviews</span><span class="text-secondary">(8)</span></a>
		</div>

		<div class="row g-3">
			<div class="col-auto">
				<div class="position-relative">
					<input class="form-control px-5" type="search"
						placeholder="Search Store"> <span
						class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50 fs-5">search</span>
				</div>
			</div>
			<div class="col-auto flex-grow-1 overflow-auto">
				<div class="btn-group position-static">
					<div class="btn-group position-static">
						<button type="button"
							class="btn border btn-light dropdown-toggle px-4"
							data-bs-toggle="dropdown" aria-expanded="false">Country
						</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="javascript:;">Action</a></li>
							<li><a class="dropdown-item" href="javascript:;">Another
									action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="javascript:;">Something
									else here</a></li>
						</ul>
					</div>
					<div class="btn-group position-static">
						<button type="button"
							class="btn border btn-light dropdown-toggle px-4"
							data-bs-toggle="dropdown" aria-expanded="false">Source</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="javascript:;">Action</a></li>
							<li><a class="dropdown-item" href="javascript:;">Another
									action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="javascript:;">Something
									else here</a></li>
						</ul>
					</div>
					<div class="btn-group position-static">
						<button type="button"
							class="btn border btn-light dropdown-toggle px-4"
							data-bs-toggle="dropdown" aria-expanded="false">More
							Filters</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="javascript:;">Action</a></li>
							<li><a class="dropdown-item" href="javascript:;">Another
									action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="javascript:;">Something
									else here</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-auto">
				<div class="d-flex align-items-center gap-2 justify-content-lg-end">
					<button class="btn btn-light px-4">
						<i class="bi bi-box-arrow-right me-2"></i>Export
					</button>
				</div>
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
												<div class="customer-pic">
													<img src="${store.avatar }" class="rounded-circle"
														width="40" height="40" alt="">
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
												<td><a href='<c:url value="/admin/store/edit-status/banning-${store.slug }"/>' class="font-text1">Banning</a></td>
											</c:when>
											<c:otherwise>
												<td><span
													class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Banned</span></td>
												<td><a href='<c:url value="/admin/store/edit-status/liencing-${store.slug }"/>' class="font-text1">Licensing</a></td>
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
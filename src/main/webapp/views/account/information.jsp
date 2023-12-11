<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Vendor CSS Files -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/bootstrap-icons/bootstrap-icons.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/boxicons/css/boxicons.min.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/quill/quill.snow.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/quill/quill.bubble.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/remixicon/remixicon.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/vendor/simple-datatables/style.css' />">

<!-- Template Main CSS File -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/templates/account/assets/css/style.css' />">

	<style>
		.custom-alert {
			display: none;
			position: fixed;
			top: 20px;
			left: 50%;
			transform: translateX(-50%);
			padding: 15px;
			background-color: #4CAF50;
			color: white;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			z-index: 999;
		}
	
		.close-btn {
			position: absolute;
			top: 5px;
			right: 10px;
			cursor: pointer;
			font-size: 18px;
			color: #fff;
		}
	</style>
	
</head>
<body>

	<c:if test="${done != null}">
		<div class="custom-alert" id="customAlert">
			<span class="close-btn" onclick="closeAlert()">&times;</span>
			${done}
		</div>
		<script>
			// Hiển thị thông báo khi có nội dung
			document.getElementById('customAlert').style.display = 'block';

			// Hàm đóng thông báo
			function closeAlert() {
				document.getElementById('customAlert').style.display = 'none';
			}
		</script>
	</c:if>


	<!-- ======= Header ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center" style="background-color: #15161d;">

		<div class="d-flex align-items-center justify-content-between" >
			<a href="<c:url value='/waiting' />" class="logo d-flex align-items-center"> <img
				src="<c:url value='/templates/account/assets/img/logo.png' />" alt=""> <span
				class="d-none d-lg-block" style="color:#ffffff;">AZSHOP</span>
			</a> <i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<!-- End Logo -->

		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">


				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="#" data-bs-toggle="dropdown"> <img
					src = "/AZShop/image?fname=${user.avatar}" alt="Profile"
						class="rounded-circle"> <span
						class="d-none d-md-block dropdown-toggle ps-2" style="color:#ffffff;">${user.email}</span>
				</a>
				<!-- End Profile Iamge Icon -->

					<ul
						class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
						<li class="dropdown-header">
							<h6>${user.firstName} ${user.lastName} </h6>
						</li>
						<li>
							<hr class="dropdown-divider">
						</li>

						<li><a class="dropdown-item d-flex align-items-center"
							href="<c:url value='/logout-customer' />"> <i class="bi bi-box-arrow-right"></i> <span>Sign
									Out</span>
						</a></li>

					</ul>
					<!-- End Profile Dropdown Items --></li>
				<!-- End Profile Nav -->

			</ul>
		</nav>
		<!-- End Icons Navigation -->

	</header>
	<!-- End Header -->

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Profile</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value='/waiting' />">Home</a></li>
					<li class="breadcrumb-item">Users</li>
					<li class="breadcrumb-item active">Profile</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section profile" >
			<div class="row">
				<div class="col-xl-4">

					<div class="card">
						<div
							class="card-body profile-card pt-4 d-flex flex-column align-items-center">
							<c:if test ="${user.avatar != null }">
								<img src = "/AZShop/image?fname=${user.avatar}" alt="Profile"
								class="rounded-circle">
							</c:if>
							<c:if test ="${user.avatar == null }">
								<img src="${pageContext.request.contextPath}/templates/static/none.png" alt="Profile"
								class="rounded-circle">
							</c:if>
							<h2>${user.firstName} ${user.lastName}</h2>
						</div>
					</div>

				</div>

				<div class="col-xl-8">

					<div class="card">
						<div class="card-body pt-3">
							<!-- Bordered Tabs -->
							<ul class="nav nav-tabs nav-tabs-bordered">

								<li class="nav-item">
									<button class="nav-link active" data-bs-toggle="tab"
										data-bs-target="#profile-overview">Overview</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-edit">Edit Profile</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-change-password">Change
										Password</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-order">Tracking Order</button>
								</li>

							</ul>
							<div class="tab-content pt-2">

								<div class="tab-pane fade show active profile-overview"
									id="profile-overview">

									<h5 class="card-title">Profile Details</h5>

									<div class="row">
										<div class="col-lg-3 col-md-4 label ">First Name</div>
										<div class="col-lg-9 col-md-8">${user.firstName}</div>
									</div>

                                    <div class="row">
										<div class="col-lg-3 col-md-4 label ">Last Name</div>
										<div class="col-lg-9 col-md-8">${user.lastName}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Cart Id</div>
										<div class="col-lg-9 col-md-8">${user.cartId}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Email</div>
										<div class="col-lg-9 col-md-8">${user.email}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Phone</div>
										<div class="col-lg-9 col-md-8">${user.phone}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Address</div>
										<div class="col-lg-9 col-md-8">${user.address}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Point</div>
										<div class="col-lg-9 col-md-8">${user.point}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">EWallet</div>
										<div class="col-lg-9 col-md-8">${user.eWallet}</div>
									</div>

								</div>

								<div class="tab-pane fade profile-edit pt-3" id="profile-edit">

									<!-- Profile Edit Form -->
									<form action="update-infor" method="post" enctype="multipart/form-data">
										<div class="row mb-3">
											<label for="profileImage"
												class="col-md-4 col-lg-3 col-form-label">Profile
												Image</label>
											<div class="col-md-8 col-lg-9">
												<img src = "/AZShop/image?fname=${user.avatar}" alt="Profile" alt="Profile">
												<div class="pt-2">
													<input type="file" name="Image" class="btn btn-primary"></input>
												</div>
											</div>
										</div>

										<div class="row mb-3">
											<label for="fullName"
												class="col-md-4 col-lg-3 col-form-label">First Name</label>
											<div class="col-md-8 col-lg-9">
												<input name="firstName" type="text" class="form-control"
													id="firstName" value="${user.firstName}">
											</div>
										</div>

                                        <div class="row mb-3">
											<label for="fullName"
												class="col-md-4 col-lg-3 col-form-label">Last Name</label>
											<div class="col-md-8 col-lg-9">
												<input name="lastName" type="text" class="form-control"
													id="lastName" value="${user.lastName}">
											</div>
										</div>


										<div class="row mb-3">
											<label for="company" class="col-md-4 col-lg-3 col-form-label">Cart Id</label>
											<div class="col-md-8 col-lg-9">
												<input name="cartId" type="text" class="form-control"
													id="cartId" value="${user.cartId}" readonly>
											</div>
										</div>

										<div class="row mb-3">
											<label for="Job" class="col-md-4 col-lg-3 col-form-label">Email</label>
											<div class="col-md-8 col-lg-9">
												<input name="email" type="email" class="form-control" id="email"
													value="${user.email}" readonly>
											</div>
										</div>

										<div class="row mb-3">
											<label for="Country" class="col-md-4 col-lg-3 col-form-label">Phone</label>
											<div class="col-md-8 col-lg-9">
												<input name="phone" type="text" class="form-control"
													id="phone" value="${user.phone}" pattern="[0-9]+" title="Please enter only digits">
											</div>
										</div>

										<div class="row mb-3">
											<label for="Address" class="col-md-4 col-lg-3 col-form-label">Address</label>
											<div class="col-md-8 col-lg-9">
												<input name="address" type="text" class="form-control"
													id="address" value="${user.address}">
											</div>
										</div>

										<div class="row mb-3">
											<label for="Phone" class="col-md-4 col-lg-3 col-form-label">Point</label>
											<div class="col-md-8 col-lg-9">
												<input name="point" type="text" class="form-control"
													id="point" value="${user.point}" readonly>
											</div>
										</div>

										<div class="row mb-3">
											<label for="Email" class="col-md-4 col-lg-3 col-form-label">EWallet</label>
											<div class="col-md-8 col-lg-9">
												<input name="email" type="text" class="form-control"
													id="email" value="${user.eWallet}" readonly>
											</div>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary">Save
												Changes</button>
										</div>
									</form>
									<!-- End Profile Edit Form -->

								</div>

								<div class="tab-pane fade pt-3" id="profile-change-password">
									<!-- Change Password Form -->
									<form action="update-password" method="post">

										<div class="row mb-3">
											<label for="currentPassword"
												class="col-md-4 col-lg-3 col-form-label">Current
												Password</label>
											<div class="col-md-8 col-lg-9">
												<input name="currentPassword" type="password" class="form-control"
													id="currentPassword">
											</div>
										</div>

										<div class="row mb-3">
											<label for="newPassword"
												class="col-md-4 col-lg-3 col-form-label">New
												Password</label>
											<div class="col-md-8 col-lg-9">
												<input name="newPassword" type="password"
													class="form-control" id="newPassword">
											</div>
										</div>

										<div class="row mb-3">
											<label for="renewPassword"
												class="col-md-4 col-lg-3 col-form-label">Re-enter
												New Password</label>
											<div class="col-md-8 col-lg-9">
												<input name="renewPassword" type="password"
													class="form-control" id="renewPassword">
											</div>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary">Change
												Password</button>
										</div>
									</form>
									<!-- End Change Password Form -->

								</div>

								<div class="tab-pane fade pt-3" id="profile-order">
									<ul class="nav nav-tabs nav-tabs-bordered">
										<li class="nav-item">
											<button class="nav-link active" data-bs-toggle="tab" data-bs-target="#order-waiting">Waiting</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-processing">Processing</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-pending">Pending Pickup</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-shipping">Shipping</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-delivered">Delivered</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-completed">Completed</button>
										</li>
										<li class="nav-item">
											<button class="nav-link" data-bs-toggle="tab" data-bs-target="#order-cancelled">Cancelled</button>
										</li>
									</ul>

									<div class="tab-content">
										<div class="tab-pane fade pt-3 show active" id="order-waiting">
											<!-- Nội dung cho Đơn hàng Đang Chờ -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListWaiting}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																
																<td>
																	<a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a>
																	
																	<form action="cancellOrder" method="post" style="display: inline;">
																		<input type="hidden" name="id" value="${order.id}">
																		<button class="btn btn-danger" type="submit">Cancel</button>
																	</form>
																</td>
																
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>
								
										<div class="tab-pane fade pt-3" id="order-processing">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListProcessing}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>

										<div class="tab-pane fade pt-3" id="order-pending">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListPending}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>

										<div class="tab-pane fade pt-3" id="order-shipping">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListShipping}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>

										<div class="tab-pane fade pt-3" id="order-delivered">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListDelivered}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>

										<div class="tab-pane fade pt-3" id="order-completed">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListCompleted}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>

										<div class="tab-pane fade pt-3" id="order-cancelled">
											<!-- Nội dung cho Đơn hàng Hoàn Thành -->
											<h5 class="card-title">Bảng dữ liệu</h5>
											<p>Theo dõi đơn hàng tại đây!</p>
											<table class="table datatable">
												<thead>
													<tr>
														<th>
														<b>O</b>rder Id
														</th>
														<th>Address</th>
														<th>Status</th>
														<th>Phone</th>
														<th data-type="date" data-format="YYYY/DD/MM">Time</th>
														<th>Action</th>
													</tr>
													</thead>
													<tbody>
														<c:forEach var="order" items="${orderListCancelled}">
															<tr>
																<td>${order.id}</td>
																<td>${order.address}</td>
																<td>${order.status}</td>
																<td>${order.phone}</td>
																<td>${order.createAt}</td>
																<td><a href="/AZShop/detailOrder?id=${order.id}" class="btn btn-primary">Detail</a></td>
															</tr>
														</c:forEach>
													</tbody>
											</table>
										</div>
									</div>
								</div>

							</div>
							<!-- End Bordered Tabs -->

						</div>
					</div>

				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->

    <!-- ======= Footer ======= -->
	<footer id="footer" class="footer" >
		<div class="copyright">
		&copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
		</div>
		<div class="credits">
		<!-- All the links in the footer should remain intact. -->
		<!-- You can delete the links only if you purchased the pro version. -->
		<!-- Licensing information: https://bootstrapmade.com/license/ -->
		<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
		Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
		</div>
	</footer><!-- End Footer -->

	<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script
		src="<c:url value='/templates/account/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/chart.js/chart.umd.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/echarts/echarts.min.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/quill/quill.min.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/simple-datatables/simple-datatables.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/tinymce/tinymce.min.js' />"></script>
	<script
		src="<c:url value='/templates/account/assets/vendor/php-email-form/validate.js' />"></script>
	<!-- Template Main JS File -->
	<script src="<c:url value='/templates/account/assets/js/main.js' />"></script>

</body>
</html>
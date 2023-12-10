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
</head>
<body>

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
					<li class="breadcrumb-item"><a href="<c:url value='/information' />">Profile</a></li>
					<li class="breadcrumb-item active"></a>Order</li>
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
							<!-- Nội dung cho Đơn hàng Đang Chờ -->
							<h5 class="card-title">Bảng dữ liệu</h5>
							<p>Theo dõi đơn hàng tại đây!</p>
				
							<table class="table datatable">
								<thead>
									<tr>
										<th><b>P</b>roduct ID</th>
										<th>Product Name</th>
										<th>Price</th>
										<th>Description</th>
										<th>Count</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="index" begin="0" end="${size - 1}">
										<tr>
											<td>${orderItems[index].productId}</td>
											<td>${product[index].name}</td>
											<td>${product[index].price}</td>
											<td>${product[index].description}</td>
											<td>${orderItems[index].count}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
				
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
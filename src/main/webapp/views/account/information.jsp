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
													id="phone" value="${user.phone}">
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
									<h5 class="card-title">Datatables</h5>
									<p>Theo dõi đơn hàng tại đây!</p>

									<!-- Table with stripped rows -->
									<table class="table datatable">
										<thead>
										<tr>
											<th>
											<b>N</b>ame
											</th>
											<th>Ext.</th>
											<th>City</th>
											<th data-type="date" data-format="YYYY/DD/MM">Start Date</th>
											<th>Completion</th>
										</tr>
										</thead>
										<tbody>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td>37%</td>
										</tr>
										<tr>
											<td>Theodore Duran</td>
											<td>8971</td>
											<td>Dhanbad</td>
											<td>1999/04/07</td>
											<td>97%</td>
										</tr>
										<tr>
										<td>Kylie Bishop</td>
										<td>3147</td>
										<td>Norman</td>
										<td>2005/09/08</td>
										<td>63%</td>
										</tr>
										<tr>
										<td>Willow Gilliam</td>
										<td>3497</td>
										<td>Amqui</td>
										<td>2009/29/11</td>
										<td>30%</td>
										</tr>
										<tr>
										<td>Blossom Dickerson</td>
										<td>5018</td>
										<td>Kempten</td>
										<td>2006/11/09</td>
										<td>17%</td>
										</tr>
										<tr>
										<td>Elliott Snyder</td>
										<td>3925</td>
										<td>Enines</td>
										<td>2006/03/08</td>
										<td>57%</td>
										</tr>
										<tr>
										<td>Castor Pugh</td>
										<td>9488</td>
										<td>Neath</td>
										<td>2014/23/12</td>
										<td>93%</td>
										</tr>
										<tr>
										<td>Pearl Carlson</td>
										<td>6231</td>
										<td>Cobourg</td>
										<td>2014/31/08</td>
										<td>100%</td>
										</tr>
										<tr>
										<td>Deirdre Bridges</td>
										<td>1579</td>
										<td>Eberswalde-Finow</td>
										<td>2014/26/08</td>
										<td>44%</td>
										</tr>
										<tr>
										<td>Daniel Baldwin</td>
										<td>6095</td>
										<td>Moircy</td>
										<td>2000/11/01</td>
										<td>33%</td>
										</tr>
										<tr>
										<td>Phelan Kane</td>
										<td>9519</td>
										<td>Germersheim</td>
										<td>1999/16/04</td>
										<td>77%</td>
										</tr>
										<tr>
										<td>Quentin Salas</td>
										<td>1339</td>
										<td>Los Andes</td>
										<td>2011/26/01</td>
										<td>49%</td>
										</tr>
										<tr>
										<td>Armand Suarez</td>
										<td>6583</td>
										<td>Funtua</td>
										<td>1999/06/11</td>
										<td>9%</td>
										</tr>
										<tr>
										<td>Gretchen Rogers</td>
										<td>5393</td>
										<td>Moxhe</td>
										<td>1998/26/10</td>
										<td>24%</td>
										</tr>
										<tr>
										<td>Harding Thompson</td>
										<td>2824</td>
										<td>Abeokuta</td>
										<td>2008/06/08</td>
										<td>10%</td>
										</tr>
										<tr>
										<td>Mira Rocha</td>
										<td>4393</td>
										<td>Port Harcourt</td>
										<td>2002/04/10</td>
										<td>14%</td>
										</tr>
										<tr>
										<td>Drew Phillips</td>
										<td>2931</td>
										<td>Goes</td>
										<td>2011/18/10</td>
										<td>58%</td>
										</tr>
										<tr>
										<td>Emerald Warner</td>
										<td>6205</td>
										<td>Chiavari</td>
										<td>2002/08/04</td>
										<td>58%</td>
										</tr>
										<tr>
										<td>Colin Burch</td>
										<td>7457</td>
										<td>Anamur</td>
										<td>2004/02/01</td>
										<td>34%</td>
										</tr>
										<tr>
										<td>Russell Haynes</td>
										<td>8916</td>
										<td>Frascati</td>
										<td>2015/28/04</td>
										<td>18%</td>
										</tr>
										<tr>
										<td>Brennan Brooks</td>
										<td>9011</td>
										<td>Olmué</td>
										<td>2000/18/04</td>
										<td>2%</td>
										</tr>
										<tr>
										<td>Kane Anthony</td>
										<td>8075</td>
										<td>LaSalle</td>
										<td>2006/21/05</td>
										<td>93%</td>
										</tr>
										<tr>
										<td>Scarlett Hurst</td>
										<td>1019</td>
										<td>Brampton</td>
										<td>2015/07/01</td>
										<td>94%</td>
										</tr>
										<tr>
										<td>James Scott</td>
										<td>3008</td>
										<td>Meux</td>
										<td>2007/30/05</td>
										<td>55%</td>
										</tr>
										<tr>
										<td>Desiree Ferguson</td>
										<td>9054</td>
										<td>Gojra</td>
										<td>2009/15/02</td>
										<td>81%</td>
										</tr>
										<tr>
										<td>Elaine Bishop</td>
										<td>9160</td>
										<td>Petrópolis</td>
										<td>2008/23/12</td>
										<td>48%</td>
										</tr>
										<tr>
										<td>Hilda Nelson</td>
										<td>6307</td>
										<td>Posina</td>
										<td>2004/23/05</td>
										<td>76%</td>
										</tr>
										<tr>
										<td>Evangeline Beasley</td>
										<td>3820</td>
										<td>Caplan</td>
										<td>2009/12/03</td>
										<td>62%</td>
										</tr>
										<tr>
										<td>Wyatt Riley</td>
										<td>5694</td>
										<td>Cavaion Veronese</td>
										<td>2012/19/02</td>
										<td>67%</td>
										</tr>
										<tr>
										<td>Wyatt Mccarthy</td>
										<td>3547</td>
										<td>Patan</td>
										<td>2014/23/06</td>
										<td>9%</td>
										</tr>
										<tr>
										<td>Cairo Rice</td>
										<td>6273</td>
										<td>Ostra Vetere</td>
										<td>2016/27/02</td>
										<td>13%</td>
										</tr>
										<tr>
										<td>Sylvia Peters</td>
										<td>6829</td>
										<td>Arrah</td>
										<td>2015/03/02</td>
										<td>13%</td>
										</tr>
										<tr>
										<td>Kasper Craig</td>
										<td>5515</td>
										<td>Firenze</td>
										<td>2015/26/04</td>
										<td>56%</td>
										</tr>
										<tr>
										<td>Leigh Ruiz</td>
										<td>5112</td>
										<td>Lac Ste. Anne</td>
										<td>2001/09/02</td>
										<td>28%</td>
										</tr>
										<tr>
										<td>Athena Aguirre</td>
										<td>5741</td>
										<td>Romeral</td>
										<td>2010/24/03</td>
										<td>15%</td>
										</tr>
										<tr>
										<td>Riley Nunez</td>
										<td>5533</td>
										<td>Sart-Eustache</td>
										<td>2003/26/02</td>
										<td>30%</td>
										</tr>
										<tr>
										<td>Lois Talley</td>
										<td>9393</td>
										<td>Dorchester</td>
										<td>2014/05/01</td>
										<td>51%</td>
										</tr>
										<tr>
										<td>Hop Bass</td>
										<td>1024</td>
										<td>Westerlo</td>
										<td>2012/25/09</td>
										<td>85%</td>
										</tr>
										<tr>
										<td>Kalia Diaz</td>
										<td>9184</td>
										<td>Ichalkaranji</td>
										<td>2013/26/06</td>
										<td>92%</td>
										</tr>
										<tr>
										<td>Maia Pate</td>
										<td>6682</td>
										<td>Louvain-la-Neuve</td>
										<td>2011/23/04</td>
										<td>50%</td>
										</tr>
										<tr>
										<td>Macaulay Pruitt</td>
										<td>4457</td>
										<td>Fraser-Fort George</td>
										<td>2015/03/08</td>
										<td>92%</td>
										</tr>
										<tr>
										<td>Danielle Oconnor</td>
										<td>9464</td>
										<td>Neuwied</td>
										<td>2001/05/10</td>
										<td>17%</td>
										</tr>
										<tr>
										<td>Kato Carr</td>
										<td>4842</td>
										<td>Faridabad</td>
										<td>2012/11/05</td>
										<td>96%</td>
										</tr>
										<tr>
										<td>Malachi Mejia</td>
										<td>7133</td>
										<td>Vorst</td>
										<td>2007/25/04</td>
										<td>26%</td>
										</tr>
										<tr>
										<td>Dominic Carver</td>
										<td>3476</td>
										<td>Pointe-aux-Trembles</td>
										<td>2014/14/03</td>
										<td>71%</td>
										</tr>
										<tr>
										<td>Paki Santos</td>
										<td>4424</td>
										<td>Cache Creek</td>
										<td>2001/18/11</td>
										<td>82%</td>
										</tr>
										<tr>
										<td>Ross Hodges</td>
										<td>1862</td>
										<td>Trazegnies</td>
										<td>2010/19/09</td>
										<td>87%</td>
										</tr>
										<tr>
										<td>Hilda Whitley</td>
										<td>3514</td>
										<td>New Sarepta</td>
										<td>2011/05/07</td>
										<td>94%</td>
										</tr>
										<tr>
										<td>Roth Cherry</td>
										<td>4006</td>
										<td>Flin Flon</td>
										<td>2008/02/09</td>
										<td>8%</td>
										</tr>
										<tr>
										<td>Lareina Jones</td>
										<td>8642</td>
										<td>East Linton</td>
										<td>2009/07/08</td>
										<td>21%</td>
										</tr>
										<tr>
										<td>Joshua Weiss</td>
										<td>2289</td>
										<td>Saint-Léonard</td>
										<td>2010/15/01</td>
										<td>52%</td>
										</tr>
										<tr>
										<td>Kiona Lowery</td>
										<td>5952</td>
										<td>Inuvik</td>
										<td>2002/17/12</td>
										<td>72%</td>
										</tr>
										<tr>
										<td>Nina Rush</td>
										<td>7567</td>
										<td>Bo‘lhe</td>
										<td>2008/27/01</td>
										<td>6%</td>
										</tr>
										<tr>
										<td>Palmer Parker</td>
										<td>2000</td>
										<td>Stade</td>
										<td>2012/24/07</td>
										<td>58%</td>
										</tr>
										<tr>
										<td>Vielka Olsen</td>
										<td>3745</td>
										<td>Vrasene</td>
										<td>2016/08/01</td>
										<td>70%</td>
										</tr>
										<tr>
										<td>Meghan Cunningham</td>
										<td>8604</td>
										<td>Söke</td>
										<td>2007/16/02</td>
										<td>59%</td>
										</tr>
										</tbody>
									</table>
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
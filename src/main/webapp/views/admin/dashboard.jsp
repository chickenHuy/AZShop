<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<main class="page-content">

		<h6 class="mb-0 fw-bold">Revenue Statistic</h6>
		<div>&nbsp;</div>

		<div class="row g-3">
			<div class="col-auto flex-grow-1 overflow-auto">
				<form action="/AZShop/admin/dashboard" method="get" class="d-flex">
					<!-- Use input type "date" for selecting a date -->
					<input type="date" id="selectedDate" name="selectedDate"
						class="form-control">

					<div class="mx-2"></div>

					<!-- Khoảng trắng giữa select và button -->
					<button type="submit" class="btn btn-primary">Filter</button>
				</form>
			</div>
		</div>

		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<div class="row">
			<div class="col-12 col-lg-4">
				<div class="card shadow-none border radius-15">
					<div class="card-body">
						<div class="d-flex align-items-center justify-content-between">
							<div class="fm-icon-box rounded-circle bg-primary text-white">
								<i class="bi bi-google"></i>
							</div>
							<div class="dropdown"></div>
						</div>
						<h5 class="mt-3 mb-0">Revenue In Day</h5>
						<div>&nbsp;</div>
						<h4 class="mb-0 text-primary">${count*1000} VND</h4>
						<div>&nbsp;</div>
						<div class="progress" style="height: 7px;">
							<div class="progress-bar bg-primary" role="progressbar"
								style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-4">
				<div class="card shadow-none border radius-15">
					<div class="card-body">
						<div class="d-flex align-items-center justify-content-between">
							<div class="fm-icon-box  rounded-circle bg-success text-white">
								<i class="bi bi-droplet-fill"></i>
							</div>
							<div class="dropdown"></div>
						</div>
						<h5 class="mt-3 mb-0">Total Revenue</h5>
						<div>&nbsp;</div>
						<h4 class="mb-0 text-success">${total*1000} VND</h4>
						<div>&nbsp;</div>
						<div class="progress" style="height: 7px;">
							<div class="progress-bar bg-success" role="progressbar"
								style="width: 45%;" aria-valuenow="55" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-4">
				<div class="card shadow-none border radius-15">
					<div class="card-body">
						<div class="d-flex align-items-center justify-content-between">
							<div class="fm-icon-box rounded-circle bg-info text-dark">
								<i class="bi bi-microsoft-teams"></i>
							</div>
							<div class="dropdown"></div>
						</div>
						<h5 class="mt-3 mb-0">Total Product</h5>

						<div>&nbsp;</div>
						<h4 class="mb-0 text-info">${totalReview != null ? totalReview : '0'}</h4>
						<div>&nbsp;</div>
						<div class="progress" style="height: 7px;">
							<div class="progress-bar bg-info" role="progressbar"
								style="width: 65%;" aria-valuenow="65" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div>&nbsp;</div>
		<div
			class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
				<div class="card radius-10 bg-danger">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1 text-white">Total Follower</p>
								<h4 class="mb-0 text-white">${totalFL}</h4>
							</div>
							<div class="ms-auto fs-2 text-white">
								<i class="bi bi-cup"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card radius-10 bg-warning">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1 text-white">Total Order</p>
								<h4 class="mb-0 text-white">${totalOrders == null ? '0' : totalOrders}
								</h4>
							</div>
							<div class="ms-auto fs-2 text-white">
								<i class="bi bi-wallet"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card radius-10 bg-primary">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1 text-white">Total Comment</p>
								<h4 class="mb-0 text-white">${totalReview == null ? '0': totalReview}</h4>
							</div>
							<div class="ms-auto fs-2 text-white">
								<i class="bi bi-chat-right"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card radius-10 bg-purple">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1 text-white">Total User</p>
								<h4 class="mb-0 text-white">${totalus}</h4>
							</div>
							<div class="ms-auto fs-2 text-white">
								<i class="bi bi-truck"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end row-->
		<div>&nbsp;</div>
		<div class="row justify-content-around">
			<div class="col">
				<div class="card rounded-4">
					<div class="card-body">
						<a href="/AZShop/customer-home" style="color: white;">
							<div class="d-flex align-items-center justify-content-between">
								<div class="">
									<h4 class="mb-0">Hello: ${userName}</h4>
									<p class="mb-0">Go to Shop</p>
								</div>
								<div class="fs-2">
									<i class="bi bi-apple"></i>
								</div>
							</div>
							<div class="progress rounded-4 my-3 bg-light-transparent-2"
								style="height: 5px;">
								<div class="progress-bar bg-info" role="progressbar"
									style="width: 60%"></div>
							</div> <small class="mb-0">Manage Stores</small>
						</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card rounded-4 bg-texture-info">
					<div class="card-body">
						<a href="/AZShop/admin/admin-info" style="color: white;">
							<div class="d-flex align-items-center justify-content-between">
								<div class="">
									<h4 class="mb-0">SECURITY</h4>
									<p class="mb-0">Manage Account</p>
								</div>
								<div class="fs-2">
									<i class="bi bi-emoji-laughing-fill"></i>
								</div>
							</div>
							<div class="progress rounded-4 my-3 bg-light-transparent-2"
								style="height: 5px;">
								<div class="progress-bar bg-danger" role="progressbar"
									style="width: 60%"></div>
							</div> <small class="mb-0">Check your account details?</small>
						</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card rounded-4 bg-texture-success">
					<div class="card-body">
						<a href="/AZShop/admin/addcategory" style="color: white;">
							<div class="d-flex align-items-center justify-content-between">
								<div class="">
									<h4 class="mb-0">${totalProducts != null ? totalProducts : '0'}
										+</h4>
										
									<p class="mb-0">Add New Category</p>
									
								</div>
								<div class="fs-2">
									<i class="bi bi-bag-plus-fill"></i>
								</div>
							</div>
							<div class="progress rounded-4 my-3 bg-light-transparent-2"
								style="height: 5px;">
								<div class="progress-bar bg-purple" role="progressbar"
									style="width: 60%"></div>
							</div> <small class="mb-0">Do you want to add category?</small>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--end row-->




		<div>&nbsp;</div>
		
		<ul class="list-group list-group-flush mb-0">
			<li
				class="list-group-item border-top d-flex justify-content-between align-items-center bg-transparent">Revenue
				in day<span class="badge bg-success rounded-pill"> ${Math.round((count / total * 100) * 100) / 100}%</span>
			</li>
			<li
				class="list-group-item d-flex justify-content-between align-items-center bg-transparent">Other<span class="badge bg-primary rounded-pill">${Math.round(((total - count) / total * 100) * 100) / 100}%</span>
			</li>
			<li
				class="list-group-item d-flex justify-content-between align-items-center bg-transparent">Total<span
				class="badge bg-danger rounded-pill">100%</span>
			</li>
		</ul>



	</main>
</body>
</html>


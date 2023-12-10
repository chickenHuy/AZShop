<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<body>
	<main class="page-content">

		<h6 class="mb-0 fw-bold">User Statistic</h6>
		<div>&nbsp;</div>
		<div class="row g-3">
			<div class="col-auto flex-grow-1 overflow-auto">
				<form action="/AZShop/admin/UserStatic" method="get" class="d-flex">
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

		<div class="row">
			<div class="col">
				<div
					class="card radius-10 border-0 border-start border-primary border-4">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1">New User</p>
								<h4 class="mb-0 text-primary">${count}</h4>
							</div>
							<div class="ms-auto widget-icon bg-primary text-white">
								<i class="bi bi-basket2-fill"></i>
							</div>
						</div>
						<div class="progress mt-3" style="height: 4.5px;">
							<div class="progress-bar" role="progressbar" style="width: 75%;"
								aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div
					class="card radius-10 border-0 border-start border-success border-4">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1">Total User</p>
								<h4 class="mb-0 text-success">${total}</h4>
							</div>
							<div class="ms-auto widget-icon bg-success text-white">
								<i class="bi bi-currency-dollar"></i>
							</div>
						</div>
						<div class="progress mt-3" style="height: 4.5px;">
							<div class="progress-bar bg-success" role="progressbar"
								style="width: 75%;" aria-valuenow="75" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<h6 class="mb-0 fw-bold">Select day</h6>	
		<div class="row g-3">
			<div class="col-auto flex-grow-1 overflow-auto">
				<form action="/AZShop/admin/UserStatic" method="get" class="d-flex">
					<!-- Khoảng trắng giữa select và button -->
					<select name="quantity" class="form-select">
						<option value="1">last days</option>
						<option value="3">3 days</option>
						<option value="7">7 days</option>
						<option value="30">30 days</option>
						<!-- Add more options as needed -->
					</select>

					<div class="mx-2"></div>

					<button type="submit" class="btn btn-primary">Filter</button>
				</form>
			</div>
		</div>
		<div>&nbsp;</div>
		<h6 class="mb-0 fw-bold">List new user in Last ${day} day</h6>		


		<hr>
		<div class="card">
			<div class="card-body">
				<div class="table-responsive">
					<table id="example2" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>User name</th>
								<th>email</th>
								<th>phone</th>
								<th>address</th>
								<th>role</th>
								<th>point</th>


							</tr>
						</thead>
						<tbody id="revenueTableBody">
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.firstName}${user.lastName}</td>
									<td>${user.email}</td>
									<td>${user.phone}</td>
									<td>${user.address}</td>
									<td>${user.role}</td>
									<td>${user.point}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>


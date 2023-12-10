<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<body>
	<main class="page-content">

		<h6 class="mb-0 fw-bold">Store Statistic</h6>
		<div>&nbsp;</div>
		<div class="row g-3">
			<div class="col-auto flex-grow-1 overflow-auto">
				<form action="/AZShop/admin/StoreStatic" method="get" class="d-flex">
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
					class="card radius-10 border-0 border-start border-danger border-4">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1">New Store</p>
								<h4 class="mb-0 text-danger">${count}</h4>
							</div>
							<div class="ms-auto widget-icon bg-danger text-white">
								<i class="bi bi-basket2-fill"></i>
							</div>
						</div>
						<div class="progress mt-3" style="height: 4.5px;">
							<div class="progress-bar bg-danger" role="progressbar" style="width: 75%;"
								aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div
					class="card radius-10 border-0 border-start border-warning border-4">
					<div class="card-body">
						<div class="d-flex align-items-center">
							<div class="">
								<p class="mb-1">Total Store</p>
								<h4 class="mb-0 text-warning">${total}</h4>
							</div>
							<div class="ms-auto widget-icon bg-warning text-white">
								<i class="bi bi-currency-dollar"></i>
							</div>
						</div>
						<div class="progress mt-3" style="height: 4.5px;">
							<div class="progress-bar bg-warning" role="progressbar"
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
				<form action="/AZShop/admin/StoreStatic" method="get" class="d-flex">
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
		<h6 class="mb-0 fw-bold">List new Store in Last ${day} day</h6>		


		<hr>
		<div class="card mt-4">
			<div class="card-body">
				<div class="table-responsive white-space-nowrap">
					<table id="example2" class="table table-striped table-bordered">
						<thead class="table-light">
							<tr>
								<th>Store ID</th>
								<th>Store Name</th>
								<th>Store Owner</th>
								<th>Creat At</th>
							</tr>
						</thead>
						<tbody id="revenueTableBody">
							<c:forEach var="store" items="${stores}">
								<tr>
									<td>${store.id}</td>
									<td>${store.name}</td>
									<td>${store.ownerId}</td>
									<td>${store.createAt}</td>
									

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>




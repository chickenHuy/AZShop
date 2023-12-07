<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit user level</title>
</head>
<body>
	<main class="page-content">
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">eCommerce</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="userlevel">User
								level</a></li>
						<li class="breadcrumb-item active" aria-current="page">Edit
							user level</li>
					</ol>
				</nav>
			</div>

		</div>
		<div>
			<a href="userlevel"><span class="material-symbols-outlined"
				style="font-size: 24px;"> arrow_back </span></a>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<form action="edituserlevel" method="post">
						<div class="card-body p-4">
							<h5 class="mb-4">Edit user level</h5>
							<div class="row mb-3">
								<label for="input35" class="col-sm-3 col-form-label">Enter
									name of user level</label>
								<div class="col-sm-9">
									<input type="hidden" name="id" value="${userlevel.id }">
									<input type="text" class="form-control" id="input35"
										placeholder="Enter name of user level" name="userlevelname"
										value="${userlevel.name }" readonly="readonly" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="input36" class="col-sm-3 col-form-label">Min
									point</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" id="input36"
										placeholder="Min point" name="minpoint"
										value="${userlevel.minPoint }" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="input37" class="col-sm-3 col-form-label">Discount</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" id="input37"
										placeholder="Enter discount" name="discount"
										value="${userlevel.discount }" required>
								</div>
							</div>

							<div class="row">
								<label class="col-sm-3 col-form-label"></label>
								<div class="col-sm-9">
									<p>${message }</p>
									<div class="d-md-flex d-grid align-items-center gap-3">
										<button type="submit" class="btn btn-primary px-4">Submit</button>
										<button type="button" class="btn btn-danger px-4" data-bs-toggle="modal" data-bs-target="#deleteConfirmationModal">Delete</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<!-- Delete Confirmation Modal -->
	<div class="modal fade" id="deleteConfirmationModal" tabindex="-1"
		aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteConfirmationModalLabel">Delete
						User Level</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to delete this user level?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<form action="deleteuserlevel" method="post">
						<input type="hidden" name="id" value="${userlevel.id}">
						<button type="submit" class="btn btn-danger">Delete</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
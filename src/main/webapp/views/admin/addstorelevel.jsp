<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add store level</title>
</head>
<body>
	<main class="page-content">
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">eCommerce</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="storelevel">Store level</a></li>
						<li class="breadcrumb-item active" aria-current="page">Add store level</li>
					</ol>
				</nav>
			</div>

		</div>
		<div>
			<a href="storelevel"><span class="material-symbols-outlined"
				style="font-size: 24px;"> arrow_back </span></a>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<form action="addstorelevel" method="post">
						<div class="card-body p-4">
							<h5 class="mb-4">Add store level</h5>
							<div class="row mb-3">
								<label for="input35" class="col-sm-3 col-form-label">Enter
									name of store level</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="input35"
										placeholder="Enter name of store level" name="storelevelname" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="input36" class="col-sm-3 col-form-label">Min
									point</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" id="input36"
										placeholder="Min point" name="minpoint" required>
								</div>
							</div>
							<div class="row mb-3">
								<label for="input37" class="col-sm-3 col-form-label">Discount</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" id="input37"
										placeholder="Enter discount" name="discount" required>
								</div>
							</div>

							<div class="row">
								<label class="col-sm-3 col-form-label"></label>
								<div class="col-sm-9">
										<p>${message }</p>
									<div class="d-md-flex d-grid align-items-center gap-3">
										<button type="submit" class="btn btn-primary px-4">Submit</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						<li class="breadcrumb-item active" aria-current="page">Add
							Category</li>
					</ol>
				</nav>
			</div>
		</div>
		<!--end breadcrumb-->
		<form action="addcategory" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-12 col-lg-8">
					<div class="card">
						<div class="card-body">
							<div class="mb-4">
								<h5 class="mb-3">Category Name</h5>
								<input type="text" class="form-control"
									placeholder="write name here...." name="categoryName" value="${category.name }">
							</div>
							<div class="mb-4">
								<h5 class="mb-3">Display images</h5>
								<div class="row g-3">
									<div class="container">
										<div class="row g-3">
											<div class="col-md-6">
												<label class="custom-file-input-wrapper"> <input
													type="file" accept=".jpg, .png, image/jpeg, image/png"
													name="image" class="custom-file-input"
													onchange="handleImageSelection(this, 'thumbnail1')">
													<div class="custom-file-label">Choose Image</div>
												</label>
												<div id="thumbnail1"></div>
												<div id="fileSize1"></div>
											</div>
										</div>
									</div>
									<span id="fileSizeError" style="color: red;"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12 col-lg-4">
					<div class="card">
						<div class="card-body">
							<h5 class="mb-3">Organize</h5>
							<div class="row g-3">
								<div class="col-12">
									<label for="Category" class="form-label fw-bold">Category</label>
									<select class="form-select" id="Category" name="categoryId">
										<option value="">-- Select Category --</option> <!-- Lựa chọn với giá trị null -->
										<c:forEach var="category" items="${listCategory}">
											<option value="${category.id }">${category.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<!--end row-->
						</div>
					</div>

					<div class="card-body">
						<div class="d-flex align-items-center justify-content-between">
							<input type="submit" value="Publish" class="btn btn-primary px-4">
						</div>
					</div>
				</div>
			</div>
			<!--end row-->
		</form>

	</main>
</body>
</html>
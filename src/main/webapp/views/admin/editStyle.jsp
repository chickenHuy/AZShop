<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit store level</title>
</head>
<body>
	<main class="page-content">
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">eCommerce</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="/AZShop/admin/styles">Style</a></li>
						<li class="breadcrumb-item active" aria-current="page">Edit
							Style</li>
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
					<form action="edit" method="post">
						<div class="card-body p-4">
							<h5 class="mb-4">Edit Style</h5>
							<div class="row mb-3">
								<label for="input35" class="col-sm-3 col-form-label">Enter
									name of Style</label>
								<div class="col-sm-9">
									<input type="hidden" name="id" value="${style.id}"> <input
										type="text" class="form-control" id="input35"
										placeholder="Enter name of style" name="styleName"
										value="${style.name}" required>
								</div>
							</div>

							<div class="d-flex">
								<label for="input36" class="form-label fw-bold me-2">Category</label>
								<select class="form-select" id="Category" name="categoryId" id="input36">
									<c:forEach var="item" items="${listCategory}">
										<c:if test="${item.id == style.categoryId}">
											<option value="${item.id}">${item.name}</option>
										</c:if>
									</c:forEach>
									<c:forEach var="item" items="${listCategory}">
										<c:if test="${item.id != style.categoryId}">
											<option value="${item.id}">${item.name}</option>
										</c:if>
									</c:forEach>
								</select>
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
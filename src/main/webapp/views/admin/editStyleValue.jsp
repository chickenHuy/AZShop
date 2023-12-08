<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<main class="page-content">
	<!--breadcrumb-->
	<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
		<div class="breadcrumb-title pe-3">eCommerce</div>
		<div class="ps-3">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb mb-0 p-0">
					<li class="breadcrumb-item"><a href="javascript:;"><i
							class="bx bx-home-alt"></i></a></li>
					<li class="breadcrumb-item active" aria-current="page">Style
						Value</li>
				</ol>
			</nav>
		</div>

	</div>
	<!--end breadcrumb-->


	

	<div class="row g-3">
		<div class="col-auto">
			<form action="editstylevalue" method="post"
				class="d-flex align-items-center justify-content-between">
				<div class="mb-3">
					<div class="d-flex">
						<div class="mb-2 me-5">
							<h5>Style Value Name</h5>
						</div>
					</div>
					<div class="d-flex">
						<input type="hidden" name="id" id="styleIdInput" value="${styleValue.id }">
						<input type="text" class="form-control" style="width: 300px;"
						name="styleValueName" value="${styleValue.name}">
						<input type="submit" value="SAVE"
							class="btn btn-primary px-4 ms-2">
					</div>
				</div>

			</form>
		</div>
	</div>
	<!--end row-->

	

</main>
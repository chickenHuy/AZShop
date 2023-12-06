<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<html lang="en" data-bs-theme="dark">
<head>
</head>
<body>
	<main class="page-content">
			<!--breadcrumb-->
					<c:if test="${message!=null}">
						<div class="alert alert-success border-0 bg-success alert-dismissible fade show">
							<div class="text-white">${message}</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
					</c:if>
					<c:if test="${error!=null}">
						<div class="alert alert-danger border-0 bg-danger alert-dismissible fade show">
							<div class="text-white">${error}</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
					</c:if>
					<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
						<div class="breadcrumb-title pe-3">Order</div>
						<div class="ps-3">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb mb-0 p-0">
									<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
									</li>
									<li class="breadcrumb-item active" aria-current="page">Processing</li>
								</ol>
							</nav>
						</div>
						<div class="ms-auto">
							<div class="btn-group">
								<button type="button" class="btn btn-primary">Settings</button>
								<button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
								</button>
								<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
									<a class="dropdown-item" href="javascript:;">Another action</a>
									<a class="dropdown-item" href="javascript:;">Something else here</a>
									<div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
								</div>
							</div>
						</div>
					</div>
					<!--end breadcrumb-->
					<h6 class="mb-0 text-uppercase">Processing orders</h6>
					<hr>
					<div class="card">
						<div class="card-body">
							<div class="table-responsive">
								<table id="example2" class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Id</th>
											<th>Status</th>
											<th>Delivery</th>
											<th>Date</th>
											<th>Total Receipts</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="order" items="${orders}">
											<tr>
												<td>${order.id}</td>
												<td>
													${order.status}
												</td>
												<td>
													<c:forEach var="delivery" items="${deliverys}">
														<c:if test="${delivery.id == order.deliveryId}">
															${delivery.name}
														</c:if>
													</c:forEach> 
												</td>
												<td>${order.createAt}</td>
												<td>${order.amountToStore} VNĐ</td>
												<td>
													<div class="dropdown text-center">
														<button
															class="btn btn-sm btn-light border dropdown-toggle dropdown-toggle-nocaret"
															type="button" data-bs-toggle="dropdown">
															<i class="fa-solid fa-ellipsis"></i>
														</button>
														<ul class="dropdown-menu">
															<li> <a class="dropdown-item" href='<c:url value="/vendor/order/detail/${order.id}"/>'>Detail</a> </li>
															<c:forEach var="st" items="${status}">
																<c:if test='${order.status != "Cancelled" && order.status != "Completed"}'>
																	<li><a class="dropdown-item" href='<c:url value="/vendor/order/status?id=${order.id}&status=${st}"/>'>Change to ${st}</a></li>
																</c:if>
															</c:forEach>
														</ul>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Id</th>
											<th>Status</th>
											<th>Delivery</th>
											<th>Date</th>
											<th>Total Receipts</th>
											<th>Action</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
	</main>

	
</body>
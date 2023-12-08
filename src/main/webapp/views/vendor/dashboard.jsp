<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

    <!--start main content-->
	<main class="page-content">
				  <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					  <div class="breadcrumb-title pe-3">Store</div>
					  <div class="ps-3">
						  <nav aria-label="breadcrumb">
							  <ol class="breadcrumb mb-0 p-0">
								  <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								  </li>
								  <li class="breadcrumb-item active" aria-current="page">${store.name}</li>
							  </ol>
						  </nav>
					  </div>
				  </div>
		  
		  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10 border-0 border-start border-primary border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Orders</p>
					  <h4 class="mb-0 text-primary">${totalOrders != null ? totalOrders : '0'}</h4>
					</div>
					<div class="ms-auto widget-icon bg-primary text-white">
						<a href="/AZShop/vendor/order/all" style="color: white;"><i class="bi bi-basket2-fill"></i></a>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 border-0 border-start border-success border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Revenue</p>
					  <h4 class="mb-0 text-success">${totalRevenue != null ? totalRevenue : '0'}</h4>
					</div>
					<div class="ms-auto widget-icon bg-success text-white">
						<a href="/AZShop/vendor/statistics-revenue" style="color:white;">
					  <i class="bi bi-currency-dollar"></i>
					</a>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 border-0 border-start border-danger border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Products</p>
					  <h4 class="mb-0 text-danger">${totalProducts != null ? totalProducts : '0'}</h4>
					</div>
					<div class="ms-auto widget-icon bg-danger text-white">
					<a href="/AZShop/vendor/statistics-product" style="color:white;">
					  	<i class="bi bi-graph-down-arrow"></i>
					  </a>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 border-0 border-start border-warning border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Sold In Day</p>
					  <h4 class="mb-0 text-warning">${totalSoldInDay != null ? totalSoldInDay : '0'}</h4>
					</div>
					<div class="ms-auto widget-icon bg-warning text-dark">
					  <i class="bi bi-people-fill"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
		  </div>
		  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10 bg-danger">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1 text-white">Yesterday's Revenue</p>
					  <h4 class="mb-0 text-white">${revenueYday == null ? '0' : revenueYday} VNĐ</h4>
					</div>
					<div class="ms-auto fs-2 text-white">
					  <i class="bi bi-cup"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 bg-info">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1 text-white">AZ Pay</p>
					  <h4 class="mb-0 text-white">${store.eWallet == null ? '0' : store.eWallet} VNĐ</h4>
					</div>
					<div class="ms-auto fs-2 text-white">
					  <i class="bi bi-wallet"></i>
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
					  <p class="mb-1 text-white">Comments</p>
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
			  <div class="card radius-10 bg-primary">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1 text-white">Total completed </p>
					  <h4 class="mb-0 text-white">${totalCompleted != null ? totalCompleted : '0'}</h4>
					</div>
					<div class="ms-auto fs-2 text-white">
					  <i class="bi bi-truck"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
		  </div><!--end row-->
  
  
		  <div class="row row-cols-1 row-cols-lg-3">
			<div class="col">
			  <div class="card rounded-4 bg-primary">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0 text-white">${totalFollows != null ? totalFollows : '0'}</h4>
					  <p class="mb-0 text-white">Total follow</p>
					</div>
					<div class="fs-2 text-white">
					  <i class="bi bi-box2-heart-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-white" role="progressbar" style="width: 60%"></div>
				  </div>
				</div>
			  </div>
			</div>
		  
			<div class="col">
			  <div class="card rounded-4 bg-warning">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0 text-dark">${newReviews != null ? newReviews : '0'}</h4>
					  <p class="mb-0 text-dark">New Review</p>
					</div>
					<div class="fs-2 text-dark">
					  <i class="bi bi-chat-dots-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-opacity-25" style="height:5px;">
					<div class="progress-bar bg-dark" role="progressbar" style="width: 60%"></div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-success">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0 text-white">${store.rating != null ? store.rating : '0'}</h4>
					  <p class="mb-0 text-white">Rating</p>
					</div>
					<div class="fs-2 text-white">
					  <i class="bi bi-share-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-white" role="progressbar" style="width: 60%"></div>
				  </div>
				</div>
			  </div>
			</div>
  
			<div class="col">
			  <div class="card rounded-4">
				<div class="card-body">
				<a href="/AZShop/customer-home" style="color: white;">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">Hello: ${user.firstName}</h4>
					  <p class="mb-0">To AZShop</p>
					</div>
					<div class="fs-2">
					   <i class="bi bi-apple"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-info" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">Are you in the mood for shopping?</small>
				  </a>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-texture-info">
				<div class="card-body">
				<a href = "/AZShop/information" style="color: white;">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">SECURITY</h4>
					  <p class="mb-0">Manage Account</p>
					</div>
					<div class="fs-2">
					  <i class="bi bi-emoji-laughing-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-danger" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">Check your account details?</small>
				  </a>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-texture-success">
				<div class="card-body">
					<a href="/AZShop/vendor/product/new" style="color: white;">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">${countProduct  != null ? countProduct  : '0'}</h4>
					  <p class="mb-0">Add New Product</p>
					</div>
					<div class="fs-2">
					  <i class="bi bi-bag-plus-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-purple" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">Do you have any products you want to sell?</small>
				  </a>
				</div>
			  </div>
			</div>
		  </div><!--end row-->
  
	   </main>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

    <!--start main content-->
	<main class="page-content">
		<!--breadcrumb-->
				  <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					  <div class="breadcrumb-title pe-3">Widgets</div>
					  <div class="ps-3">
						  <nav aria-label="breadcrumb">
							  <ol class="breadcrumb mb-0 p-0">
								  <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								  </li>
								  <li class="breadcrumb-item active" aria-current="page">Static Widgets</li>
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
		  
		  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10 border-0 border-start border-primary border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Orders</p>
					  <h4 class="mb-0 text-primary">248</h4>
					</div>
					<div class="ms-auto widget-icon bg-primary text-white">
					  <i class="bi bi-basket2-fill"></i>
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
					  <h4 class="mb-0 text-success">$1,245</h4>
					</div>
					<div class="ms-auto widget-icon bg-success text-white">
					  <i class="bi bi-currency-dollar"></i>
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
					  <p class="mb-1">Bounce Rate</p>
					  <h4 class="mb-0 text-danger">24.25%</h4>
					</div>
					<div class="ms-auto widget-icon bg-danger text-white">
					  <i class="bi bi-graph-down-arrow"></i>
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
					  <p class="mb-1">New Users</p>
					  <h4 class="mb-0 text-warning">214</h4>
					</div>
					<div class="ms-auto widget-icon bg-warning text-dark">
					  <i class="bi bi-people-fill"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
		  </div><!--end row-->
  
		  <div class="row">
			<div class="col-12 col-lg-4">
			  <div class="card shadow-none border radius-15">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="fm-icon-box rounded-circle bg-primary text-white"><i class="bi bi-google"></i>
					</div>
					<div class="dropdown">
					  <button class="btn btn-sm dropdown-toggle dropdown-toggle-nocaret" type="button" data-bs-toggle="dropdown">
						<i class="bi bi-three-dots me-0"></i>
					  </button>
					  <ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					  </ul>
					</div>
				  </div>
				  <h5 class="mt-3 mb-0">Google Drive</h5>
				  <p class="mb-1 mt-4"><span>45.5 GB</span>  <span class="float-end">50 GB</span>
				  </p>
				  <div class="progress" style="height: 7px;">
					<div class="progress-bar bg-primary" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="col-12 col-lg-4">
			  <div class="card shadow-none border radius-15">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="fm-icon-box  rounded-circle bg-success text-white"><i class="bi bi-droplet-fill"></i>
					</div>
					<div class="dropdown">
					  <button class="btn btn-sm dropdown-toggle dropdown-toggle-nocaret" type="button" data-bs-toggle="dropdown">
						<i class="bi bi-three-dots me-0"></i>
					  </button>
					  <ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					  </ul>
					</div>
				  </div>
				  <h5 class="mt-3 mb-0">Dropbox</h5>
				  <p class="mb-1 mt-4"><span>1,2 GB</span>  <span class="float-end">3 GB</span>
				  </p>
				  <div class="progress" style="height: 7px;">
					<div class="progress-bar bg-success" role="progressbar" style="width: 45%;" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
				  </div>
				</div>
			  </div>
			</div>
			<div class="col-12 col-lg-4">
			  <div class="card shadow-none border radius-15">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="fm-icon-box rounded-circle bg-info text-dark"><i class="bi bi-microsoft-teams"></i>
					</div>
					<div class="dropdown">
					  <button class="btn btn-sm dropdown-toggle dropdown-toggle-nocaret" type="button" data-bs-toggle="dropdown">
						<i class="bi bi-three-dots me-0"></i>
					  </button>
					  <ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					  </ul>
					</div>
				  </div>
				  <h5 class="mt-3 mb-0">OneDrive</h5>
				  <p class="mb-1 mt-4"><span>2,5 GB</span>  <span class="float-end">3 GB</span>
				  </p>
				  <div class="progress" style="height: 7px;">
					<div class="progress-bar bg-info" role="progressbar" style="width: 65%;" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
				  </div>
				</div>
			  </div>
			</div>
		  </div><!--end row-->
  
		  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Notifications</p>
					  <h4 class="mb-0 text-primary">145</h4>
					</div>
					<div class="ms-auto fs-2 text-primary">
					  <i class="bi bi-bell-fill"></i>
					</div>
				  </div>
				  <hr class="my-2">
				  <small class="mb-0"><i class="bi bi-arrow-up"></i> <span>+12.3% from last week</span></small>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Posts</p>
					  <h4 class="mb-0 text-danger">249</h4>
					</div>
					<div class="ms-auto fs-2 text-danger">
					  <i class="bi bi-chat-right-text-fill"></i>
					</div>
				  </div>
				  <hr class="my-2">
				  <small class="mb-0"><i class="bi bi-arrow-up"></i> <span>+10.5% from last week</span></small>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Messages</p>
					  <h4 class="mb-0 text-success">845</h4>
					</div>
					<div class="ms-auto fs-2 text-success">
					  <i class="bi bi-collection-fill"></i>
					</div>
				  </div>
				  <hr class="my-2">
				  <small class="mb-0"><i class="bi bi-arrow-up"></i> <span>+15.8% from last week</span></small>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Articles</p>
					  <h4 class="mb-0 text-orange">645</h4>
					</div>
					<div class="ms-auto fs-2 text-orange">
					  <i class="bi bi-cup-hot-fill"></i>
					</div>
				  </div>
				  <hr class="my-2">
				  <small class="mb-0"><i class="bi bi-arrow-up"></i> <span>+16.5% from last week</span></small>
				</div>
			  </div>
			 </div>
		  </div><!--end row-->
  
		  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10 bg-danger">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1 text-white">Total Orders</p>
					  <h4 class="mb-0 text-white">542</h4>
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
					  <p class="mb-1 text-white">Total Income</p>
					  <h4 class="mb-0 text-white">$875</h4>
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
					  <h4 class="mb-0 text-white">59</h4>
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
					  <p class="mb-1 text-white">Tickets</p>
					  <h4 class="mb-0 text-white">145</h4>
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
					  <h4 class="mb-0 text-white">986</h4>
					  <p class="mb-0 text-white">Total Likes</p>
					</div>
					<div class="fs-2 text-white">
					  <i class="bi bi-box2-heart-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-white" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0 text-white">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
		  
			<div class="col">
			  <div class="card rounded-4 bg-warning">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0 text-dark">856</h4>
					  <p class="mb-0 text-dark">New Comments</p>
					</div>
					<div class="fs-2 text-dark">
					  <i class="bi bi-chat-dots-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-opacity-25" style="height:5px;">
					<div class="progress-bar bg-dark" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0 text-dark">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-success">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0 text-white">356</h4>
					  <p class="mb-0 text-white">Total Shares</p>
					</div>
					<div class="fs-2 text-white">
					  <i class="bi bi-share-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-white" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0 text-white">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
  
			<div class="col">
			  <div class="card rounded-4">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">642</h4>
					  <p class="mb-0">Total Orders</p>
					</div>
					<div class="fs-2">
					   <i class="bi bi-apple"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-info" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-texture-info">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">247</h4>
					  <p class="mb-0">Total Clicks</p>
					</div>
					<div class="fs-2">
					  <i class="bi bi-emoji-laughing-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-danger" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
			<div class="col">
			  <div class="card rounded-4 bg-texture-success">
				<div class="card-body">
				  <div class="d-flex align-items-center justify-content-between">
					<div class="">
					  <h4 class="mb-0">985</h4>
					  <p class="mb-0">Total Views</p>
					</div>
					<div class="fs-2">
					  <i class="bi bi-bag-plus-fill"></i>
					</div>
				  </div>
				  <div class="progress rounded-4 my-3 bg-light-transparent-2" style="height:5px;">
					<div class="progress-bar bg-purple" role="progressbar" style="width: 60%"></div>
				  </div>
				  <small class="mb-0">+2.6% Since Last Week</small>
				</div>
			  </div>
			</div>
		  </div><!--end row-->
  
	   </main>
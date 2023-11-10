<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!doctype html>
<html lang="en" data-bs-theme="dark">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--plugins-->
	<link href="<c:url value='/templates/assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/plugins/metismenu/css/metisMenu.min.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/plugins/simplebar/css/simplebar.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/plugins/bs-stepper/css/bs-stepper.css' />" rel="stylesheet">
	<!-- loader-->
	<link href="<c:url value='/templates/assets/css/pace.min.css' />" rel="stylesheet">
	<script src="<c:url value='/templates/assets/js/pace.min.js' />"></script>
	
	<!--Styles-->
	<link href="<c:url value='/templates/assets/css/bootstrap.min.css' />" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<link href="<c:url value='/templates/assets/css/icons.css' />" rel="stylesheet">
	
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
	<link href="<c:url value='/templates/assets/css/main.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/css/dark-theme.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/css/semi-dark-theme.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/css/minimal-theme.css' />" rel="stylesheet">
	<link href="<c:url value='/templates/assets/css/shadow-theme.css' />" rel="stylesheet">
	
</head>

	<body>
	<!--start stepper one--> 
   
	<div id="stepper1" class="bs-stepper">
	  <div class="card">
		
		<div class="card-header bg-transparent">
			<div class="d-lg-flex flex-lg-row align-items-lg-center justify-content-lg-between" role="tablist">
				<div class="step" data-target="#test-l-1">
				  <div class="step-trigger" role="tab" id="stepper1trigger1" aria-controls="test-l-1">
					<div class="bs-stepper-circle">1</div>
					<div class="">
						<h5 class="mb-0 steper-title">Product Info</h5>
						<p class="mb-0 steper-sub-title">Enter Product Details</p>
					</div>
				  </div>
				</div>
				<div class="bs-stepper-line"></div>
				<div class="step" data-target="#test-l-2">
					<div class="step-trigger" role="tab" id="stepper1trigger2" aria-controls="test-l-2">
					  <div class="bs-stepper-circle">2</div>
					  <div class="">
						  <h5 class="mb-0 steper-title">Media Content</h5>
						  <p class="mb-0 steper-sub-title">Video & Image</p>
					  </div>
					</div>
				  </div>
				<div class="bs-stepper-line"></div>
				<div class="step" data-target="#test-l-3">
					<div class="step-trigger" role="tab" id="stepper1trigger3" aria-controls="test-l-3">
					  <div class="bs-stepper-circle">3</div>
					  <div class="">
						  <h5 class="mb-0 steper-title">Category Selection</h5>
						  <p class="mb-0 steper-sub-title"></p>
					  </div>
					</div>
				  </div>
				  <div class="bs-stepper-line"></div>
					<div class="step" data-target="#test-l-4">
						<div class="step-trigger" role="tab" id="stepper1trigger4" aria-controls="test-l-4">
						<div class="bs-stepper-circle">4</div>
						<div class="">
							<h5 class="mb-0 steper-title">Preview and Confirm</h5>
							<p class="mb-0 steper-sub-title">Experience Details</p>
						</div>
						</div>
					</div>
			  </div>
		</div>
	    <div class="card-body">
		
		  <div class="bs-stepper-content">
			<form onSubmit="return false">
			  <div id="test-l-1" role="tabpanel" class="bs-stepper-pane" aria-labelledby="stepper1trigger1">
				<h5 class="mb-1">Your Personal Information</h5>
				<p class="mb-4">Enter your personal information to get closer to copanies</p>

				<div class="row g-3">
					<div class="col-12 col-lg-6">
						<label for="FisrtName" class="form-label">First Name</label>
						<input type="text" class="form-control" id="FisrtName" placeholder="First Name">
					</div>
					<div class="col-12 col-lg-6">
						<label for="LastName" class="form-label">Last Name</label>
						<input type="text" class="form-control" id="LastName" placeholder="Last Name">
					</div>
					<div class="col-12 col-lg-6">
						<label for="PhoneNumber" class="form-label">Phone Number</label>
						<input type="text" class="form-control" id="PhoneNumber" placeholder="Phone Number">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputEmail" class="form-label">E-mail Address</label>
						<input type="text" class="form-control" id="InputEmail" placeholder="Enter Email Address">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputCountry" class="form-label">Country</label>
						<select class="form-select" id="InputCountry" aria-label="Default select example">
							<option selected>---</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						  </select>
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputLanguage" class="form-label">Language</label>
						<select class="form-select" id="InputLanguage" aria-label="Default select example">
							<option selected>---</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						  </select>
					</div>
					<div class="col-12 col-lg-6">
						<button class="btn btn-primary px-4" onclick="stepper1.next()">Next<i class='bx bx-right-arrow-alt ms-2'></i></button>
					</div>
				</div><!---end row-->
				
			  </div>

			  <div id="test-l-2" role="tabpanel" class="bs-stepper-pane" aria-labelledby="stepper1trigger2">

				<h5 class="mb-1">Account Details</h5>
				<p class="mb-4">Enter Your Account Details.</p>

				<div class="row g-3">
					<div class="col-12 col-lg-6">
						<label for="InputUsername" class="form-label">Username</label>
						<input type="text" class="form-control" id="InputUsername" placeholder="jhon@123">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputEmail2" class="form-label">E-mail Address</label>
						<input type="text" class="form-control" id="InputEmail2" placeholder="example@xyz.com">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputPassword" class="form-label">Password</label>
						<input type="password" class="form-control" id="InputPassword" value="12345678">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputConfirmPassword" class="form-label">Confirm Password</label>
						<input type="password" class="form-control" id="InputConfirmPassword" value="12345678">
					</div>
					<div class="col-12">
						<div class="d-flex align-items-center gap-3">
							<button class="btn btn-outline-secondary px-4" onclick="stepper1.previous()"><i class='bx bx-left-arrow-alt me-2'></i>Previous</button>
							<button class="btn btn-primary px-4" onclick="stepper1.next()">Next<i class='bx bx-right-arrow-alt ms-2'></i></button>
						</div>
					</div>
				</div><!---end row-->
				
			  </div>

			  <div id="test-l-3" role="tabpanel" class="bs-stepper-pane" aria-labelledby="stepper1trigger3">
				<h5 class="mb-1">Your Education Information</h5>
				<p class="mb-4">Inform companies about your education life</p>

				<div class="row g-3">
					<div class="col-12 col-lg-6">
						<label for="SchoolName" class="form-label">School Name</label>
						<input type="text" class="form-control" id="SchoolName" placeholder="School Name">
					</div>
					<div class="col-12 col-lg-6">
						<label for="BoardName" class="form-label">Board Name</label>
						<input type="text" class="form-control" id="BoardName" placeholder="Board Name">
					</div>
					<div class="col-12 col-lg-6">
						<label for="UniversityName" class="form-label">University Name</label>
						<input type="text" class="form-control" id="UniversityName" placeholder="University Name">
					</div>
					<div class="col-12 col-lg-6">
						<label for="InputCountrya" class="form-label">Course Name</label>
						<select class="form-select" id="InputCountrya" aria-label="Default select example">
							<option selected>---</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						  </select>
					</div>
					<div class="col-12">
						<div class="d-flex align-items-center gap-3">
							<button class="btn btn-outline-secondary px-4" onclick="stepper1.previous()"><i class='bx bx-left-arrow-alt me-2'></i>Previous</button>
							<button class="btn btn-primary px-4" onclick="stepper1.next()">Next<i class='bx bx-right-arrow-alt ms-2'></i></button>
						</div>
					</div>
				</div><!---end row-->
				
			  </div>

			  <div id="test-l-4" role="tabpanel" class="bs-stepper-pane" aria-labelledby="stepper1trigger4">
				<h5 class="mb-1">Work Experiences</h5>
				<p class="mb-4">Can you talk about your past work experience?</p>

				<div class="row g-3">
					<div class="col-12 col-lg-6">
						<label for="Experience1" class="form-label">Experience 1</label>
						<input type="text" class="form-control" id="Experience1" placeholder="Experience 1">
					</div>
					<div class="col-12 col-lg-6">
						<label for="Position1" class="form-label">Position</label>
						<input type="text" class="form-control" id="Position1" placeholder="Position">
					</div>
					<div class="col-12 col-lg-6">
						<label for="Experience2" class="form-label">Experience 2</label>
						<input type="text" class="form-control" id="Experience2" placeholder="Experience 2">
					</div>
					<div class="col-12 col-lg-6">
						<label for="PhoneNumber1" class="form-label">Position</label>
						<input type="text" class="form-control" id="PhoneNumber1" placeholder="Position">
					</div>
					<div class="col-12 col-lg-6">
						<label for="Experience3" class="form-label">Experience 3</label>
						<input type="text" class="form-control" id="Experience3" placeholder="Experience 3">
					</div>
					<div class="col-12 col-lg-6">
						<label for="PhoneNumber2" class="form-label">Position</label>
						<input type="text" class="form-control" id="PhoneNumber2" placeholder="Position">
					</div>
					<div class="col-12">
						<div class="d-flex align-items-center gap-3">
							<button class="btn btn-primary px-4" onclick="stepper1.previous()"><i class='bx bx-left-arrow-alt me-2'></i>Previous</button>
							<button class="btn btn-success px-4" onclick="stepper1.next()">Submit</button>
						</div>
					</div>
				</div><!---end row-->
				
			  </div>
			</form>
		  </div>
		   
		</div>
	   </div>
	 </div>
	<!--end stepper one--> 
	<!--plugins-->
	<script src="<c:url value='/templates/assets/js/jquery.min.js' />"></script>
	<script src="<c:url value='/templates/assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js' />"></script>
	<script src="<c:url value='/templates/assets/plugins/metismenu/js/metisMenu.min.js' />"></script>
	<script src="<c:url value='/templates/assets/plugins/simplebar/js/simplebar.min.js' />"></script>
	<script src="<c:url value='/templates/assets/plugins/bs-stepper/js/bs-stepper.min.js' />"></script>
	<script src="<c:url value='/templates/assets/plugins/bs-stepper/js/main.js' />"></script>
	
	<!--BS Scripts-->
	<script src="<c:url value='/templates/assets/js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='/templates/assets/js/main.js' />"></script>

  </body>
</html>
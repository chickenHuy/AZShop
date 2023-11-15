<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<!--start main content-->
	<main class="page-content">
		<h4 class="mb-3">Edit Shop Information</h4>
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<div class="card">
					<div class="card-body">
						<form>
							<div class="container-cover-imagea rounded"
								style="background-color: #252830; min-height: 300px;">
								<div
									class="image d-flex justify-content-center position-relative"
									style="min-height: 300px;">
									<img src=" assets/images/gallery/01.pn"
										style="max-width: 100%; max-height: 100%;">
									<button type="button"
										class="btn btn-sm radius-30 px-4 position-absolute"
										style="background-color: #15161d; color: #fff; bottom: 10px; right: 20px;"
										onmouseover="this.style.color='#d10024'"
										onmouseleave="this.style.color='#fff'">
										<i class="bi bi-file-earmark-image me-2"></i>Change Cover
										Image
									</button>
								</div>
							</div>
							<div class="container-avatar-image">
								<div
									class="mb-4 d-flex flex-column gap-3 align-items-center justify-content-center position-relative"
									style="left: -30%; transform: translateY(-50px); height: 100px;">
									<div class="user-change-photo shadow"
										style="min-height: 140px;">
										<img src="assets/images/avatars/06.pn" alt="...">
									</div>
									<button type="button" class="btn btn-sm radius-30 px-4"
										style="background-color: #15161d; color: #fff; bottom: 10px; right: 20px;"
										onmouseover="this.style.color='#d10024'"
										onmouseleave="this.style.color='#fff'">
										<i class="bi bi-file-earmark-image me-2"></i>Change Avatar
									</button>
								</div>
							</div>
							<h5 class="mb-0 mt-4">Shop Information</h5>
							<hr>
							<div class="row g-3">
								<div class="col-6">
									<label class="form-label">Shop name</label> <input type="text"
										class="form-control" placeholder="Shop name">
								</div>
							</div>
							<hr>
							<div class="row g-3">
								<div class="col-12">
									<label class="form-label">Shop bio</label>
									<textarea class="form-control" rows="4" cols="4"
										placeholder="Describe your shop..."></textarea>
								</div>
							</div>
							<div class="row g-3">
								<div class="col-12">
									<label class="form-label">Shop bio</label>
									<textarea class="form-control" rows="4" cols="4"
										placeholder="Describe your shop..."></textarea>
								</div>
							</div>
							<div class="text-start mt-3 text-end">
								<button type="button" class="btn btn-md radius-30 px-4"
									style="background-color: #15161d; color: #fff; bottom: 10px; right: 20px;"
									onmouseover="this.style.color='#d10024'"
									onmouseleave="this.style.color='#fff'">Save changes</button>
								<button type="button" class="btn btn-md radius-30 px-4"
									style="background-color: #15161d; color: #aaa; bottom: 10px; right: 20px;"
									onmouseover="this.style.color='#d10024'"
									onmouseleave="this.style.color='#fff'">Cancel</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--end row-->


	</main>
	<!--end main content-->

</body>
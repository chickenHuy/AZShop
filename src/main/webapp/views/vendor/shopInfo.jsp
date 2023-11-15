<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
									style="background-color: #404040; min-height: 300px;">
									<div class="image d-flex justify-content-center position-relative"
										style="min-height: 300px;">
										<img src="" id="previewCoverImage" style="max-width: 100%; max-height: 100%;">
										<input type="file" id="coverImage" name="coverImage" style="display: none;"
											accept="image/*"> <label class="button__input--cover-image" for="coverImage"
											style="width: auto; height: auto; padding: 5px 30px; border-radius: 3px; position: absolute; bottom: 10px; right: 20px; background-color: #15161d; color: #fff;"
											onmouseover="this.style.color = '#d10024'"
											onmouseleave="this.style.color='#fff'"> <span>Change
												Cover Photo</span>
										</label>
									</div>
								</div>
								<div class="container-avatar-image">
									<div class="mb-4 d-flex flex-column gap-3 align-items-center justify-content-center position-relative"
										style="left: -35%; transform: translateY(-50px); height: 150px;">
										<div class="user-change-photo shadow-sm" style="min-height: 200px; min-width: 200px;">
											<img id="previewAvatarImage" src="">
										</div>
										<input type="file" id="avatarImage" name="avatarImage" style="display: none;"
											accept="image/*"> <label class="button__input--cover-image" for="avatarImage"
											style="width: auto; height: auto; padding: 5px 30px; border-radius: 3px; background-color: #15161d; color: #fff;"
											onmouseover="this.style.color = '#d10024'"
											onmouseleave="this.style.color='#fff'"> <span>Change Avatar</span>
										</label>
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
								<hr>
								<div class="row g-3">
									<div>
										<label class="form-label">Featured photos of the shop</label> <input type="file"
											id="featuredImage" name="featuredImage" style="display: none;"
											accept="image/*"> <label class="button__input--featured-image"
											for="featuredImage"
											style="width: auto; height: auto; padding: 7px 20px; border-radius: 5px; margin: 0 20px; background-color: #15161d; color: #fff;"
											onmouseover="this.style.color = '#d10024'"
											onmouseleave="this.style.color='#fff'"> <span>Choose
												a photo</span> <i class="fa-solid fa-upload"></i>
										</label>
									</div>
									<div class="col-12 d-flex justify-content-center"
										style="min-height: 250px; background-color: #404040; padding: 15px; border-radius: 5px;">
										<img id="previewFeaturedImage" src=""
											style="max-width: 100%; max-height: 100%;">
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

		<script>
			// Load featured image of the shop for review
			const featuredImageInput = document.getElementById('featuredImage');
			const previewFeaturedImage = document.getElementById('previewFeaturedImage');

			featuredImageInput.addEventListener('change', function (event) {
				const file = featuredImageInput.files[0];
				const reader = new FileReader();

				reader.onload = function (e) {
					previewFeaturedImage.src = e.target.result;
					previewFeaturedImage.style.display = 'block';
				};

				if (file) {
					reader.readAsDataURL(file);
				} else {
					previewFeaturedImage.style.display = 'none';
				}
			});

			// Load cover image of the shop for review
			const coverImageInput = document.getElementById('coverImage');
			const previewCoverImage = document.getElementById('previewCoverImage');
			coverImageInput.addEventListener('change', function (event) {
				const file = coverImageInput.files[0];
				const reader = new FileReader();

				reader.onload = function (e) {
					previewCoverImage.src = e.target.result;
					previewCoverImage.style.display = 'block';
				};

				if (file) {
					reader.readAsDataURL(file);
				} else {
					previewCoverImage.style.display = 'none';
				}
			});

			// Load avatar image of the shop for review
			const avatarImageInput = document.getElementById('avatarImage');
			const previewAvatarImage = document.getElementById('previewAvatarImage');
			avatarImageInput.addEventListener('change', function (event) {
				const file = avatarImageInput.files[0];
				const reader = new FileReader();

				reader.onload = function (e) {
					previewAvatarImage.src = e.target.result;
					previewAvatarImage.style.display = 'block';
				};

				if (file) {
					reader.readAsDataURL(file);
				} else {
					previewAvatarImage.style.display = 'none';
				}
			});
		</script>
	</body>
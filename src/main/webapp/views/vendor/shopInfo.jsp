<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<body>
		<!--start main content-->
		<main class="page-content">
			<div style="display: flex; flex-direction: row; align-items: center">
				<h4 class="mb-3">${!isView?"Edit Shop Information":"Shop Information"}</h4>
				<a href="update-shop-info" ${!isView? 'style="display: none;"' : '' }>
					<button class="button__edit-shop-info"
						style="width: auto; height: auto; padding: 5px 30px; margin: 0 70px; border: none; border-radius: 3px; background-color: #383d42; color: #fff; transform: translateY(-5px);"
						onmouseover="this.style.color = '#d10024'" onmouseleave="this.style.color='#fff'">Edit</button>
				</a>
			</div>
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<div class="card">
						<div class="card-body">
							<form action="update-shop-info" method="post" enctype="multipart/form-data">
								<div class="container-cover-imagea rounded"
									style="background-color: #383d42; min-height: 300px;">
									<div class="image d-flex justify-content-center position-relative"
										style="min-height: 300px;">
										<img src="" id="previewCoverImage" style="max-width: 100%; max-height: 100%;">
										<input type="file" id="coverImage" name="coverImage" style="display: none;"
											accept="image/*"> <label ${isView? 'style="display: none;"' : '' }
											class="button__input--cover-image" for="coverImage"
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
										<div class="user-change-photo shadow-sm"
											style="min-height: 200px; min-width: 200px;">
											<img id="previewAvatarImage" src="">
										</div>
										<input type="file" id="avatarImage" name="avatarImage" style="display: none;"
											accept="image/*"> <label ${isView? 'style="display: none;"' : '' }
											class="button__input--cover-image" for="avatarImage"
											style="width: auto; height: auto; padding: 5px 30px; border-radius: 3px; background-color: #15161d; color: #fff;"
											onmouseover="this.style.color = '#d10024'"
											onmouseleave="this.style.color='#fff'"> <span>Change
												Avatar</span>
										</label>
									</div>
								</div>
								<h5 class="mb-0 mt-4">Shop Information</h5>
								<hr>
								<div class="row g-3">
									<div class="col-6">
										<label class="form-label">Shop name</label> <input type="text"
											class="form-control shopName" placeholder="Shop name" value="${storeInfo.name}" ${isView?'readonly':''}>
									</div>
								</div>
								<hr>
								<div class="row g-3">
									<div class="col-12">
										<label class="form-label">Shop bio</label>
										<textarea class="form-control shopBio" rows="4" cols="4"
											placeholder="Describe your shop..." ${isView?'readonly':''}>${storeInfo.bio}</textarea>
									</div>
								</div>
								<hr>
								<div class="row g-3">
									<div>
										<label class="form-label">Featured photos of the shop</label> <input type="file"
											id="featuredImage" name="featuredImage" style="display: none;"
											accept="image/*"> <label ${isView? 'style="display: none;"' : '' }
											class="button__input--featured-image" for="featuredImage"
											style="width: auto; height: auto; padding: 7px 20px; border-radius: 5px; margin: 0 20px; background-color: #15161d; color: #fff;"
											onmouseover="this.style.color = '#d10024'"
											onmouseleave="this.style.color='#fff'"> <span>Choose
												a photo</span> <i class="fa-solid fa-upload"></i>
										</label>
									</div>
									<div class="col-12 d-flex justify-content-center"
										style="min-height: 250px; background-color: #383d42; padding: 15px; border-radius: 5px;">
										<img id="previewFeaturedImage" src=""
											style="max-width: 100%; max-height: 100%;">
									</div>
								</div>
								<div class="text-start mt-3 text-end">
									<button type="button" class="btn btn-md radius-30 px-4"
										${isView? 'style="display: none;"' : '' } onclick="sendDataToController();"
										style="background-color: #15161d; color: #fff; bottom: 10px; right: 20px;"
										onmouseover="this.style.color='#d10024'"
										onmouseleave="this.style.color='#fff'">Save changes</button>
									<a href="view-shop-info">
										<button type="button" class="btn btn-md radius-30 px-4"
											${isView? 'style="display: none;"' : '' }
											style="background-color: #15161d; color: #aaa; bottom: 10px; right: 20px;"
											onmouseover="this.style.color='#d10024'"
											onmouseleave="this.style.color='#fff'">Cancel</button>
									</a>
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

			function sendDataToController() {
				const shopNameInput = document.querySelector('.shopName').value;
				const shopBioInput = document.querySelector('.shopBio').value;
				const coverImageInput = document.getElementById('coverImage');
				const avatarImageInput = document.getElementById('avatarImage');
				const featuredImageInput = document.getElementById('featuredImage');
				const formData = new FormData();

				if (coverImageInput.files.length > 0) {
					const coverImage = coverImageInput.files[0];
					formData.append('coverImage', coverImage, coverImage.name);
				}

				if (avatarImageInput.files.length > 0) {
					const avatarImage = avatarImageInput.files[0];
					formData.append('avatarImage', avatarImage, avatarImage.name);
				}

				if (featuredImageInput.files.length > 0) {
					const featuredImage = featuredImageInput.files[0];
					formData.append('featuredImage', featuredImage, featuredImage.name);
				}

				formData.append('shopName', shopNameInput);
				formData.append('shopBio', shopBioInput);

				fetch("update-shop-info", {
					method: "POST",
					body: formData,
				})
					.then(function (response) {
						// Đọc nội dung phản hồi từ backend
						if (response.ok) {
							return response.text(); // Hoặc sử dụng response.json() nếu backend trả về dữ liệu JSON
						} else {
							throw new Error("Có lỗi xảy ra khi gửi dữ liệu.");
						}
					})
					.then(function (data) {
						// Xử lý dữ liệu phản hồi và in ra màn hình
						console.log("Dữ liệu đã được gửi thành công:", data);
						// Thực hiện các hành động khác sau khi gửi dữ liệu thành công
					})
					.catch(function (error) {
						console.log("Có lỗi xảy ra:", error);
					});
			}

			// function sendDataToController() {
			// 	var shopName = document.querySelector(".shopName").value;
			// 	var shopBio = document.querySelector(".shopBio").value;
			// 	var coverImage = document.querySelector("#coverImage").value;
			// 	var avatarImage = document.querySelector("#avatarImage").value;
			// 	var featuredImage = document.querySelector("#featuredImage").value;

			// 	var formData = new FormData();
			// 	formData.append("shopName", shopName);
			// 	formData.append("shopBio", shopBio);
			// 	formData.append("coverImage", coverImage);
			// 	formData.append("avatarImage", avatarImage);
			// 	formData.append("featuredImage", featuredImage);

			// 	console.log("FormData values:");
			// 	for (var pair of formData.entries()) {
			// 		console.log(pair[0] + ": " + pair[1]);
			// 	}

			// 	fetch("update-shop-info", {
			// 		method: "POST",
			// 		body: formData,
			// 	})
			// 	.then(function (response) {
			// 		// Đọc nội dung phản hồi từ backend
			// 		if (response.ok) {
			// 			return response.text(); // Hoặc sử dụng response.json() nếu backend trả về dữ liệu JSON
			// 		} else {
			// 			throw new Error("Có lỗi xảy ra khi gửi dữ liệu.");
			// 		}
			// 	})
			// 	.then(function (data) {
			// 		// Xử lý dữ liệu phản hồi và in ra màn hình
			// 		console.log("Dữ liệu đã được gửi thành công:", data);
			// 		// Thực hiện các hành động khác sau khi gửi dữ liệu thành công
			// 	})
			// 	.catch(function (error) {
			// 		console.log("Có lỗi xảy ra:", error);
			// 	});
		</script>
	</body>
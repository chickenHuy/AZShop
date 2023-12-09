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
						<li class="breadcrumb-item"><a
							href="/AZShop/admin/categories">Categories</a></li>
						<li class="breadcrumb-item active" aria-current="page">Edit
							Category</li>
					</ol>
				</nav>
			</div>
		</div>
		<!--end breadcrumb-->
		<form action="edit" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-12 col-lg-8">
					<div class="card">
						<div class="card-body">
							<div class="mb-4">
								<h5 class="mb-3">Category Name</h5>
								<input type="text" class="form-control"
									placeholder="write name here...." name="categoryName"
									value="${category.name }" required> <input
									type="hidden" class="form-control"
									placeholder="write name here...." name="id"
									value="${category.id }">
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
													onchange="handleImageSelection(this, 'thumbnail', 'imgCate')">
													<div class="custom-file-label">Choose Image</div>
												</label>
												<div id="thumbnail">
													<img id="imgCate"
														src="/AZShop/image?fname=${category.image}" alt=""
														width="400" height="400" />
												</div>
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
										<c:forEach var="item" items="${listCategory}">
											<c:if test="${item.id == category.categoryId}">
												<option value="${category.categoryId}">${item.name}</option>

											</c:if>
										</c:forEach>

										<!-- Nếu không có hình ảnh, sử dụng hình ảnh mặc định -->
										<option value="0">--Select Category--</option>

										<c:forEach var="item" items="${listCategory}">
											<c:if test="${item.id != category.categoryId}">
												<option value="${item.id}">${item.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<!--end row-->
						</div>
					</div>

					<div class="card-body">
						<div class="d-flex">
							<input type="submit" value="Save" class="btn btn-primary px-4">
							<button type="button" class="btn btn-danger px-4 ms-2"
								data-bs-toggle="modal" data-bs-target="#deleteConfirmationModal">Delete</button>
						</div>

						<p class="mt-2">${message}</p>
						<!-- Thêm lớp mt-2 để thêm margin-top -->

					</div>
				</div>
			</div>
			<!--end row-->
		</form>

	</main>

	<div class="modal fade" id="deleteConfirmationModal" tabindex="-1"
		aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteConfirmationModalLabel">Delete
						Category</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to delete this category?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancel</button>
					<form action="delete" method="post">
						<input type="hidden" name="slug" value="${category.slug}">
						<button type="submit" class="btn btn-danger">Delete</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
	function handleImageSelection(input, thumbnailId, imgId) {
        var file = input.files[0];
        var thumbnail = document.getElementById(thumbnailId);
        var fileSizeElementId = 'fileSize' + input.name.substring(input.name.length - 1);
        var fileSizeElement = document.getElementById(fileSizeElementId);
        var fileSizeError = document.getElementById('fileSizeError');
        if (file) {
            var reader = new FileReader();
            var previousImageSource = thumbnail.getAttribute('data-previous-source');
            if (previousImageSource != null){
				deleteImage(previousImageSource,thumbnailId)
            }
            reader.onload = function (e) {
            	var img = document.getElementById(imgId);
                img.src = e.target.result;
                img.classList.add('thumbnail');
                img.width = 400;
                img.height = 400; 
                thumbnail.innerHTML = '';
                thumbnail.appendChild(img);
                checkFileSize(input, fileSizeElement, fileSizeError);
            };

            reader.readAsDataURL(file);
        }
    }

    function checkFileSize(input, fileSizeElement, fileSizeError) {
        var fileSize = input.files[0].size;
        var fileSizeFormatted = formatBytes(fileSize);

        if (fileSize > 1.5 * 512 * 512) {
            fileSizeElement.innerHTML = 'Size: ' + fileSizeFormatted;
            fileSizeError.innerHTML = 'The file size of ' + input.name + ' exceeds the allowed limit.';
            input.value = ''; // Clear the selected file so that the user can choose again
        } else {
            fileSizeElement.innerHTML = 'Size: ' + fileSizeFormatted;
            fileSizeError.innerHTML = ''; // Clear the error message if the file size is valid
        }
    }

    function formatBytes(bytes, decimals = 2) {
        if (bytes === 0) return '0 Bytes';

        const k = 512;
        const dm = decimals < 0 ? 0 : decimals;
        const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

        const i = Math.floor(Math.log(bytes) / Math.log(k));

        return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
    }
	</script>
</body>
</html>
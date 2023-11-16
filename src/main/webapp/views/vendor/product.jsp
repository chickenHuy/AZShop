<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>

        <head>
            <style>
                .custom-file-input-wrapper {
                    position: relative;
                    display: inline-block;
                    cursor: pointer;
                }

                .custom-file-input {
                    position: absolute;
                    top: 0;
                    left: 0;
                    opacity: 0;
                    cursor: pointer;
                }

                .custom-file-label {
                    border: 2px dashed #0077cc;
                    padding: 2px 15px;
                    border-radius: 5px;
                    display: inline-block;
                    cursor: pointer;
                    margin: 10px 0;
                    height: 30px;
                }

                .custom-file-label:hover {
                    background-color: #f0faff;
                }

                .thumbnail {
                    max-width: 60px;
                    max-height: 60px;
                    margin: 10px 0;
                    display: block;
                }

                .file-size-error {
                    color: red;
                }
            </style>

        </head>

        <body>

            <main class="page-content">
                <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                    <div class="breadcrumb-title pe-3">Product</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Add Product</li>
                            </ol>
                        </nav>
                    </div>
                </div>
                <form action="${action}" method="post" id="productForm" enctype="multipart/form-data">
                    <input type="hidden" id="isActive" name="isActive">
                    <div class="row">
                        <div class="col-12 col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="mb-4">
                                        <h5 class="mb-3">Product Title</h5>
                                        <input type="text" class="form-control" placeholder="write title here...."
                                            name="name" required>
                                    </div>
                                    <div class="mb-4">
                                        <h5 class="mb-3">Product Description</h5>
                                        <textarea class="form-control" cols="4" rows="6"
                                            placeholder="write a description here.." name="description"
                                            required></textarea>
                                    </div>
                                    <div class="mb-4">
                                        <h5 class="mb-3">Display images</h5>
                                        <div class="row g-3">
                                            <div class="container">
                                                <div class="row g-3">
                                                    <div class="col-md-6">
                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image1"
                                                                required class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail1')">
                                                            <div class="custom-file-label">Choose Image 1</div>
                                                        </label>
                                                        <div id="thumbnail1"></div>
                                                        <div id="fileSize1"></div>

                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image2"
                                                                class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail2')">
                                                            <div class="custom-file-label">Choose Image 2</div>
                                                        </label>
                                                        <div id="thumbnail2"></div>
                                                        <div id="fileSize2"></div>

                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image3"
                                                                class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail3')">
                                                            <div class="custom-file-label">Choose Image 3</div>
                                                        </label>
                                                        <div id="thumbnail3"></div>
                                                        <div id="fileSize3"></div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image4"
                                                                class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail4')">
                                                            <div class="custom-file-label">Choose Image 4</div>
                                                        </label>
                                                        <div id="thumbnail4"></div>
                                                        <div id="fileSize4"></div>

                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image5"
                                                                class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail5')">
                                                            <div class="custom-file-label">Choose Image 5</div>
                                                        </label>
                                                        <div id="thumbnail5"></div>
                                                        <div id="fileSize5"></div>

                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image6"
                                                                class="custom-file-input"
                                                                onchange="handleImageSelection(this, 'thumbnail6')">
                                                            <div class="custom-file-label">Choose Image 6</div>
                                                        </label>
                                                        <div id="thumbnail6"></div>
                                                        <div id="fileSize6"></div>
                                                    </div>
                                                </div>
                                            </div>

                                            <span id="fileSizeError" style="color: red;"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                <div class="mb-4">
                                    <h5 class="mb-3">Inventory</h5>
                                    <div class="container">
                                        <div class="row g-3">
                                            <div class="col-12 col-lg-3">
                                                <div
                                                    class="nav flex-column nav-pills border rounded vertical-pills overflow-hidden">
                                                    <button class="nav-link px-4 rounded-0" data-bs-toggle="pill"
                                                        data-bs-target="#Pricing" type="button"><i
                                                            class="bi bi-tag-fill me-2"></i>Pricing</button>
                                                    <button class="nav-link px-4 rounded-0" data-bs-toggle="pill"
                                                        data-bs-target="#Restock" type="button"><i
                                                            class="bi bi-box-seam-fill me-2"></i>Restock</button>
                                                </div>
                                            </div>
                                            <div class="col-12 col-lg-9">
                                                <div class="tab-content">
                                                    <div class="tab-pane fade" id="Pricing">
                                                        <div class="row g-3">
                                                            <div class="col-12 col-lg-6">
                                                                <h6 class="mb-2">Regular price</h6>
                                                                <input class="form-control" type="text"
                                                                    placeholder="VNĐ" name="price" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="Restock">
                                                        <h6 class="mb-3">Add to Stock</h6>
                                                        <div class="row g-3">
                                                            <div class="col-sm-7">
                                                                <input class="form-control" type="number"
                                                                    placeholder="Quantity" name="quantity" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="col-12 col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <button type="button" class="btn btn-danger px-4"
                                            onclick="discardAction()">Discard</button>
                                        <button type="submit" class="btn btn-success px-4"
                                            onclick="saveDraftAction()">Save Draft</button>
                                        <button type="submit" class="btn btn-primary px-4"
                                            onclick="publishAction()">Publish</button>
                                    </div>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-body">
                                    <h5 class="mb-3">Organize</h5>
                                    <div class="row g-3">
                                        <div class="col-12">
                                            <label for="AddCategory" class="form-label fw-bold">Category</label>
                                            <select class="form-select" id="CategorySelected" name="categoryId"
                                                onchange="loadStyles()" required>
                                                <option value="" disabled selected>Select a Category</option>
                                                <!-- Options sẽ được thêm bởi AJAX -->
                                                <c:forEach var="item" items="${categorys}">
                                                    <option value="${item.id}">${item.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label for="StyleSelected" class="form-label fw-bold">Style</label>
                                            <!-- Thêm thẻ select cho danh sách styles -->
                                            <select class="form-select" id="StyleSelected" name="styleId"
                                                onchange="loadStylesValue()" required>
                                                <option value="" disabled selected>Select a Style</option>
                                                <!-- Options sẽ được thêm bởi AJAX -->
                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label for="AddStyleValue" class="form-label fw-bold">Style Value</label>
                                            <!-- Thêm thẻ select cho danh sách styles -->
                                            <select class="form-select" id="AddStyleValue" name="styleValueId" required>
                                                <option value="" disabled selected>Select a Style Value</option>
                                                <!-- Options sẽ được thêm bởi AJAX -->
                                            </select>
                                        </div>

                                    </div>
                                </div>
                            </div>


                            <div class="card">
                                <div class="card-body">
                                    <h5 class="mb-3">Video Content</h5>
                                    <div class="row g-3">
                                        <div class="col-12">
                                            <label class="custom-file-input-wrapper">
                                                <input type="file" name="video" accept=".mp4" id="fileInputVideo"
                                                    class="custom-file-input" onchange="checkFileVideoSize()" />
                                                <div class="custom-file-label">Choose Video</div>
                                            </label>
                                            <br><span id="fileSizeErrorVideo" style="color: red;"></span>
                                            <div class="card">
                                                <video controls id="selectedVideo"></video>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </form>
            </main>

            <script>
            function discardAction() {
                // Thực hiện hành động khi nhấp vào nút "Discard"
                window.location.href = "/AZShop/vendor/product";
            }

            function saveDraftAction() {
                // Thực hiện hành động khi nhấp vào nút "Save Draft"
                if (validateForm()) {
                    document.getElementById("isActive").value = "false";
                    // Gửi form
                    document.forms[0].submit();
                }
            }

            function publishAction() {
                // Thực hiện hành động khi nhấp vào nút "Publish"
                if (validateForm()) {
                    document.getElementById("isActive").value = "true";
                    // Gửi form
                    document.forms[0].submit();
                }
            }
                
            function validateForm() {
                var name = document.forms["productForm"]["name"].value;
                var description = document.forms["productForm"]["description"].value;
                var image1 = document.forms["productForm"]["image1"].value;
                var category = document.forms["productForm"]["categoryId"].value;
                var style = document.forms["productForm"]["styleId"].value;
                var styleValue = document.forms["productForm"]["styleValueId"].value;
                var quantity = document.forms["productForm"]["quantity"].value;
                var price = document.forms["productForm"]["price"].value;
                

                // Add checks for other required fields
                if (
                    name.trim() === "" ||
                    description.trim() === "" ||
                    image1.trim() === "" ||
                    video.trim() === "" ||
                    category.trim() === "" ||
                    style.trim() === "" ||
                    styleValue.trim() === "" ||
                    quantity.trim()=== "" ||
                    price.trim() === "" ||
                ) {
                    alert("Please fill in all required fields.");
                    return false;
                }
            </script>
            <script>
                function checkFileVideoSize() {
                    var fileInput = document.getElementById('fileInputVideo');
                    var fileSize = fileInput.files[0].size; // kích thước file
                    var maxSize = 40 * 1024 * 1024; // giới hạn kích thước file (ví dụ: 10 MB)
                    var fileSizeError = document.getElementById('fileSizeErrorVideo');
                    var showVideo = document.getElementById('selectedVideo');

                    if (fileSize > maxSize) {
                        fileSizeError.innerHTML = '"The file size must be less than 40MB.';
                        fileInput.value = ''; // Xóa file đã chọn để người dùng có thể chọn lại
                        showVideo.src = '';
                    } else {
                        fileSizeError.innerHTML = ''; // Xóa thông báo nếu kích thước file hợp lệ
                        displaySelectedVideo();
                    }
                }

                function displaySelectedVideo() {
                    var fileInput = document.getElementById('fileInputVideo');
                    var videoElement = document.getElementById('selectedVideo');

                    var file = fileInput.files[0];

                    if (file) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            videoElement.src = e.target.result;
                            videoElement.style.display = 'block';
                        };

                        reader.readAsDataURL(file);
                    }
                }
            </script>

            <script>
                function handleImageSelection(input, thumbnailId) {
                    var file = input.files[0];
                    var thumbnail = document.getElementById(thumbnailId);
                    var fileSizeElementId = 'fileSize' + input.name.substring(input.name.length - 1);
                    var fileSizeElement = document.getElementById(fileSizeElementId);
                    var fileSizeError = document.getElementById('fileSizeError');

                    if (file) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            var img = document.createElement('img');
                            img.src = e.target.result;
                            img.classList.add('thumbnail');
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

                    if (fileSize > 1.5 * 1024 * 1024) {
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

                    const k = 1024;
                    const dm = decimals < 0 ? 0 : decimals;
                    const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

                    const i = Math.floor(Math.log(bytes) / Math.log(k));

                    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
                }
            </script>
            <script>
                function loadStyles() {
                    var categoryId = $("#CategorySelected").val();

                    $.ajax({
                        type: "GET",
                        url: "/AZShop/vendor/product/new?categoryId=" + encodeURIComponent(categoryId),
                        success: function (styles) {
                            // Cập nhật danh sách style
                            updateStyleList(styles);
                        },
                        error: function (xhr, status, error) {
                            console.error("AJAX request failed:", status, error);
                        }
                    });
                }

                function updateStyleList(styles) {
                    var styleSelect = $("#StyleSelected");
                    var styleValueSelect = $("#AddStyleValue");
                    styleSelect.empty();
                    styleSelect.append('<option value="" disabled selected>Select a Style</option>');
                    styleValueSelect.empty();
                    styleValueSelect.append('<option value="" disabled selected>Select a Style Value</option>');
                    $.each(styles, function (index, style) {
                        styleSelect.append('<option value="' + style.id + '">' + style.name + '</option>');
                    });
                }

            </script>

            <script>
                function loadStylesValue() {
                    var styleId = $("#StyleSelected").val();

                    $.ajax({
                        type: "GET",
                        url: "/AZShop/vendor/product/new?styleId=" + encodeURIComponent(styleId),
                        success: function (styleValues) {
                            // Cập nhật danh sách style value
                            updateStyleValueList(styleValues);
                        },
                        error: function (xhr, status, error) {
                            console.error("AJAX request failed:", status, error);
                        }
                    });
                }

                function updateStyleValueList(styleValues) {
                    var styleValueSelect = $("#AddStyleValue");
                    styleValueSelect.empty();
                    styleValueSelect.append('<option value="" disabled selected>Select a Style Value</option>');
                    $.each(styleValues, function (index, styleValue) {
                        styleValueSelect.append('<option value="' + styleValue.id + '">' + styleValue.name + '</option>');
                    });
                }

            </script>
            <script>
                function displayImage(input, thumbnailId) {
                    var file = input.files[0];
                    var thumbnail = document.getElementById(thumbnailId);

                    if (file) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            var img = document.createElement('img');
                            img.src = e.target.result;
                            img.classList.add('thumbnail');
                            thumbnail.innerHTML = '';
                            thumbnail.appendChild(img);
                        };

                        reader.readAsDataURL(file);
                    }
                }
            </script>


        </body>
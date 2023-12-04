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
                .delete-button {
				  opacity: 0.1;
				  display: flex;
				  color: red;
				  width: 22px;
				  height: 22px;
				  background-color: #0077cc;
				  cursor: pointer;
				  border-radius: 50%;
				  display: flex;
				  justify-content: center;
				  align-items: center;
				}
				
				.delete-button:hover {
				  opacity: 1;
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
                    <input type="hidden" id="isActive" name="isActive" value='1'>
                    <div class="row">
                        <div class="col-12 col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="mb-4">
                                        <h5 class="mb-3">Product Title</h5>
                                        <input type="text" class="form-control" placeholder="write title here...."
                                            name="name"  value="${product != null ? product.name : ''}" required>
                                    </div>
                                    <div class="mb-4">
                                        <h5 class="mb-3">Product Description</h5>
                                        <textarea class="form-control" cols="4" rows="6"
                                            placeholder="write a description here.." name="description"
                                            required> ${product != null ? product.description : ''}</textarea>
                                    </div>
                                    <div class="mb-4">
                                        <h5 class="mb-3">Display images</h5> 
                                        <div class="row g-3">
                                            <div class="container">
                                                <div class="row g-3">
                                                    <div class="col-md-6">
                                                        <label class="custom-file-input-wrapper">
                                                            <input type="file"
                                                                accept=".jpg, .png, image/jpeg, image/png" name="image1" class="custom-file-input"
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
                                                                    placeholder="VNĐ" name="price" value="${product != null ? product.price : ''}" required>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="Restock">
                                                        <h6 class="mb-3">Add to Stock</h6>
                                                        <div class="row g-3">
                                                            <div class="col-sm-7">
                                                                <input class="form-control" type="number"
                                                                    placeholder="Quantity" name="quantity" value="${product != null ? product.quantity : ''}" required>
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
                                        <button type="button" id="discard" class="btn btn-danger px-4">
                                            <c:if test="${product == null}">
                                                <a href='<c:url value="/vendor/product/all"/>' style="color: #f0faff;">Discard</a>
                                            </c:if>
                                            <c:if test="${product != null}">
                                                <a href='<c:url value="/vendor/product/delete/${product.slug}"/>' style="color: #f0faff;">Discard</a>
                                            </c:if>
                                        </button>
                                        <button type="submit" class="btn btn-success px-4" onclick="saveDraft()" >Save Draft</button>
                                        <button type="submit" id="publish" class="btn btn-primary px-4" onclick="publish()">Publish</button>
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
											        <c:choose>
											            <c:when test="${product != null && product.categoryId == item.id}">
											                <option value="${item.id}" selected>${item.name}</option>
											            </c:when>
											            <c:otherwise>
											                <option value="${item.id}">${item.name}</option>
											            </c:otherwise>
											        </c:choose>
											    </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label for="StyleSelected" class="form-label fw-bold">Style</label>
                                            <!-- Thêm thẻ select cho danh sách styles -->
                                            <select class="form-select" id="StyleSelected" name="styleId"
                                                onchange="loadStylesValue()" required>
                                                 <c:if test="${styleModelId == null}">
										            <option value="" disabled selected>Select a Style</option>
										         </c:if>
										        
										       
        
                                                <!-- Options sẽ được thêm bởi AJAX -->
                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label for="AddStyleValue" class="form-label fw-bold">Style Value</label>
                                            <!-- Thêm thẻ select cho danh sách styles -->
                                            <select class="form-select" id="AddStyleValue" name="styleValueId" required>
                                                 <c:if test="${product == null}">
										            <option value="" disabled selected>Select a Style</option>
										         </c:if>
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
                                                    class="custom-file-input" onchange="checkFileVideoSize()"/>
                                                <div class="custom-file-label">Choose Video</div>
                                            </label>
                                            <br><span id="fileSizeErrorVideo" style="color: red;"></span>
                                            <div class="card">
                                                <video controls id="selectedVideo"  src="${(product != null && product.video != null) ? '/AZShop/video?fname=' : ''}${(product != null && product.video != null) ? product.video : ''}"></video>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="deletethumbnail1" name="deletethumbnail1" value="0">
					<input type="hidden" id="deletethumbnail2" name="deletethumbnail2" value="0">
					<input type="hidden" id="deletethumbnail3" name="deletethumbnail3" value="0">
					<input type="hidden" id="deletethumbnail4" name="deletethumbnail4" value="0">
					<input type="hidden" id="deletethumbnail5" name="deletethumbnail5" value="0">
					<input type="hidden" id="deletethumbnail6" name="deletethumbnail6" value="0">
                    

                </form>
            </main>

            <script>
            function saveDraft() {

            // Đặt giá trị vào trường ẩn
            document.getElementById("isActive").value = '0';
            }  
            function publish() {

            // Đặt giá trị vào trường ẩn
            document.getElementById("isActive").value = '1';
            }  
                    
            function validateForm() {
                var name = document.forms["productForm"]["name"].value;
                var description = document.forms["productForm"]["description"].value;
                var category = document.forms["productForm"]["categoryId"].value;
                var style = document.forms["productForm"]["styleId"].value;
                var styleValue = document.forms["productForm"]["styleValueId"].value;
                var quantity = document.forms["productForm"]["quantity"].value;
                var price = document.forms["productForm"]["price"].value;
                

                // Add checks for other required fields
                if (
                    name.trim() === "" ||
                    description.trim() === "" ||
                    category.trim() === "" ||
                    style.trim() === "" ||
                    styleValue.trim() === "" ||
                    quantity.trim()=== "" ||
                    price.trim() === ""
                ) {
                    alert("Please fill in all required fields.");
                    return false;
                }
                }
            
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
        
                function handleImageSelection(input, thumbnailId) {
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
                    var styleIdSelected = "${styleModelId}";
                    styleSelect.empty();
                    
                    styleValueSelect.empty();
                    styleValueSelect.append('<option value="" disabled selected>Select a Style Value</option>');
                    $.each(styles, function (index, style) {
                    	if (styleIdSelected != style.id) {
                        	styleSelect.append('<option value="' + style.id + '">' + style.name + '</option>');
                    	}
                    	else
                    	{
                    		styleSelect.append('<option selected value="' + style.id + '">' + style.name + '  </option>');
                    		loadStylesValue();
                    	}
                    });

                    if ( styleIdSelected == "") {
                        styleSelect.append('<option value="" disabled selected>Select a Style</option>');
                    }
                }

            
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
                    var styleValueIdSelected = "${product.styleValueId}";
                    styleValueSelect.empty();
                    $.each(styleValues, function (index, styleValue) {
                        if (styleValueIdSelected != styleValue){
                            styleValueSelect.append('<option value="' + styleValue.id + '">' + styleValue.name + '</option>');
                        }
                        else
                        {
                            styleValueSelect.append('<option selected value="' + styleValue.id + '">' + styleValue.name + '</option>');
                        }
                    });
                    if (styleValueIdSelected == "")
                    {
                        styleValueSelect.append('<option value="" disabled selected>Select a Style Value</option>');
                    }
                    
                }

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
                
                function displayProductInfo() {
                    // Lấy các giá trị của các thuộc tính image từ các trường input
                    var image1Value = getImageValue("${image1}");
                    var image2Value = getImageValue("${image2}");
                    var image3Value = getImageValue("${image3}");
                    var image4Value = getImageValue("${image4}");
                    var image5Value = getImageValue("${image5}");
                    var image6Value = getImageValue("${image6}");

                    // Hiển thị hình ảnh trên các thẻ thumbnail tương ứng
                    displayImageFromSource(image1Value, 'thumbnail1');
                    displayImageFromSource(image2Value, 'thumbnail2');
                    displayImageFromSource(image3Value, 'thumbnail3');
                    displayImageFromSource(image4Value, 'thumbnail4');
                    displayImageFromSource(image5Value, 'thumbnail5');
                    displayImageFromSource(image6Value, 'thumbnail6');
                }

                // Hàm kiểm tra giá trị của image và trả về giá trị hoặc null
                function getImageValue(image) {
                    if (image) {
                        return "/AZShop/image?fname=" + image;
                    } else {
                        return null;
                    }
                }
                // Hàm hiển thị hình ảnh từ nguồn (source) trên một thẻ thumbnail cụ thể
				function displayImageFromSource(source, thumbnailId) {
				    var thumbnail = document.getElementById(thumbnailId);
				
				    if (source) {
				        // Tạo và hiển thị hình ảnh mới
				        var img = document.createElement('img');
				        img.src = source;
				        img.classList.add('thumbnail');
				        thumbnail.innerHTML = '';
				        thumbnail.appendChild(img);
				        thumbnail.setAttribute('data-previous-source', img.src);
				
				        // Tạo nút xóa
				        var deleteButton = document.createElement('span');
				        deleteButton.innerHTML = '<i class="fas fa-times"></i>';
				        deleteButton.classList.add('delete-button');
				
				        // Gắn kết sự kiện click để xóa hình ảnh và gửi yêu cầu AJAX
				        deleteButton.addEventListener('click', function() {
				            deleteImage(source,thumbnailId)
				            thumbnail.innerHTML = '';
				            
				        });
				
				        // Thêm nút xóa vào thumbnail
				        thumbnail.appendChild(deleteButton);
				    }
				}
				function deleteImage(imageSource, thumbnailId) {
				    console.log('Delete button clicked for image ' + thumbnailId);
				    document.getElementById('delete' + thumbnailId).value = '1';
				}

                // Gọi hàm khi trang web được tải
                window.onload = function () {
                    displayProductInfo();
                    loadStyles();
                };


            </script>
			
        </body>
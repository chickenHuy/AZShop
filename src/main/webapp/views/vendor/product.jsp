<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<head>
<style>
    .custom-file-input {
        border: 2px dashed #0077cc;
        padding: 15px; /* Tăng khoảng cách */
        border-radius: 5px;
        display: inline-block;
        cursor: pointer;
        margin: 10px 0; /* Thêm khoảng cách trên và dưới */
    }

    .custom-file-input:hover {
        background-color: #f0faff;
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
                      <input type="text" class="form-control" placeholder="write title here...." name="name" required>
                   </div>
                   <div class="mb-4">
                     <h5 class="mb-3">Product Description</h5>
                     <textarea class="form-control" cols="4" rows="6" placeholder="write a description here.." name="description" required></textarea>
                   </div>
                   <div class="mb-4">
                    <h5 class="mb-3">Display images</h5>
                    <div class="row g-3">
                   		<div class="container">
						    <div class="row g-3">
						        <div class="col-md-6">
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image1" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize1"></div>
						
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image2" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize2"></div>
						
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image3" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize3"></div>
						        </div>
						        <div class="col-md-6">
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image4" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize4"></div>
						
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image5" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize5"></div>
						
						            <input type="file" accept=".jpg, .png, image/jpeg, image/png" name="image6" multiple required class="custom-file-input" onchange="checkFileSize(this)">
						            <div id="fileSize6"></div>
						        </div>
						    </div>
						    <span id="fileSizeError" style="color: red;"></span>
						</div>
					</div>
					    <span id="fileSizeError" style="color: red;"></span>
                  </div>
                  <div class="mb-4">
                    <h5 class="mb-3">Inventory</h5>
                    
                    <div class="row g-3">
                      <div class="col-12 col-lg-3">
                        <div class="nav flex-column nav-pills border rounded vertical-pills overflow-hidden">
                          <button class="nav-link px-4 rounded-0" data-bs-toggle="pill" data-bs-target="#Pricing" type="button"><i class="bi bi-tag-fill me-2"></i>Pricing</button>
                          <button class="nav-link px-4 rounded-0" data-bs-toggle="pill" data-bs-target="#Restock" type="button"><i class="bi bi-box-seam-fill me-2"></i>Restock</button>
                          </div>
                      </div>
                      <div class="col-12 col-lg-9">
                        <div class="tab-content">
                          <div class="tab-pane fade" id="Pricing">
                            <div class="row g-3">
                              <div class="col-12 col-lg-6">
                                <h6 class="mb-2">Regular price</h6>
                                <input class="form-control" type="text" placeholder="VNĐ" name="price" required>
                              </div>
                            </div>
                          </div>
                          <div class="tab-pane fade" id="Restock">
                            <h6 class="mb-3">Add to Stock</h6>
                            <div class="row g-3">
                              <div class="col-sm-7">
                                <input class="form-control" type="number" placeholder="Quantity" name="quantity" required>
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
                    <button type="button" class="btn btn-danger px-4" onclick="discardAction()">Discard</button>
					<button type="submit" class="btn btn-success px-4" onclick="saveDraftAction()">Save Draft</button>
					<button type="submit" class="btn btn-primary px-4" onclick="publishAction()">Publish</button>
                   </div>
                </div>
              </div>
              
              <div class="card">
                <div class="card-body">
                   <h5 class="mb-3">Organize</h5>
                      <div class="row g-3">
                          <div class="col-12">
						    <label for="AddCategory" class="form-label fw-bold">Category</label>
						    <select class="form-select" id="CategorySelected" name="categoryId" onchange="loadStyles()" required>
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
						    <select class="form-select" id="StyleSelected" name="styleId" onchange="loadStylesValue()" required>
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
                           <input type="file" name="video" accept=".mp4" id="fileInputVideo" class="custom-file-input" onchange="checkFileVideoSize()">

    						<br><span id="fileSizeErrorVideo" style="color: red;"></span>
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
        document.getElementById("isActive").value = "false";
        // Gửi form
        document.forms[0].submit();
    }

    function publishAction() {
        // Thực hiện hành động khi nhấp vào nút "Publish"
        document.getElementById("isActive").value = "true";
        // Gửi form
        document.forms[0].submit();
    }
</script>
<script>
    function checkFileVideoSize() {
        var fileInput = document.getElementById('fileInputVideo');
        var fileSize = fileInput.files[0].size; // kích thước file
        var maxSize = 40 * 1024 * 1024; // giới hạn kích thước file (ví dụ: 10 MB)
        var fileSizeError = document.getElementById('fileSizeErrorVideo');

        if (fileSize > maxSize) {
            fileSizeError.innerHTML = '"The file size must be less than 40MB.';
            fileInput.value = ''; // Xóa file đã chọn để người dùng có thể chọn lại
        } else {
            fileSizeError.innerHTML = ''; // Xóa thông báo nếu kích thước file hợp lệ
        }
    }

    function validateForm() {
        // Có thể thêm các kiểm tra khác ở đây nếu cần
        return true; // Cho phép form được gửi đi
    }
</script>

<script>
    function checkFileSize(input) {
        var fileSize = input.files[0].size;
        var fileSizeFormatted = formatBytes(fileSize);
        var fileSizeElementId = 'fileSize' + input.name.substring(input.name.length - 1);
        var fileSizeElement = document.getElementById(fileSizeElementId);
        var fileSizeError = document.getElementById('fileSizeError');

        if (fileSize > 1.5 * 1024 * 1024) {
            fileSizeElement.innerHTML = 'Size: ' + fileSizeFormatted;
            fileSizeError.innerHTML = 'The file size of ' + input.name + ' exceeds the allowed limit.';
            input.value = ''; // Xóa file đã chọn để người dùng có thể chọn lại
        } else {
            fileSizeElement.innerHTML = 'Size: ' + fileSizeFormatted;
            fileSizeError.innerHTML = ''; // Xóa thông báo nếu kích thước file hợp lệ
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

    function validateForm() {
        // Có thể thêm các kiểm tra khác ở đây nếu cần
        return true; // Cho phép form được gửi đi
    }
</script>

   </body>
   		
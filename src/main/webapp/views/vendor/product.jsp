<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
        <form action="" method="post" id="productForm"> 
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
                    <input id="fancy-file-upload" type="file" accept=".jpg, .png, image/jpeg, image/png" name="images" multiple required>
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
                          <input id="fancy-file-upload2" type="file" name="video" > 
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
        window.location.href = "/AZShop/Vendor/Product";
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
function setFormAction(action, productSlug) {
    // Lấy form bằng id
    var myForm = document.getElementById("productForm");

    // Thay đổi hành động của form dựa trên giá trị của "action" và "productSlug"
    if (action === 'insert') {
        myForm.action = "vendor/product/new";
    } else if (action === 'update') {
        // Thêm slug vào đường dẫn
        myForm.action = "vendor/product/edit/" + productSlug;
    }
}
</script>
   </body>
   		
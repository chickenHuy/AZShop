<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Add Product</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Settings</button>
							<button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
							</button>
							<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
              	<a class="dropdown-item" href="javascript:;">Action</a>
								<a class="dropdown-item" href="javascript:;">Another action</a>
								<a class="dropdown-item" href="javascript:;">Something else here</a>
								<div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
							</div>
						</div>
					</div>
				</div>
				<!--end breadcrumb-->
        <form action="addproduct" method="post">
         <div class="row">
            <div class="col-12 col-lg-8">
                <div class="card">
                   <div class="card-body">
                     <div class="mb-4">
                        <h5 class="mb-3">Product Title</h5>
                        <input type="text" class="form-control" placeholder="write title here...." name="productName">
                     </div>
                     <div class="mb-4">
                       <h5 class="mb-3">Product Description</h5>
                       <textarea class="form-control" cols="4" rows="6" placeholder="write a description here.." name="description"></textarea>
                     </div>
                     <div class="mb-4">
                      <h5 class="mb-3">Display images</h5>
                      <input id="fancy-file-upload" type="file" name="files" accept=".jpg, .png, image/jpeg, image/png" multiple>
                    </div>
                    <div class="mb-4">
                      <h5 class="mb-3">Inventory</h5>
                      
                      <div class="row g-3">
                        <div class="col-12 col-lg-9">
                          <div class="tab-content">
                              <div class="row g-3">
                                <div class="col-12 col-lg-6">
                                  <h6 class="mb-2">Regular price</h6>
                                  <input class="form-control" type="text" placeholder="$$$" name="price">
                                </div>
                              </div>
                              <h6 class="mb-3">Add to Stock</h6>
                              <div class="row g-3">
                                <div class="col-sm-7">
                                  <input class="form-control" type="text" placeholder="Quantity" name="quantity">
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
                     <h5 class="mb-3">Organize</h5>
                        <div class="row g-3">
                            <div class="col-12">
                              <label for="Category" class="form-label fw-bold">Category</label>
                              <select class="form-select" id="Category" name="categoryId">
                              	<c:forEach var="category" items="${listCategory}">
                                <option value=${category.id}>${category.name}</option>
                                </c:forEach>
                              </select>
                            </div>
                            <div class="col-12">
                              <label for="StyleValue" class="form-label fw-bold">Style Value</label>
                              <select class="form-select" id="Style" name="styleValueId">
                              	<c:forEach var="styleValue" items="${listStyleValue}">
                                <option value=${styleValue.id}>${styleValue.name}</option>
                                </c:forEach>
                              </select>
                            </div>
                            <div class="col-12">
                              <label for="Store" class="form-label fw-bold">Store</label>
                              <select class="form-select" id="Store" name="storeId">
                              	<c:forEach var="store" items="${listStore}">
                                <option value=${store.id}>${store.name}</option>
                                </c:forEach>
                              </select>
                            </div>
                          </div><!--end row-->
                       </div>
                  </div>
                  
                  <div class="card-body">
                     <div class="d-flex align-items-center justify-content-between">
                      <input type="submit" value="Publish" class="btn btn-primary px-4">
                     </div>
                  </div>
             </div>   
           </div><!--end row-->
          </form>
		 
     </main>
</body>
</html>
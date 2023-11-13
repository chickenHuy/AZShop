<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


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
       
       <div class="row">
          <div class="col-12 col-lg-8">
              <div class="card">
                 <div class="card-body">
                   <div class="mb-4">
                      <h5 class="mb-3">Product Title</h5>
                      <input type="text" class="form-control" placeholder="write title here....">
                   </div>
                   <div class="mb-4">
                     <h5 class="mb-3">Product Description</h5>
                     <textarea class="form-control" cols="4" rows="6" placeholder="write a description here.."></textarea>
                   </div>
                   <div class="mb-4">
                    <h5 class="mb-3">Display images</h5>
                    <input id="fancy-file-upload" type="file" name="files" accept=".jpg, .png, image/jpeg, image/png" multiple>
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
                                <input class="form-control" type="text" placeholder="VNĐ">
                              </div>
                            </div>
                          </div>
                          <div class="tab-pane fade" id="Restock">
                            <h6 class="mb-3">Add to Stock</h6>
                            <div class="row g-3">
                              <div class="col-sm-7">
                                <input class="form-control" type="number" placeholder="Quantity">
                              </div>
                              <div class="col-sm">
                                <button class="btn btn-outline-primary"><i class="bi bi-check2 me-2"></i>Confirm</button>
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
                    <button type="button" class="btn btn-danger px-4">Discard</button>
                    <button type="button" class="btn btn-success px-4">Save Draft</button>
                    <button type="button" class="btn btn-primary px-4">Publish</button>
                   </div>
                </div>
              </div>
              <div class="card">
                <div class="card-body">
                   <h5 class="mb-3">Organize</h5>
                      <div class="row g-3">
                          <div class="col-12">
                            <label for="AddCategory" class="form-label fw-bold">Category</label>
                            <select class="form-select" id="AddCategory">
                              <option value="0">Topwear</option>
                              <option value="1">Bottomwear</option>
                              <option value="2">Casual Tshirt</option>
                              <option value="3">Electronic</option>
                            </select>
                          </div>
                           <div class="col-12">
                            <label for="AddCategory" class="form-label fw-bold">Style</label>
                            <select class="form-select" id="AddCategory">
                              <option value="0">Topwear</option>
                              <option value="1">Bottomwear</option>
                              <option value="2">Casual Tshirt</option>
                              <option value="3">Electronic</option>
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
                          <input id="fancy-file-upload2" type="file" name="video" accept=".mp4">
                       </div>
                        <div class="col-12">
                          <div class="d-grid">
                            <button type="button" class="btn btn-primary">Add Video</button>
                          </div>
                        </div>
                      </div>
                  </div>
                 </div>

              </div>                
          
         </div>
 
   </main>
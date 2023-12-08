<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>
    <main class="page-content">
        <!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Store</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Customer reviews</li>
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
        <div class="card mt-4">
          <div class="card-body">
            <h5 class="mb-3 fw-bold">Ratings & Reviews<span class="fw-light ms-2">(${count})</span></h5>
            <div class="product-table">
              <div class="table-responsive white-space-nowrap">
                 <table class="table align-middle">
                  <thead class="table-light">
                    <tr>
                      <th>Product Name</th>
                      <th>Rating</th>
                      <th>Review</th>
                      <th>Date</th>
                    </tr>
                   </thead>
                   <tbody>
                    <c:forEach var = "review" items="${reviews}">
                        <tr>
                         <td>
                            <c:forEach var = "product" items = "${products}">
                                <c:if test="${product.id eq review.productId}">
                                     <a href="/AZShop/vendor/review/detail?slug=${product.slug}&id=${review.id}" class="product-title">${product.name}</a> 
                                </c:if>
                            </c:forEach>
                        <td>
                            <div class="text-warning">
                                <span>${review.rating}</span>
                                <i class="fa-solid fa-star-half-stroke"></i>
                            </div>
                        </td>
                        <td width="400">${review.content}</td>
                        <td>
                        	${review.updateAt == null ? review.createAt : review.updateAt}
                        </td>
                        </tr>
                    </c:forEach>
                   </tbody>
                 </table>
              </div>
            </div>
          </div>
        </div>


     </main>
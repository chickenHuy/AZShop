<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<body>
	<main class="page-content">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4">
			<div class="col">
			  <div class="card radius-10 border-0 border-start border-primary border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total Product</p>
					  <h4 class="mb-0 text-primary">${totalProduct}</h4>
					</div>
					<div class="ms-auto widget-icon bg-primary text-white">
					  <i class="bi bi-basket2-fill"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 border-0 border-start border-success border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Total sales volume</p>
					  <h4 class="mb-0 text-success">${totalSales}</h4>
					</div>
					<div class="ms-auto widget-icon bg-success text-white">
					  <i class="bi bi-currency-dollar"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
			 <div class="col">
			  <div class="card radius-10 border-0 border-start border-danger border-4">
				<div class="card-body">
				  <div class="d-flex align-items-center">
					<div class="">
					  <p class="mb-1">Best seller</p>
					  <c:if test ="${bestSeller != null}">
					  <a href="/AZShop/vendor/product/${bestSeller.slug}">
					  	<h4 class="mb-0 text-danger">${bestSeller.name}</h4>
					  </a>
					  </c:if>
					  <c:if test ="${bestSeller == null}">
					  	<h4 class="mb-0 text-danger">No products</h4>
					  </c:if>
					</div>
					<div class="ms-auto widget-icon bg-danger text-white">
					  <i class="bi bi-graph-down-arrow"></i>
					</div>
				  </div>
				</div>
			  </div>
			 </div>
            <div class="col">
                <div class="card radius-10 border-0 border-start border-warning border-4">
                  <div class="card-body">
                    <div class="d-flex align-items-center">
                      <div class="">
                        <p class="mb-1">Sold on the day</p>
                        <h4 class="mb-0 text-warning">${totalInDay != null ? totalInDay : '0'}</h4>
                      </div>
                      <div class="ms-auto widget-icon bg-warning text-dark">
                        <i class="bi bi-people-fill"></i>
                      </div>
                    </div>
                  </div>
                </div>
               </div>
            </div>
			<h6 id="selectedDays" class="mb-0 text-uppercase">Top-selling products
			</h6>
			<hr>
			<div class="card">
				<div class="card-body">
					<div class="table-responsive">
						<table id="example2" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Product name</th>
									<th>Price</th>
									<th>Sold</th>
								</tr>
							</thead>
							<tbody id="revenueTableBody">
								<c:forEach var="product" items="${products}">
									<tr>
										<td><a href="/AZShop/vendor/product/${product.slug}">${product.name}</a></td>
										<td>${product.price}</td>
										<td>${product.sold}</td>	
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
    </main>
</body>
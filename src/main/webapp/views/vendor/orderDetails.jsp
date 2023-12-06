<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
<head>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<main class="page-content">
       <!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Store</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Order Details</li>
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

        <div class="card">
          <div class="card-body">
              <div class="d-flex flex-lg-row flex-column align-items-start align-items-lg-center justify-content-between gap-3">
                 <div class="flex-grow-1">
                   <h4 class="fw-bold">Order #${order.id}</h4>
                   <p class="mb-0">Customer ID : <a href="javascript:;">${order.userId}</a></p>
                   <p class="mb-0">Date : ${order.createAt}</p>
                 </div>
                 <div class="overflow-auto">
                  <div class="btn-group position-static">
                    <div class="btn-group position-static">
                      <button type="button" class="btn btn-outline-primary px-4">
                        <i class="bi bi-printer-fill me-2"></i>Print
                      </button>
                    </div>
                  </div>  
                </div>
              </div>
          </div>
        </div>

         <div class="row">
            <div class="col-12 col-lg-8 d-flex">
               <div class="card w-100">
                <div class="card-body">
                  <h5 class="mb-3 fw-bold">Wishlist<span class="fw-light ms-2">(${countItem})</span></h5>
                  <div class="product-table">
                    <div class="table-responsive white-space-nowrap">
                       <table class="table align-middle">
                  <thead class="table-light">
                    <tr>
                     
                      <th>Product Name</th>
                      <th>Quantity</th>
                      <th>Price</th>
                      <th>Total</th>
                    </tr>
                   </thead>
                   <tbody>
                    <c:set var="subtotal" value="0" />
                    <c:forEach var = "product" items = "${products}">
                      <c:forEach var = "orderItem" items = "${orderItems}">
                        <c:if test="${product.id eq orderItem.productId}">
                          <tr>
                            <td>
                              <div class="d-flex align-items-center gap-3">
                                <div class="product-box">
                                  <c:set var="hasImages" value="false" />
                                   <c:forEach var = "image" items="${images}">
                                        <c:if test="${image.productId eq product.id}"> 
                                          <img src="/AZShop/image?fname=${image.image}" alt="">
                                          <c:set var="hasImages" value="true" />
                                        </c:if>
                                  </c:forEach>
                                  <c:if test="${not hasImages}">
                                    <img src="${pageContext.request.contextPath}/templates/static/none.png" alt=""/>
                                  </c:if>
                                  </div>
                                <div class="product-info">
                                <a href="/AZShop/vendor/product/edit/${product.slug}" class="product-title">${product.name}</a>
                                <c:forEach var = "category" items = "${categorys}">
                                  <c:if test="${category.id eq product.categoryId}">
                                    <p class="mb-0 product-category">Category : ${category.name}</p>
                                  </c:if>
                                </c:forEach>
                                </div>
                              </div>
                            </td>
                            <td>${orderItem.count}</td>
                            <td>${product.price} VNĐ</td>
                            <td>${product.price * orderItem.count} VNĐ</td>
                            <c:set var="subtotal" value="${subtotal + (product.price * orderItem.count)}" />
                          </tr>
                        </c:if>
                      </c:forEach>
                    </c:forEach>
                   </tbody>
                 </table>
                    </div>
                  </div>
                  <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fw-bold">Items subtotal :</p>
                    <p class="mb-0 fw-bold">${subtotal} VNĐ</p>
                  </div>
                </div>
               </div>
            </div>
            <div class="col-12 col-lg-4 d-flex">
              <div class="w-100">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title mb-4 fw-bold">Summary</h4>
                  <div>
                    <div class="d-flex justify-content-between">
                      <p class="fw-semi-bold">Items subtotal :</p>
                      <p class="fw-semi-bold">${subtotal} VNĐ</p>
                    </div>
                  <div class="d-flex justify-content-between border-top pt-4">
                    <h5 class="mb-0 fw-bold">Total Receipts:</h5>
                    <h5 class="mb-0 fw-bold">${order.amountToStore} VNĐ</h5>
                  </div>
                </div>
              </div>
              
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title mb-4 fw-bold">Order Status</h4>
                  <label class="form-label" id="orderStatus">${order.status}</label>
                  <select class="form-select" name="orderStatus" id="seletedStatus">
                    <option value="" disabled selected>Change status</option>
                    <c:if test = '${!(order.status eq "Cancelled") && !(order.status eq "Completed")}'>
                    <c:forEach var = "st" items="${status}">
                      <option value="${st}" >Change to ${st}</option>
                    </c:forEach>
                    </c:if>
                  </select>
                </div>
              </div>
            </div>
           </div>
         </div>

        
     </main>

     <script>
      $(document).ready(function() {
          // Xử lý sự kiện khi chọn một trạng thái mới từ dropdown
          $('select[name="orderStatus"]').change(function() {
              var newStatus = $(this).val(); // Lấy giá trị mới từ dropdown
      
              // Gửi AJAX để cập nhật trạng thái
              $.ajax({
                  type: 'GET', // Hoặc 'GET' tùy thuộc vào cách bạn cấu hình server
                  url: '/AZShop/vendor/order/status?id='+ encodeURIComponent("${order.id}") + '&status=' + encodeURIComponent(newStatus), // Thay đổi đường dẫn tới endpoint của server
                  success: function(response) {
                      // Cập nhật trạng thái trên trang
                      $("#orderStatus").text(newStatus);
                  },
                  error: function(error) {
                      // Xử lý lỗi nếu có
                      console.error(error);
                  }
              });
          });
      });
      $(document).ready(function() {
      // Xử lý sự kiện khi nhấn nút in
      $('button.btn-outline-primary:contains("Print")').click(function() {
          // Gọi hàm in trang
          printPage();
      });

      function printPage() {
          // Tạo một chuỗi HTML chứa thông tin bạn muốn in
          var printContent = "<h4>Order #" + "${order.id}" + "</h4>";
          printContent += "<p>Items Subtotal: " + "${subtotal} VNĐ" + "</p>";

          // Thêm thông tin Total Receipts vào chuỗi HTML
          printContent += "<p>Total Receipts: " + "${order.amountToStore} VNĐ" + "</p>";

          // Lặp qua sản phẩm để thêm thông tin sản phẩm
          printContent += "<table>";
          printContent += "<thead><tr><th>Product Name</th><th>Quantity</th><th>Price</th><th>Total</th></tr></thead>";
          printContent += "<tbody>";
          <c:forEach var="product" items="${products}">
              <c:forEach var="orderItem" items="${orderItems}">
                  <c:if test="${product.id eq orderItem.productId}">
                      printContent += "<tr><td>" + "${product.name}" + "</td><td>" + "${orderItem.count}" + "</td><td>" + "${product.price} VNĐ" + "</td><td>" + "${product.price * orderItem.count} VNĐ" + "</td></tr>";
                  </c:if>
              </c:forEach>
          </c:forEach>
          printContent += "</tbody></table>";

          // Tạo một cửa sổ in và hiển thị nội dung cần in
          var printWindow = window.open('', '_blank');
          printWindow.document.open();
          printWindow.document.write('<html><head><title>Print</title></head><body>');
          printWindow.document.write(printContent);
          printWindow.document.write('</body></html>');
          printWindow.document.close();

          // In trang
          printWindow.print();
      }
  });
      </script>
</body>
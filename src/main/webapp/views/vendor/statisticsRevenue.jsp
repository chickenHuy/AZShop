<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
<body>
    <main class="page-content">
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                    <div class="breadcrumb-title pe-3">Statistics</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Revanue</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary">Settings</button>
                            <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
                                <a class="dropdown-item" href="javascript:;">Another action</a>
                                <a class="dropdown-item" href="javascript:;">Something else here</a>
                                <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card radius-10 border-0 border-start border-success border-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">Total Revenue</p> 
                          <h4 class="mb-0 text-success">${totalRevenue == null ? '0' : totalRevenue } VNĐ</h4>
                        </div>
                        <div class="ms-auto widget-icon bg-success text-white">
                          <i class="bi bi-currency-dollar"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card radius-10 border-0 border-start border-primary border-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">AZ Pay</p>
                          <h4 class="mb-0 text-primary">${eWallet == null ? '0' : eWallet } VNĐ</h4>
                        </div>
                        <div class="ms-auto widget-icon bg-primary text-white">
                          <i class="bi bi-basket2-fill"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="customRange1" class="form-label">Select the number of days</label>
                    <input type="range" class="form-range" id="customRange1" min="1" max="100">
                </div>
        
                <h6 id="selectedDays" class="mb-0 text-uppercase">Revenue last 
                    <span id="daysValue">${nDay}</span> day
                </h6>
                <hr>
        
                <div class="card">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="example2" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Date</th>
                                        <th>Revenue</th>
                                    </tr>
                                </thead>
                                <tbody id="revenueTableBody">
                                    <c:forEach var="revenue" items="${revenues}">
	                                    <tr>
	                                        <td>${revenue.date}</td>
	                                        <td>${revenue.revenue}</td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <canvas id="myChart" width="400" height="200"></canvas>
            </main>
            
            <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Lấy giá trị nDay từ server hoặc cách khác
                var nDay = parseInt('${nDay}');

                // Lấy tham chiếu đến phần tử input
                var rangeInput = document.getElementById('customRange1');
                
                // Set giá trị ban đầu cho thanh range
                rangeInput.value = nDay;

                // Tính toán vị trí của nút trượt dựa trên giá trị của thanh range
                var min = rangeInput.min;
                var max = rangeInput.max;
                var percent = ((nDay - min) / (max - min)) * 100;

                // Bắt sự kiện input để cập nhật vị trí khi giá trị thay đổi
                rangeInput.addEventListener('input', function () {
                    var value = rangeInput.value;
                    document.getElementById('daysValue').innerText = value;

                    // Tính toán lại vị trí của nút trượt khi giá trị thay đổi
                    var percent = ((value - min) / (max - min)) * 100;
                });
            });
                var rangeInput = document.getElementById('customRange1');
        
                rangeInput.addEventListener('input', function () {
                    var value = rangeInput.value;
        
                    window.location.href = '/AZShop/vendor/statistics-revenue?nDay=' + value; 
                });
            </script>
        </body>
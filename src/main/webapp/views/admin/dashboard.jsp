<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <main class="page-content">
        <div class="row g-3">
            <div class="col-auto flex-grow-1 overflow-auto">
                <form action="/AZShop/admin/dashboard" method="get" class="d-flex">
                    <!-- Use input type "date" for selecting a date -->
                    <input type="date" id="selectedDate" name="selectedDate" class="form-control">
                    
                    <div class="mx-2"></div>
                    
                    <!-- Khoảng trắng giữa select và button -->
                    <button type="submit" class="btn btn-primary">Filter</button>
                </form>
            </div>
        </div>
        <div>&nbsp;</div>
        
        <div class="row">
            <div class="col">
                <div class="card radius-10 border-0 border-start border-primary border-4">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div class="">
                                <p class="mb-1">New User</p>
                                <h4 class="mb-0 text-primary">${count}</h4>
                            </div>
                            <div class="ms-auto widget-icon bg-primary text-white">
                                <i class="bi bi-basket2-fill"></i>
                            </div>
                        </div>
                        <div class="progress mt-3" style="height: 4.5px;">
                            <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col">
                <div class="card radius-10 border-0 border-start border-success border-4">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div class="">
                                <p class="mb-1">Total User</p>
                                <h4 class="mb-0 text-success">${total}</h4>
                            </div>
                            <div class="ms-auto widget-icon bg-success text-white">
                                <i class="bi bi-currency-dollar"></i>
                            </div>
                        </div>
                        <div class="progress mt-3" style="height: 4.5px;">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>

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

      
         <div class="col">
          <div class="card radius-10 border-0 border-start border-warning border-4">
            <div class="card-body">
              <div class="d-flex align-items-center">
                <div class="">
                  <p class="mb-1">New Users</p>
                  <h4 class="mb-0 text-warning">${count}</h4>
                </div>
                <div class="ms-auto widget-icon bg-warning text-dark">
                  <i class="bi bi-people-fill"></i>
                </div>
              </div>
              <div class="progress mt-3" style="height: 4.5px;">
                <div class="progress-bar bg-warning" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
            </div>
          </div>
         </div>
      

      

        
     </main>
</body>
</html>
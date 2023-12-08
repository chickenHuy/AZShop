<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<head>
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <main class="page-content">
        <c:if test="${message!=null}">
					<div class="alert alert-success border-0 bg-success alert-dismissible fade show">
						<div class="text-white">${message}</div>
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					  </div>
				</c:if>
				<c:if test="${error!=null}">
					<div class="alert alert-danger border-0 bg-danger alert-dismissible fade show">
						<div class="text-white">${error}</div>
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body p-4">
                <h5 class="mb-4">Pickup Address</h5>
                <div class="row mb-3">
                    <label for="input46" class="col-sm-3 col-form-label">Address List</label>
                    <div class="col-sm-9">
                    <select class="form-select" id="input46">
                        <option value="-1" selected >Default</option>
                        <c:forEach var="address" items="${optionAddress}">
                            <option value="${address.id}" data-phone="${address.phone}" data-address="${address.address}">
                                ${address.phone} - ${address.address}
                            </option>
                        </c:forEach>
                     </select>
                    </div>
                </div>
                <form method="post" action="pickup-address">
                    <div class="row mb-3">
                        <label for="input44" class="col-sm-3 col-form-label">Email Address</label>
                        <div class="col-sm-9">
                        <div class="position-relative input-icon">
                            <input type="text" class="form-control" name= "email" id="input44" placeholder="Email Address" disabled value="${user != null ? user.email : ''}">
                            <span class="position-absolute top-50 translate-middle-y"><i class="bi bi-envelope-fill"></i></span>
                        </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="input43" class="col-sm-3 col-form-label">Phone No</label>
                        <div class="col-sm-9">
                        <div class="position-relative input-icon">
                            <input type="text" class="form-control" name= "phone" id="input43" placeholder="Phone No" value="${user != null ? user.phone : ''}">
                            <span class="position-absolute top-50 translate-middle-y"><i class="bi bi-telephone-fill"></i></span>
                        </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="input45" class="col-sm-3 col-form-label">Address</label>
                        <div class="col-sm-9">
                        <div class="position-relative input-icon">
                            <input type="text" class="form-control" name= "address" id="input45" placeholder="Address" value="${user != null ? user.address : ''}">
                            <span class="position-absolute top-50 translate-middle-y"><i class="bi bi-buildings-fill"></i></span>
                        </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-sm-3 col-form-label"></label>
                        <div class="col-sm-9">
                        <div class="d-md-flex d-grid align-items-right gap-3">
                            <button type="submit" class="btn btn-primary px-4">Update</button>
                        </div>
                        </div>
                    </div>
                </form>
            </div>
            </div>
        </div>
        </main>
    
        <script>
             document.getElementById('input46').addEventListener('change', function () {
        var selectedValue = this.value;

        var phoneInput = document.getElementById('input43');
        var addressInput = document.getElementById('input45');

        if (selectedValue === '-1') {
            phoneInput.value = "${user != null ? user.phone : ''}";
            addressInput.value = "${user != null ? user.address : ''}";
        } else {
            // Retrieve data from the selected option's data attributes
            var selectedOption = this.options[this.selectedIndex];
            var selectedPhone = selectedOption.getAttribute('data-phone');
            var selectedAddress = selectedOption.getAttribute('data-address');
            
            // Update phoneInput and addressInput
            phoneInput.value = selectedPhone;
            addressInput.value = selectedAddress;
        }
    });
        </script>
        
</body>
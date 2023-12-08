<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký cửa hàng</title>
  <style>
   	.BodyRegister {
  font-family: Arial, sans-serif;
  background-color: #d21737; /* Đổi màu nền thành #d21737 */
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

    .registration-form {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 20px;
      width: 80%; /* Điều chỉnh kích thước chiều ngang */
      max-width: 600px; /* Giới hạn chiều rộng tối đa */
    }

    .form-group {
      margin-bottom: 15px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .required::before {
      content: "* ";
      color: red;
      font-weight: bold;
      text-align: left; /* Đưa label về phía trái */
      margin-right: 8px;
      width:30%;
    }

    .requiredInput{
      width:70%;
      height: 30px; /* Điều chỉnh chiều cao của ô input */
      padding: 8px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .requiredInput[disabled] {
      background-color: #eee; /* Đặt màu nền mờ cho ô bị vô hiệu hóa */
    }

    .btnDangKy {
      background-color: #D10024;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: right;
    }

    .btnDangKy:hover {
      background-color: #15161d;
    }
  </style>
</head>
<body>
  <div class="BodyRegister">
    <div class="registration-form">
      <h2 style="display: table; margin: 20px auto 40px;">Đăng ký cửa hàng</h2>
      <form action="register-shop" id="register-form" method="post">
        <div class="form-group">
          <label for="shopName" class="required">Tên cửa hàng:</label>
          <input type="text" id="shopName" name="name" required class="requiredInput">
        </div>

        <div class="form-group">
          <label for="email" class="required" class="requiredInput">Email:</label>
          <input type="email" id="email" name="email" value="${user.email}" disabled class="requiredInput">
        </div>

        <div class="form-group">
          <label for="phoneNumber"  class="required" class="requiredInput">Số điện thoại:</label>
        <c:if test="${user.phone != null}">
          <input type="tel" id="phoneNumber" name="phoneNumber" value="${user.phone}" disabled class="requiredInput">
          </c:if>
          <c:if test="${user.phone == null}">
          <input type="tel" id="phoneNumber" name="phoneNumber" value="" required class="requiredInput">
          </c:if>
        </div>

        <div class="form-group">
          <label for="phoneNumber"  class="required" class="requiredInput">Địa chỉ:</label>
          <c:if test="${user.address != null}"> 
          	<input type="tel" id="ad" name="address" value="${user.address}" disabled class="requiredInput">
          </c:if>
          <c:if test="${user.address == null}"> 
          	<input type="tel" id="ad" name="address" value="" required class="requiredInput">
          </c:if>
        </div>

        <button type="submit" class="btnDangKy">Đăng ký</button>
      </form>
    </div>
  </div>
  
  <%
    // Lấy thông báo lỗi từ request
    String error = (String) request.getAttribute("error");

    // Kiểm tra xem có thông báo lỗi không và hiển thị cửa sổ alert
    if (error != null && !error.isEmpty()) {
%>
    <script>
        alert("Lỗi: <%= error %>");
    </script>
<%
    }
%>

</body>
</html>

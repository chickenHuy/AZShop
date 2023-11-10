<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký cửa hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
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

    label {
      font-weight: bold;
      text-align: left; /* Đưa label về phía trái */
      margin-right: 8px;
      width:30%;
    }

    .required::before {
      content: "* ";
      color: red;
    }

    input {
      width:70%;
      height: 30px; /* Điều chỉnh chiều cao của ô input */
      padding: 8px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    input[disabled] {
      background-color: #eee; /* Đặt màu nền mờ cho ô bị vô hiệu hóa */
    }

    button {
      background-color: #D10024;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: right;
    }

    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

  <div class="registration-form">
    <h2 style="display: table; margin: 20px auto 40px;">Đăng ký cửa hàng</h2>
    <form id="register-form">
      <div class="form-group">
        <label for="shopName" class="required">Tên cửa hàng:</label>
        <input type="text" id="shopName" name="shopName" required>
      </div>

      <div class="form-group">
        <label for="email" class="required">Email:</label>
        <input type="email" id="email" name="email" value="example@email.com" disabled>
      </div>

      <div class="form-group">
        <label for="address" class="required">Địa chỉ:</label>
        <input type="text" id="address" name="address" value="123 Street, City" disabled>
      </div>

      <div class="form-group">
        <label for="phoneNumber"  class="required">Số điện thoại:</label>
        <input type="tel" id="phoneNumber" name="phoneNumber" value="123456789" disabled>
      </div>

      <button type="submit">Đăng ký</button>
    </form>
  </div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="width: 500px; height: auto; margin: 50px auto; background-color: #1e1f29; border-radius: 13px; display: flex; flex-direction: column; justify-content: flex-start;">
		<h3 style="color: #fff; margin: 25px auto 30px;">New address
			shipping</h3>
		<form id="addressForm" action="add-address" method="POST"
			style="display: flex; flex-direction: column; align-items: center; justify-content: center; margin: 0 auto;">
			<div style="display: flex; flex-direction: column; width: 100%;">
				<label for="recipientName" style="margin-bottom: 4px; color: #fff;">Recipient
					Name:</label> <input type="text" id="recipientName" name="recipientName"
					required style="margin-bottom: 10px; width: 350px; height: 35px; border-radius: 7px;">
			</div>
			<div style="display: flex; flex-direction: column; width: 100%;">
				<label for="address" style="margin-bottom: 5px; color: #fff;">Address:</label> <input
					type="text" id="address" name="address" required
					style="margin-bottom: 10px; width: 350px; height: 35px; border-radius: 7px;">
			</div>
			<div style="display: flex; flex-direction: column; width: 100%;">
				<label for="phone" style="margin-bottom: 5px; color: #fff;">Phone:</label> <input
					type="text" id="phone" name="phone" required
					style="margin-bottom: 10px; width: 350px; height: 35px; border-radius: 7px;">
			</div>
			<input type="submit" value="Add Address"
				style="width: 150px; padding: 10px; border-radius: 7px; margin: 20px auto; background-color: #4CAF50; color: white; border: none; cursor: pointer;">
		</form>
	</div>
</body>
</html>
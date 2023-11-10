<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

	<div class="billing-details" style="width: 30%; margin: 0 auto">
		<div class="section-title" style="text-align: center;">
			<h3 class="title">Register</h3>
		</div>

		<form action="#" method="post">
			<div class="form-group">
				<input class="input" type="text" name="username"
					placeholder="Username" required>
			</div>
			<div class="form-group">
				<input class="input" type="password" name="password"
					placeholder="Password" required>
			</div>
			<div class="form-group">
				<input class="input" type="text" name="first-name"
					placeholder="First Name" required>
			</div>
			<div class="form-group">
				<input class="input" type="text" name="last-name"
					placeholder="Last Name" required>
			</div>
			<div class="form-group" style="text-align: center;">
				<input class="primary-btn order-submit" style="background: #D10024;"
					type="submit" value="Register">
			</div>
		</form>
	</div>

</body>
</html>
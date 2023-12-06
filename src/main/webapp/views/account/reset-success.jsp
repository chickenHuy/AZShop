<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/account/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/account/css/fontawesome-all.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/account/css/iofrm-style.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/templates/account/css/iofrm-theme22.css" />">
</head>
<body>
	<div class="form-body without-side">
		<div class="row">
			<div class="img-holder">
				<div class="bg"></div>
				<div class="info-holder">
					<img
						src="<c:url value="/templates/account/img/graphic3.svg"></c:url>"
						alt="">
				</div>
			</div>
			<div class="form-holder">
				<div class="form-content">
					<div class="form-items">
						<div class="tick-holder">
							<div class="tick-icon"></div>
						</div>
						<h3>Password link sent</h3>
						<p>Please check your inbox!</p>
						<div class="info-holder">
							<span>Thank you! ?</span> <a
								href="${pageContext.request.contextPath}/login-customer" />Back to login</a>.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <script src="<c:url value='/templates/account/js/jquery.min.js' />"></script>
    <script src="<c:url value='/templates/account/js/popper.min.js' />"></script>
    <script src="<c:url value='/templates/account/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/templates/account/js/main.js' />"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="<c:url value="/templates/account/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/templates/account/css/fontawesome-all.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/templates/account/css/iofrm-style.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/templates/account/css/iofrm-theme22.css" />">
</head>
<body>
    <div class="form-body without-side">

        <div class="row">
            <div class="img-holder">
                <div class="bg"></div>
                <div class="info-holder">
                    <img src="<c:url value="/templates/account/img/graphic3.svg"></c:url>" alt="">
                </div>
            </div>
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Login to account</h3>
						<br>
                        <form action="login-customer" method="post">
                            <input class="form-control" type="text" name="username" placeholder="Username" required>
                            <input class="form-control" type="password" name="password" placeholder="Password" required>
                            <div class="form-button">
                                <button id="submit" type="submit" class="ibtn">Login</button> <a href="<c:url value="/views/account/forget.jsp" />">Forget password?</a>
                            </div>
                        </form>
                        <div class="other-links">
                            <div class="text">Or login with</div>
                            <a href="#"><i class="fab fa-facebook-f"></i>Facebook</a><a href="#"><i class="fab fa-google"></i>Google</a><a href="#"><i class="fab fa-linkedin-in"></i>Linkedin</a>
                        </div>
                        <div class="page-links">
                            <a href="<c:url value="/views/account/register.jsp" />">Register new account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="<c:url value="/templates/account/js/jquery.min.js"></c:url>"></script>
<script src="<c:url value="/templates/account/js/popper.min.js"></c:url>"></script>
<script src="<c:url value="/templates/account/js/bootstrap.min.js"></c:url>"></script>
<script src="<c:url value="/templates/account/js/main.js"></c:url>"></script>
</body>
</html>
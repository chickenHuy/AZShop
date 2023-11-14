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
                        <h3>Password Reset</h3>
                        <p>To reset your password, enter the email address you use to sign in to iofrm</p>
                        <form>
                            <input class="form-control" type="text" name="username" placeholder="E-mail Address" required>
                            <div class="form-button full-width">
                                <button id="submit" type="submit" class="ibtn btn-forget">Send Reset Link</button>
                            </div>
                        </form>
                    </div>
                    <div class="form-sent">
                        <div class="tick-holder">
                            <div class="tick-icon"></div>
                        </div>
                        <h3>Password link sent</h3>
                        <p>Please check your inbox iofrm@iofrmtemplate.io</p>
                        <div class="info-holder">
                            <span>Unsure if that email address was correct?</span> <a href="#">We can help</a>.
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
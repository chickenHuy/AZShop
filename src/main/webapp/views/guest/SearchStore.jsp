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
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<c:forEach var="store" items="${storeList}">
					<!-- shop -->
					<a href='<c:url value="/guest/store/${store.slug}"/>'>
						<div class="col-md-4 col-xs-6">
							<div class="shop">
								<div class="shop-img">
									<img src="/AZShop/image?fname=${store.avatar}" alt="" />
								</div>
								<div class="shop-body">
									<h3>
										${store.avatar}<br>Store
									</h3>
									<a href="#" class="cta-btn">Shop now <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
					</a>
					<!-- /shop -->
				</c:forEach>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->
</body>
</html>
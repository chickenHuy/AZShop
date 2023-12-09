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
	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<h3 class="breadcrumb-header">Checkout</h3>
					<ul class="breadcrumb-tree">
						<li><a href="#">Home</a></li>
						<li class="active">Checkout</li>
					</ul>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<div class="col-md-7">
					<!-- Billing Details -->
					<div class="billing-details">
						<div class="section-title">
							<h3 class="title">Billing address</h3>
						</div>
						<div class="form-group">
							<input class="input" type="text" name="first-name" placeholder="First Name" value="${user.firstName}">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="last-name" placeholder="Last Name" value="${user.lastName}">
						</div>
						<div class="form-group">
							<input class="input" type="email" name="email" placeholder="Email" value="${user.email}">
						</div>
						<div class="form-group">
							<input class="input" type="text" name="address" placeholder="Address" value="${user.address}">
						</div>
						
						<div class="form-group">
							<input class="input" type="tel" name="tel" placeholder="Telephone" value="${user.phone}">
						</div>
						<div class="form-group">
							<div class="input-checkbox">
								<input type="checkbox" id="create-account"> <label
									for="create-account"> <span></span> Create Account?
								</label>
								<div class="caption">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit, sed do eiusmod tempor incididunt.</p>
									<input class="input" type="password" name="password"
										placeholder="Enter Your Password">
								</div>
							</div>
						</div>
					</div>
					<!-- /Billing Details -->

					<!-- Shiping Details -->
					<div class="shiping-details">
						<div class="section-title">
							<h3 class="title">Shiping address</h3>
						</div>
						<div class="input-checkbox">
							<input type="checkbox" id="shiping-address"> <label
								for="shiping-address"> <span></span> Ship to a diffrent
								address?
							</label>
							<div class="caption">
								<div class="form-group">
									<input class="input" type="text" name="first-name"
										placeholder="First Name">
								</div>
								<div class="form-group">
									<input class="input" type="text" name="last-name"
										placeholder="Last Name">
								</div>
								<div class="form-group">
									<input class="input" type="email" name="email"
										placeholder="Email">
								</div>
								<div class="form-group">
									<input class="input" type="text" name="address"
										placeholder="Address">
								</div>
								<div class="form-group">
									<input class="input" type="text" name="city" placeholder="City">
								</div>
								<div class="form-group">
									<input class="input" type="text" name="country"
										placeholder="Country">
								</div>
								<div class="form-group">
									<input class="input" type="text" name="zip-code"
										placeholder="ZIP Code">
								</div>
								<div class="form-group">
									<input class="input" type="tel" name="tel"
										placeholder="Telephone">
								</div>
							</div>
						</div>
					</div>
					<!-- /Shiping Details -->

					<!-- Order notes -->
					<div class="order-notes">
						<textarea class="input" placeholder="Order Notes"></textarea>
					</div>
					<!-- /Order notes -->
				</div>

				<!-- Order Details -->
				<div class="col-md-5 order-details">
					<div class="section-title text-center">
						<h3 class="title">Your Order</h3>
					</div>
					<div class="order-summary">
						<div class="order-col">
							<div>
								<strong>PRODUCT</strong>
							</div>
							<div>
								<strong>TOTAL</strong>
							</div>
						</div>
						<div class="order-products">
							<c:forEach var="cartItem" items="${cartItemList}">
								<div class="order-col">
									<c:forEach var="product" items="${productsInCart}">
										<c:if test="${product.id eq cartItem.productId}">
											<div>${product.name}</div>
											<div>${product.price} VNĐ</div>
										</c:if>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
						<div class="order-col">
							<div>Shiping</div>
							<div>
								<strong>FREE</strong>
							</div>
						</div>
						<div class="order-col">
							<div>
								<strong>TOTAL</strong>
							</div>
							<div>
								<strong class="order-total">${sumPrice} VNĐ</strong>
							</div>
						</div>
					</div>
					<div class="payment-method">
						<c:forEach var="delivery" items="${deliveryList}" varStatus="loop">
							<div class="input-radio">
								<input type="radio" name="payment"
									id="payment-${loop.index + 1}"> <label
									for="payment-${loop.index + 1}"> <span></span>
									${delivery.name} (${delivery.price} VNĐ)
								</label>
								<div class="caption">
									<p>${delivery.description}</p>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="input-checkbox">
						<input type="checkbox" id="terms"> <label for="terms">
							<span></span> I've read and accept the <a href="#">terms &
								conditions</a>
						</label>
					</div>
					<a href="#" class="primary-btn order-submit">Place order</a>
				</div>
				<!-- /Order Details -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION --></html>
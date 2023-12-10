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
	<div id="response--success"
		style="display: none; flex-direction: row; align-items: center; justify-content: center; border-radius: 7px; width: 250px; height: 70px; background-color: rgb(25, 252, 101); position: fixed; z-index: 1; right: 3vw; top: 10vh;">
		<div class="response__icon--success"
			style="color: #000; font-size: 1.7em; margin: 0 10px;">
			<i class="fa-solid fa-circle-check"></i>
		</div>
		<div class="response__messag--success"
			style="color: #000; font-size: 1.1em; margin: 0 10px;">Order
			success!!!</div>
	</div>
	<div id="response--error"
		style="display: none; flex-direction: row; align-items: center; justify-content: center; border-radius: 7px; width: 370px; height: 70px; background-color: #d10024; position: fixed; z-index: 1; right: 3vw; top: 10vh;">
		<div class="response__icon--error"
			style="color: #000; font-size: 1.5em; margin: 0 10px;">
			<i class="fa-solid fa-circle-exclamation"></i>
		</div>
		<div class="response__messag--error"
			style="color: #000; font-size: 1.1em; margin: 0 10px;">Please
			choose a shipping method!!!</div>
	</div>
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
					<div class="billing-details">
						<div class="section-title">
							<h3 class="title">Billing information</h3>
						</div>
						<label>Recipient name</label>
						<div class="form-group">
							<input class="input" type="text" name="name" readonly
								placeholder="Recipient name" required="required"
								value="${user.firstName} ${user.lastName}">
						</div>
						<label>Email</label>
						<div class="form-group">
							<input class="input" type="email" name="email" readonly
								placeholder="Email" required="required" value="${user.email}">
						</div>
						<label>Address shipping</label>
						<div class="form-group">
							<input class="input" type="text" name="address" readonly
								placeholder="Address" required="required"
								value="${user.address}">
						</div>
						<label>Phone number</label>
						<div class="form-group">
							<input class="input" type="tel" name="phone" readonly
								placeholder="Telephone" required="required"
								value="${user.phone}">
						</div>
						<label>Other address shipping</label>
						<div class="form-group">
							<select id="addressSelect" name="otherAddress"
								style="width: 100%; height: 40px; border-color: #E4E7ED">
								<option class="input" value="0" selected="selected"></option>
								<c:forEach var="item" items="${listAddress}">
									<optgroup label="Address">
										<option value="${item.id}">
											<p>${item.recipientName}</p>
											<p>,</p>
											<p>${item.address}</p>
											<p>,</p>
											<p>${item.phone}</p>
										</option>
									</optgroup>
								</c:forEach>
							</select>
						</div>
					</div>

				</div>

				<!-- Order Details -->
				<div class="col-md-5 order-details">
					<div class="section-title text-center">
						<h3 class="title">Your Order</h3>
					</div>
					<div class="order-summary">
						<div class="order-col">
							<div></div>
							<div></div>
						</div>
						<div class="order-products">
							<c:forEach var="cart" items="${cartList}">
								<label class="nameStore-count">${cart.nameStore}</label>
								<c:forEach var="cartItem" items="${cartItemList}">
									<c:if test="${cartItem.cartId eq cart.id}">
										<div class="order-col">
											<c:forEach var="product" items="${productsInCart}">
												<c:if test="${product.id eq cartItem.productId}">
													<div
														style="width: 100%; display: flex; flex-direction: row; justify-content: space-between;">
														<div style="width: 60%; text-align: left">
															${product.name}</div>
														<div
															style="width: 40%; display: flex; flex-direction: row; justify-content: flex-end;">
															<div class="${product.id}" style="text-align: right;">${product.price}VNĐ
															</div>
															<span style="margin: 0 3px;">x</span><span>${cartItem.count}</span>
														</div>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</div>
						<div class="order-col">
							<div>
								<strong>Total product cost</strong>
							</div>
							<div>
								<strong class="order-total-product"> <c:set
										var="sumPrice" value="${sumPrice}" /> <script>
												function formatPrice(price) {
													var formattedPrice = price
														.toLocaleString(
															undefined,
															{
																minimumFractionDigits: price % 1 === 0 ? 0
																	: 3,
															});
													return formattedPrice;
												}
												var sumPriceElement = document
													.querySelector(".order-total-product");
												var sumPrice = parseFloat("${sumPrice}");
												sumPriceElement.textContent = formatPrice(sumPrice)
													+ " VNĐ";
											</script>
								</strong>
							</div>
						</div>
					</div>
					<div class="payment-method">
						<c:forEach var="delivery" items="${deliveryList}" varStatus="loop">
							<div class="input-radio">
								<input type="radio" name="payment"
									id="payment-${loop.index + 1}" value="${delivery.id}">
								<label for="payment-${loop.index + 1}"> <span></span>
									${delivery.name} (${delivery.price} VNĐ)
								</label>
								<div class="caption">
									<p>${delivery.description}</p>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="order-col"
						style="width: 100%; display: flex; flex-direction: row;">
						<div style="width: 30%; text-align: left;">
							<strong style="font-size: 1.5em;">Total</strong>
						</div>
						<div style="width: 70%; text-align: right;">
							<strong style="font-size: 1.5em; color: #d10024;"
								class="order-total"> <c:set var="sumPrice"
									value="${sumPrice}" /> <script>
											function formatPrice(price) {
												var formattedPrice = price
													.toLocaleString(
														undefined,
														{
															minimumFractionDigits: price % 1 === 0 ? 0
																: 3,
														});
												return formattedPrice;
											}
											var sumPriceElement = document
												.querySelector(".order-total");
											var sumPrice = parseFloat("${sumPrice}");
											sumPriceElement.textContent = formatPrice(sumPrice)
												+ " VNĐ";
										</script>
							</strong>
						</div>
					</div>

					<button style="width: 100%;" class="primary-btn order-submit">Place
						order</button>
				</div>
				<!-- /Order Details -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->
</html>


<script>
			document.addEventListener('DOMContentLoaded', function () {
				var radioButtons = document.querySelectorAll('input[name="payment"]');

				radioButtons.forEach(function (radioButton) {
					radioButton.addEventListener('change', function () {
						var selectedId = radioButton.getAttribute('deliveryId');
					});
				});
			});

			var paymentRadios = document.getElementsByName("payment");
			for (var i = 0; i < paymentRadios.length; i++) {
				paymentRadios[i].addEventListener("change", totalPrice);
			}

			function totalPrice() {
				var countStore = document.querySelectorAll(".nameStore-count").length;
				var orderTotal = parseFloat(document
					.querySelector(".order-total-product").textContent.trim().replace(/,/g, ''));
				console.log(this.nextElementSibling.textContent
					.split('(')[1].split(' ')[0].trim().replace(/,/g, ''));
				var selectedPaymentContent = parseFloat(this.nextElementSibling.textContent
					.split('(')[1].split(' ')[0].trim().replace(/,/g, ''));
				var totalPrice = orderTotal + selectedPaymentContent * countStore;
				var orderTotalElement = document.querySelector(".order-total");
				orderTotalElement.textContent = totalPrice.toLocaleString() + "VNĐ";
			}

			var placeOrderButton = document.getElementsByClassName("primary-btn order-submit")[0];
			placeOrderButton.addEventListener("click", sendDataToServer);

			function sendDataToServer() {
				  var otherAddress = document.getElementsByName("otherAddress")[0].value;
				  var selectedPaymentValue = "0";

				  for (var i = 0; i < paymentRadios.length; i++) {
				    if (paymentRadios[i].checked) {
				      selectedPaymentValue = paymentRadios[i].value;
				      break;
				    }
				  }
				  var payload = {
				    otherAddress: otherAddress,
				    shippingValue: selectedPaymentValue
				  };

				  var url = "checkout-comfirm";
				  var options = {
				    method: "POST",
				    headers: {
				      "Content-Type": "application/json"
				    },
				    body: JSON.stringify(payload)
				  };
				  fetch(url, options)
				  .then(function(response) {
					    if (response.ok) {
					      return response.json();
					    } else {
					      throw new Error("Gửi dữ liệu thất bại");
					    }
					  })
					  .then(function(data) {
					    console.log("Dữ liệu nhận được từ máy chủ: ", data);
					    if(data.status == "Error"){
					    	var messageSuccess = document.getElementById("response--error");
							messageSuccess.style.display = "flex";
							setTimeout(function () {
								messageSuccess.style.transform = "translateX(calc(370px + 3vw))";
								messageSuccess.style.transition = "all .7s linear";
							}, 5000);

							setTimeout(function () {
								messageSuccess.style.transform = "";
								messageSuccess.style.transition = "";
								messageSuccess.style.display = "none";
							}, 7500);
					    }
					    else{
					    	if(data.status == "Success"){
					    		var messageSuccess = document.getElementById("response--success");
								messageSuccess.style.display = "flex";
								setTimeout(function () {
									messageSuccess.style.transform = "translateX(calc(250px + 3vw))";
									messageSuccess.style.transition = "all .7s linear";
								}, 5000);

								setTimeout(function () {
									messageSuccess.style.transform = "";
									messageSuccess.style.transition = "";
									messageSuccess.style.display = "none";
								}, 5500);
					    	}
					    }
					  })
					  .catch(function(error) {
					    console.log("Đã xảy ra lỗi: ", error);
					  });
				}
		</script>
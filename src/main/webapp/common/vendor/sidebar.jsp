<aside class="sidebar-wrapper">
	<div class="sidebar-header">
		<div class="logo-icon">
			<img src="assets/images/logo-icon.png" class="logo-img" alt="">
		</div>
		<div class="logo-name flex-grow-1">
			<h5 class="mb-0">AZSHOP</h5>
		</div>
		<div class="sidebar-close ">
			<span class="material-symbols-outlined">close</span>
		</div>
	</div>
	<div class="sidebar-nav" data-simplebar="true">

		<!--navigation-->
		<ul class="metismenu" id="menu">
			<li><a href="/AZShop/vendor/dashboard">
					<div class="parent-icon">
						<span class="material-symbols-outlined">home</span>
					</div>
					<div class="menu-title">Dashboard</div>
			</a></li>
			<li class="menu-label">Management</li>
			<li><a href="javascript:;" class="has-arrow">
					<div class="parent-icon">
						<span class="material-symbols-outlined">widgets</span>
					</div>
					<div class="menu-title">Product</div>
			</a>
				<ul>
					<li><a href="<c:url value="/vendor/product/all"/>"><span
							class="material-symbols-outlined">arrow_right</span>Product List</a></li>
					<li><a href="<c:url value="/vendor/product/new"/>"><span
							class="material-symbols-outlined">arrow_right</span>Add Product</a></li>
				</ul></li>
			<li><a href="javascript:;" class="has-arrow">
					<div class="parent-icon">
						<span class="material-symbols-outlined">shopping_cart</span>
					</div>
					<div class="menu-title">Order</div>
			</a>
				<ul>
					<li><a href="<c:url value="/vendor/order/all"/>"><span
							class="material-symbols-outlined">arrow_right</span>All Order</a></li>
					<li><a href="<c:url value="/vendor/order/processed"/>"><span
							class="material-symbols-outlined">arrow_right</span>Processed Order</a></li>
					<li><a href="<c:url value="/vendor/order/cancelled"/>"><span
							class="material-symbols-outlined">arrow_right</span>Cancelled Order</a></li>
				</ul></li>
			<li class="menu-label">Pages</li>
			<li><a href="user-profile.html">
					<div class="parent-icon">
						<span class="material-symbols-outlined">account_circle</span>
					</div>
					<div class="menu-title">Profile</div>
			</a></li>
			<li><a href="/AZShop/vendor/review">
					<div class="parent-icon">
						<span class="material-symbols-outlined">hotel_class</span>
					</div>
					<div class="menu-title">Customer Reviews</div>
			</a></li>
			<li><a href="/AZShop/vendor/pickup-address">
					<div class="parent-icon">
						<span class="material-symbols-outlined">call</span>
					</div>
					<div class="menu-title">Pickup address</div>
			</a></li>
			<li>
				<a href="<c:url value='/information' />">
                    <div class="parent-icon">
                    	<span class="material-symbols-outlined">lock_open</span>
                    </div>
                    <div class="menu-title">Authentication</div>
                  </a>
			</li>
			<li><a class="has-arrow" >
					<div class="parent-icon">
						<span class="material-symbols-outlined">monitoring</span>
					</div>
					<div class="menu-title">Statistics</div>
			</a>
				<ul>
					<li><a href="/AZShop/vendor/statistics-revenue"><span
							class="material-symbols-outlined">arrow_right</span>Revenue</a></li>
					<li><a href="/AZShop/vendor/statistics-product"><span
							class="material-symbols-outlined">arrow_right</span>Product</a></li>
				</ul></li>
		</ul>


	</div>
	<div class="sidebar-bottom dropdown dropup-center dropup">
		<div
			class="dropdown-toggle d-flex align-items-center px-3 gap-3 w-100 h-100"
			data-bs-toggle="dropdown">
			<div class="user-img">
				<img src="assets/images/avatars/01.png" alt="">
			</div>
			<div class="user-info">
				<h5 class="mb-0 user-name">
					<c:if test="${user != null}">
						${user.firstName} ${user.lastName}
					</c:if>
				</h5>
			</div>
		</div>
		<ul class="dropdown-menu dropdown-menu-end">
			<li><a class="dropdown-item" href="javascript:;"><span
					class="material-symbols-outlined me-2"> account_circle </span><span>Profile</span></a>
			</li>
			<li><a class="dropdown-item" href="javascript:;"><span
					class="material-symbols-outlined me-2"> tune </span><span>Settings</span></a>
			</li>
			<li><a class="dropdown-item" href="javascript:;"><span
					class="material-symbols-outlined me-2"> dashboard </span><span>Dashboard</span></a>
			</li>
			<li><a class="dropdown-item" href="javascript:;"><span
					class="material-symbols-outlined me-2"> account_balance </span><span>Earnings</span></a>
			</li>
			<li><a class="dropdown-item" href="javascript:;"><span
					class="material-symbols-outlined me-2"> cloud_download </span><span>Downloads</span></a>
			</li>
			<li>
				<div class="dropdown-divider mb-0"></div>
			</li>
			<li><a class="dropdown-item" href="/AZShop/vendor/logout"><span
					class="material-symbols-outlined me-2"> logout </span><span>Logout</span></a>
			</li>
		</ul>
	</div>
</aside>

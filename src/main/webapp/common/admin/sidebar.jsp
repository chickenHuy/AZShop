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
			<li><a href="dashboard">
					<div class="parent-icon">
						<span class="material-symbols-outlined">home</span>
					</div>
					<div class="menu-title">Dashboard</div>
			</a></li>
			<li class="menu-label">MANAGEMENT</li>
			<li><a href="javascript:;" class="has-arrow">
					<div class="parent-icon">
						<span class="material-symbols-outlined">shopping_cart</span>
					</div>
					<div class="menu-title">eCommerce</div>
			</a>
				<ul>
					<li><a href='<c:url value="/admin/product"/>'><span
							class="material-symbols-outlined">arrow_right</span>Products</a></li>
					<li><a href='<c:url value="/admin/categories"/>'><span
							class="material-symbols-outlined">arrow_right</span>Categories</a></li>
					<li><a href='<c:url value="/admin/delivery"/>'><span
							class="material-symbols-outlined">arrow_right</span>Delivery</a></li>
					<li><a href='<c:url value="/admin/styles"/>'><span
							class="material-symbols-outlined">arrow_right</span>Styles</a></li>
					<li><a href='<c:url value="/admin/customer"/>'><span
							class="material-symbols-outlined">arrow_right</span>Customers</a></li>
					<li><a href='<c:url value="/admin/userlevel"/>'><span
							class="material-symbols-outlined">arrow_right</span>User level</a></li>
					<li><a href='<c:url value="/admin/store"/>'><span
							class="material-symbols-outlined">arrow_right</span>Store</a></li>
					<li><a href='<c:url value="/admin/storelevel"/>'><span
							class="material-symbols-outlined">arrow_right</span>Store level</a></li>
					<li><a href='<c:url value="/admin/orders"/>'><span
							class="material-symbols-outlined">arrow_right</span>Orders</a></li>
							<li><a><span
									class="material-symbols-outlined">arrow_right</span>Statistic</a>
								<ul>
							        <li><a href='<c:url value="/admin/UserStatic"/>'>User Statistic</a></li>
							        <li><a href='<c:url value="/admin/StoreStatic"/>'>Store Statistic</a></li>
							        <!-- Thêm các mục con khác nếu cần -->
							   </ul>	
								</li>
								
						<li><a href='<c:url value="/admin/transaction"/>'><span
							class="material-symbols-outlined">arrow_right</span>Transaction</a></li>
								
					
									
								
				</ul></li>


			<li class="menu-label">Pages</li>
			<li><a href="<c:url value="/admin/admin-info"/>">
					<div class="parent-icon">
						<span class="material-symbols-outlined">account_circle</span>
					</div>
					<div class="menu-title">Admin Profile</div>
			</a></li>

			<li><a>
					<div class="parent-icon">
						<span class="material-symbols-outlined">currency_bitcoin</span>
					</div>
					<div class="menu-title">Pricing</div>
			</a></li>
			<li><a>
					<div class="parent-icon">
						<span class="material-symbols-outlined">receipt_long</span>
					</div>
					<div class="menu-title">Documentation</div>
			</a></li>
			<li><a>
					<div class="parent-icon">
						<span class="material-symbols-outlined">shop</span>
					</div>
					<div class="menu-title">Support</div>
			</a></li>
		</ul>
		<!--end navigation-->


	</div>
	<div class="sidebar-bottom dropdown dropup-center dropup">
		<div
			class="dropdown-toggle d-flex align-items-center px-3 gap-3 w-100 h-100"
			data-bs-toggle="dropdown">
			<div class="user-img">
				<img src="${adminAvatar}" alt="">
			</div>
			<div class="user-info">
				<h5 class="mb-0 user-name">${userName}</h5>
				<p class="mb-0 user-designation">Admin</p>
			</div>
		</div>
		<ul class="dropdown-menu dropdown-menu-end">
			<li><a class="dropdown-item" href='<c:url value="/admin/admin-info"/>'><span
					class="material-symbols-outlined me-2"> account_circle </span><span>Profile</span></a>
			</li>
			<li><a class="dropdown-item" ><span
					class="material-symbols-outlined me-2"> tune </span><span>Settings</span></a>
			</li>
			<li><a class="dropdown-item" href='<c:url value="/admin/dashboard"/>'><span
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
			<li><a class="dropdown-item" href="<c:url value='/logout-customer' />"><span
					class="material-symbols-outlined me-2"> logout </span><span>Logout</span></a>
			</li>
		</ul>
	</div>
</aside>
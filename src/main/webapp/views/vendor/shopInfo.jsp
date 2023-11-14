<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>

	<!--start header-->
	<header class="top-header">
		<nav class="navbar navbar-expand justify-content-between">
			<div class="btn-toggle-menu">
				<span class="material-symbols-outlined">menu</span>
			</div>
			<div class="position-relative search-bar d-lg-block d-none"
				data-bs-toggle="modal" data-bs-target="#exampleModal">
				<input class="form-control form-control-sm rounded-5 px-5" disabled
					type="search" placeholder="Search"> <span
					class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50">search</span>
			</div>
			<ul class="navbar-nav top-right-menu gap-2">
				<li class="nav-item d-lg-none d-block" data-bs-toggle="modal"
					data-bs-target="#exampleModal"><a class="nav-link"
					href="javascript:;"><span class="material-symbols-outlined">
							search </span></a></li>
				<li class="nav-item dark-mode"><a
					class="nav-link dark-mode-icon" href="javascript:;"><span
						class="material-symbols-outlined">dark_mode</span></a></li>
				<li class="nav-item dropdown dropdown-app"><a
					class="nav-link dropdown-toggle dropdown-toggle-nocaret"
					data-bs-toggle="dropdown" href="javascript:;"><span
						class="material-symbols-outlined"> apps </span></a>
					<div class="dropdown-menu dropdown-menu-end mt-lg-2 p-0">
						<div class="app-container p-2 my-2">
							<div class="row gx-0 gy-2 row-cols-3 justify-content-center p-2">
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/slack.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Slack</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/behance.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Behance</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/google-drive.png" width="30"
													alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Dribble</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/outlook.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Outlook</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/github.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">GitHub</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/stack-overflow.png" width="30"
													alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Stack</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/figma.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Stack</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/twitter.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Twitter</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/google-calendar.png"
													width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Calendar</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/spotify.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Spotify</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/google-photos.png" width="30"
													alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Photos</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/pinterest.png" width="30"
													alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Photos</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/linkedin.png" width="30"
													alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">linkedin</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/dribble.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Dribble</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/youtube.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">YouTube</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/google.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">News</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/envato.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Envato</p>
											</div>
										</div>
									</a>
								</div>
								<div class="col">
									<a href="javascript:;">
										<div class="app-box text-center">
											<div class="app-icon">
												<img src="assets/images/icons/safari.png" width="30" alt="">
											</div>
											<div class="app-name">
												<p class="mb-0 mt-1">Safari</p>
											</div>
										</div>
									</a>
								</div>

							</div>
							<!--end row-->

						</div>
					</div></li>
				<li class="nav-item dropdown dropdown-large"><a
					class="nav-link dropdown-toggle dropdown-toggle-nocaret"
					href="javascript:;" data-bs-toggle="dropdown">
						<div class="position-relative">
							<span class="notify-badge">8</span> <span
								class="material-symbols-outlined"> notifications_none </span>
						</div>
				</a>
					<div class="dropdown-menu dropdown-menu-end mt-lg-2">
						<a href="javascript:;">
							<div class="msg-header">
								<p class="msg-header-title">Notifications</p>
								<p class="msg-header-clear ms-auto">Marks all as read</p>
							</div>
						</a>
						<div class="header-notifications-list">
							<a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-primary border">
										<span class="material-symbols-outlined">
											add_shopping_cart </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											New Orders <span class="msg-time float-end">2 min ago</span>
										</h6>
										<p class="msg-info">You have recived new orders</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-danger border">
										<span class="material-symbols-outlined"> account_circle
										</span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											New Customers<span class="msg-time float-end">14 Sec
												ago</span>
										</h6>
										<p class="msg-info">5 new user registered</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-success border">
										<span class="material-symbols-outlined"> picture_as_pdf
										</span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											24 PDF File<span class="msg-time float-end">19 min ago</span>
										</h6>
										<p class="msg-info">The pdf files generated</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-info border">
										<span class="material-symbols-outlined"> store </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											New Product Approved <span class="msg-time float-end">2
												hrs ago</span>
										</h6>
										<p class="msg-info">Your new product has approved</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-warning border">
										<span class="material-symbols-outlined">
											event_available </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											Time Response <span class="msg-time float-end">28 min
												ago</span>
										</h6>
										<p class="msg-info">5.1 min avarage time response</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-danger border">
										<span class="material-symbols-outlined"> forum </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											New Comments <span class="msg-time float-end">4 hrs
												ago</span>
										</h6>
										<p class="msg-info">New customer comments recived</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-primary border">
										<span class="material-symbols-outlined"> local_florist
										</span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											New 24 authors<span class="msg-time float-end">1 day
												ago</span>
										</h6>
										<p class="msg-info">24 new authors joined last week</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-success border">
										<span class="material-symbols-outlined"> park </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											Your item is shipped <span class="msg-time float-end">5
												hrs ago</span>
										</h6>
										<p class="msg-info">Successfully shipped your item</p>
									</div>
								</div>
							</a> <a class="dropdown-item" href="javascript:;">
								<div class="d-flex align-items-center">
									<div class="notify text-warning border">
										<span class="material-symbols-outlined"> elevation </span>
									</div>
									<div class="flex-grow-1">
										<h6 class="msg-name">
											Defense Alerts <span class="msg-time float-end">2
												weeks ago</span>
										</h6>
										<p class="msg-info">45% less alerts last 4 weeks</p>
									</div>
								</div>
							</a>
						</div>
						<a href="javascript:;">
							<div class="text-center msg-footer">View All</div>
						</a>
					</div></li>

				<li class="nav-item"><a class="nav-link"
					data-bs-toggle="offcanvas" href="#ThemeCustomizer"><span
						class="material-symbols-outlined"> settings </span></a></li>
			</ul>
		</nav>
	</header>
	<!--end header-->


	<!--start sidebar-->
	<aside class="sidebar-wrapper">
		<div class="sidebar-header">
			<div class="logo-icon">
				<img src="assets/images/logo-icon.png" class="logo-img" alt="">
			</div>
			<div class="logo-name flex-grow-1">
				<h5 class="mb-0">Roksyn</h5>
			</div>
			<div class="sidebar-close ">
				<span class="material-symbols-outlined">close</span>
			</div>
		</div>
		<div class="sidebar-nav" data-simplebar="true">

			<!--navigation-->
			<ul class="metismenu" id="menu">
				<li><a href="javascript:;" class="has-arrow">
						<div class="parent-icon">
							<span class="material-symbols-outlined">home</span>
						</div>
						<div class="menu-title">Dashboard</div>
				</a>
					<ul>
						<li><a href="index.html"><span
								class="material-symbols-outlined">arrow_right</span>Default</a></li>
						<li><a href="index2.html"><span
								class="material-symbols-outlined">arrow_right</span>Alternate</a></li>
						<li><a href="index3.html"><span
								class="material-symbols-outlined">arrow_right</span>Graphical</a></li>
					</ul></li>
				<li><a href="javascript:;" class="has-arrow">
						<div class="parent-icon">
							<span class="material-symbols-outlined">apps</span>
						</div>
						<div class="menu-title">Application</div>
				</a>
					<ul>
						<li><a href="app-emailbox.html"><span
								class="material-symbols-outlined">arrow_right</span>Email</a></li>
						<li><a href="app-chat-box.html"><span
								class="material-symbols-outlined">arrow_right</span>Chat Box</a></li>
						<li><a href="app-file-manager.html"><span
								class="material-symbols-outlined">arrow_right</span>File Manager</a>
						</li>
						<li><a href="app-contact-list.html"><span
								class="material-symbols-outlined">arrow_right</span>Contatcs</a></li>
						<li><a href="app-to-do.html"><span
								class="material-symbols-outlined">arrow_right</span>Todo List</a></li>
						<li><a href="app-invoice.html"><span
								class="material-symbols-outlined">arrow_right</span>Invoice</a></li>
						<li><a href="app-fullcalender.html"><span
								class="material-symbols-outlined">arrow_right</span>Calendar</a></li>
					</ul></li>
				<li class="menu-label">UI Elements</li>
				<li><a href="widgets.html">
						<div class="parent-icon">
							<span class="material-symbols-outlined">widgets</span>
						</div>
						<div class="menu-title">Widgets</div>
				</a></li>
				<li><a href="javascript:;" class="has-arrow">
						<div class="parent-icon">
							<span class="material-symbols-outlined">shopping_cart</span>
						</div>
						<div class="menu-title">eCommerce</div>
				</a>
					<ul>
						<li><a href="ecommerce-products.html"><span
								class="material-symbols-outlined">arrow_right</span>Products</a></li>
						<li><a href="ecommerce-products-details.html"><span
								class="material-symbols-outlined">arrow_right</span>Product
								Details</a></li>
						<li><a href="ecommerce-add-new-products.html"><span
								class="material-symbols-outlined">arrow_right</span>Add New
								Products</a></li>
						<li><a href="ecommerce-orders.html"><span
								class="material-symbols-outlined">arrow_right</span>Orders</a></li>
					</ul></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">redeem</span>
						</div>
						<div class="menu-title">Components</div>
				</a>
					<ul>
						<li><a href="component-alerts.html"><span
								class="material-symbols-outlined">arrow_right</span>Alerts</a></li>
						<li><a href="component-accordions.html"><span
								class="material-symbols-outlined">arrow_right</span>Accordions</a></li>
						<li><a href="component-badges.html"><span
								class="material-symbols-outlined">arrow_right</span>Badges</a></li>
						<li><a href="component-buttons.html"><span
								class="material-symbols-outlined">arrow_right</span>Buttons</a></li>
						<li><a href="component-cards.html"><span
								class="material-symbols-outlined">arrow_right</span>Cards</a></li>
						<li><a href="component-carousels.html"><span
								class="material-symbols-outlined">arrow_right</span>Carousels</a></li>
						<li><a href="component-list-groups.html"><span
								class="material-symbols-outlined">arrow_right</span>List Groups</a>
						</li>
						<li><a href="component-media-object.html"><span
								class="material-symbols-outlined">arrow_right</span>Media
								Objects</a></li>
						<li><a href="component-modals.html"><span
								class="material-symbols-outlined">arrow_right</span>Modals</a></li>
						<li><a href="component-navs-tabs.html"><span
								class="material-symbols-outlined">arrow_right</span>Navs & Tabs</a>
						</li>
						<li><a href="component-navbar.html"><span
								class="material-symbols-outlined">arrow_right</span>Navbar</a></li>
						<li><a href="component-paginations.html"><span
								class="material-symbols-outlined">arrow_right</span>Pagination</a></li>
						<li><a href="component-popovers-tooltips.html"><span
								class="material-symbols-outlined">arrow_right</span>Popovers &
								Tooltips</a></li>
						<li><a href="component-progress-bars.html"><span
								class="material-symbols-outlined">arrow_right</span>Progress</a></li>
						<li><a href="component-spinners.html"><span
								class="material-symbols-outlined">arrow_right</span>Spinners</a></li>
						<li><a href="component-notifications.html"><span
								class="material-symbols-outlined">arrow_right</span>Notifications</a>
						</li>
						<li><a href="component-avtars-chips.html"><span
								class="material-symbols-outlined">arrow_right</span>Avatrs &
								Chips</a></li>
					</ul></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">bookmark_add</span>
						</div>
						<div class="menu-title">Content</div>
				</a>
					<ul>
						<li><a href="content-grid-system.html"><span
								class="material-symbols-outlined">arrow_right</span>Grid System</a>
						</li>
						<li><a href="content-typography.html"><span
								class="material-symbols-outlined">arrow_right</span>Typography</a></li>
						<li><a href="content-text-utilities.html"><span
								class="material-symbols-outlined">arrow_right</span>Text
								Utilities</a></li>
					</ul></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">add_reaction</span>
						</div>
						<div class="menu-title">Icons</div>
				</a>
					<ul>
						<li><a href="icons-line-icons.html"><span
								class="material-symbols-outlined">arrow_right</span>Line Icons</a></li>
						<li><a href="icons-boxicons.html"><span
								class="material-symbols-outlined">arrow_right</span>Boxicons</a></li>
						<li><a href="icons-feather-icons.html"><span
								class="material-symbols-outlined">arrow_right</span>Feather
								Icons</a></li>
					</ul></li>
				<li class="menu-label">Forms & Tables</li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">diamond</span>
						</div>
						<div class="menu-title">Forms</div>
				</a>
					<ul>
						<li><a href="form-elements.html"><span
								class="material-symbols-outlined">arrow_right</span>Form
								Elements</a></li>
						<li><a href="form-input-group.html"><span
								class="material-symbols-outlined">arrow_right</span>Input Groups</a>
						</li>
						<li><a href="form-radios-and-checkboxes.html"><span
								class="material-symbols-outlined">arrow_right</span>Radios &
								Checkboxes</a></li>
						<li><a href="form-layouts.html"><span
								class="material-symbols-outlined">arrow_right</span>Forms
								Layouts</a></li>
						<li><a href="form-validations.html"><span
								class="material-symbols-outlined">arrow_right</span>Form
								Validation</a></li>
						<li><a href="form-wizard.html"><span
								class="material-symbols-outlined">arrow_right</span>Form Wizard</a>
						</li>
						<li><a href="form-text-editor.html"><span
								class="material-symbols-outlined">arrow_right</span>Text Editor</a>
						</li>
						<li><a href="form-file-upload.html"><span
								class="material-symbols-outlined">arrow_right</span>File Upload</a>
						</li>
						<li><a href="form-date-time-pickes.html"><span
								class="material-symbols-outlined">arrow_right</span>Date Pickers</a>
						</li>
						<li><a href="form-select2.html"><span
								class="material-symbols-outlined">arrow_right</span>Select2</a></li>
						<li><a href="form-repeater.html"><span
								class="material-symbols-outlined">arrow_right</span>Form
								Repeater</a></li>
					</ul></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">backup_table</span>
						</div>
						<div class="menu-title">Tables</div>
				</a>
					<ul>
						<li><a href="table-basic-table.html"><span
								class="material-symbols-outlined">arrow_right</span>Basic Table</a>
						</li>
						<li><a href="table-datatable.html"><span
								class="material-symbols-outlined">arrow_right</span>Data Table</a></li>
					</ul></li>
				<li class="menu-label">Pages</li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">lock_open</span>
						</div>
						<div class="menu-title">Authentication</div>
				</a>
					<ul>
						<li><a class="has-arrow" href="javascript:;"><span
								class="material-symbols-outlined">arrow_right</span>Basic</a>
							<ul>
								<li><a href="auth-basic-signin.html" target="_blank"><span
										class="material-symbols-outlined">arrow_right</span>Sign In</a></li>
								<li><a href="auth-basic-signup.html" target="_blank"><span
										class="material-symbols-outlined">arrow_right</span>Sign Up</a></li>
								<li><a href="auth-basic-forgot-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Forgot
										Password</a></li>
								<li><a href="auth-basic-reset-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Reset
										Password</a></li>
							</ul></li>
						<li><a class="has-arrow" href="javascript:;"><span
								class="material-symbols-outlined">arrow_right</span>Cover</a>
							<ul>
								<li><a href="auth-cover-signin.html" target="_blank"><span
										class="material-symbols-outlined">arrow_right</span>Sign In</a></li>
								<li><a href="auth-cover-signup.html" target="_blank"><span
										class="material-symbols-outlined">arrow_right</span>Sign Up</a></li>
								<li><a href="auth-cover-forgot-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Forgot
										Password</a></li>
								<li><a href="auth-cover-reset-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Reset
										Password</a></li>
							</ul></li>
						<li><a class="has-arrow" href="javascript:;"><span
								class="material-symbols-outlined">arrow_right</span>With Header
								Footer</a>
							<ul>
								<li><a href="auth-header-footer-signin.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Sign
										In</a></li>
								<li><a href="auth-header-footer-signup.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Sign
										Up</a></li>
								<li><a href="auth-header-footer-forgot-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Forgot
										Password</a></li>
								<li><a href="auth-header-footer-reset-password.html"
									target="_blank"><span class="material-symbols-outlined">arrow_right</span>Reset
										Password</a></li>
							</ul></li>
					</ul></li>
				<li><a href="user-profile.html">
						<div class="parent-icon">
							<span class="material-symbols-outlined">account_circle</span>
						</div>
						<div class="menu-title">User Profile</div>
				</a></li>
				<li><a href="timeline.html">
						<div class="parent-icon">
							<span class="material-symbols-outlined">hotel_class</span>
						</div>
						<div class="menu-title">Timeline</div>
				</a></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">warning</span>
						</div>
						<div class="menu-title">Errors</div>
				</a>
					<ul>
						<li><a href="errors-404-error.html" target="_blank"><span
								class="material-symbols-outlined">arrow_right</span>404 Error</a></li>
						<li><a href="errors-500-error.html" target="_blank"><span
								class="material-symbols-outlined">arrow_right</span>500 Error</a></li>
						<li><a href="errors-coming-soon.html" target="_blank"><span
								class="material-symbols-outlined">arrow_right</span>Coming Soon</a>
						</li>
						<li><a href="error-blank-page.html" target="_blank"><span
								class="material-symbols-outlined">arrow_right</span>Blank Page</a></li>
					</ul></li>
				<li><a href="faq.html">
						<div class="parent-icon">
							<span class="material-symbols-outlined">call</span>
						</div>
						<div class="menu-title">FAQ</div>
				</a></li>
				<li><a href="pricing-table.html">
						<div class="parent-icon">
							<span class="material-symbols-outlined">currency_bitcoin</span>
						</div>
						<div class="menu-title">Pricing</div>
				</a></li>
				<li class="menu-label">Charts & Maps</li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">monitoring</span>
						</div>
						<div class="menu-title">Charts</div>
				</a>
					<ul>
						<li><a href="charts-apex-chart.html"><span
								class="material-symbols-outlined">arrow_right</span>Apex</a></li>
						<li><a href="charts-chartjs.html"><span
								class="material-symbols-outlined">arrow_right</span>Chartjs</a></li>
						<li><a href="charts-highcharts.html"><span
								class="material-symbols-outlined">arrow_right</span>Highcharts</a></li>
					</ul></li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">distance</span>
						</div>
						<div class="menu-title">Maps</div>
				</a>
					<ul>
						<li><a href="map-google-maps.html"><span
								class="material-symbols-outlined">arrow_right</span>Google Maps</a>
						</li>
						<li><a href="map-vector-maps.html"><span
								class="material-symbols-outlined">arrow_right</span>Vector Maps</a>
						</li>
					</ul></li>
				<li class="menu-label">Others</li>
				<li><a class="has-arrow" href="javascript:;">
						<div class="parent-icon">
							<span class="material-symbols-outlined">toc</span>
						</div>
						<div class="menu-title">Menu Levels</div>
				</a>
					<ul>
						<li><a class="has-arrow" href="javascript:;"><span
								class="material-symbols-outlined">arrow_right</span>Level One</a>
							<ul>
								<li><a class="has-arrow" href="javascript:;"><span
										class="material-symbols-outlined">arrow_right</span>Level Two</a>
									<ul>
										<li><a href="javascript:;"><span
												class="material-symbols-outlined">arrow_right</span>Level
												Three</a></li>
									</ul></li>
							</ul></li>
					</ul></li>
				<li><a
					href="https://codervent.com/rocker/documentation/index.html"
					target="_blank">
						<div class="parent-icon">
							<span class="material-symbols-outlined">receipt_long</span>
						</div>
						<div class="menu-title">Documentation</div>
				</a></li>
				<li><a href="https://themeforest.net/user/codervent"
					target="_blank">
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
					<img src="assets/images/avatars/01.png" alt="">
				</div>
				<div class="user-info">
					<h5 class="mb-0 user-name">Jhon Maxwell</h5>
					<p class="mb-0 user-designation">UI Engineer</p>
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
				<li><a class="dropdown-item" href="javascript:;"><span
						class="material-symbols-outlined me-2"> logout </span><span>Logout</span></a>
				</li>
			</ul>
		</div>
	</aside>
	<!--end sidebar-->


	<!--start main content-->
	<main class="page-content">
		<!--breadcrumb-->
		<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
			<div class="breadcrumb-title pe-3">Pages</div>
			<div class="ps-3">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mb-0 p-0">
						<li class="breadcrumb-item"><a href="javascript:;"><i
								class="bx bx-home-alt"></i></a></li>
						<li class="breadcrumb-item active" aria-current="page">Edit
							Profile</li>
					</ol>
				</nav>
			</div>
			<div class="ms-auto">
				<div class="btn-group">
					<button type="button" class="btn btn-primary">Settings</button>
					<button type="button"
						class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split"
						data-bs-toggle="dropdown">
						<span class="visually-hidden">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
						<a class="dropdown-item" href="javascript:;">Action</a> <a
							class="dropdown-item" href="javascript:;">Another action</a> <a
							class="dropdown-item" href="javascript:;">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="javascript:;">Separated link</a>
					</div>
				</div>
			</div>
		</div>
		<!--end breadcrumb-->

		<div class="row">
			<div class="col-lg-8 mx-auto">
				<div class="card">
					<div class="card-body">
						<form>
							<h5 class="mb-3">Edit Profile</h5>
							<div
								class="mb-4 d-flex flex-column gap-3 align-items-center justify-content-center">
								<div class="user-change-photo shadow">
									<img src="assets/images/avatars/06.png" alt="...">
								</div>
								<button type="button"
									class="btn btn-outline-primary btn-sm radius-30 px-4">
									<i class="bi bi-file-earmark-image me-2"></i>Change Photo
								</button>
							</div>
							<h5 class="mb-0 mt-4">User Information</h5>
							<hr>
							<div class="row g-3">
								<div class="col-6">
									<label class="form-label">Username</label> <input type="text"
										class="form-control" value="@jhon">
								</div>
								<div class="col-6">
									<label class="form-label">Email address</label> <input
										type="text" class="form-control" value="xyz@example.com">
								</div>
								<div class="col-6">
									<label class="form-label">First Name</label> <input type="text"
										class="form-control" value="jhon">
								</div>
								<div class="col-6">
									<label class="form-label">Last Name</label> <input type="text"
										class="form-control" value="">
								</div>
							</div>

							<h5 class="mb-0 mt-4">Contact Information</h5>
							<hr>
							<div class="row g-3">
								<div class="col-12">
									<label class="form-label">Address</label> <input type="text"
										class="form-control" value="47-A, city name, United States">
								</div>
								<div class="col-6">
									<label class="form-label">City</label> <input type="text"
										class="form-control" value="@jhon">
								</div>
								<div class="col-6">
									<label class="form-label">Country</label> <input type="text"
										class="form-control" value="xyz@example.com">
								</div>
								<div class="col-6">
									<label class="form-label">Pin Code</label> <input type="text"
										class="form-control" value="jhon">
								</div>
								<div class="col-6">
									<label class="form-label">Last Name</label> <input type="text"
										class="form-control" value="Deo">
								</div>
								<div class="col-12">
									<label class="form-label">About Me</label>
									<textarea class="form-control" rows="4" cols="4"
										placeholder="Describe yourself..."></textarea>
								</div>
							</div>
							<div class="text-start mt-3">
								<button type="button" class="btn btn-primary px-4">Save
									Changes</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
		<!--end row-->


	</main>
	<!--end main content-->


	<!--start overlay-->
	<div class="overlay btn-toggle-menu"></div>
	<!--end overlay-->

	<!-- Search Modal -->
	<div class="modal" id="exampleModal" tabindex="-1">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header gap-2">
					<div class="position-relative popup-search w-100">
						<input
							class="form-control form-control-lg ps-5 border border-3 border-primary"
							type="search" placeholder="Search"> <span
							class="material-symbols-outlined position-absolute ms-3 translate-middle-y start-0 top-50">search</span>
					</div>
					<button type="button" class="btn-close d-xl-none"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="search-list">
						<p class="mb-1">Html Templates</p>
						<div class="list-group">
							<a href="javascript:;"
								class="list-group-item list-group-item-action active align-items-center d-flex gap-2"><i
								class="bi bi-filetype-html fs-5"></i>Best Html Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-award fs-5"></i>Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-box2-heart fs-5"></i>Responsive Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-camera-video fs-5"></i>eCommerce Html Templates</a>
						</div>
						<p class="mb-1 mt-3">Web Designe Company</p>
						<div class="list-group">
							<a href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-chat-right-text fs-5"></i>Best Html Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-cloud-arrow-down fs-5"></i>Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-columns-gap fs-5"></i>Responsive Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-collection-play fs-5"></i>eCommerce Html Templates</a>
						</div>
						<p class="mb-1 mt-3">Software Development</p>
						<div class="list-group">
							<a href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-cup-hot fs-5"></i>Best Html Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-droplet fs-5"></i>Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-exclamation-triangle fs-5"></i>Responsive Html5
								Templates</a> <a href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-eye fs-5"></i>eCommerce Html Templates</a>
						</div>
						<p class="mb-1 mt-3">Online Shoping Portals</p>
						<div class="list-group">
							<a href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-facebook fs-5"></i>Best Html Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-flower2 fs-5"></i>Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-geo-alt fs-5"></i>Responsive Html5 Templates</a> <a
								href="javascript:;"
								class="list-group-item list-group-item-action align-items-center d-flex gap-2"><i
								class="bi bi-github fs-5"></i>eCommerce Html Templates</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!--start theme customization-->
	<div class="offcanvas offcanvas-end" tabindex="-1" id="ThemeCustomizer"
		aria-labelledby="ThemeCustomizerLable">
		<div class="offcanvas-header border-bottom">
			<h5 class="offcanvas-title" id="ThemeCustomizerLable">Theme
				Customizer</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<h6 class="mb-0">Theme Variation</h6>
			<hr>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="inlineRadioOptions" id="LightTheme" value="option1">
				<label class="form-check-label" for="LightTheme">Light</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="inlineRadioOptions" id="DarkTheme" value="option2" checked="">
				<label class="form-check-label" for="DarkTheme">Dark</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="inlineRadioOptions" id="SemiDarkTheme" value="option3">
				<label class="form-check-label" for="SemiDarkTheme">Semi
					Dark</label>
			</div>
			<hr>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="inlineRadioOptions" id="MinimalTheme" value="option3">
				<label class="form-check-label" for="MinimalTheme">Minimal
					Theme</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio"
					name="inlineRadioOptions" id="ShadowTheme" value="option4">
				<label class="form-check-label" for="ShadowTheme">Shadow
					Theme</label>
			</div>

		</div>
	</div>
</body>
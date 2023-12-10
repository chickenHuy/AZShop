<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
     <main class="page-content">
       <!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Pages</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Admin Profile</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Settings</button>
							<button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
							</button>
							<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
								<a class="dropdown-item" href="javascript:;">Another action</a>
								<a class="dropdown-item" href="javascript:;">Something else here</a>
								<div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
							</div>
						</div>
					</div>
				</div>
				<!--end breadcrumb-->

        <div class="row">
          <div class="col-12 col-lg-8 col-xl-9">
            <div class="card overflow-hidden">
              <div class="profile-cover bg-dark position-relative mb-4">
                <div class="user-profile-avatar shadow position-absolute top-50 start-0 translate-middle-x">
                  <img src="https://zpsocial-f53-org.zadn.vn/cb028b736f4d8e13d75c.jpg" alt="...">
                </div>
              </div>
              <div class="card-body">
                <div class="mt-5 d-flex align-items-start justify-content-between">
                  <div class="">
                    <h3 class="mb-2">${adminName}</h3>
                    <p class="mb-1">Software engineer at VNG</p>
                    <p>Số 1, Võ Văn Ngân</p>
                    <div class="">
                      <span class="badge rounded-pill bg-primary">Java Developer</span>
                      <span class="badge rounded-pill bg-primary">Project Management</span>
                    </div>
                  </div>
                  <div class="">
                     <a href="javascript:;" class="btn btn-primary"><i class="bi bi-chat me-2"></i>Send Message</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="card">
              <div class="card-body">
                <h4 class="mb-2">About Me</h4>
                <p class="">Admin uy tín số 1 VN</p>
                <p>Quản trị viên có tâm</p>
                <p></p>
              </div>
            </div>
          </div>
          <div class="col-12 col-lg-4 col-xl-3">
            <div class="card">
              <div class="card-body">
                <h5 class="mb-3">Location</h5>
                 <p class="mb-0"><i class="bi bi-geo-alt-fill me-2"></i>Kalkio Network</p>
              </div>
            </div>

            <div class="card">
              <div class="card-body">
                <h5 class="mb-3">Connect</h5>
                 <p class=""><i class="bi bi-browser-edge me-2"></i>www.example.com</p>
                 <p class=""><i class="bi bi-facebook me-2"></i>Facebook</p>
                 <p class=""><i class="bi bi-twitter me-2"></i>Twitter</p>
                 <p class="mb-0"><i class="bi bi-linkedin me-2"></i>LinkedIn</p>
              </div>
            </div>

            <div class="card">
              <div class="card-body">
                <h5 class="mb-3">Skills</h5>
                 <div class="mb-3">
                  <p class="mb-1">Web Design</p>
                  <div class="progress" style="height: 5px;">
                   <div class="progress-bar" role="progressbar" style="width: 45%"></div>
                  </div>
                 </div>
                 <div class="mb-3">
                  <p class="mb-1">HTML5</p>
                  <div class="progress" style="height: 5px;">
                   <div class="progress-bar" role="progressbar" style="width: 55%"></div>
                  </div>
                 </div>
                 <div class="mb-3">
                  <p class="mb-1">PHP7</p>
                  <div class="progress" style="height: 5px;">
                   <div class="progress-bar" role="progressbar" style="width: 65%"></div>
                  </div>
                 </div>
                 <div class="mb-3">
                  <p class="mb-1">CSS3</p>
                  <div class="progress" style="height: 5px;">
                   <div class="progress-bar" role="progressbar" style="width: 75%"></div>
                  </div>
                 </div>
                 <div class="mb-0">
                  <p class="mb-1">Photoshop</p>
                  <div class="progress" style="height: 5px;">
                   <div class="progress-bar" role="progressbar" style="width: 85%"></div>
                  </div>
                 </div>

              </div>
            </div>

          </div>
        </div><!--end row-->
        
     </main>
</body>
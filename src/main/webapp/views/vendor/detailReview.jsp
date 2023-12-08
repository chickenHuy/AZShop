<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>

<body>
     <main class="page-content">
        <!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Reviews</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">All reviews</li>
							</ol>
						</nav>
					</div>
				</div>
        <div class="">
					<div class="">
						<div class="container py-2">
							<h2 class="font-weight-light text-center text-muted py-3">${name}</h2>
							<c:forEach var="review" items="${reviews}">
								<c:if test = "${id eq review.id}">
									<div class="row">
										<div class="col-auto text-center flex-column d-none d-sm-flex">
											<div class="row h-50">
												<div class="col border-end">&nbsp;</div>
												<div class="col">&nbsp;</div>
											</div>
											<h5 class="m-2">
											<span class="badge rounded-pill bg-primary">&nbsp;</span>
										</h5>
											<div class="row h-50">
												<div class="col border-end">&nbsp;</div>
												<div class="col">&nbsp;</div>
											</div>
										</div>
										<div class="col py-2">
											<div class="card border-primary shadow radius-15">
												<div class="card-body">
													<div class="float-end text-primary">${review.createAt}</div>
													<h4 class="card-title text-primary">Customer ${review.customerId} has rated ${reviews.rating} stars</h4>
													<p class="card-text">${review.content}</p>
												</div>
											</div>
										</div>
									</div>
								</c:if>
								<c:if test = "${!(id eq review.id)}">
									<div class="col-auto text-center flex-column d-none d-sm-flex">
										<div class="row h-50">
											<div class="col">&nbsp;</div>
											<div class="col">&nbsp;</div>
										</div>
										<h5 class="m-2">
										<span class="badge rounded-pill bg-light border">&nbsp;</span>
									</h5>
										<div class="row h-50">
											<div class="col border-end">&nbsp;</div>
											<div class="col">&nbsp;</div>
										</div>
									</div>
									<div class="col py-2">
										<div class="card radius-15">
											<div class="card-body">
												<div class="float-end text-muted">${review.createAt}</div>
												<h4 class="card-title text-muted">Customer ${review.customerId} has rated ${reviews.rating} stars</h4>
												<p class="card-text">${review.content}</p>
											</div>
										</div>
									</div>
								</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
						
     </main>
</body>
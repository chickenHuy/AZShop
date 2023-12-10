<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction</title>
</head>
<body>
    <!--start main content-->
    <main class="page-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">eCommerce</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i
                                class="bx bx-home-alt"></i></a></li>
                        <li class="breadcrumb-item active" aria-current="page">Transaction</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="card mt-4">
            <div class="card-body">
                <div class="customer-table">
                    <div class="table-responsive white-space-nowrap">
                        <table id="example2" class="table align-middle">
                            <thead class="table-light">
                                <tr>
                                    <th>UserID</th>
                                    <th>StoreID</th>
                                    <th>Giao dịch</th>
                                    <th>Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="transaction" items="${listTransaction}">
                                    <tr>
                                        <td>${transaction.userId }</td>
                                        <td>${transaction.storeId }</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${transaction.isUp() == true}">
                                                    <span class="lable-table bg-success-subtle text-success rounded border border-success-subtle font-text2 fw-bold">Nạp tiền</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="lable-table bg-danger-subtle text-danger rounded border border-danger-subtle font-text2 fw-bold">Rút tiền</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${transaction.amount }</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </main>
    <!--end main content-->

</body>
</html>

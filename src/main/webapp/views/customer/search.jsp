<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<c:forEach var = "store" items = "${stores}">
<h5>${store.name} - ${store.bio}</h5>
<hr>
</c:forEach>
<c:forEach var = "product" items = "${products}">
<h5>${product.name} - ${product.price}</h5>
<hr>
</c:forEach>
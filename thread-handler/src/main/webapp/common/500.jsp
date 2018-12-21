<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%@include file="/common/head.jsp"%>

<div style='height: 50px;'></div>
<center>
	<h5>网速慢，请刷新试试!-laomn.com</h5>
	<h5>
		<a style="opacity: 1;" class="link" href="${ctx}/"
			onclick="history.go(-1)">返回</a>
	</h5>
</center>
<div style='height: 50px;'></div>

<%@include file="/common/footer.jsp"%>
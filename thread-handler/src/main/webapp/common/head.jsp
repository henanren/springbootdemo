<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN" manifest="cache.manifest">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监控平台</title>
 <link rel="icon" type="image/x-icon" href="/static/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/bootstrap.min.css" />
<!-- 	<link rel="stylesheet" type="text/css" -->
<%-- 	href="${ctx}/static/css/bootstrap.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/common.css" />

<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/style.css" />


<style type="text/css">


.three{background-color: white; color: #369;}
</style>
<script type="text/javascript">
var ctx ="${ctx}" ;
</script>
</head>

<body>
	<div class="navbar-header" style="display:block;clear:both;position:static; white-space:nowrap;overflow:hidden;text-align: center;padding-top: 20px;" >
	 
		<h1>监控平台</h1>
		 
	 
		 
	</div>

	<div class="navbar-wrapper" style="clear:both;position:static;float:none;">
		<!-- 		class="container" -->
		<div style="margin: 2px auto 0; background-color: #369;">
			<div class="navbar navbar-inverse "
				style='width: 1170px; margin: 0 auto; color: #FFFFFF;'>
				<div class="navbar-inner">
					<button type="button" class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<%-- 					<a class="brand" href="${ctx}">主页</a> --%>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
							<li><a href="${ctx}/" class="brand"    <c:if test="${first_menu  == 1}">style="background-color: white; color: #369;"</c:if> >首页 </a></li>
							<li><a href="${ctx}/monitor/status" class="brand"  <c:if test="${status_menu  == 1}">style="background-color: white; color: #369;"</c:if>  >状态
							</a></li>
							<li><a href="${ctx}/monitor/queue" class="brand"   <c:if test="${queue_menu  == 1}">style="background-color: white; color: #369;"</c:if>   >队列
							</a></li>
						 <li><a href="${ctx}/monitor/thread" class="brand"   <c:if test="${thread_menu  == 1}">style="background-color: white; color: #369;"</c:if>   >线程
							</a></li>



<!-- <li id="1"><a href="javascript:void();" class="brand">首页 </a></li> -->
<!-- <li id="2"><a href="javascript:void();" class="brand">状态 </a></li> -->
<!-- <li id="3"><a href="javascript:void();" class="brand">队列 </a></li> -->
<!-- <li id="4"><a href="javascript:void();" class="brand">线程 </a></li> -->
							 
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div style='height: 50px;'></div>

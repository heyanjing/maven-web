<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib2.jsp"%>
<!--sitemesh2的装饰页面 -->
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/WEB-INF/layout/head.jsp"%> 
		<title> <sitemesh:title/></title>
		<link rel="stylesheet" type="text/css" href="${CSS }/decorator/decorator.css?${V}">
		<sitemesh:head />
	</head>
	<body>
		<sitemesh:body />
	</body>
</html>
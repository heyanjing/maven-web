<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="/WEB-INF/layout/head.jsp"%> 
		<title> <sitemesh:write property='title' /></title>
		<link rel="stylesheet" type="text/css" href="${CSS }/decorator/decorator.css?${V}">
		<sitemesh:write property='head' />
	</head>
	<body>
		<sitemesh:write property='body' />
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>select</title>
<link rel="stylesheet" type="text/css"
	href="${JQUERY}/select2/select2.css?${V}">
</head>
<body>

	
	
	<select class="select2">
	</select>
	<input id="btn2" type="button" value="远程分页获取值">
	
	<select class="select3">
	</select>
	<input id="btn3" type="button" value="远程获取值">

	<select class="select1">
	</select>
	<input id="btn1" type="button" value="本地数据获取值">
	
	
	<script type="text/javascript" src="${JQUERY}/select2/zh-CN.js"></script>
	<script type="text/javascript" src="${JS}/test/select2.js?${V}"></script>
</body>
</html>
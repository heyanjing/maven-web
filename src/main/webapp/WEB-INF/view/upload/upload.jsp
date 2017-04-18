<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>spring upload</title>
	</head>
	<body>
		<form action="${CTX}/upload/test" method="post" enctype="multipart/form-data">
			<label>选择文件:</label>
			<input type="file" name="file">
			<input type="submit" value="提交">
		</form>
		<a href="${CTX}/home">跳转首页</a>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>spring home</title>
</head>
<body>
	<div id="hand"></div>
	
	
	
	<script id="entry-template1" type="text/x-handlebars-template">    
	{{#each arr}}
	{{@key}}{{name}}
	{{age}}
{{/each}}
</script>



	<script type="text/javascript" src="${JS}/test/handlebars.js?${V}"></script>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>spring home</title>
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/page/normalize.css?${V}">
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/page/pagination.css?${V}">
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/page/common.css?${V}">
        <script type="text/javascript" src="${PAG}/jquery.pagination.js"></script>
    </head>
    <body>
    	<div id="content"></div>
    	<div class="M-box"></div>
        
        
        
         <script id="myTemplate" type="text/x-jsrender">
			<!--/ 是index的结束标签-->
            {{index #getIndex()/}}
            id: {{:id}}
            name: {{:name}}
            age: {{:age}}
            data: {{:#data.name}}
            <br/>
        </script>
        
        
        
        
        
        
        <script type="text/javascript" src="${JS}/test/page_jsrender2.js?${V}"></script>
        <script type="text/javascript" src="${JS}/test/testMoment.js?${V}"></script>
    </body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>spring home</title>
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/pagination.css?${V}">
        <script type="text/javascript" src="${PAG}/pagination.js"></script>
    </head>
    <body>
    	<!--正文  -->
        <div id="content"></div>
        <!-- 分页 -->
        <div id="page"></div>
        <br/>
        <input id="search" type="button" value="查询">
        
        
        
        
        
        
        
        
        <script id="myTemplate" type="text/x-jsrender">
			<!--/ 是index的结束标签-->
            {{index #getIndex()/}}
            id: {{:id}}
            name: {{:name}}
            age: {{:age}}
            data: {{:#data.name}}
            <br/>
        </script>
        
        
        <script type="text/javascript" src="${JS}/test/page_jsrender_opts.js?${V}"></script>
        <script type="text/javascript" src="${JS}/test/page_jsrender.js?${V}"></script>
    </body>
</html>
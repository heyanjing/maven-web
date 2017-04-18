<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>spring home</title>
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/pagination.css?${V}">
    </head>
    <body>
        <div id="content"></div>
        
        
        
        
        
        
        
        
        
        <script id="myTemplate" type="text/x-jsrender">
            {{num #getIndex()/}}
            id: {{:id}}
            name: {{:name}}
            age: {{:age}}
            data: {{:#data.name}}
            <br/>
        </script>
        
        
        
        <script type="text/javascript" src="${JS}/test/test.js?${V}"></script>
    </body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>spring home</title>
        <link rel="stylesheet" type="text/css" href="${CSS }/test/test.css?${V}">
        <link rel="stylesheet" type="text/css" href="${CSS }/pagination/pagination.css?${V}">
    </head>
    <body>
        <div id="tpl">
            
        </div>
        <script id="teamTemplate" type="text/x-jsrender">
            {{if arr.length>0}}
                11111111
            {{/if}}
            {{for arr}}
                {{:#parent.parent.length}}
            {{/for}}
        </script>
        <script type="text/javascript" src="${JS}/test/jsrender.js?${V}"></script>
    </body>
</html>
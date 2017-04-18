<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JqueryUI</title>
<%--         <link rel="stylesheet" type="text/css" href="${LIBS}/jquery/jqueryUI/jquery-ui.css"> --%>
        <link rel="stylesheet" type="text/css" href="${LIBS}/jquery/datetimepicker/jquery.datetimepicker.min.css">
    </head>
    <body>
    <input id="datetimepicker" type="text" >
    <br/>
    <input id="startDate"  type="text" >至 <input id="endDate" type="text" >
    
    
<%--     <script type="text/javascript" src="${LIBS}/jquery/jqueryUI/jquery-ui.js"></script> --%>
    <script type="text/javascript" src="${LIBS}/jquery/datetimepicker/jquery.datetimepicker.full.min.js"></script>
    <script type="text/javascript" src="${JS}/test/jqueryui.js"></script>
    </body>
</html>
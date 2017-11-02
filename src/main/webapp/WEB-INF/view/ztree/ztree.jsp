<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JqueryUI</title>
        <link rel="stylesheet" type="text/css" href="${LIBS}/ztree/css/zTreeStyle/zTreeStyle.css">
    </head>
    <body>
        ${a.b}

            <c:if test="${not empty  a and a.b=='xx' }">
                selected="selected"
            </c:if>
        <div>
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <input id="btn" type="button" value="按钮" />
        <script type="text/javascript" src="${JS}/ztree/ztree.js"></script>
    </body>
</html>
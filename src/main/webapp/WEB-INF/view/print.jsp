<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>spring home</title>
        <object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
            <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
        </object>
    </head>
    <body>
        <a href="javascript:check();">检查</a>
        <a href="javascript:LODOP.PRINT_DESIGN();">设计</a>
        <a href="javascript:view1();">预览1</a>
        <a href="javascript:view2();">预览2</a>
        <script type="text/javascript" src="${JS}/test/print.js?${V}"></script>
<script lang="javascript" type="text/javascript">

</script>
    </body>
</html>
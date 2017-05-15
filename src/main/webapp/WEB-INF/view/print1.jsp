<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/layout/jspTaglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <script type="text/javascript" src="${JS}/test/jatoolsPrinter.js?${V}"></script>
    <!--
    插入打印控件 -->
    <object id="jatoolsPrinter" classid="clsid:b43d3361-d075-4be2-87fe-057188254255" codebase="jatoolsPrinter.cab#version=5,0,0,0"></object>

    <title>套打位置的拖放调整</title>
    <style>
        .#page1 DIV {
            POSITION: absolute
        }
    </style>

    <script language="JavaScript">
        function doPrint() {

            myDoc = {
                settings: {
                    paperWidth: 4200,   //指定纸张的宽度单位是十分之一毫米
                    paperHeight: 3900,  //指定纸张的高度
                },
                documents: document,
                marginIgnored: true,  //零边距打印
                dragDesigner: {viewSource: true},
                settingsID: 'mydoc3',
                copyrights: "杰创软件拥有版权 www.jatools.com"
            }

            getJatoolsPrinter().printPreview(myDoc);
        }
    </script>
</head>
<body>
<p class="title">套打位置的拖放调整
    <input type="button" value="打印预览..." onclick="doPrint()"></p>

<div id="page1" style='width:420mm;height:290mm;position:relative'>
    <img src="${IMG}/test/资质.jpg" style='width:420mm;height:290mm;'/>
</div>

</body>
</html>
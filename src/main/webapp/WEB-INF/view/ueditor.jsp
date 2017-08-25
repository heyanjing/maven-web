<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/layout/jspTaglib.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script type="text/javascript" charset="utf-8" src="${UE}/ueditor.config.js?2023"></script>
    <script type="text/javascript" charset="utf-8" src="${UE}/ueditor.all.js?2023"> </script>
    <script type="text/javascript" charset="utf-8" src="${UE}/lang/zh-cn/zh-cn.js?2023"></script>
    <script type="text/javascript" charset="utf-8" src="${UE}/formdesign/leipi.formdesign.v4.js?2023"></script>
</head>
<body>
    <input type="hidden" name="fields" id="fields" value="0">
    <div style="width: 200px;float: left">
        <ul class="nav nav-list">
            <li class="nav-header">两栏布局</li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('text');" class="btn btn-link">文本框</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('textarea');" class="btn btn-link">多行文本</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('select');" class="btn btn-link">下拉菜单</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('radios');" class="btn btn-link">单选框</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('checkboxs');" class="btn btn-link">复选框</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('macros');" class="btn btn-link">宏控件</a></li>
            <%--<li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('progressbar');" class="btn btn-link">进度条</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('qrcode');" class="btn btn-link">二维码</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('listctrl');" class="btn btn-link">列表控件</a></li>
            <li><a href="javascript:void(0);" onclick="leipiFormDesign.exec('more');" class="btn btn-link">一起参与...</a></li>--%>

        </ul>

    </div>
    <div style="width: 800px;float: left">
        <script id="myFormDesign" type="text/plain" ></script>
    </div>
    <!-- script start-->
    <script type="text/javascript" src="${JS}/test/ueditor.js?${V}"></script>
    <!-- script end -->
</body>
</html>

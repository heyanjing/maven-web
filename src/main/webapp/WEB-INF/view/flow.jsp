<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/layout/jspTaglib.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <link href="${FLOW}/css/bootstrap/css/bootstrap.css?2025" rel="stylesheet" type="text/css" />
    <link href="${FLOW}/css/site.css?2025" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${FLOW}/js/flowdesign/flowdesign.css"/>
    <link rel="stylesheet" type="text/css" href="${FLOW}/js/jquery.multiselect2side/css/jquery.multiselect2side.css"/>
    <script charset="utf-8" src="${FLOW}/js/jquery-1.7.2.min.js"></script>
    <script src="${FLOW}/js/jquery-ui/jquery-ui-1.9.2-min.js" ></script>
    <script src="${FLOW}/js/jsPlumb/jquery.jsPlumb-1.3.16-all-min.js"></script>
    <script src="${FLOW}/js/jquery.contextmenu.r2.js"></script>
    <script src="${FLOW}/js/jquery.multiselect2side/js/jquery.multiselect2side.js"></script>
    <script src="${FLOW}/js/flowdesign/leipi.flowdesign.v3.js"></script>
</head>
<body>


    <!--contextmenu div-->
    <div id="processMenu" style="display:none;">
        <ul>
            <!--li id="pm_begin"><i class="icon-play"></i>&nbsp;<span class="_label">设为第一步</span></li-->
            <!--li id="pm_addson"><i class="icon-plus"></i>&nbsp;<span class="_label">添加子步骤</span></li-->
            <!--li id="pm_copy"><i class="icon-check"></i>&nbsp;<span class="_label">复制</span></li-->
            <li id="pmAttribute"><i class="icon-cog"></i>&nbsp;<span class="_label">属性</span></li>
            <li id="pmForm"><i class="icon-th"></i>&nbsp;<span class="_label">表单字段</span></li>
            <li id="pmJudge"><i class="icon-share-alt"></i>&nbsp;<span class="_label">转出条件</span></li>
            <li id="pmSetting"><i class=" icon-wrench"></i>&nbsp;<span class="_label">样式</span></li>
            <li id="pmDelete"><i class="icon-trash"></i>&nbsp;<span class="_label">删除</span></li>

        </ul>
    </div>
    <div id="canvasMenu" style="display:none;">
        <ul>
            <li id="cmSave"><i class="icon-ok"></i>&nbsp;<span class="_label">保存设计</span></li>
            <li id="cmAdd"><i class="icon-plus"></i>&nbsp;<span class="_label">添加步骤</span></li>
            <li id="cmRefresh"><i class="icon-refresh"></i>&nbsp;<span class="_label">刷新 F5</span></li>
            <!--li id="cmPaste"><i class="icon-share"></i>&nbsp;<span class="_label">粘贴</span></li-->
            <li id="cmHelp"><i class="icon-search"></i>&nbsp;<span class="_label">帮助</span></li>
        </ul>
    </div>
    <!--end div-->

    <div class="container mini-layout" id="flowdesign_canvas">
        <!--div class="process-step btn" style="left: 189px; top: 340px;"><span class="process-num badge badge-inverse"><i class="icon-star icon-white"></i>3</span> 步骤3</div-->
    </div> <!-- /container -->

    <script type="text/javascript" src="${JS}/test/flow.js?${V}"></script>
</body>
</html>

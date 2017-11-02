<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/layout/jspTaglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>select</title>
    <style type="text/css">
        * { margin:0; padding:0; }
        div.centent {
            float:left;
            text-align: center;
            margin: 10px;
        }
        span {
            display:block;
            margin:2px 2px;
            padding:4px 10px;
            background:#898989;
            cursor:pointer;
            font-size:12px;
            color:white;
        }
    </style>
</head>
<body>
    <div class="centent">
        <select multiple="multiple" id="select1" style="width:100px;height:160px;">
            <option value="1">选项1</option>
            <option value="2">选项2</option>
            <option value="3">选项3</option>
            <option value="4">选项4</option>
            <option value="5">选项5</option>
            <option value="6">选项6</option>
            <option value="7">选项7</option>
        </select>
        <div>
            <span id="add" >选中添加到右边>></span>
            <span id="add_all" >全部添加到右边>></span>
        </div>
    </div>
    <div class="centent">
        <select multiple="multiple" id="select2" style="width: 100px;height:160px;">
            <option value="8">选项8</option>
        </select>
        <div>
            <span id="remove"><<选中删除到左边</span>
            <span id="remove_all"><<全部删除到左边</span>
        </div>
    </div>

    <script type="text/javascript" src="${JS}/test/multiselect2.js?${V}"></script>
</body>
</html>
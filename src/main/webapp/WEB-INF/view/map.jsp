<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>百度地图</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Hello, World</title>
        <link rel="stylesheet" type="text/css" href="${CSS}/test/test4.css" />
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=T5ko2rxUUmqAfBRiyw688dM0B2wG1c5S"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/shangquan/forward/?qt=sub_area_list&ext=1&level=1&areacode=132&business_flag=0"></script>
    </head>

    <body>
        <div style="width:100%;height:100%;">
            <div id="container"></div>
        </div>
        <script type="text/javascript" src="${JS}/test/map.js?${V}"></script>
    </body>
</html>
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

    ${sessionId}
    <br/>
    ${session}
    <br/>
    ${userKey}
    <br/>
        ${page1}
        <br />
        ${page2}
        <br />

        <div class="test">
            <span> ${CTX}aa${model}${sessionScope.model} </span><label>xxx</label>
        </div>
        <br />
        <img alt=" " src="${IMG }/test/1.jpg">
        <img id="kaptcha" alt=" " src="${CTX}/kaptcha/kaptcha.jpg">
        <input id="kaptchaCode" type="text">
        <img id="" alt=" " src="${JQUERY}/me.png">

        <br />
        <a  href="${PDF}/web/viewer.html?file=${PDF}/compressed.tracemonkey-pldi-09.pdf">Open yourpdf.pdf with PDF.js</a>
        <br>
        <a href="${CTX}/home/upload">跳转上传页面</a>
        <input id="btn" type="button" value="提交">
        <script type="text/javascript" src="${JS}/test/test.js?${V}"></script>
        <div id="content">
            ${PAG }
        </div>
        <div id="demo"></div>
        <input id="test" type="button" value="ajax测试"/>
    </body>
</html>
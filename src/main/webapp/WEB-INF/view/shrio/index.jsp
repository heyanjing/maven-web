<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/layout/jspTaglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">退出</a>
</shiro:user>


<br/>
${a=1}<br/>
${b=2}<br/>
${a=a+=b}<br/>
${a}<br/>
${a=1;123}<br/>
${sessionId}
<br/>
${session}
<br/>
<a id="login" href="/spring/user/login?userName=何彦静&password=123456">何彦静登陆</a>
<a id="login" href="/spring/user/login?userName=陈友兰&password=123456">陈友兰登陆</a>
    <a href="/spring/user/reg?userName=何彦静&password=123456">注册</a>
    <a href="/spring/user/logout">注销</a>
    ${result}
<script type="text/javascript">
</script>

</body>
</html>

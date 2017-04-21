<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<shiro:hasRole name="user1">
    <a href="/spring/page1">页面一，角色user1才能访问</a>
</shiro:hasRole>
<shiro:hasRole name="user2">
    <a href="/spring/page2">页面二，角色user2才能访问</a>
</shiro:hasRole>
<a href="/spring/user/logout">注销</a>
${result}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

    $('#login').on('click',function () {

    });
</script>

</body>
</html>

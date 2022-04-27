<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/25
  Time: 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<a style="font-size: 24px" href="home">首页</a>
<form action="loginServlet" method="post">
    姓名：<input type="text" id="uname" name="uname"><br>
    密码：<input type="password" id="password" name="upd"><br>
    <input type="submit" value="提交">
    <%--<span style="color: firebrick;font-size:12px"><%=request.getAttribute("msg")%></span>--%>
    <span style="color: firebrick;font-size:12px">${msg}</span>
</form>
</body>
</html>

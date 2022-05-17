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
<jsp:include page="02-header.jsp"></jsp:include><br>
<form action="mydearservlet" method="post">
    name：<input type="text" id="name" name="name"><br>
    class：<input type="password" id="class" name="class"><br>
    ID：<input type="password" id="ID" name="ID"><br>

    <input type="submit" value="send data to server">
    <%--<span style="color: firebrick;font-size:12px"><%=request.getAttribute("msg")%></span>--%>
<%--    <span style="color: firebrick;font-size:12px">${msg}</span>--%>
</form>
</body>
</html>

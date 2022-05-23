<%@ page import="com.chengxin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/4/12
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<%User user= (User) session.getAttribute("user");%>
<body>
<h3>
    User Info
</h3>
<table >
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Birthdate:</td><td><%=user.getBirthdate()%></td></tr>
    <tr><td><a href="updateUser">Update User</a></td></tr>

</table>
</body>
</html>
<%@include file="footer.jsp"%>

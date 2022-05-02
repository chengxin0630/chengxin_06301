<%@ page import="com.chengxin.model.User" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: always
  Date: 2022/4/15
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User </h1>

<%
    User u =(User) session.getAttribute("user");
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    String birth=df.format(u.getBirthDate());
%>
<form method="post" action="updateUser"><!--action to link jsp  to servlet -->
    <input type="hidden" name="id" value="<%=u.getId()%>">
    Username <input type="text" name="username" value="<%=u.getUsername()%>"/><br/>
    password <input type="password" name="password" value="<%=u.getPassword()%>"/><br/>
    Email <input type="text" name="email" value="<%=u.getEmail()%>"/><br/>

    Gender <input type="radio" name="gender" value="male" <%= "male".equals(u.getGender())?"checked" :""%>>Male
           <input type="radio" name="gender" value="female" <%= "female".equals(u.getGender())?"checked" :""%>>Female <br/>
    Birth Date <input type="text" name="birthDate" value="<%=birth%>"/><br/>
    <input type="submit" value="Save Changes"/>

</form>
<%@include file="footer.jsp"%>
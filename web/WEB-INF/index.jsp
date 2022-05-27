<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>

<html>
<head>
    <title>JSP - Home Page</title>
</head>
<body>
<h1><%= "Home Page" %></h1>
</body>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>
    <input value="Search" type="submit">
</form>

</html>

<%@include file="footer.jsp"%>

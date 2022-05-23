<%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/4/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Login</h3>
<%
    //    PrintWriter writer=response.getWriter();
    if(!(request.getAttribute("message") == null)){
        out.println("<h4>"+request.getAttribute("message")+"</h4>");
    }
%>
    <form action="login" method="post">
        <table>
            <tr> <td class="right">Username: </td>
                <td><input type="text" id="username" name="inName"/></td>
            </tr>
            <tr> <td class="right">Password: </td>
                <td><input type="password" id="password" style="ime-mode:disabled" name="inPwd" /></td>
            </tr>
            <tr><td></td>
                <td>
                    <input type="submit" value="login" onClick="return validateLogin()">
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>
<script language="javascript">
    function validateLogin(){
        var userName = document.getElementById("username");
        var password = document.getElementById("password");
        if (userName.value.length == 0){
            alert("请输入用户名!");
            return false;
        }

        if (password.value.length == 0){
            alert("请输入密码!");
            return  false;
        }
    }
</script>
</body>
</html>
<%@include file="footer.jsp"%>

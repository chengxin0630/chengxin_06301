<%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/4/24
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
  User u=(User) session.getAttribute("user");
%>
<form action="updateUser" method="post">
    <table>
        <input type="hidden" name="id" value="<%=u.getId()%>">
        <tr> <td class="right">Username: </td> <td><input type="text" name="uName" value="<%=u.getUsername()%>"/></td></tr>
        <tr> <td class="right">Password: </td> <td>
            <input type="password" id="password" value="<%=u.getPassword()%>" style="ime-mode:disabled" name="uPwd" onBlur = "restriction()"/>
        </td></tr>

        <tr>
            <td class="right">Gender: </td>
            <td>
                <input type="radio" name="uSex" value="Male" <%="Male".equals(u.getGender()) ?"checked":""%>/>Male
                <input type="radio" name="uSex" value="Female" <%="Female".equals(u.getGender()) ?"checked":""%>/> Female
            </td>
        </tr>

        <tr><td class="right">Email: </td><td><input type="email" name="uEmail" value="<%=u.getEmail()%>"/></td></tr>
        <tr><td class="right">Birthdate: </td><td><input type="date" name="uDate" value="<%=u.getBirthdate()%>"/></td></tr>

        <tr>
            <td></td>
            <td>
            <input type="submit" value="Save Changes" onclick="return restriction()">
            <input type="reset" value="Reset">
            </td>
        </tr>

    </table>
</form>
<%@include file="footer.jsp"%>

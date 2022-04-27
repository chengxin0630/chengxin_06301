package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("运行了");
        request.setCharacterEncoding("UTF-8");
        String uname=request.getParameter("uname");
        String upd=request.getParameter("upd");
        System.out.println(uname);
        if("".equals(uname)) {
            request.setAttribute("msg", "用户名称不能为空！");

            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if("".equals(upd)) {
            request.setAttribute("msg", "用户密码不能为空！");

            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if("admin".equals(uname)||"111".equals(upd)){
            request.setAttribute("msg","登录失败！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        request.getSession().setAttribute("uname",uname);
        response.sendRedirect("login1.jsp");
    }
}

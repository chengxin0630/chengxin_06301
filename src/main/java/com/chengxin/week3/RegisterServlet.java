package com.chengxin.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(
        value ="/register"
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("uName");
        String password=request.getParameter("uPwd");
        String gender=request.getParameter("uSex");
        String email=request.getParameter("uEmail");
        String birthdate=request.getParameter("uDate");

        String sql="insert into userTable values(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, gender);
            pstmt.setString(4, email);
            pstmt.setString(5, birthdate);
            pstmt.executeUpdate();

            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}



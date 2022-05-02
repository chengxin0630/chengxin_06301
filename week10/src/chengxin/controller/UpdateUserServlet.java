package com.chengxin.controller;

import com.chengxin.dao.UserDao;
import com.chengxin.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1 : forward to WEB-INF/views/UpdateUser.jsp
        //TODO 2 : create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1 : get all (6) request parameters
        //TODO 2 : create an object of User Model
        //TODO 3 : set all 6 request parameters values into User model - setXXX()
        //TODO 4 : create an object of UserDao
        //TODO 5 : Call updateUser() in UserDao
        //TODO 6 : forward to WEB-INF/views/UserInfo.jsp
        int id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String birthDate=request.getParameter("birthDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        User u=new User(id,username,password,email,gender,date);
        UserDao d=new UserDao();
        Connection con=(Connection) request.getServletContext().getAttribute("con");
        if(con!=null) System.out.println("success!!!");
        else System.out.println("err!!!");
        int res=0;
        try {
            res= d.updateUser(con,u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(res==1){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",u);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        }else{
            System.out.println("err!!!");
        }
    }
}

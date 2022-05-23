package com.chengxin.controller;

import com.chengxin.dao.UserDao;
import com.chengxin.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        UserDao userDao=new UserDao();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        request.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("uName");
        String password=request.getParameter("uPwd");
        String gender=request.getParameter("uSex");
        String email=request.getParameter("uEmail");
        String birthdate=request.getParameter("uDate");

        Date date = null;
        try {
            date = formatter.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setEmail(email);
        user.setBirthdate(date);
        try {
            userDao.updateUser(con,user);
            user=userDao.findById(con,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        request.getRequestDispatcher("accountDetails").forward(request,response);
//        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}

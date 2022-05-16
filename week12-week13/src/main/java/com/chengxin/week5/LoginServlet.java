package com.chengxin.week5;

import com.chengxin.dao.UserDao;
import com.chengxin.model.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDao();

        String inUsername=request.getParameter("inName");
        String inPassword=request.getParameter("inPwd");
        System.out.println(inUsername+inPassword);
        try {
            User user=userDao.findByUsernamePassword(con,inUsername,inPassword);
            System.out.println(user);
            if(user != null){
                if(!(request.getParameter("rememberMe") == null || request.getParameter("rememberMe").length() == 0)){
                    if(request.getParameter("rememberMe").equals("1")){
                        Cookie usernameCookies=new Cookie("cUsername",user.getUsername());
                        Cookie passwordCookies=new Cookie("cPassword",user.getPassword());
                        Cookie rememberMeCookies=new Cookie("cRememberMe",request.getParameter("rememberMe"));

                        usernameCookies.setMaxAge(5);
                        passwordCookies.setMaxAge(5);
                        rememberMeCookies.setMaxAge(5);

                        response.addCookie(usernameCookies);
                        response.addCookie(passwordCookies);
                        response.addCookie(rememberMeCookies);
                    }
                }

                HttpSession session=request.getSession();
                System.out.println("id-->"+session.getId());

//                request.setAttribute("user",user);
                session.setAttribute("user",user);

                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","wrong user name or password!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.setContentType("text/html;charset=gbk");

    }
}

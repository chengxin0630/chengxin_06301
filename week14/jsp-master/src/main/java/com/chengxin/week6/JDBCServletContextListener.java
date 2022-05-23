package com.chengxin.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection con=null;
        ServletContext context=sce.getServletContext();

        String driver=context.getInitParameter("driver");
        String dbURL=context.getInitParameter("dbURL");
        String userName=context.getInitParameter("userName");
        String userPwd=context.getInitParameter("userPwd");

        System.out.println("输出"+driver+dbURL+userName+userPwd);

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("--->JDBCConnect "+con);
            context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("con");
    }
}

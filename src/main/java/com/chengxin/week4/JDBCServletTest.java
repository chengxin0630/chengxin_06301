package com.chengxin.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="dbURL",value = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=userdb"),
                @WebInitParam(name="userName",value = "sa"),
                @WebInitParam(name="userPwd",value = "123456"),
        },loadOnStartup = 1
)
public class JDBCServletTest extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
//        String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=userdb";	//
//        String userName = "sa";
//        String userPwd = "123456";
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String dbURL=config.getInitParameter("dbURL");
        String userName=config.getInitParameter("userName");
        String userPwd=config.getInitParameter("userPwd");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("--->init "+con);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sql="select * from userTable";
//        try {
//            ResultSet rs = con.createStatement().executeQuery(sql);
//            while (rs.next()){
//
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
//    Caused by: java.lang.IllegalArgumentException: 名为 [JDBCServlet]和 [com.JiangTao.week4.JDBCServlet] 的servlet不能映射为一个url模式(url-pattern) [/jdbc]

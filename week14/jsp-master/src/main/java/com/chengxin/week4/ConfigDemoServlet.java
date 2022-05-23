package com.chengxin.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet(
////        method 1
//        urlPatterns = {"/config"},
//        initParams = {
//                @WebInitParam(name="id",value = "2019211001000709"),
//                @WebInitParam(name="name",value = "JiangTao"),
//        },loadOnStartup = 1
//)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String id=config.getInitParameter("id");
        String name=config.getInitParameter("name");

        PrintWriter writer= response.getWriter();
        writer.println("studentId: "+id);
        writer.println("name: "+name);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

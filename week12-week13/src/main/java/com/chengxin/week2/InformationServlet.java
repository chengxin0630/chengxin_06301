package com.chengxin.week2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet(value = "/informationServlet")
public class InformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /**
         * doGet()只要http 协议是1.1就返回405，不然就返回400，直接报错
         */

        PrintWriter writer= resp.getWriter();
        writer.println("Name:JiangTao");
        writer.println("ID:2019211001000709");
        Date date=new Date();
        writer.println(date);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


package com.chengxin.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String txt=request.getParameter("txt");

        System.out.println(txt);
        if(txt.trim().equals("")){
            response.sendRedirect("index.jsp");
        }
        else{
            String search=request.getParameter("search");
            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+ URLEncoder.encode(txt,"UTF-8"));//中文转码
            }
            else if(search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+URLEncoder.encode(txt,"UTF-8"));
            }
            else if(search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+URLEncoder.encode(txt,"UTF-8"));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

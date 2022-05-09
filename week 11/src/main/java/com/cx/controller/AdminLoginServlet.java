package com.cx.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AdminLoginServlet", value = "/admin/login")
public class AdminLoginServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../WEB-INF/views/admin/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

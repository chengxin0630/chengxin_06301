package com.chengxin.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in AuthFilter-->dpFilter()- before servlet-(request come here )");

        chain.doFilter(request, response);

        System.out.println("i am i AuthFilter-->doFilter()- AFTER servlet-(response come here )");
    }
}

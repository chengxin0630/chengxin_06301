package com.chengxin.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns ="/*",
initParams ={@WebInitParam(name ="characterEncoding",value = "utf-8")})
public class CharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;
    private String characterEncoding;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;
        characterEncoding = this.filterConfig.getInitParameter("characterEncoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(null != characterEncoding){
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
        }
        chain.doFilter(request, response);
    }
}

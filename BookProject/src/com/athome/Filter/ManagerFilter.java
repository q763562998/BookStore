package com.athome.Filter;

import com.athome.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
       User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user!=null){
            chain.doFilter(request,response);
        }
        else {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}

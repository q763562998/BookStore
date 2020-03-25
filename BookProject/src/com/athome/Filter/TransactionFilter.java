package com.athome.Filter;

import com.athome.utils.Jdbc_teach_util;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        try {
            chain.doFilter(request,response);
            Jdbc_teach_util.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            Jdbc_teach_util.rollbackAndClose();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}

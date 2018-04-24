package com.mybank.fundtrans.controller;

import com.mybank.fundtrans.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthorityFilter", urlPatterns = "*.jsp")
public class AuthorityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("login.jsp").forward(req, response);
        } else {
            chain.doFilter(req, rep);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

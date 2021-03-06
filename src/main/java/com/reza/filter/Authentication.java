package com.reza.filter;

import com.reza.bean.Customer;
import com.reza.util.DatabaseUtil;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class Authentication implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getSession(false) == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("../login.jsp");
        } else if (((HttpServletRequest)servletRequest).getSession(true).getAttribute("customer") == null) {
            Session session = DatabaseUtil.getSessionFactory().openSession();
            Set<Customer> customers = DatabaseUtil.getAllEntities(session, Customer.class);
            String username = "";
            String password = "";
            boolean isAuthenticated = false;
            HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
            if (servletRequest.getParameter("username") != null && servletRequest.getParameter("password") != null) {
                username = servletRequest.getParameter("username");
                password = servletRequest.getParameter("password");
                for (Customer i : customers) {
                    if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
                        httpSession.setAttribute("customer", i);
                        Cookie usernameCookie = new Cookie("username", username);
                        usernameCookie.setMaxAge(60 * 60 * 24);
                        Cookie passwordCookie = new Cookie("password", password);
                        passwordCookie.setMaxAge(60 * 60 * 24);
                        ((HttpServletResponse)servletResponse).addCookie(usernameCookie);
                        ((HttpServletResponse)servletResponse).addCookie(passwordCookie);
                        isAuthenticated = true;
                    }
                }
            } else if (((HttpServletRequest)servletRequest).getCookies().length != 0) {
                Cookie[] cookies = ((HttpServletRequest)servletRequest).getCookies();
                for (Cookie i : cookies) {
                    if (i.getName().equals("username")) {
                        username = i.getValue();
                    }
                    if (i.getName().equals("password")) {
                        password = i.getValue();
                    }
                }
                if (username != "" && password != "") {
                    for (Customer i : customers) {
                        if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
                            httpSession.setAttribute("customer", i);
                            Cookie usernameCookie = new Cookie("username", username);
                            usernameCookie.setMaxAge(60 * 60 * 24);
                            Cookie passwordCookie = new Cookie("password", password);
                            passwordCookie.setMaxAge(60 * 60 * 24);
                            ((HttpServletResponse)servletResponse).addCookie(usernameCookie);
                            ((HttpServletResponse)servletResponse).addCookie(passwordCookie);
                            isAuthenticated = true;
                        }
                    }
                }
            }
            if (isAuthenticated) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse)servletResponse).sendRedirect("../login.jsp");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

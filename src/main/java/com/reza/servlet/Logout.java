package com.reza.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        Cookie usernameCookie = new Cookie("username", "");
        Cookie passwordCookie = new Cookie("password", "");
        usernameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        resp.addCookie(usernameCookie);
        resp.addCookie(passwordCookie);
        req.getRequestDispatcher("../login.jsp").include(req, resp);
    }
}

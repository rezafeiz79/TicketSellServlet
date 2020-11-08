package com.reza.servlet;

import com.reza.bean.Customer;
import com.reza.util.DatabaseUtil;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Customer customer = new Customer(null, req.getParameter("name"),
                req.getParameter("gender"), req.getParameter("username"),
                req.getParameter("password"), null);
        DatabaseUtil.saveEntity(session, customer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }
}

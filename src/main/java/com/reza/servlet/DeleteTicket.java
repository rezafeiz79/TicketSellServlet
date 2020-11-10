package com.reza.servlet;

import com.reza.bean.Ticket;
import com.reza.util.DatabaseUtil;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Ticket ticket = DatabaseUtil.getEntityById(session, Integer.parseInt(req.getParameter("ticketId")), Ticket.class);
        DatabaseUtil.deleteEntity(session, ticket);
        req.setAttribute("ticket", ticket);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(req, resp);
    }
}

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

public class TicketDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(req.getParameter("ticketId"));
        Ticket ticket = DatabaseUtil.getEntityById(session, id, Ticket.class);
        req.setAttribute("ticket", ticket);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ticketDetail.jsp");
        requestDispatcher.forward(req, resp);
    }
}

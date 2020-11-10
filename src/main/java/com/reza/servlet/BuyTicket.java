package com.reza.servlet;

import com.reza.bean.Customer;
import com.reza.bean.Ticket;
import com.reza.bean.Trip;
import com.reza.util.DatabaseUtil;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuyTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Trip trip = DatabaseUtil.getEntityById(session, Integer.parseInt(req.getParameter("tripId")), Trip.class);
        Ticket ticket = new Ticket(null, trip, (Customer) req.getSession().getAttribute("customer"));
        DatabaseUtil.saveEntity(session, ticket);
        ticket.setId(12);
        req.setAttribute("ticket", ticket);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(req, resp);
    }
}

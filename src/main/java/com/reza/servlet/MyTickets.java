package com.reza.servlet;

import com.reza.bean.Customer;
import com.reza.bean.Ticket;
import com.reza.util.DatabaseUtil;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class MyTickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Set<Ticket> tickets = DatabaseUtil.getAllEntities(session, Ticket.class);
        List<Ticket> resultList = new ArrayList<>();
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        for (Ticket i : tickets) {
            if (customer.getId() == i.getCustomer().getId()) {
                resultList.add(i);
            }
        }
        if (!resultList.isEmpty()) {
            resultList.sort(Comparator.comparing((Ticket t) -> t.getTrip().getMoveDate()));
            req.setAttribute("resultList", resultList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("myTickets.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("searchTicket.jsp");
        }
    }
}

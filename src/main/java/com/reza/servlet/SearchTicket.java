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
import java.time.LocalDate;
import java.util.*;

public class SearchTicket extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Set<Ticket> tickets = DatabaseUtil.getAllEntities(session, Ticket.class);
        String originCity = req.getParameter("originCity");
        String destinationCity = req.getParameter("destinationCity");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        List<Ticket> resultTickets = new ArrayList<>();
        for (Ticket i : tickets) {
            if (i.getTrip().getOriginCity().equals(originCity) &&
                    i.getTrip().getDestinationCity().equals(destinationCity) &&
                    i.getTrip().getMoveDate().isEqual(date)) {
                resultTickets.add(i);
            }
        }
        resultTickets.sort(Comparator.comparing((Ticket t) -> t.getTrip().getMoveTime()));
        req.setAttribute("resultList", resultTickets);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("serviceJSPPages/ticketList.jsp");
        requestDispatcher.forward(req, resp);
    }
}

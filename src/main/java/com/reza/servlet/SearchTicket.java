package com.reza.servlet;

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
import java.time.LocalDate;
import java.util.*;

public class SearchTicket extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = DatabaseUtil.getSessionFactory().openSession();
        Set<Trip> trips = DatabaseUtil.getAllEntities(session, Trip.class);
        String originCity = req.getParameter("originCity");
        String destinationCity = req.getParameter("destinationCity");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        List<Trip> resultTrips = new ArrayList<>();
        for (Trip i : trips) {
            if (i.getOriginCity().equals(originCity) &&
                    i.getDestinationCity().equals(destinationCity) &&
                    i.getMoveDate().isEqual(date)) {
                resultTrips.add(i);
            }
        }
        if (!resultTrips.isEmpty()) {
            Comparator<Trip> compare = Comparator.comparing(Trip::getId);
            Collections.sort(resultTrips, compare);
            req.setAttribute("resultList", resultTrips);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("ticketList.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("searchTicket.jsp");
        }
    }
}

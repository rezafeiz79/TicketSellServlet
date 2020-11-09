<%@ page import="com.reza.bean.Customer" %>
<%@ page import="com.reza.bean.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 11/8/2020
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><%= ((Customer)request.getSession().getAttribute("customer")).getName() + "'s Tickets" %></title>
    </head>
    <body>
    <table>
        <tr>
            <th>Tickets</th>
        </tr>
        <tr>
            <th>Choose</th>
            <th>Ticket ID</th>
            <th>Date</th>
        </tr>
        <% for (Ticket i : (List<Ticket>)request.getAttribute("resultList")) { %>
        <tr>
            <td><a href="<%= "service/TicketDetail?ticketId=" + i.getId() %>">Show</a></td>
            <td><%= i.getId() %></td>
            <td><%= i.getTrip().getMoveDate() %></td>
        </tr>
        <% } %>
    </table>
    </body>
</html>

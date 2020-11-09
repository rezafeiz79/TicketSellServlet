<%@ page import="com.reza.bean.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 11/8/2020
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Ticket ID: <%= ((Ticket)request.getAttribute("ticket")).getId() %></title>
    </head>
    <body>
        <table>
            <tr>
                <th>Ticket</th>
            </tr>
            <tr>
                <td>Ticket ID</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getId() %></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getCustomer().getName() %></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getCustomer().getGender() %></td>
            </tr>
            <tr>
                <td>Origin City</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getTrip().getOriginCity() %></td>
            </tr>
            <tr>
                <td>Destination City</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getTrip().getDestinationCity() %></td>
            </tr>
            <tr>
                <td>Date</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getTrip().getMoveDate() %></td>
            </tr>
            <tr>
                <td>Time</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getTrip().getMoveTime() %></td>
            </tr>
            <tr>
                <td>Trip ID</td>
                <td><%= ((Ticket)request.getAttribute("ticket")).getTrip().getId() %></td>
            </tr>
            <tr>
                <td><a href=<%= "service/DeleteTicket?ticketId=" + ((Ticket)request.getAttribute("ticket")).getTrip().getId() %>>Delete Ticket</a></td>
            </tr>
        </table>
    </body>
</html>

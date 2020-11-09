<%@ page import="com.reza.bean.Trip" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 11/8/2020
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tickets List</title>
    </head>
    <body>
        <table style="width:100%">
            <tr>
                <th><%= ((List<Trip>)request.getAttribute("resultList")).get(0).getOriginCity() + " - " + ((List<Trip>)request.getAttribute("resultList")).get(0).getDestinationCity() %></th>
                <th>Date: <%= ((List<Trip>)request.getAttribute("resultList")).get(0).getMoveDate() %></th>
            </tr>
            <tr>
                <th>Choose</th>
                <th>Time</th>
                <th>Trip Id</th>
            </tr>
            <% for (Trip i : (List<Trip>)request.getAttribute("resultList")) { %>
                <tr>
                    <th><a href="<%= "./service/BuyTicket?tripId=" + i.getId() %>">Buy</a></th>
                    <th><%= i.getMoveTime() %></th>
                    <th><%= i.getId() %></th>
                </tr>
            <% } %>
        </table>
    </body>
</html>

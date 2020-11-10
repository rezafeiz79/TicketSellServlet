<%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 11/8/2020
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Serch Tickets</title>
    </head>
    <body>
        <form action="SearchTicket" method="post">
            Origin City:<input type="text" name="originCity"><br>
            Destination City:<input type="text" name="destinationCity"><br>
            Date:<input type="date" name="date"><br>
            <input type="submit" value="Serach">
        </form>
        <h1><a href="MyTickets">MyTickets</a></h1>
    </body>
</html>
<%@ page import="com.reza.bean.Customer" %>
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
        <title>Success</title>
    </head>
    <body>
        <%
            String prefix = "";
            if (((Customer)request.getAttribute("customer")).getGender().equals("male")) {
                prefix = "Mister ";
            } else if (((Customer)request.getAttribute("customer")).getGender().equals("female")) {
                prefix = "Ms ";
            }
        %>
        <h1>Success</h1>
        <p><%= prefix + ((Customer)request.getAttribute("customer")).getName() %></p>
        <p><%= ((Ticket)request.getAttribute("ticket")).getId() %></p>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 11/8/2020
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="service/searchTicket.jsp" method="post">
            Username:<input type="text" name="username"/><br/>
            Password:<input type="password" name="password"/><br/>
            <input type="submit" value="Login">
        </form>
        <% String name = (String)request.getAttribute("LoginFailedMessage"); %>
        <%= name %>
    </body>
</html>

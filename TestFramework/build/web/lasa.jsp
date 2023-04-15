<%-- 
    Document   : lasa
    Created on : Mar 24, 2023, 8:51:44 AM
    Author     : yohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Models.*,java.util.Vector" %>
<%
    Vector<Emp> all=(Vector<Emp>)request.getAttribute("list");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Framework Works!</h1>
        <% for(Emp emp: all){ %>
        <p><%=emp.getNom() %></p>
        <% } %>
    </body>
</html>

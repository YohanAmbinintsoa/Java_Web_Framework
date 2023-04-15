<%-- 
    Document   : lasa
    Created on : Mar 24, 2023, 8:51:44 AM
    Author     : yohan
--%>
<%@page import="Models.*,java.util.Vector" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector<Emp> all=(Vector<Emp>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Framework Works!</h1>
        <% for(emp in all){ %>
            <%=emp.getNom() %>
        <% } %>
    </body>
</html>

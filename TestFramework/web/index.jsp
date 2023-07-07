<%-- 
    Document   : index
    Created on : Apr 18, 2023, 11:01:30 AM
    Author     : yohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nom="";
    if(request.getAttribute("nom")!=null){
        nom=(String)request.getAttribute("nom");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Sprint 8</h1>
        <a href="milay/get-all">Sprint 7</a>
        <br>
        <form action="milay/insertEmp" method="GET">
            <input type="text" name="nom"  placeholder="Nom employe">
            <input type="date" name="dateHeure">
            <input type="submit" value="Inserer">
        </form>
        <p><%=nom %></p>
        <h1>Login</h1>
        <form action="milay/check-user" method="get">
            <input type="text" name="user">
            <input type="submit" value="Valider">
        </form>
    </body>
</html>

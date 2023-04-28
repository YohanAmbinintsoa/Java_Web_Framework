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
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="milay/get-all">Lasa.jsp</a>
        <br>
        <form action="milay/insertEmp" method="GET">
            <input type="text" name="nom"  placeholder="Nom employe">
            <input type="date" name="dateHeure">
            <input type="submit" value="Inserer">
        </form>
        <p><%=nom %></p>
    </body>
</html>

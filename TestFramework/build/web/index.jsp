<%-- 
    Document   : index
    Created on : Apr 18, 2023, 11:01:30 AM
    Author     : yohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nom="";
    String id="";
    if(request.getAttribute("nom")!=null){
        nom=(String)request.getAttribute("nom");
    }
    if(request.getAttribute("id")!=null){
        id=(String)request.getAttribute("id");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sprint 8</h1>
        <a href="milay/get-all">Sprint 7</a>
        <br>
        <form enctype="multipart/form-data" action="milay/insertEmp" method="POST">
            <input type="text" name="nom"  placeholder="Nom employe">
            <input type="date" name="dateHeure">
            <input type="file" name="file" id="">
            <input type="submit" value="Inserer">
        </form>
        <p><%=nom %></p>
        <p><%=id %></p>
        <h1>Sprint 11</h1>
        <form action="milay/check-user" method="get">
            <input type="text" name="user" id="">
            <input type="submit" value="Valider">
        </form>
    </body>
</html>

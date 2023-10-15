%-- 
    Document   : Wlecome
    Created on : 10 oct. 2023, 12:20:14
    Author     : lenovo
--%>

<%@page import="ma.projet.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            h1 {
                color: #333;
                text-align: center;
                margin-top: 100px;
            }

            form {
                text-align: center;
                margin-top: 20px;
            }

            input[type="submit"] {
                background-color: #007BFF;
                color: #fff;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <%!Client c;%>
        <%

            HttpSession sessio = request.getSession();
            if (sessio != null) {
                c = (Client) sessio.getAttribute("client");
            } else {
                response.sendRedirect("Authentification.jsp");
            }
        %>
        <h1>Welcome MR : <%= c.getNom() + " " + c.getPrenom()%> </h1>
        <form action="Deconnexion">
            <input type="submit" value="Deconnecter">
        </form>

    </body>
</html>

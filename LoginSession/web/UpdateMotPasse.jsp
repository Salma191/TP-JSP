<%-- 
    Document   : UpdateMotPasse
    Created on : 10 oct. 2023, 18:04:49
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>nouveau mot de passe</legend>
            <form action="UpdateMotPasse" method="post">
                <table>
                    <tr>
                        <td>passworde:</td>
                        <td><input type="password" name="password"></td>
                        <td>confirmer password :</td>
                        <td><input type="password" name="passwordcnf"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Modifier"</td>
                    </tr>
                    <tr><td><h4><%= request.getParameter("msg")%></h4></td></tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>

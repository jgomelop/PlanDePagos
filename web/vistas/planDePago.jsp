<%-- 
    Document   : planDePago
    Created on : 3/04/2022, 11:07:09 PM
    Author     : Juan Pablo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan de pago</title>
    </head>
    <body>
        <h1>Plan de pago de crédito</h1>
        <h2>Información básica</h2>

        <table>
            <tbody>
                <tr>
                    <td> Credito ID</td>
                    <td>&nbsp;${credito.idCredito}</td>
                </tr>
                <tr>
                    <td> Nombre Cliente</td>
                    <td>&nbsp;${credito.nombreCliente}</td>
                </tr>
                <tr>
                    <td> Monto Inicial</td>
                    <td>&nbsp;${credito.montoInicial}</td>
                </tr>
                <tr>
                    <td> Plazo Meses</td>
                    <td>&nbsp;${credito.plazoMeses}</td>
                </tr>
                <tr>
                    <td> Tasa Interes</td>
                    <td>&nbsp;${credito.tasaInteres}</td>
                </tr>
            </tbody>
        </table>

        <form action="${pageContext.request.contextPath}/CreditoServlet" method="post">
            <input type="submit" name="action" value="Regresar" />
        </form>
    </body>
</html>

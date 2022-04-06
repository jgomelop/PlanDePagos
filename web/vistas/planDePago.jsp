<%-- 
    Document   : planDePago
    Created on : 3/04/2022, 11:07:09 PM
    Author     : Juan Pablo Gómez López
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Plan de pago</title>
    </head>
    <body>

        <div class="container w-50 mt-3 mb-5">

            <h1 class="mb-0">Plan de pago de crédito</h1>
            <br>
            <h2 class="mb-0">Información básica</h2>
            <br>
            <table class="table table-striped table-bordered mb-0">
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
                        <td id="monto_inicial">${credito.montoInicial}</td>
                    </tr>
                    <tr>
                        <td> Plazo Meses</td>
                        <td id="plazo_meses">&nbsp;${credito.plazoMeses}</td>
                    </tr>
                    <tr>
                        <td> Tasa Interes</td>
                        <td id="tasa_interes">&nbsp;${credito.tasaInteres}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <h2 class="mb-0">Plan de Pagos</h2>
            <br>
            <div class="container px-0" id="resultado"></div>
            <br>
            <form action="${pageContext.request.contextPath}/CreditoServlet" method="post">
                <input class="mt-0 btn btn-secondary" type="submit" name="action" value="Regresar" />
            </form>

        </div>
        <script src="generarPlanDePagos.js"></script>
    </body>
</html>

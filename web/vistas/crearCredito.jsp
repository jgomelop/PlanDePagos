<%-- 
    Document   : crearCredito
    Created on : 4/04/2022, 06:39:49 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Credito</title>
    </head>
    <body>
        <h1>Crear Crédito</h1>
        <form action="${pageContext.request.contextPath}/CreditoServlet" method="GET">
            <table>
                <tr>
                    <th> Nombre Cliente</th>
                    <th> <input type="text" name="nombreCliente" value="${credito.nombreCliente}"/></th>
                </tr>
                <tr>
                    <th> Monto Inicial</th>
                    <th><input type="text" name="montoInicial" value="${credito.montoInicial}"/> </th>
                </tr>
                <tr>
                    <th> Plazo Meses</th>
                    <th> <input type="text" name="plazoMeses" value="${credito.plazoMeses}"/></th>
                </tr>
                <tr>
                    <th> Tasa Interes</th>
                    <th> <input type="text" name="tasaInteres" value="${credito.tasaInteres}"/></th>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="Crear"/></td>
                    <td><input type="submit" name="action" value="Regresar"/></td>
                </tr>

            </table>
        </form>
    </body>
</html>

<%-- 
    Document   : editarCredito
    Created on : 3/04/2022, 11:06:06 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Credito</title>
        
    </head>
    <body>
        <h1>Editar Credito</h1>
        <form action="${pageContext.request.contextPath}/CreditoServlet" method="GET">
            <table>
                <tr>
                    <th> Credito ID</th>
                    <th><input type="text" name="idCredito" value="${credito.idCredito}" readonly/> </th>
                </tr>
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
                    <td><input type="submit" name="action" value="Actualizar"/></td>
                    <td><input type="submit" name="action" value="Regresar"/></td>
                </tr>

            </table>
        </form>
    </body>
</html>

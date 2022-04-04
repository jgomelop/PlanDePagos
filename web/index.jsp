<%-- 
    Document   : index
    Created on : 3/04/2022, 07:19:45 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información Credito</title>
    </head>
    <body>
        <h1>Información Credito</h1>
        <form action="./CreditoServlet" method="GET">
            <table>
                <tr>
                    <th> Credito ID</th>
                    <th><input type="text" name="idCredito" value="${credito.idCredito}"/> </th>
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
                    <td colspan="2">
                        <input type="submit" name="action" value="Add"/>
                        <input type="submit" name="action" value="Edit"/>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="submit" name="action" value="Search"/>
                    </td>
                </tr>

            </table>
        </form>
        <br>

        <table border="1">
            <th>Credito Id</th>
            <th>Nombre Cliente</th>
            <th>Monto Inicial</th>
            <th>Plazo Meses</th>
            <th> Tasa Interes </th>
            <th> Operaciones </th>


            <c:forEach items="${allCreditos}" var="cred">
                <tr>
                    <td>${cred.idCredito}</td>
                    <td>${cred.nombreCliente}</td>
                    <td>${cred.montoInicial}</td>
                    <td>${cred.plazoMeses}</td>
                    <td>${cred.tasaInteres} </td>
                    <td> 
                        <a href="#"> Detalles </a>
                        <a href="#"> Editar </a> 
                        <form action="${pageContext.request.contextPath}/CreditoServlet" method="get">
                            <input type="submit" name="action" value="Eliminar" />
                            <input type="hidden" name="credIdToDelete" value="${cred.idCredito}" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>

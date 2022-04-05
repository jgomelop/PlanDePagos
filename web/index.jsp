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
        <title>Información de créditos</title>
    </head>
    <body>
        <h1>Información de créditos</h1>
        
        <form action="${pageContext.request.contextPath}/CreditoServlet" method="get">
            <input type="submit" name="action" value="Agregar" />
        </form>
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
                        <form action="${pageContext.request.contextPath}/CreditoServlet" method="get">
                            <input type="submit" name="action" value="Detalles" />
                            <input type="hidden" name="credIdToDetail" value="${cred.idCredito}" />
                        </form>
                        <form action="${pageContext.request.contextPath}/CreditoServlet" method="get">
                            <input type="submit" name="action" value="Editar" />
                            <input type="hidden" name="credIdToEdit" value="${cred.idCredito}" />
                        </form>
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

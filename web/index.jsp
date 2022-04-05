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
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Información de créditos</title>
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="mb-0">Información de créditos</h1>
            <br>
            <form action="${pageContext.request.contextPath}/CreditoServlet" method="POST">
                <input class="mb-1 btn btn-primary" type="submit" name="action" value="Agregar" />
            </form>
            <table class="table table-bordered">
                <th>Credito Id</th>
                <th>Nombre Cliente</th>
                <th>Monto Inicial</th>
                <th>Plazo Meses</th>
                <th> Tasa Interes </th>
                <th></th>
                <th></th>
                <th></th>

                <c:forEach items="${allCreditos}" var="cred">
                    <tr>
                        <td>${cred.idCredito}</td>
                        <td>${cred.nombreCliente}</td>
                        <td>${cred.montoInicial}</td>
                        <td>${cred.plazoMeses}</td>
                        <td>${cred.tasaInteres} </td>
                        <td class="text-center"> 
                            <form action="${pageContext.request.contextPath}/CreditoServlet" method="POST">
                                <input class="btn btn-success"type="submit" name="action" value="Detalles" />
                                <input type="hidden" name="credIdToDetail" value="${cred.idCredito}" />
                            </form>
                        </td>
                        <td class="text-center">
                            <form action="${pageContext.request.contextPath}/CreditoServlet" method="POST">
                                <input class="btn btn-warning" type="submit" name="action" value="Editar" />
                                <input type="hidden" name="credIdToEdit" value="${cred.idCredito}" />
                            </form>
                        </td>
                        <td class="text-center">
                            <form action="${pageContext.request.contextPath}/CreditoServlet" method="POST">
                                <input class="btn btn-danger" type="submit" name="action" value="Eliminar" />
                                <input type="hidden" name="credIdToDelete" value="${cred.idCredito}" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>           

        </div>                
    </body>
</html>

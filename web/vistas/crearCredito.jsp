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
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Crear Credito</title>
    </head>
    <body>

        <div class="container w-50 mt-5" >

            <h1 class="mb-0 ">Crear Crédito</h1>

            <form class="mt-2" action="${pageContext.request.contextPath}/CreditoServlet" method="POST">
                <div class="form-group">
                    <label for="nombreClienteInput">Nombre Cliente: </label>
                    <input class="form-control" type="text" name="nombreCliente" value="${credito.nombreCliente}" id="nombreClienteInput" placeholder="Nombre del cliente" required>
                </div>
                <div class="form-group">
                    <label for="montoInicialInput">Monto Inicial</label>
                    <input class="form-control" type="number" name="montoInicial" min="0" value="${credito.montoInicial}" id="montoInicialInput" placeholder="Monto inicial" required>
                </div>
                
                <div class="form-group">
                    <label for="plazoMesesInput">Plazo Meses</label>
                    <input class="form-control" type="number" name="plazoMeses" min="1" max="18" value="${credito.plazoMeses}" id="plazoMesesInput" placeholder="Max. 18 meses" required>
                </div>
                <div class="form-group">
                    <label for="tasaInteresInput">Tasa Interés</label>
                    <input class="form-control" type="text" name="tasaInteres" value="1.1" readonly id="tasaInteresInput">
                </div>
               
                <input class="mt-2 btn btn-primary" type="submit" name="action" value="Crear"/>
                <input class="mt-2 btn btn-secondary"type="submit" name="action" value="Regresar" formnovalidate="formnovalidate"/>
            </form>

        </div>

    </body>
</html>

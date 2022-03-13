<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%Map<String, String> errores= (Map)request.getAttribute("errores");%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Drogueria- Formulario de Domicilios</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
     <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>
<h1 align="center">Aplicacion Web Drogueria</h1>
<h2 align="center">Formulario de Domicilio</h2>
<div class="px-5">
<img src="https://marketing4ecommerce.co/wp-content/uploads/2020/06/apps-de-reparto.jpg" width="300" height="200" >

<div class="container-domicilio">
    <form action="/webapp-drogueria/domicilio" method="post">

        <div class="container-form container-data-domicilio">
            <h3>1. Informacion del Domicilio</h3>
            <div class="row mb-3">
                <label for="codigoDomicilio"  class="col-form-label col-sm-2">Codigo del Domicilio</label>
                <div class="col-sm-4"><input type="text" name="codigoDomicilio" id="codigoDomicilio" placeholder="codigo" value=${param.codigoDomicilio}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("codigoDomicilio")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("codigoDomicilio")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="fechaDomicilio" class="col-form-label col-sm-2">Fecha del Domicilio</label>
                <div class="col-sm-4"><input type="text" name="fechaDomicilio" id="fechaDomicilio" placeholder="fecha" value=${param.fechaDomicilio}></div>
            </div>
            <%
             if(errores!=null && errores.containsKey("fechaDomicilio")){
             out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("fechaDomicilio")+"</div>");
             }
            %>

            <div class="row mb-3">
                <label for="direccionDomicilio"  class="col-form-label col-sm-2">Direccion del Domicilio</label>
                <div class="col-sm-4"><input type="text" name="direccionDomicilio" id="direccionDomicilio" placeholder="direccion" value=${param.direccionDomicilio}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("direccionDomicilio")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("direccionDomicilio")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="costoDomicilio" class="col-form-label col-sm-2">Costo del Domicilio</label>
                <div class="col-sm-4"><input type="text" name="costoDomicilio" id="costoDomicilio" placeholder="costo" value=${param.costoDomicilio}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("costoDomicilio")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("costoDomicilio")+"</div>");
            }
            %>

        </div>

        <div class="container-form container-data-producto">
            <h3>2. Informacion del Producto</h3>

            <div class="row mb-3">
                <label for="codigoProducto" class="col-form-label col-sm-2">Codigo del Producto</label>
                <div class="col-sm-4"><input type="text" name="codigoProducto" id="codigoProducto" placeholder="codigo" value=${param.codigoProducto}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("codigoProducto")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("codigoProducto")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="nombreProducto" class="col-form-label col-sm-2">Nombre del Producto</label>
                <div class="col-sm-4"><input type="text" name="nombreProducto" id="nombreProducto" placeholder="nombre" value=${param.nombreProducto}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("nombreProducto")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("nombreProducto")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="valorProducto" class="col-form-label col-sm-2">Valor del Producto</label>
                <div class="col-sm-4"><input type="text" name="valorProducto" id="valorProducto" placeholder="valor" value=${param.valorProducto}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("valorProducto")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("valorProducto")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="cantidadProducto" class="col-form-label col-sm-2">Cantidad del Producto</label>
                <div class="col-sm-4"><input type="text" name="cantidadProducto" id="cantidadProducto" placeholder="cantidad" value=${param.cantidadProducto}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("cantidadProducto")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cantidadProducto")+"</div>");
            }
            %>
        </div>

        <div class="container-form container-data-cliente">
            <h3>3. Informacion del Cliente</h3>
            <label for="cliente" class="col-form-label col-sm-2">Cliente</label>
            <div class="col-sm-4">
                <select name="cliente" id="cliente" value=${param.cliente}>
                    <option value="" selected>Seleccione un Cliente</option>
                    <option value="manuela-1109" ${param.cliente.equals("manuela-1109")? "selected": ""}>Manuela Torres</option>
                    <option value="alejandro-1110" ${param.cliente.equals("alejandro-1110")? "selected": ""}>Alejandro Muñoz</option>
                    <option value="david-1111" ${param.cliente.equals("david-1111")? "selected": ""}>David Giraldo</option>
                </select>
                <%
                if(errores!=null && errores.containsKey("cliente")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cliente")+"</div>");
                }
                %>
            </div>
        </div>

        <div class="container-form container-data-empleado">
            <h3>4. Informacion del Empleado</h3>
            <label for="empleado" class="col-form-label col-sm-2">Empleado</label>
            <div class="col-sm-4">
                <select name="empleado" id="empleado" value=${param.cliente}>
                    <option value="" selected>Seleccione un Empleado</option>
                    <option value="maria-1097" ${param.empleado.equals("maria-1097")? "selected": ""}>Maria arias</option>
                   <option value="andres-1098" ${param.empleado.equals("andres-1098")? "selected": ""}>Andres lopez</option>
                    <option value="fabian-1099" ${param.empleado.equals("fabian-1099")? "selected": ""}>Fabian arias</option>
                </select>
                <%
                if(errores!=null && errores.containsKey("empleado")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("empleado")+"</div>");
                }
                %>
            </div>
        </div>


        <div>
              <div>
                <input type="submit" value="Registrar Transaccion" class="btn btn-danger">
              </div>
        </div>
    </form>
</div>
</div>
</body>
</html>
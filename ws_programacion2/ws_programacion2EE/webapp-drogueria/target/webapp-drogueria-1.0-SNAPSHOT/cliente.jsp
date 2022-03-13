<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%Map<String, String> errores= (Map)request.getAttribute("errores");%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
     <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>
<h1 align="center">Aplicacion Web Drogueria</h1>
<h2 align="center">Gestion de Clientes</h2>

<%if(errores != null && errores.size() > 0){%>
<ul class="alert alert-danger mx-5">
    <%for(String error: errores.values()){%>
    <li><%=error%></li>
    <%}%>
</ul>
<%}%>
<div class="px-5">
<img src="https://cdn-icons-png.flaticon.com/512/686/686317.png" width="300" height="300" >

<div class="container-domicilio">
    <form action="/webapp-drogueria/cliente/create" method="post">

        <div class="container-form container-data-clientes">
            <h3>1. Informacion del Cliente</h3>
            <div class="row mb-3">
                <label for="nombreCliente"  class="col-form-label col-sm-2">Nombre(s)</label>
                <div class="col-sm-4"><input type="text" name="nombreCliente" id="nombreCliente" placeholder="nombre" value=${param.nombreCliente}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("nombreCliente")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("nombreCliente")+"</div>");
            }
            %>

            <div class="row mb-3">
                <label for="cedulaCliente" class="col-form-label col-sm-2">Cedula</label>
                <div class="col-sm-4"><input type="text" name="cedulaCliente" id="cedulaCliente" placeholder="cedula" value=${param.cedulaCliente}></div>
            </div>
            <%
             if(errores!=null && errores.containsKey("cedulaCliente")){
             out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cedulaCliente")+"</div>");
             }
            %>

            <div class="row mb-3">
                <label for="telefonoCliente"  class="col-form-label col-sm-2">Telefono</label>
                <div class="col-sm-4"><input type="text" name="telefonoCliente" id="telefonoCliente" placeholder="telefono" value=${param.telefonoCliente}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("telefonoCliente")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("telefonoCliente")+"</div>");
            }
            %>
            <div class="row mb-3">
                <label for="direccionCliente" class="col-form-label col-sm-2">Direccion</label>
                <div class="col-sm-4"><input type="text" name="direccionCliente" id="direccionCliente" placeholder="direccion" value=${param.direccionCliente}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("direccionCliente")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("direccionCliente")+"</div>");
            }
            %>
            <div class="row mb-3">
                <label for="correoCliente" class="col-form-label col-sm-2">Correo</label>
                <div class="col-sm-4"><input type="text" name="correoCliente" id="correoCliente" placeholder="correo" value=${param.correoCliente}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("correoCliente")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("correoCliente")+"</div>");
            }
            %>
            <div class="row mb-3">
                <label for="pagoCliente" class="col-form-label col-sm-2">Pago</label>
                <div class="col-sm-4"><input type="text" name="pagoCliente" id="pagoCliente" placeholder="pago" value=${param.pagoCliente}></div>
            </div>
            <%
            if(errores!=null && errores.containsKey("pagoCliente")){
            out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("pagoCliente")+"</div>");
            }
            %>
            <hr>

            <div class="row">
                <div class="col">
                  <input type="submit" value="Crear Cliente" class="btn btn-danger">
                </div>
                 <div class="col">
                    <input type="submit"  formaction="/webapp-drogueria/cliente" formmethod="get" value="Consultar Clientes" class="btn btn-danger">
                 </div>
          </div>
        </div>


        <div class="container-form container-data-clientes">
            <h3>2. Actualizar Cliente</h3>
            <div class="row mb-3">
                <label for="cedulaClienteAct" class="col-form-label col-sm-2">Cedula</label>
                <div class="col-sm-4"><input type="text" name="cedulaClienteAct" id="cedulaClienteAct" placeholder="cedula" value=${param.cedulaClienteAct}></div>
            </div>
            <%
             if(errores!=null && errores.containsKey("cedulaClienteAct")){
             out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cedulaClienteAct")+"</div>");
             }
            %>
            <hr>
                <div class="row mb-3">
                    <label for="nombreClienteAct"  class="col-form-label col-sm-2">Nombre(s)</label>
                    <div class="col-sm-4"><input type="text" name="nombreClienteAct" id="nombreClienteAct" placeholder="nombre" value=${param.nombreClienteAct}></div>
                </div>
                <%
                if(errores!=null && errores.containsKey("nombreClienteAct")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("nombreClienteAct")+"</div>");
                }
                %>

                <div class="row mb-3">
                    <label for="telefonoClienteAct"  class="col-form-label col-sm-2">Telefono</label>
                    <div class="col-sm-4"><input type="text" name="telefonoClienteAct" id="telefonoClienteAct" placeholder="telefono" value=${param.telefonoClienteAct}></div>
                </div>
                <%
                if(errores!=null && errores.containsKey("telefonoClienteAct")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("telefonoClienteAct")+"</div>");
                }
                %>
      
                <div class="row mb-3">
                    <label for="direccionClienteAct" class="col-form-label col-sm-2">Direccion</label>
                    <div class="col-sm-4"><input type="text" name="direccionClienteAct" id="direccionClienteAct" placeholder="direccion" value=${param.direccionClienteAct}></div>
                </div>
                <%
                if(errores!=null && errores.containsKey("direccionClienteAct")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("direccionClienteAct")+"</div>");
                }
                %>
      
                <div class="row mb-3">
                    <label for="correoClienteAct" class="col-form-label col-sm-2">Correo</label>
                    <div class="col-sm-4"><input type="text" name="correoClienteAct" id="correoClienteAct" placeholder="correo" value=${param.correoClienteAct}></div>
                </div>
                <%
                if(errores!=null && errores.containsKey("correoClienteAct")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("correoClienteAct")+"</div>");
                }
                %>
                <div class="row mb-3">
                    <label for="pagoClienteAct" class="col-form-label col-sm-2">Pago</label>
                    <div class="col-sm-4"><input type="text" name="pagoClienteAct" id="pagoClienteAct" placeholder="pago" value=${param.pagoClienteAct}></div>
                </div>
                <%
                if(errores!=null && errores.containsKey("pagoClienteAct")){
                out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("pagoClienteAct")+"</div>");
                }
                %>
                <hr>
                <div class="col">
                    <input type="submit"  formaction="/webapp-drogueria/cliente/update" formmethod="post" value="Actualizar Cliente" class="btn btn-danger">
                </div>
              </div>
          </div>
          



        <div class="container-form container-data-clientes">
            <h3>3. Eliminar Cliente</h3>

            <div class="row mb-3">
                <label for="cedulaClienteEliminar" class="col-form-label col-sm-2">Cedula</label>
                <div class="col-sm-4"><input type="text" name="cedulaClienteEliminar" id="cedulaClienteEliminar" placeholder="cedula" value=${param.cedulaClienteEliminar}></div>
            </div>
            <%
             if(errores!=null && errores.containsKey("cedulaClienteEliminar")){
             out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cedulaClienteEliminar")+"</div>");
             }
            %>
            <hr>
                <div class="col">
                    <input type="submit"  formaction="/webapp-drogueria/cliente/delete" formmethod="post" value="Eliminar Cliente" class="btn btn-warning">
                </div>
          </div>
        </div>

        <div class="container-form container-data-clientes">
            <h3>4. Consultas Cliente</h3>




            <div class="row mb-3">
                <label for="cConsulta1" class="col-form-label col-sm-2">Consulta 1</label>
                <div class="col-sm-4"><input type="text" name="cConsulta1" id="cConsulta1" placeholder="parametro" value=${param.cConsulta1}></div>
            </div>
            <%
             if(errores!=null && errores.containsKey("cConsulta1")){
             out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("cConsulta1")+"</div>");
             }
            %>
                <div  class="col">
                    <input type="submit"  formaction="/webapp-drogueria/cliente/consulta1" formmethod="post" value="Consulta 1" class="btn btn-success">
                </div>
                <hr>
                <div class="row mb-3">
                              <label for="consulta2" class="col-form-label col-sm-2">Consulta 2</label>
                              <div class="col-sm-4"><input type="text" name="consulta2" id="consulta2" placeholder="parametro" value=${param.consulta2}></div>
                          </div>
                          <%
                           if(errores!=null && errores.containsKey("consulta2")){
                           out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("consulta2")+"</div>");
                           }
                          %>
                              <div  class="col">
                                  <input type="submit"  formaction="/webapp-drogueria/cliente/consulta2" formmethod="post" value="Consulta 2" class="btn btn-success">
                              </div>
                              <hr>
                        <div class="row mb-3">
                            <label for="consulta3" class="col-form-label col-sm-2">Consulta 3</label>
                            <div class="col-sm-4"><input type="text" name="consulta3" id="consulta3" placeholder="parametro" value=${param.consulta3}></div>
                        </div>
                        <%
                         if(errores!=null && errores.containsKey("consulta3")){
                         out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("consulta3")+"</div>");
                         }
                        %>
                            <div  class="col">
                                <input type="submit"  formaction="/webapp-drogueria/cliente/consulta3" formmethod="post" value="Consulta 3" class="btn btn-success">
                            </div>
                            <hr>
                      <div class="row mb-3">
                          <label for="consulta4" class="col-form-label col-sm-2">Consulta 4</label>
                          <div class="col-sm-4"><input type="text" name="consulta4" id="consulta4" placeholder="parametro" value=${param.consulta4}></div>
                      </div>
                      <%
                       if(errores!=null && errores.containsKey("consulta4")){
                       out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("consulta4")+"</div>");
                       }
                      %>
                          <div  class="col">
                              <input type="submit"  formaction="/webapp-drogueria/cliente/consulta4" formmethod="post" value="Consulta 4" class="btn btn-success">
                          </div>

                          <hr>
                      <div class="row mb-3">
                            <label for="consulta5" class="col-form-label col-sm-2">Consulta 5</label>
                            <div class="col-sm-4"><input type="text" name="consulta5" id="consulta5" placeholder="parametro" value=${param.consulta5}></div>
                        </div>
                        <%
                         if(errores!=null && errores.containsKey("consulta5")){
                         out.println("<div class='rpw mb-3 alert-danger col sm-4' style= 'color: red;'>"+errores.get("consulta5")+"</div>");
                         }
                        %>
                            <div  class="col">
                                <input type="submit"  formaction="/webapp-drogueria/cliente/consulta5" formmethod="post" value="Consulta 5" class="btn btn-success">
                            </div>
        </div>

    </form>
</div>
</div>
</body>
</html>
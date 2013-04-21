<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="com.fpmislata.persistencia.dao.BussinessMessage"%>
<%@page import="ejemplo06.controller.FormOperation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FormOperation formOperation = (FormOperation) request.getAttribute("formOperation");
    String labelButton;
    String urlAction;
    switch (formOperation) {
        case Create:
            labelButton="Guardar";
            urlAction=request.getContextPath() + "/usuario/save.html";
            break;
        case Read:
            labelButton="Aceptar";
            urlAction=request.getContextPath() + "/index.html";
            break;
        case Update:
            labelButton="Guardar";
            urlAction=request.getContextPath() + "/usuario/update.html";
            break;
        case Delete:
            labelButton="Borrar";
            urlAction=request.getContextPath() + "/usuario/delete.html";
            break;
        default:
            throw new RuntimeException("El valor de 'formOperation' no es válido"+formOperation);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesor</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.8.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row">
            <div class="span12">&nbsp;</div>
        </div>        
        <div class="row">
            <div class="offset1 span10 well">
                <h3>Usuario</h3> 
                <form action="<%=urlAction%>" method="post" >
                <fieldset>
                    <label class="control-label" for="idUsuario">IdUsuario:</label>
                    <input class="input-xlarge disabled " id="idUsuario" name="idUsuario" type="text" value="${usuario.idUsuario}" readonly="readonly">

                    <label class="control-label" for="login">Login:</label>
                    <input class="input-xlarge" id="login" type="text" name="login" value="${usuario.login}"  >

                    <label class="control-label" for="nombre">Nombre:</label>
                    <input class="input-xlarge" id="nombre" type="text" name="nombre" value="${usuario.nombre}" >

                    <label class="control-label" for="ape1">1º Apellido:</label>
                    <input class="input-xlarge" id="ape1" type="text" name="ape1" value="${usuario.ape1}" >
                    
                    <label class="control-label" for="ape2">2º Apellido:</label>
                    <input class="input-xlarge" id="ape2" type="text" name="ape2" value="${usuario.ape2}" >                        

                    <label class="control-label" for="password">Contraseña:</label>
                    <input class="input-xlarge" id="password" type="" name="password" value="${usuario.password}" >                        
                </fieldset>
                <%
                if (request.getAttribute("bussinessMessages") != null) {
                %>                 
                <div class="alert alert-error">
                <%
                    for (BussinessMessage bussinessMessage : (Set<BussinessMessage>) request.getAttribute("bussinessMessages")) {
                        if (bussinessMessage.getFieldName() != null) {
                            out.print("<strong>" + HtmlUtils.htmlEscape(bussinessMessage.getFieldName()) + "</strong>-" + HtmlUtils.htmlEscape(bussinessMessage.getMessage()));
                        } else {
                            out.print(HtmlUtils.htmlEscape(bussinessMessage.getMessage()));
                        }
                        out.println("<br />");
                    }
                %>
                </div>
                <%
                }
                %>                     
                <div class="form-actions">
                    <button id="aceptarBtn" class="btn" type="submit"><%=labelButton %></button>       
                </div>
                </form>
            </div>
        </div>
        <script>

        </script>       
    </body>
</html>
<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="com.fpmislata.persistencia.dao.BussinessMessage"%>
<%@page import="ejemplo03.presentacion.FormOperation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FormOperation formOperation = (FormOperation) request.getAttribute("formOperation");
    String labelButton = null;
    String urlAction;
    switch (formOperation) {
        case Insert:
            labelButton = "Insertar";
            urlAction = request.getContextPath() + "/profesor/insert.html";
            break;
        case Update:
            labelButton = "Actualizar";
            urlAction = request.getContextPath() + "/profesor/update.html";
            break;
        case Delete:
            labelButton = "Borrar";
            urlAction = request.getContextPath() + "/profesor/delete.html";
            break;
        default:
            throw new RuntimeException("El valor de 'formOperation' no es válido" + formOperation);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesor</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row">
            <div class="offset1 span10 well">
                <h3>Profesor</h3>
                <form action="<%=urlAction%>" method="post" >
                    <fieldset>
                        <label class="control-label" for="id">Id:</label>
                        <input class="input-large disabled " id="id" name="id" type="text" value="${profesor.id}" readonly="readonly">

                        <label class="control-label" for="nombre">Nombre:</label>
                        <input class="input-xlarge" id="nombre" type="text" name="nombre" value="${profesor.nombre}" >

                        <label class="control-label" for="ape1">1º Apellido:</label>
                        <input class="input-xlarge" id="ape1" type="text" name="ape1" value="${profesor.ape1}" >

                        <label class="control-label" for="ape2">2º Apellido:</label>
                        <input class="input-xlarge" id="ape2" type="text" name="ape2" value="${profesor.ape2}" >
                    </fieldset>
                    <%
                        if (request.getAttribute("bussinessMessages") != null) {
                    %>
                    <div class="alert alert-error alert-block">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <ul>
                            <%
                                for (BussinessMessage bussinessMessage : (Set<BussinessMessage>) request.getAttribute("bussinessMessages")) {
                            %>
                            <li>
                                <%
                                    if (bussinessMessage.getFieldName() != null) {
                                        out.print("<strong>" + HtmlUtils.htmlEscape(bussinessMessage.getFieldName()) + "</strong>");
                                    }
                                %>
                                <%=HtmlUtils.htmlEscape(bussinessMessage.getMessage())%>
                            </li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                    <%
                        }
                    %>
                    <div class="form-actions">
                        <button id="aceptarBtn" class="btn btn-primary" type="submit"><%=labelButton%></button>
                        <a class="btn" href="<%=request.getContextPath()%>/index.html" >Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
        <script>

        </script>
    </body>
</html>
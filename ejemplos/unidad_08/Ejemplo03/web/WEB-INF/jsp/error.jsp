<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="com.fpmislata.persistencia.dao.BussinessMessage"%>
<%
//Página para mostrar mensajes de error del tipo BussinessMessage
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="offset1 span11 well">
                <h3>No se ha podido completar la operaci&oacute;n.</h3>
                <h4>Se han producido los siguientes errores:</h4>
                <br />
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
                    <button id="aceptarBtn" class="btn btn-primary">Aceptar</button>
                </div>
                <script>
                    $("#aceptarBtn").click(function(e){
                        window.location.href ="<%=request.getAttribute("backURL") %>";
                    });
                </script>                       
            </div>
        </div>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="offset1  span11 well">
                <div class="row">
                    <div class="span10">
                        <h3>Usuario</h3>
                        <label class="control-label" for="nombre">IdUsuario:</label>
                        <input class="input-xlarge" id="idUsuario" type="text" name="idUsuario" value=""  >
                    </div>
                </div>
                <div class="row">
                    <div class="span10">
                        <button id="btnNuevo" class="btn btn-primary">Nuevo</button>
                        <button id="btnVer" class="btn">Ver</button>
                        <button id="btnEditar" class="btn">Editar</button>
                        <button id="btnBorrar" class="btn">Borrar</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $("#btnNuevo").click(function(e){
                window.location.href = "<%=request.getContextPath()%>/usuario/newForm.html";
            });
            $("#btnVer").click(function(e){
                window.location.href = "<%=request.getContextPath()%>/usuario/viewForm.html?idUsuario="+$("#idUsuario").val();
            });
            $("#btnEditar").click(function(e){
                window.location.href = "<%=request.getContextPath()%>/usuario/editForm.html?idUsuario="+$("#idUsuario").val();
            });
            $("#btnBorrar").click(function(e){
                window.location.href = "<%=request.getContextPath()%>/usuario/deleteForm.html?idUsuario="+$("#idUsuario").val();

            });



        </script>
    </body>
</html>
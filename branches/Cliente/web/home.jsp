<%

            if (request.getParameter("user") == null) {
%>
<jsp:forward page="index.jsp"/>
<%            }
            String user = request.getParameter("user");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SISTEMA PERSONAL</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <link href="./css/mn_css_menu.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="./js/tools.js"></script>
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/menuJavaScript.js"></script>
        <script language="javascript" type="text/javascript" src="./js/loginJs.js"></script>
        <style type="text/css">
            html { overflow-x:hidden; }
        </style>
    </head>

    <body>
        <div class="cabecera">
            <div class="logo"></div>
            <div class="user">
				<ul class="pureCssMenu pureCssMenum0">
					<li><a class="user_2" href="#"><span><b>User<b></span><![if gt IE 6]></a><![endif]>
						<ul class="pureCssMenum">
							<li class="pureCssMenui"><a id="User_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Editar Perfil</a></li>
							<li class="pureCssMenui"><a id="User_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Cerrar Sesión</a></li>
						</ul>
					</li>
				</ul>
			</div>
        </div>
        <div>
            <table width="100%" height="20" border="0" align="center" class="botonera">
                <tr>
                    <td width="542">&nbsp;</td>
                    <td width="584" height="40" align="center" valign="top">
                        <ul class="pureCssMenu pureCssMenum0">
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Personal</span><![if gt IE 6]></a><![endif]>
                                <ul class="pureCssMenum">
                                    <li class="pureCssMenui"><a id="Personal_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar personal</a></li>
                                    <li class="pureCssMenui"><a id="Personal_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar personal</a></li>
                                    <li class="pureCssMenui"><a id="Personal_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Asignar legajo</a></li>
                                </ul>
                            </li>
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Horarios</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                <ul class="pureCssMenum">
                                    <li class="pureCssMenui"><a id="Horario_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar Tipo de Horario</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Asignacion horarios</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Registro de periodo</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Manejo de licencias</a></li>
                                </ul>
                            </li>
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Seguimiento</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                <ul class="pureCssMenum">
                                    <li class="pureCssMenui"><a id="Seguimiento_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar categoria</a></li>
                                    <li class="pureCssMenui"><a id="Seguimiento_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar departamentos</a></li>
                                    <li class="pureCssMenui"><a id="Seguimiento_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Recategorizar Empleado</a></li>
                                    <li class="pureCssMenui"><a id="Seguimiento_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar categorias</a></li>
                                    <li class="pureCssMenui"><a id="Seguimiento_mnu5" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar departamento</a></li>
                                </ul>
                            </li>
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Reportes</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                <ul class="pureCssMenum">
                                    <li class="pureCssMenui"><a id="Reporte_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes personal</a></li>
                                    <li class="pureCssMenui"><a id="Reporte_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes horarios</a></li>
                                    <li class="pureCssMenui"><a id="Reporte_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes seguimiento</a></li>
                                    <li class="pureCssMenui"><a id="Reporte_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes departamentos</a></li>
                                    <li class="pureCssMenui"><a id="Reporte_mnu5" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes usuarios</a></li>
                                </ul>
                            </li>
                        </ul>
                    </td>
                    <td width="502">&nbsp;</td>

                </tr>
            </table>
            <div id="noticias" class="noticias" src="PanelNoticias.html"></div>
    </body>
</html>

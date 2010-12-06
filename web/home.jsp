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
        
        <script src="./tools/datepicker/datepickercontrol.js" type="text/javascript"></script>
        <link  href="./tools/datepicker/datepickercontrol.css" type="text/css" rel="stylesheet" />

        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesProfesional.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesEmpleado.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesAsignarLegajo.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesRegistroPeriodo.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesLicencia.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesAsignacionHorario.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesTipoHorario.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validaciones.js"></script>

        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/asignarLegJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/Personal.js"></script>
        <script language="javascript" type="text/javascript" src="./js/Horario.js"></script>
        <script language="javascript" type="text/javascript" src="./js/tools.js"></script>
        <script language="javascript" type="text/javascript" src="./js/menuJavaScript.js"></script>
        <script language="javascript" type="text/javascript" src="./js/loginJs.js"></script>

        <script language="javascript" type="text/javascript" src="./js/recategorizarJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/reportCategoria.js"></script>
        <style type="text/css">
            html { overflow-x:hidden; }
        </style>
    </head>

    <body>
        <div class="cabecera">
            <div class="logo">
            </div>
            <div class="user">
                <ul class="pureCssMenu pureCssMenum0">
                    <li><a class="user_2" href="#"><span id="username" style="background-image: url(./img/arr_black.gif); background-position: center right; background-repeat:no-repeat; padding-right:9px; text-align:right; font-weight:bold;"> <%= user %> </span><![if gt IE 6]></a><![endif]>
                        <ul class="pureCssMenum">
                            <li class="pureCssMenui"><a id="User_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Editar Perfil</a></li>
                            <li class="pureCssMenui"><a id="User_mnu2" class="pureCssMenui" onclick="js_logOff()" href="#">Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="botonera" width="100%">
            <table height="20" border="0" align="center" class="botonera">
                <tr>
                    <td height="40" align="center" valign="top">
                        <ul class="pureCssMenu pureCssMenum0">
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Personal</span><![if gt IE 6]></a><![endif]>
                                                                <ul class="pureCssMenum">
                                                                    <li class="pureCssMenui"><a id="Personal_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar personal</a></li>
                                                                    <li class="pureCssMenui"><a id="Personal_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar personal</a></li>
                                                                </ul>
                            </li>
                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Horarios</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                <ul class="pureCssMenum">
                                    <li class="pureCssMenui"><a id="Horario_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Tipo de Horario</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Asignacion horarios</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Registro de periodo</a></li>
                                    <li class="pureCssMenui"><a id="Horario_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Licencias</a></li>
                                </ul>
                            </li>
                                                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Seguimiento</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                                                <ul class="pureCssMenum">
                                                                    <li class="pureCssMenui"><a id="Seguimiento_mnu1" class="pureCssMenui" onclick="cargarNoticiasAsignarLegajo('Alta_Legajo_Final.jsp')" href="#">Asignar legajo</a></li>
                                                                    <li class="pureCssMenui"><a id="Seguimiento_mnu3" class="pureCssMenui" onclick="js_cargarNoticias_recat(this.id)" href="#">Recategorizar Empleado</a></li>
                                                                </ul>
                                                            </li>
                                                            <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Reportes</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                                                                <ul class="pureCssMenum">
                                                                    <li class="pureCssMenui"><a id="Reporte_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes personal</a></li>
                                                                    <li class="pureCssMenui"><a id="Reporte_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes horarios</a></li>
                                                                    <li class="pureCssMenui"><a id="Reporte_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes seguimiento</a></li>
                                                                    <li class="pureCssMenui"><a id="Reporte_mnu5" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes usuarios</a></li>
                                                                </ul>
                                                            </li>
                        </ul>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
        <div id="noticias" class="noticias" src="PanelNoticias.html"></div>
    </body>
</html>

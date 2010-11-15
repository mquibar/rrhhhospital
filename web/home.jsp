<%

if( request.getParameter("user") == null)
{
%>
<jsp:forward page="index.jsp"/>
<%
}
String user = request.getParameter("user");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SISTEMA PERSONAL</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="./js/tools.js"></script>
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/menuJavaScript.js"></script>
    </head>

    <body>
        <div class="cabecera">
            <div class="logo"></div>
            <div class="user">
                <div class="user_2">User: <%=user%></div>
                <div class="log_off">LogOff </div>
            </div>
        </div>
        <div>
            <style>
                #pcm{display:none;}
                ul.pureCssMenu ul{display:none}
                ul.pureCssMenu li:hover>ul{display:block}
                ul.pureCssMenu ul{position: absolute;left:-1px;top:98%;}
                ul.pureCssMenu ul ul{position: absolute;left:98%;top:-2px;}
                ul.pureCssMenu,ul.pureCssMenu ul {
                    margin:0px;
                    list-style:none;
                    padding:0px 2px 2px 0px;
                    background-color:#fff;
                    background-repeat:repeat;
                    border-color:#808080;
                    border-width:1px;
                    border-style:solid;
                }
                ul.pureCssMenu table {border-collapse:collapse}ul.pureCssMenu {
                    display:block;
                    zoom:1;
                    height:21px;
                    float: left;
                }
                ul.pureCssMenu ul{
                    width:145.95000000000002px;
                }
                ul.pureCssMenu li{
                    display:block;
                    margin:2px 0px 0px 2px;
                    font-size:0px;
                }
                ul.pureCssMenu a:active, ul.pureCssMenu a:focus {
                    outline-style:none;
                }
                ul.pureCssMenu a, ul.pureCssMenu li.dis a:hover, ul.pureCssMenu li.sep a:hover {
                    display:block;
                    vertical-align:middle;
                    background-color:#FFFFFF;
                    border-width:1px;
                    border-color:#fff;
                    border-style:solid;
                    text-align:center;
                    text-decoration:none;
                    padding:2px 5px 5px 10px;
                    _padding-left:0;
                    font:normal 11px Tahoma;
                    color: #000;
                    text-decoration:none;
                    cursor:default;
                }
                ul.pureCssMenu span{
                    overflow:hidden;
                }
                ul.pureCssMenu li {
                    float:left;
                }
                ul.pureCssMenu ul li {
                    float:none;
                }
                ul.pureCssMenu ul a {
                    text-align:left;
                    white-space:nowrap;
                }
                ul.pureCssMenu li.sep{
                    text-align:left;
                    padding:0px;
                    line-height:0;
                    height:100%;
                }
                ul.pureCssMenu li.sep span{
                    float:none;	padding-right:0;
                    width:3px;
                    height:100%;
                    display:inline-block;
                    background-color:#808080;	background-image:none;}
                ul.pureCssMenu ul li.sep span{
                    width:100%;
                    height:3px;
                }
                ul.pureCssMenu li:hover{
                    position:relative;
                }
                ul.pureCssMenu li:hover>a{
                    background-color:#DBF0F9;
                    border-color:#45ADE4;
                    border-style:solid;
                    font:normal 11px Tahoma;
                    color: #444;
                    text-decoration:none;
                }
                ul.pureCssMenu li a:hover{
                    position:relative;
                    background-color:#DBF0F9;
                    border-color:#45ADE4;
                    border-style:solid;
                    font:normal 11px Tahoma;
                    color: #444;
                    text-decoration:none;
                }
                ul.pureCssMenu li.dis a {
                    color: #557D4F !important;
                }
                ul.pureCssMenu img {border: none;float:left;_float:none;margin-right:2px;width:16px;
                                    height:16px;
                }
                ul.pureCssMenu ul img {width:16px;
                                       height:16px;
                }
                ul.pureCssMenu img.over{display:none}
                ul.pureCssMenu li.dis a:hover img.over{display:none !important}
                ul.pureCssMenu li.dis a:hover img.def {display:inline !important}
                ul.pureCssMenu li:hover > a img.def  {display:none}
                ul.pureCssMenu li:hover > a img.over {display:inline}
                ul.pureCssMenu a:hover img.over,ul.pureCssMenu a:hover ul img.def,ul.pureCssMenu a:hover a:hover img.over{display:inline}
                ul.pureCssMenu a:hover img.def,ul.pureCssMenu a:hover ul img.over,ul.pureCssMenu a:hover a:hover img.def{display:none}
                ul.pureCssMenu a:hover ul{display:block}
                ul.pureCssMenu span{
                    display:block;
                    background-image:url(./img/arrv_white.gif);
                    background-position:right center;
                    background-repeat: no-repeat;
                    padding-right:9px;}
                ul.pureCssMenu ul span{background-image:url(./img/arr_black.gif)}
                ul.pureCssMenu ul li:hover > a span{	background-image:url(./img/arr_white.gif);}
                ul.pureCssMenu table a:hover span{background-image:url(./img/arr_white.gif)}
                ul.pureCssMenu li.pureCssMenui0 {
                    width:110px;
                    height:23px;
                }
                ul.pureCssMenu li a.pureCssMenui0{
                    height:100%;
                    background-image:url(./img/btn3.jpg);
                    border-width:0px;
                    font:normal 11px Tahoma;
                    color:#fff;
                }
                ul.pureCssMenu li a.pureCssMenui0:hover{
                    background-image:url(./img/btn4.jpg);
                    font:normal 11px Tahoma;
                    color:#eee;
                }
                ul.pureCssMenum0 {
                    background-color:transparent;
                    border-width:0px;
                    padding:0px 0px 0px 0px;
                }
                ul.pureCssMenum0>li>a {
                    padding:8px 10px 0px 10px;
                }
                ul.pureCssMenum0 a {
                    padding:8px 10px 0px 10px;
                }
                ul.pureCssMenum0 ul a {
                    padding:2px 5px 5px 10px;
                }
                ul.pureCssMenum0>li {
                    margin:0px 0px 0px 0px;
                }
                ul.pureCssMenum0 li {
                    margin:0px 0px 0px 0px;
                }
                ul.pureCssMenum0 li li {
                    margin:2px 0px 0px 2px;
                }
            </style>
            <!-- End PureCSSMenu.com STYLE -->




            <!-- Start PureCSSMenu.com MENU -->
            <ul class="pureCssMenu pureCssMenum0">
                <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Personal</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                    <ul class="pureCssMenum">
                        <li class="pureCssMenui"><a id="Personal_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar personal</a></li>
                        <li class="pureCssMenui"><a id="Personal_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar personal</a></li>
                        <li class="pureCssMenui"><a id="Personal_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Asignar legajo</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
                <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Horarios</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                    <ul class="pureCssMenum">
                        <li class="pureCssMenui"><a id="Horario_mnu1" class="pureCssMenui"
                                                    href="#" onclick="cargarNoticias('./manejoHorarios/gestionar.jsp?nombreEntidad=tipo_horario');">Gestionar Tipo de Horario</a></li>
                        <li class="pureCssMenui"><a id="Horario_mnu1" class="pureCssMenui"
                                                    href="#" onclick="cargarNoticias('./manejoHorarios/gestionar.jsp?nombreEntidad=asignacion_horario');">Asignacion horarios</a></li>
                        <li class="pureCssMenui"><a id="Horario_mnu3" class="pureCssMenui"
                                                    href="#" onclick="cargarNoticias('./manejoHorarios/gestionar.jsp?nombreEntidad=registro_periodo');">Registro de periodo</a></li>
                        <li class="pureCssMenui"><a id="Horario_mnu2" class="pureCssMenui"
                                                    href="#" onclick="cargarNoticias('./manejoHorarios/gestionar.jsp?nombreEntidad=licencia');">Manejo de licencias</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
                <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Seguimiento</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                    <ul class="pureCssMenum">
                        <li class="pureCssMenui"><a id="Seguimiento_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar categoria</a></li>
                        <li class="pureCssMenui"><a id="Seguimiento_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Gestionar departamentos</a></li>
                        <li class="pureCssMenui"><a id="Seguimiento_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Recategorizar Empleado</a></li>
                        <li class="pureCssMenui"><a id="Seguimiento_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar categorias</a></li>
                        <li class="pureCssMenui"><a id="Seguimiento_mnu5" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Consultar departamento</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
                <li class="pureCssMenui0"><a class="pureCssMenui0" href="#"><span>Reportes</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
                    <ul class="pureCssMenum">
                        <li class="pureCssMenui"><a id="Reporte_mnu1" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes personal</a></li>
                        <li class="pureCssMenui"><a id="Reporte_mnu2" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes horarios</a></li>
                        <li class="pureCssMenui"><a id="Reporte_mnu3" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes seguimiento</a></li>
                        <li class="pureCssMenui"><a id="Reporte_mnu4" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes departamentos</a></li>
                        <li class="pureCssMenui"><a id="Reporte_mnu5" class="pureCssMenui" onclick="loadMenuFunction(this.id)" href="#">Reportes usuarios</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
            </ul>
            <a id="pcm" href="http://www.purecssmenu.com/">CSS Drop Down Menu by PureCSSMenu.com</a>
            <!-- End PureCSSMenu.com MENU --></div>
        <iframe id="noticias" class="noticias">NOTICIAS</iframe>
    </body>
</html>

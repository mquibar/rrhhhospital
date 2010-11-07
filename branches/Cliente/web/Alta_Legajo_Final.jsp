<%--@page import="Controlers.ControladorAltaAsignacionHorario" --%>

<%!
    String getValue(ServletRequest request, String varName) {
        String varVal = request.getParameter(varName);
        return (varVal) == null ? "" : varVal;
    }
%>

<%
            if (request.getParameter("buttonCancel") != null) {

%>

<%} else {
//ControladorAltaAsignacionHorario c = new ControladorAltaAsignacionHorario();

String fechaInicio = getValue(request, "fechaInicio");
String fechaFin = getValue(request, "fechaFin");
String empleado = getValue(request, "empleado");
String tipoHorario = getValue(request, "tipoHorario");
String descripcion = getValue(request, "descripcion");
String vigente = getValue(request, "vigente");

String mensageEstado = "";

if (request.getParameter("buttonActualizar") != null) {
    /*c.iniciarAlta(
            fechaInicio,
            fechaFin,
            empleado,
            tipoHorario,
            descripcion,
            "true");

    mensageEstado = c.guardar();*/
    mensageEstado = "Actualizado";
}

if (mensageEstado != "" && mensageEstado.indexOf("Error:") == -1) {

%>

<jsp:forward page="./tools/messageBox.jsp">
    <jsp:param name="msg" value= "<%= mensageEstado %>" />
    <jsp:param name="target" value="home.html" />
</jsp:forward>

<%    } else {

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="./css/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
</script>
<script language="javascript" type="text/javascript" src="./js/Funciones.js"></script>
</head>

<body>
<div class="cabecera">
  <div class="logo"></div>
  <div class="user">
    <div class="user_2">User: </div>
    <div class="log_off">LogOff </div>
  </div>
</div>
<div class="noticias" id="noticias_2"> Alta Legajo<br />
    
   <div class="forms">
    <div class="izquierda"><br />
      <form id="form1" name="form1" method="post" action="">
        <p>Empleado<br />
        </p>
        <p>
          <select name="empleado" size="1" id="empleado" >
            <%--=c.getOptionsTipoEmpleado(empleado)--%>
          </select>
        </p>
        <p>
          <input type="button" name="button" id="button" value="Seleccionar" onclick="agre()"/>
        </p>
        <p>Legajo        </p>
        <p>
          <label>
            <input type="text" name="legajo" id="legajo" />
          </label>
        </p>
		<hr color="#E3E3E3"/>
        <p>Agrupamiento        </p>
        <p>
          <select name="agrupamiento" size="1" id="agrupamiento" onchange="gtramo()">
          </select>
        </p>
        <p>Tramo</p>
        <p>
          <select name="tramo" size="1" id="tramo" onchange="ecategoria()">
          </select>
        </p>
        <p>Categoria</p>
        <p>
          <select name="categoria" size="1" id="categoria" >
          </select>
        </p>
        <p>&nbsp;</p>
        <p>
          <input type="submit" name="buttonActualizar" id="buttonActualizar" value="Actualizar" onclick="sleep(5000)"/>
          <br />
          <br />
        </p>
</form>
    </div>
    <div class="derecha"></div>
  </div>
</div>
</body>
</html>
<%
                }
            }%>
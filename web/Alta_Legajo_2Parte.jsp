<%@page import="controllers.ctrlAltaLegajo" %>

<%!
String getValue(ServletRequest request, String varName)
{
    String varVal = request.getParameter(varName);
    return (varVal) == null ? "" : varVal;
}
%>

<%
if (request.getParameter("buttonCancel") != null)
{

    %>

    <jsp:forward page="./tools/messageBox.jsp">
        <jsp:param name="msg" value="Operacion cancelada por el usuario" />
        <jsp:param name="target" value="home.html" />
    </jsp:forward>

    <%

}
else
{
    ctrlAltaLegajo c = new ctrlAltaLegajo();

    String empleado         = getValue(request, "empleado");
    String legajo           = getValue(request, "legajo");
    String categoria        = getValue(request, "categoria");

    c.setEmpleadoSeleccionado(empleado);

    String mensageEstado = "";

    if (request.getParameter("buttonSave") != null)
    {
        c.iniciarModificacion
                (
                 empleado,
                 legajo,
                 categoria
                );

        mensageEstado = c.guardar();
    }

    if (mensageEstado != "" && mensageEstado.indexOf("Error:") == -1)
    {

    %>

    <jsp:forward page="./tools/messageBox.jsp">
        <jsp:param name="msg" value="<%=mensageEstado%>" />
        <jsp:param name="target" value="home.html" />
    </jsp:forward>

    <%

    }
    else
    {

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
    <div class="izquierda">Empleado: <%= c.getNombreEmpleadoSeleccionado()%><br />
      <form id="form1" name="form1" method="post" action="">
        <p>Legajo - Categoria<br />
        </p>
        <p>Legajo<br />
          <label>
            <input type="legajo" name="legajo" id="legajo" value='<%=legajo%>'/>
          </label>
        </p>
        <p>Categoria<br />
          <select name="categoria" size="1" id="categoria">
                <%= c.getModels("categoriasElegibles").toString()%>
          </select>
        </p>
        <p>&nbsp;</p>
        <p>
          <input type="submit" name="buttonSave" id="buttonSave" value="Actualizar" />
          <input type="submit" name="buttonCancel" id="buttonCancel" value="Cancelar" />
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

<%@page import="controllers.ctrlModificarEmpleado" %>

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
        <jsp:param name="target" value="home.jsp" />
    </jsp:forward>

    <%

}
else
{
    ctrlModificarEmpleado c = new ctrlModificarEmpleado();

    String nombre           = getValue(request, "nombre");
    String apellido         = getValue(request, "apellido");
    String fechaNacimiento  = getValue(request, "fechaNacimiento");
    String dni              = getValue(request, "dni");
    String telefono         = getValue(request, "telefono");
    String matricula        = getValue(request, "matricula");
    String cuil             = getValue(request, "cuil");
    String calle            = getValue(request, "calle");
    String numero           = getValue(request, "numero");
    String barrio           = getValue(request, "barrio");
    String piso             = getValue(request, "piso");
    String departamento     = getValue(request, "departamento");

    String empleado         = getValue(request, "empleados");
    String localidad        = getValue(request, "localidad");
    String provincia        = getValue(request, "provincia");
    String pais             = getValue(request, "pais");

    String mensageEstado = "";

    if (request.getParameter("buttonSave") != null)
    {
        mensageEstado = c.modificarEmpleado
                            (
                             empleado,
                             nombre,
                             apellido,
                             dni,
                             fechaNacimiento,
                             telefono,
                             barrio,
                             calle,
                             numero,
                             piso,
                             departamento,
                             localidad,
                             provincia,
                             pais,
                             "Masculino",
                             cuil
                            );
        mensageEstado = "algo";

    }

    if (mensageEstado != "" && mensageEstado.indexOf("Error") == -1)
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
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
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
<div class="noticias" id="noticias_2"> Modificar Personal<br />
   <%
        if(mensageEstado != "")
        {
            out.println("<p class='error'>" + mensageEstado + "</p>");
        }
        %>
        <div class="forms">
	<form id="form1" name="form1" method="post" action="">
		<div class="izquierda"><br />
			 EMPLEADO<br />
			 <br />
			<select name="empleados" size="1" id="empleados" >
			  <%--= c.getModels("EMPLEADO").toString()--%>
			</select>
			<br />
			<br />
			Nombre<br />
			<label>
			  <input type="text" name="nombre" id="nombre" />
			</label>
			<br />
			<br />
			Apellido<br />
			<label>
			  <input type="text" name="apellido" id="apellido" />
			</label>
			<br />
			<br />
			DNI<br />
			<label>
			  <input type="text" name="dni" id="dni" />
			</label>
			<br />
			<br />
			Fecha de nacimiento<br />
			<label>
			  <input type="text" name="fechaNacimiento" id="fechaNacimiento" />
			</label>
			<br />
			<br />
			Teléfono<br />
			<label>
			  <input type="text" name="telefono" id="telefono" />
			</label>
			<br />
			<br />
			Matricula<br />
			<label>
			  <input type="text" name="matricula" id="matricula" />
			</label>
			<br />
			<br />
			Cuil<br />
			<label>
			  <input type="text" name="cuil" id="cuil" />
			</label>
		</div>
		<div class="derecha"><br />
		  DOMICILIO<br />
		  <br />
		  Calle<br />
			<label>
			  <input type="text" name="calle" id="calle" />
			</label>
			<br />
			<br />
		  Numero<br />
		  <label>
			<input type="text" name="numero" id="numero" />
		  </label>
		  <br />
		  <br />
		  Barrio<br />
		  <label>
			<input type="text" name="barrio" id="barrio" />
		  </label>
		  <br />
		  <br />
		  Piso<br />
		  <label>
			<input type="text" name="piso" id="piso" />
		  </label>
		  <br />
		  <br />
		  Departamento<br />
		  <label>
			<input type="text" name="departamento" id="departamento" />
		  </label>
		  <br />
		  <br />
		  Localidad<br />
		  <select name="localidad" id="localidad" >
			<%--= c.getModels("LOCALIDAD").toString()--%>
		  </select>
		  <br />
		  <br />
		  Provincia
		  <br />
		  <select name="provincia" id="provincia" >
			<%--= c.getModels("PROVINCIA").toString()--%>
		  </select>
		  <br />
		  <br />
		  País<br />
		  <select name="pais" id="pais" >
                        <%--= c.getModels("PROVINCIA").toString()--%>
		  </select>
		  <br />
		</div>
		<div class="guardar">
			<label>
			  <input type="submit" name="buttonSave" id="buttonSave" value="Guardar" />
			</label>
			<label>
			  <input type="submit" name="buttonCancel" id="buttonCancel" value="Cancelar" />
			</label>
		</div>
	</form>

	</div>
</div>
</body>
</html>
<%
    }
}%>
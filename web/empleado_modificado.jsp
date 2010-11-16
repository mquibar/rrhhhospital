<%@page import="controllers.ctrlModificarEmpleado" %>
<%@page import="models.combos.ModelOptionPais" %>
<%@page import="models.combos.ModelOptionLocalidad" %>
<%@page import="models.combos.ModelOptionProvincia" %>
<%@page import="models.combos.ModelOptionEmpleado" %>

<%!
String getValue(ServletRequest request, String varName)
{
    String varVal = request.getParameter(varName);
    return (varVal) == null ? "" : varVal;
}
%>

<%
if (request.getParameter("buttonVolver") != null)
{

    %>

    <jsp:forward page="modificar_personal_ajax.jsp"/>
        
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

        /*mensageEstado = c.modificarEmpleado
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
                            );*/
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
<script type="text/javascript"></script>
</head>

<body>
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
			Empleado: <%=empleado%> <br />
			<br />
                        <br />
			Nombre<br />
			<label>
			  <input type="text" name="nombre" id="nombre" value="<%=nombre%>" />
			</label>
			<br />
			<br />
			Apellido<br />
			<label>
			  <input type="text" name="apellido" id="apellido" value="<%=apellido%>"/>
			</label>
			<br />
			<br />
			DNI<br />
			<label>
			  <input type="text" name="dni" id="dni" value="<%=dni%>"/>
			</label>
			<br />
			<br />
			Fecha de nacimiento<br />
			<label>
			  <input type="text" name="fechaNacimiento" id="fechaNacimiento" value="<%=fechaNacimiento%>" />
			</label>
			<br />
			<br />
			Teléfono<br />
			<label>
			  <input type="text" name="telefono" id="telefono" value="<%=telefono%>" />
			</label>
			<br />
			<br />
			Cuil<br />
			<label>
			  <input type="text" name="cuil" id="cuil" value="<%=cuil%>"/>
			</label>
                        <br />
		</div>
		<div class="derecha"><br />
		  DOMICILIO<br />
		  <br />
		  Calle<br />
			<label>
			  <input type="text" name="calle" id="calle" value="<%=calle%>"/>
			</label>
			<br />
			<br />
		  Numero<br />
		  <label>
			<input type="text" name="numero" id="numero" value="<%=numero%>"/>
		  </label>
		  <br />
		  <br />
		  Barrio<br />
		  <label>
			<input type="text" name="barrio" id="barrio"value="<%=barrio%>" />
		  </label>
		  <br />
		  <br />
		  Piso<br />
		  <label>
			<input type="text" name="piso" id="piso" value="<%=piso%>"/>
		  </label>
		  <br />
		  <br />
		  Departamento<br />
		  <label>
			<input type="text" name="departamento" id="departamento" value="<%=departamento%>" />
		  </label>
		  <br />
		  <br />
		  Localidad<br />
		  <select name="localidad" id="localidad"  >
			<%= ( (ModelOptionLocalidad) c.getModels("LOCALIDAD")).toStringLocalidad(localidad)%>
		  </select>
		  <br />
		  <br />
		  Provincia
		  <br />
		  <select name="provincia" id="provincia" >
			<%= ( (ModelOptionProvincia) c.getModels("PROVINCIA")).toStringProvincia(provincia)%>
		  </select>
		  <br />
		  <br />
		  País<br />
		  <select name="pais" id="pais" >
                        <%= ( (ModelOptionPais) c.getModels("PAIS")).toStringPais(pais)%>
		  </select>
		  <br />
		</div>
		<div class="guardar">
			<label>
			  <input type="button" name="buttonSave" id="buttonSave" value="Actualizar" onclick="guardarModificacionEmpleado()" />
			</label>
			<label>
			  <input type="submit" name="buttonVolver" id="buttonVolver" value="Volver" />
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
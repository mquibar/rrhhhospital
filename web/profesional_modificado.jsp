<%@page import="controllers.ctrlModificarProfesional" %>
<%@page import="models.combos.ModelOptionPais" %>
<%@page import="models.combos.ModelOptionLocalidad" %>
<%@page import="models.combos.ModelOptionProvincia" %>
<%@page import="models.combos.ModelOptionProfesional" %>
<%@page import="models.combos.ModelOptionSexo" %>

<%!
String getValue(ServletRequest request, String varName)
{
    String varVal = request.getParameter(varName);
    return (varVal) == null ? "" : varVal;
}
%>

<%

    ctrlModificarProfesional c = new ctrlModificarProfesional();

    String nombre           = getValue(request, "nombre");
    String apellido         = getValue(request, "apellido");
    String fechaNacimiento  = getValue(request, "fechaNacimiento");
    String dni              = getValue(request, "dni");
    String telefono         = getValue(request, "telefono");
    String matricula        = getValue(request, "matricula");
    String cuil             = getValue(request, "cuil");
    String sexo             = getValue(request, "sexo");
    String calle            = getValue(request, "calle");
    String numero           = getValue(request, "numero");
    String barrio           = getValue(request, "barrio");
    String piso             = getValue(request, "piso");
    String departamento     = getValue(request, "departamento");
    String titulo           = getValue(request, "titulo");

    String profesional      = getValue(request, "profesional");
    String localidad        = getValue(request, "localidad");
    String provincia        = getValue(request, "provincia");
    String pais             = getValue(request, "pais");

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
         <div class="forms">
	<form id="form1" name="form1" method="post" action="">
		<div class="izquierda"><br />
			Profesional<br />
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
			Sexo<br /><select name="sexo" id="sexo" ><%= ( (ModelOptionSexo) c.getModels("SEXO")).toStringSexo(sexo)%></select>
			<br />
			<br />
			Teléfono<br />
			<label>
			  <input type="text" name="telefono" id="telefono" value="<%=telefono%>" />
			</label>
			<br />
			<br />
			Matricula<br />
			<label>
			  <input type="text" name="matricula" id="matricula" value="<%=matricula%>"/>
			</label>
			<br />
			<br />
			Cuil<br />
			<label>
			  <input type="text" name="cuil" id="cuil" value="<%=cuil%>"/>
			</label>
                        <br />
                        <br />
			Título<br />
			<label>
			  <input type="text" name="titulo" id="titulo" value="<%=titulo%>"/>
			</label>
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
			  <input type="button" name="buttonSave" id="buttonSave" value="Actualizar" onclick="guardarModificacionProfesional()" />
			</label>
			<label>
			  <input type="button" name="buttonVolver" id="buttonVolver" value="Volver" onclick="js_cancel_operacion()"  />
			</label>
		</div>
	</form>

	</div>
</div>
</body>
</html>

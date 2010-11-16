
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="./css/estilos.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
<script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
<script language="javascript" type="text/javascript" src="./js/Personal.js"></script>
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
        <div class="forms">
	<form id="form1" name="form1" method="post" action="">
		<div class="izquierda"><br />
			 EMPLEADO<br />
			<br />
                        <select name="empleados" size="1" id="empleados" onchange="loadNuevaPagina()">
                        </select>
			<br />
                        <label>
                            <input type="button" name="buttonTraer" id="buttonTraer" value="Consultar Empleado" onclick="loadPersonas()" />
			</label>
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
		  </select>
		  <br />
		  <br />
		  Provincia
		  <br />
		  <select name="provincia" id="provincia" >
		  </select>
		  <br />
		  <br />
		  País<br />
		  <select name="pais" id="pais" >
		  </select>
		  <br />
		</div>
		<div class="guardar">
			<label>
			  <input type="submit" name="buttonCancel" id="buttonCancel" value="Cancelar" />
			</label>
		</div>
	</form>

	</div>
</div>
</body>
</html>

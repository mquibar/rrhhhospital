

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="../css/estilos.css" rel="stylesheet" type="text/css" />
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
  <div class="logo">LOGO</div>
  <div class="user">
    <div class="user_2">User: </div>
    <div class="log_off">LogOff </div>
  </div>
</div>
<div class="noticias" id="noticias_2"> personal<br />
  <div class="forms">
	<form id="form1" name="form1" method="post" action="">
		<div class="izquierda"><br />
			 EMPLEADO<br />
			 <br />
			<select name="jumpMenu" size="1" id="jumpMenu" onchange="MM_jumpMenu('parent',this,0)">
			  <option>elemento ejemplo 1</option>
			  <option>elemento2</option>
			  <option>elemento3</option>
			</select>
			<br />
			<br />
			Nombre<br />
			<label>
			  <input type="text" name="textfield" id="textfield" />
			</label>
			<br />
			<br />
			Apellido<br />
			<label>
			  <input type="text" name="textfield2" id="textfield2" />
			</label>
			<br />
			<br />
			DNI<br />
			<label>
			  <input type="text" name="textfield3" id="textfield3" />
			</label>
			<br />
			<br />
			Fecha de nacimiento<br />
			<label>
			  <input type="text" name="textfield4" id="textfield4" />
			</label>
			<br />
			<br />
			Teléfono<br />
			<label>
			  <input type="text" name="textfield5" id="textfield5" />
			</label>
			<br />
			<br />
			Matricula<br />
			<label>
			  <input type="text" name="textfield8" id="textfield8" />
			</label>
			<br />
			<br />
			Cuil<br />
			<label>
			  <input type="text" name="textfield9" id="textfield9" />
			</label>
		</div>
		<div class="derecha"><br />
		  DOMICILIO<br />
		  <br />
		  Calle<br />
			<label>
			  <input type="text" name="textfield6" id="textfield6" />
			</label>
			<br />
			<br />
		  Numero<br />
		  <label>
			<input type="text" name="textfield7" id="textfield7" />
		  </label>
		  <br />
		  <br />
		  Barrio<br />
		  <label>
			<input type="text" name="textfield10" id="textfield10" />
		  </label>
		  <br />
		  <br />
		  Piso<br />
		  <label>
			<input type="text" name="textfield11" id="textfield11" />
		  </label>
		  <br />
		  <br />
		  Departamento<br />
		  <label>
			<input type="text" name="textfield12" id="textfield12" />
		  </label>
		  <br />
		  <br />
		  Localidad<br />
		  <select name="jumpMenu2" id="jumpMenu2" onchange="MM_jumpMenu('parent',this,0)">
			<option>elemento1</option>
			<option>elemento2</option>
			<option>elemento3</option>
			<option>elemento4</option>
		  </select>
		  <br />
		  <br />
		  Provincia
		  <br />
		  <select name="jumpMenu3" id="jumpMenu3" onchange="MM_jumpMenu('parent',this,0)">
			<option>elemento1</option>
			<option>elemento2</option>
			<option>elemento3</option>
		  </select>
		  <br />
		  <br />
		  País<br />
		  <select name="jumpMenu4" id="jumpMenu4" onchange="MM_jumpMenu('parent',this,0)">
			<option>elemento1</option>
			<option>elemento2</option>
			<option>elemento3</option>
		  </select>
		  <br />
		</div>
		<div class="guardar">
			<label>
			  <input type="submit" name="button" id="button" value="Guardar" />
			</label>
			<label>
			  <input type="submit" name="button2" id="button2" value="Cancelar" />
			</label>
		</div>
	</form>

	</div>
</div>
</body>
</html>

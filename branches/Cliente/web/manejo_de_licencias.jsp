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
<div class="noticias" id="noticias_2"> MANEJO DE LICENCIAS<br />
  <div class="forms">
    <div class="izquierda"><br />
      <form id="form1" name="form1" method="post" action="">
         EMPLEADO<br />
         <br />
        <select name="jumpMenu" size="1" id="jumpMenu" onchange="MM_jumpMenu('parent',this,0)">
          <option>elemento ejemplo 1</option>
          <option>elemento2</option>
          <option>elemento3</option>
        </select>
        <br />
        <br />
        Tipo de horario<br />
        <select name="jumpMenu2" id="jumpMenu2" onchange="MM_jumpMenu('parent',this,0)">
          <option>elemento1</option>
          <option>elemento2</option>
          <option>elemento3</option>
          <option>elemento4</option>
        </select>
        <br />
        <br />
        Fecha inicio<br />
        <label>
          <input type="text" name="textfield2" id="textfield2" />
        </label>
        <br />
        <br />
        Fecha fin<br />
        <label>
          <input type="text" name="textfield" id="textfield" />
        </label>
<br />
        <br />
        Motivo<br />
        <label>
          <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
        </label>
        <br />
        <br />
        <label>
          <input type="submit" name="button" id="button" value="Guardar" />
        </label>
        <label>
          <input type="submit" name="button2" id="button2" value="Cancelar" />
        </label>
        <br />
      </form>
    </div>
    <div class="derecha"></div>
  </div>
</div>
</body>
</html>

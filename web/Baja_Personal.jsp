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
<div class="noticias" id="noticias_2"> Baja Personal<br />
  <div class="forms">
    <div class="izquierda"><br />
      <br />
      EMPLEADO<br />
      <br />
      <select name="jumpMenu" size="1" id="jumpMenu" onchange="MM_jumpMenu('parent',this,0)">
        <option>elemento ejemplo 1</option>
        <option>elemento2</option>
        <option>elemento3</option>
      </select>
      <br />
      <br />
      <br />
      Datos<br />
      <label>
        <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
      </label>
      <br />
      <br />
      <br />
      <label>
        <input type="submit" name="Baja" id="button" value="Baja" />
      </label>
      <label>
        <input type="submit" name="button2" id="button2" value="Cancelar" />
      </label>
      <br />
      <br />
      <br />
    </div>
    <div class="derecha"></div>
  </div>
</div>
</body>
</html>
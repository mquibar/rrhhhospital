<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="./css/estilos.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
<script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
<script language="javascript" type="text/javascript" src="./js/Personal.js"></script>
<script language="javascript" type="text/javascript" src="./js/Funciones.js"></script>
<script language="javascript" type="text/javascript" src="./js/tools.js"></script>
</head>

<body onload="iniciaBaja()">
<div class="noticias" id="noticias_2"> Baja Personal<br />
  <div class="forms">
    <div class="izquierda"><br />
      <br />
      EMPLEADO<br />
      <br />
      <select name="empleados" size="1" id="empleados" onchange="mostrarDatosParaDarBaja()">

      </select>
      <br />
      <br />
      <br />
      Datos<br />
      <label>
        <textarea name="datos" id="datos" cols="45" rows="5"></textarea>
      </label>
      <br />
      <br />
      <br />
      <label>
        <input type="button" name="Baja" id="button" onclick="darBaja()" value="Aceptar"/>
      </label>
      <label>
          <input type="button" name="button2" id="button2" value="Cancelar" onclick="js_cancel_operacion()" />
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
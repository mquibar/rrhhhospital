<%@page import="controllers.ctrlRecategorizacion" %>

<% ctrlRecategorizacion c = new ctrlRecategorizacion(); %>

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
<div class="noticias" id="noticias_2"> Recategorización<br />
  <div class="forms">
    <div class="izquierda"><br />
<form id="form1" name="form1" method="post" action="Recategorizacion_2daParte.jsp">
        <p>Seleccionar Empleado<br />
           <br />
           <select name="empleado" size="1" id="empleado">
                <%= c.getModels("empleado").toString()%>
           </select>
         </p>
        <p>&nbsp;</p>
        <p>
          <input type="submit" name="selectButton" id="selectButton" value="Seleccionar" />
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
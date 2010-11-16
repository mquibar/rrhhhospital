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
          mensageEstado = "apreto save";

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
<script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
<script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
<script language="javascript" type="text/javascript" src="./js/Personal.js"></script>
<script language="javascript" type="text/javascript" src="./js/tools.js"></script>
</head>

<body>
        <div class="noticias" id="noticias_2"> CONSULTAR PERSONA<br />
            <div class="forms">
                <div align="left"></div>
                <div class="izquierda">
                    <div align="left"><br />
                    </div>
                    <form id="form1" name="form1" method="post" action="">
                        <p align="left">EMPLEADO</p>
                        <p align="left">Nombre<br />
                            <label>
                                <input type="text" name="nombre" id="nombre" />
                            </label>
                            <br />
                            <br />
                            Apellido<br />
                            <input type="text" name="apellido" id="apellido" />
                        </p>
                        <p align="left">
                            <label>
                                <input type="button" name="buttonConsultar" id="buttonConsultar" onclick="consultarEmpleado()" value="Buscar"/>
                            </label>
                            <label>
                                <input type="button" name="buttonCancelar" id="buttonCancelar" value="Cancelar" onclick="js_cancel_operacion()" />
                            </label>
                        </p>
                        <p align="left">Empleado/s<br />
                            <select name="empleados" id="empleados" onchange="responderEmpleado()">
                                
                            </select>
                        </p>
                        <p align="left">Datos<br />
                            <label>
                                <textarea name="datos" id="datos" cols="45" rows="5"></textarea>
                            </label>
                            <br />
                            <br />
                            <br />
                        </p>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
<%
    }
}%>
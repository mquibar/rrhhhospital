<%@page import="controllers.ctrlAltaRegistroPeriodo" %>

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

    <jsp:forward page="../tools/messageBox.jsp">
    <jsp:param name="msg" value="Operacion cancelada por el usuario" />
    <jsp:param name="target" value="home.html" />
    </jsp:forward>

<%
}
else
{
    String empleado = getValue(request, "empleado");
    String fechaEntrada = getValue(request, "fechaEntrada");
    String fechaSalida = getValue(request, "fechaSalida");
    String horaEntrada = getValue(request, "horaEntrada");
    String horaSalida = getValue(request, "horaSalida");
    String vigente = getValue(request, "vigente");

    String mensageEstado = "";
    ctrlAltaRegistroPeriodo c = null;
   try
    {
        c = new ctrlAltaRegistroPeriodo();

        if (request.getParameter("buttonSave") != null)
        {
            c.iniciarAlta(
                empleado,
                fechaEntrada,
                horaEntrada,
                fechaSalida,
                horaSalida,
                vigente
                    );

            mensageEstado = c.guardar();
        }
    }
    catch(Exception ex)
    {
       mensageEstado = "Error: " + ex.toString();
    }

    if (mensageEstado != "" && mensageEstado.indexOf("Error:") == -1)
    {

%>

        <jsp:forward page="../tools/messageBox.jsp">
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
            <title>Asignacion de Horario</title>
            <link href="../css/estilos.css" rel="stylesheet" type="text/css" />

            <script src="../js/validaciones/validaciones.js" type="text/javascript"></script>
            <script src="../js/validaciones/validacionesRegistroPeriodo.js" type="text/javascript"></script>
            <script src="../tools/datepicker/datepickercontrol.js" type="text/javascript"></script>
            <link  href="../tools/datepicker/datepickercontrol.css" type="text/css" rel="stylesheet" />

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
            <div class="noticias" id="noticias_2"> ASIGNACION HORARIOS<br />
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
                            <select name="empleado" size="1" id="empleado" >
                                <%= c.getOptionsEmpleado(empleado)%>
                            </select>
                            <br />
                            <br />
                           Fecha<br />
                            <label>
                                <input type="text" name="fechaEntrada" id="DPC_edit1"  value='<%=fechaEntrada%>' />
                            </label>
                            <br />
                            <br />
                            Hora Entrada<br />
                            <label>
                                <input name="horaEntrada" id="horaEntrada" value="<%=horaEntrada%>"/>
                            </label>
                            <br />
                            <br />
                            Hora Salida<br />
                            <label>
                                <input name="horaSalida" id="horaSalida" value="<%=horaSalida%>"/>
                            </label>
                            <br />
                            <br />
                        </div>
                        <div class="derecha"></div>
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

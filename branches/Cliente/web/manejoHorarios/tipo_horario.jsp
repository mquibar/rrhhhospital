<%@page import="controllers.ctrlAltaTipoHorario" %>

<%!
    String getValue(ServletRequest request, String varName)
    {
        String varVal = request.getParameter(varName);
        return (varVal) == null ? "" : varVal;
    }

    String getTitle(Boolean esBorrado, String idEntidad)
    {
        if(esBorrado)
        {
            return "ELIMINACION";
        }
        else if(!idEntidad.equals(""))
        {
            return "MODIFICACION";
        }
        else
        {
            return "ALTA";
        }
    }

    String getAction(Boolean esBorrado, String idEntidad)
    {
        if(esBorrado)
        {
            return "Eliminar";
        }
        else if(!idEntidad.equals(""))
        {
            return "Modificar";
        }
        else
        {
            return "Agregar";
        }
    }
%>

<%
if (request.getParameter("buttonCancel") != null)
{
%>

    <jsp:forward page="../tools/messageBox.jsp">
    <jsp:param name="msg" value="Operacion cancelada por el usuario" />
    <jsp:param name="target" value="../PanelNoticias.html" />
    </jsp:forward>

<%
}
else
{
    String mensageEstado = "";
    String idEntidad = getValue(request, "idEntidad");
    String action = getValue(request, "action");
    String esRecarga = getValue(request, "esRecarga");
    String eliminado = getValue(request, "eliminado");
    Boolean esBorrado = (action.equals("delete"));
    String deshabilitar = (esBorrado) ? "readonly" : "";
    boolean cargarEntidad = !idEntidad.equals("") && !esRecarga.equals("Si");
    eliminado = esBorrado.toString();
    
    String horaEntrada = getValue(request, "horaEntrada");
    String horaSalida = getValue(request, "horaSalida");
    String nombre = getValue(request, "nombre");
    String descripcion = getValue(request, "descripcion");

    ctrlAltaTipoHorario c = null;
    try
    {
        c = new ctrlAltaTipoHorario();

        if(cargarEntidad)
        {
            horaEntrada = c.getHoraIngreso(idEntidad);
            horaSalida = c.getHoraSalida(idEntidad);
            nombre = c.getNombre(idEntidad);
            descripcion = c.getDescripcion(idEntidad);
            
            esRecarga = "Si";
        }

        if (request.getParameter("buttonSave") != null)
        {
            mensageEstado = c.guardar(
                    idEntidad,
                    nombre,
                    descripcion,
                    horaEntrada,
                    horaSalida,
                    eliminado);
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
            <jsp:param name="target" value="../PanelNoticias.html" />
        </jsp:forward>

<%
    }
    else
    {

%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml"><head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>Alta de Tipo de Horario</title>
            <link href="../css/estilos.css" rel="stylesheet" type="text/css" />

            <script src="../js/validaciones/validaciones.js" type="text/javascript"></script>
            <script src="../js/validaciones/validacionesTipoHorario.js" type="text/javascript"></script>
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
            <div class="noticias" id="noticias_2"> 
                <%=getTitle(esBorrado, idEntidad)%> TIPO HORARIO<br />
<%
    if(mensageEstado != "")
    {
        out.println("<p class='error'>" + mensageEstado + "</p>");
    }
%>
                <div class="forms">
                    <form id="form1" name="form1" method="post" action="">
                        <div class="izquierda"><br />
                                <input type="hidden" name="idEntidad" id="idEntidad" value="<%=idEntidad%>"/>
                                <input type="hidden" name="esRecarga" id="esRecarga" value="<%=esRecarga%>"/>
                                <input type="hidden" name="action" id="action" value="<%=action%>"/>
                                <input type="hidden" name="eliminado" id="eliminado" value="<%=eliminado%>"/>
                            Nombre<br />
                            <label>
                                <input name="nombre" id="nombre" <%=deshabilitar%> value="<%=nombre%>" />
                            </label>
                            <br />
                            <br />
                            Descripcion<br />
                            <label>
                                <textarea name="descripcion" id="descripcion" cols="45" rows="5" <%=deshabilitar%> ><%=descripcion%></textarea>
                            </label>
                            <br />
                            <br />
                            Hora Entrada<br />
                            <label>
                                <input name="horaEntrada" id="horaEntrada" <%=deshabilitar%> value="<%=horaEntrada%>"/>
                            </label>
                            <br />
                            <br />
                            Hora Salida<br />
                            <label>
                                <input name="horaSalida" id="horaSalida" <%=deshabilitar%> value="<%=horaSalida%>" />
                            </label>
                            <br />
                            <br />
                        </div>
                        <div class="derecha"></div>
                        <div class="guardar">
                            <label>
                                <input type="submit" name="buttonSave" id="buttonSave" value="<%=getAction(esBorrado, idEntidad)%>" />
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
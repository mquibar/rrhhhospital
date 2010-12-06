<%@page import="controllers.ctrlAltaAsignacionHorario" %>

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
    String mensageEstado = "";
    String idEntidad = getValue(request, "idEntidad");
    String action = getValue(request, "action");
    String esRecarga = getValue(request, "esRecarga");
    String eliminado = getValue(request, "eliminado");
    Boolean esBorrado = (action.equals("delete"));
    String deshabilitar = (esBorrado) ? "readonly" : "";
    boolean cargarEntidad = !idEntidad.equals("") && !esRecarga.equals("Si");
    eliminado = esBorrado.toString();

    String fechaInicio = getValue(request, "fechaInicio");
    String fechaFin = getValue(request, "fechaFin");
    String empleado = getValue(request, "empleado");
    String tipoHorario = getValue(request, "tipoHorario");
    String descripcion = getValue(request, "descripcion");

    ctrlAltaAsignacionHorario c = null;
    try
    {
        c = new ctrlAltaAsignacionHorario();
    }
    catch(Exception ex)
    {
       mensageEstado = "Error: " + ex.toString();
    }
%>

<div id="noticias_2">
    <%=getTitle(esBorrado, idEntidad)%> ASIGNACION HORARIO<br />
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
                EMPLEADO<br />
                <br />
                <select name="empleado"  <%=deshabilitar%> size="1" id="empleado" >
                    <%= c.getOptionsEmpleado(empleado)%>
                </select>
                <br />
                <br />
                Tipo de horario<br />
                <select name="tipoHorario"  <%=deshabilitar%> id="tipoHorario" >
                    <%= c.getOptionsTipoHorario(tipoHorario)%>
                </select>
                <br />
                <br />
                Fecha Inicio<br />
                <label>
                    <input type="text" name="fechaInicio"  <%=deshabilitar%> id="DPC_edit1"  value='<%=fechaInicio%>' />
                </label>
                <br />
                <br />

<% if(idEntidad == ""){%>
                Fecha Fin<br />
                <label>
                    <input type="text" name="fechaFin"  <%=deshabilitar%> id="DPC_edit2"  value='<%=fechaFin%>' />
                </label>
                <br />
                <br />
<% }%>
                Descripcion<br />
                <label>
                    <textarea name="descripcion" id="descripcion"  <%=deshabilitar%> cols="45" rows="5"><%=descripcion%></textarea>
                </label>
                <br />
            </div>
            <div class="derecha"></div>
            <div class="guardar">
                <label>
                    <input type="button" name="buttonSave" id="buttonSave" value="<%=getAction(esBorrado, idEntidad)%>"
                           onclick="guardarModificacionAsignacionHorario();" />
                </label>
                <label>
                    <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar"
                           onclick="js_cancel_operacion();" />
                </label>
            </div>
        </form>
    </div>
</div>

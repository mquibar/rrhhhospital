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
    
    String horaEntrada = getValue(request, "horaEntrada");
    String horaSalida = getValue(request, "horaSalida");
    String nombre = getValue(request, "nombre");
    String descripcion = getValue(request, "descripcion");

%>

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
                    <input type="button" name="buttonSave" id="buttonSave" value="<%=getAction(esBorrado, idEntidad)%>"  
                           onclick="guardarModificacionTipoHorario();" />
                </label>
                <label>
                    <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar"
                           onclick="js_cancel_operacion();" />
                </label>
            </div>
        </form>
    </div>
</div>

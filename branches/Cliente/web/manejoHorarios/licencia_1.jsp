<%@page import="controllers.ctrlAltaLicencia" %>

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

    String empleado = getValue(request, "empleado");
    String tipoLicencia = getValue(request, "tipoLicencia");
    String fechaInicio = getValue(request, "fechaInicio");
    String fechaFin = getValue(request, "fechaFin");
    String motivo = getValue(request, "motivo");
 
    ctrlAltaLicencia c = null;
   try
    {
        c = new ctrlAltaLicencia();
    }
    catch(Exception ex)
    {
       mensageEstado = "Error: " + ex.toString();
    }

 %>

<div id="noticias_2">
    <%=getTitle(esBorrado, idEntidad)%> LICENCIA<br />
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
                Empleado<br />
                <br />
                <select id="empleado" name="empleado"  <%=deshabilitar%> size="1" >
                    <%= c.getOptionsEmpleado(empleado)%>
                </select>
                <br />
                <br />
                Tipo de Licencia<br />
                <select id="tipoLicencia" name="tipoLicencia"  <%=deshabilitar%> >
                    <%= c.getOptionsTipoLicencia(tipoLicencia)%>
                </select>
                <br />
                <br />
                Fecha Inicio<br />
                <label>
                    <input type="text" id="DPC_edit1" name="fechaInicio"  <%=deshabilitar%> value='<%=fechaInicio%>' />
                </label>
                <br />
                <br />
                Fecha Fin<br />
                <label>
                    <input type="text" id="DPC_edit2"  name="fechaFin"  <%=deshabilitar%>  value='<%=fechaFin%>' />
                </label>
                <br />
                <br />
                Motivo<br />
                <label>
                    <textarea name="motivo" id="motivo"  <%=deshabilitar%> cols="45" rows="5"><%=motivo%></textarea>
                </label>
                <br />
            </div>
            <div class="derecha"></div>
            <div class="guardar">
                <label>
                    <input type="button" name="buttonSave" id="buttonSave" value="<%=getAction(esBorrado, idEntidad)%>"
                           onclick="guardarModificacionLicencia();" />
                </label>
                <label>
                    <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar"
                           onclick="js_cancel_operacion();" />
                </label>
            </div>
        </form>
    </div>
</div>

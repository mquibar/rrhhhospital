<%@page import="controllers.ctrlReporteHorario" %>

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

    String getNombreReporte(ServletRequest request)
    {
        String rep = getValue(request, "tipoReporte");
        return rep.replace("_", " ");
    }

    String getTipoReporte(ServletRequest request)
    {
        String rep = getValue(request, "tipoReporte");
        return rep;
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
    String tipoReporte = getTipoReporte(request);

    ctrlReporteHorario c = null;
    try
    {
        c = new ctrlReporteHorario();
    }
    catch(Exception ex)
    {
       mensageEstado = "Error: " + ex.toString();
    }

%>

<div id="noticias_2"> 
    Reporte <%=getNombreReporte(request)%><br />

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
                    <input type="hidden" name="tipoReporte" id="tipoReporte" value="<%=tipoReporte%>"/>

                EMPLEADO<br />
                <br />
                <select id="empleado" name="empleado" size="1"  >
                    <%= c.getOptionsEmpleado(empleado)%>
                </select>
                <br />
                <br />
                Fecha Inicio<br />
                <label>
                    <input type="text" name="fechaInicio" id="DPC_edit1" />
                </label>
                <br />
                <br />
                Fecha Fin<br />
                <label>
                    <input type="text" name="fechaFin" id="DPC_edit2" />
                </label>
                <!--br />
                <br />
                ENTIDADES<br />
                <br />
                <select id="entidades" name="entidades" size="1"  >
                </select-->
            </div>
            <div class="derecha"></div>

            <div class="guardar">
                <label>
                    <input type="button" name="buttonSave" id="buttonSave" value="Lanzar Reporte"
                           onclick="lanzarReporte();" />
                </label>
                <label>
                    <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar"
                           onclick="js_cancel_operacion();" />
                </label>
            </div>

        </form>
    </div>
</div>

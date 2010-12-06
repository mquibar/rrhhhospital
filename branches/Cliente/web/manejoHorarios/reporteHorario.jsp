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
    String empleado = getValue(request, "empleado");

    ctrlReporteHorario c = null;
    try
    {
        c = new ctrlReporteHorario();
    }
    catch(Exception ex)
    {
       String mensageEstado = "Error: " + ex.toString();
    }

%>

<div id="noticias_2"> 
    Reporte <%=getNombreReporte(request)%><br />

    <div class="forms">
        <form id="form1" name="form1" method="post" action="">
            <div class="izquierda"><br />
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
                <br />
                <br />
                ENTIDADES<br />
                <br />
                <select id="entidades" name="entidades" size="1"  >
                </select>
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

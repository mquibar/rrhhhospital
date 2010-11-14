<%@page import="controllers.ctrlComboSeleccion" %>
<%-- 
    Document   : modificar
    Created on : 13/11/2010, 16:24:17
    Author     : leoroot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
    String getValue(ServletRequest request, String varName)
    {
        String varVal = request.getParameter(varName);
        return (varVal) == null ? "" : varVal;
    }

    String descamelcasear(String val)
    {
        val = val.replace("_", " ");

        return val;
    }

    String nombreImprimible(ServletRequest request)
    {
        return descamelcasear(getValue(request, "nombreEntidad"));
    }
%>

<html>
    <head>
        <link href="../css/estilos.css" rel="stylesheet" type="text/css" />
        <script src="../js/tools.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificacion de <%=nombreImprimible(request)%></title>
    </head>
    <body>
        Elija <%=nombreImprimible(request)%> a modificar: 
        <select onchange="cargarSource('abm', '<%=getValue(request, "pathEntidad")%><%=getValue(request, "nombreEntidad")%>.jsp?idEntidad=' + this.value);">Seleccionar
            <%=ctrlComboSeleccion.getCombo(getValue(request, "nombreEntidad"))%>
        </select>
        <iframe class="noticias" id="abm" src="#"></iframe>
    </body>
</html>

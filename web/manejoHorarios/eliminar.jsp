<%@page import="controllers.ctrlComboSeleccion" %>
<%-- 
    Document   : eliminar
    Created on : 13/11/2010, 17:17:07
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
        <title>Eliminacion de <%=nombreImprimible(request)%></title>
    </head>
    <body>
        Elija <%=nombreImprimible(request)%> a eliminar
        <select onchange="cargar('<%=getValue(request, "pathEntidad")%><%=getValue(request, "nombreEntidad")%>.jsp?idEntidad=' + this.value + '&action=delete');">Seleccionar
            <%=ctrlComboSeleccion.getCombo(getValue(request, "nombreEntidad"))%>
        </select>
    </body>
</html>

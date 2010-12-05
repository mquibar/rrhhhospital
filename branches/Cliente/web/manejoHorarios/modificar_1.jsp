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

    String nombreTituloPegado(ServletRequest request)
    {
        String nom = getValue(request, "nombreEntidad");
        nom = nom.replace("_", "");
        return nom;
    }

    String getOperacion(ServletRequest request)
    {
        String oper = getValue(request, "operacion");
        oper = (oper.equals(""))?"Modificar":oper;
        return oper;
    }
%>

Elija <%=nombreImprimible(request)%> a <%=getOperacion(request)%>
<select id="selector" onchange="load<%=getOperacion(request)%>('<%=nombreTituloPegado(request)%>');">
    <%=ctrlComboSeleccion.getCombo(getValue(request, "nombreEntidad"))%>
</select>

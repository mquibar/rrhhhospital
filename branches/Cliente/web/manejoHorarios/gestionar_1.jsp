<%-- 
    Document   : gestionar
    Created on : 13/11/2010, 15:12:44
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

    String getBase(ServletRequest request)
    {
        String bas = getValue(request, "pathEntidad");

        if(bas.length()>0)
        {
            bas += "/";
        }

        return bas;
    }

    String getEntidad(ServletRequest request)
    {
        return getValue(request, "nombreEntidad");
    }
%>


<div class="noticias" id="noticias_2"> GESTIONAR <%=nombreImprimible(request).toUpperCase()%> <br />
  <div class="forms">
    <div class="izquierda"><br />
      <br />
      <a href="#" onclick="load('<%=getBase(request)%><%=getEntidad(request).toLowerCase()%>_1.jsp','noticias');">Alta <%=nombreImprimible(request)%></a> <br />
      <br />
      <br />
      <a href="#" onclick="load('<%=getBase(request)%>modificar_1.jsp?nombreEntidad=<%=getEntidad(request)%>','noticias');">Modificar <%=nombreImprimible(request)%></a> <br />
      <br />
      <br />
      <a href="#" onclick="load('<%=getBase(request)%>modificar_1.jsp?operacion=Eliminar&nombreEntidad=<%=getEntidad(request)%>','noticias');">Baja <%=nombreImprimible(request)%></a> <br />
      <br />
      <br />
    </div>
    <div class="derecha"></div>
  </div>
</div>

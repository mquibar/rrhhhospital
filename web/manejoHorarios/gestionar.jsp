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
%>

<html>
    <head>
        <link href="../css/estilos.css" rel="stylesheet" type="text/css" />
        <script src="../js/tools.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de <%=nombreImprimible(request)%></title>
    </head>
    <body>
        <div class="noticias" id="noticias_2"> GESTIONAR <%=nombreImprimible(request).toUpperCase()%> <br />
          <div class="forms">
            <div class="izquierda"><br />
              <br />
              <a href="<%=getValue(request, "pathEntidad")%><%=getValue(request, "nombreEntidad")%>.jsp">Alta <%=nombreImprimible(request)%></a> <br />
              <br />
              <br />
              <a href="<%=getValue(request, "pathEntidad")%>modificar.jsp?nombreEntidad=<%=getValue(request, "nombreEntidad")%>">Modificar <%=nombreImprimible(request)%></a> <br />
              <br />
              <br />
              <a href="<%=getValue(request, "pathEntidad")%>eliminar.jsp?nombreEntidad=<%=getValue(request, "nombreEntidad")%>">Baja <%=nombreImprimible(request)%></a> <br />
              <br />
              <br />
            </div>
            <div class="derecha"></div>
          </div>
        </div>
    </body>
</html>

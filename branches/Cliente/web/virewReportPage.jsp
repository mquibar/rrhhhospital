<%-- 
    Document   : virewReportPage
    Created on : 15-nov-2010, 16:53:10
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controllers.ctrlReporte" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte</title>
    </head>
    <%
            String reporte = request.getParameter("report");
            ctrlReporte c = new ctrlReporte();
            byte[] b;
            if (reporte != null) {
                b = c.armarReporte(reporte);
            } else {
                b = c.armarReporte();
            }
            try {
                response.setContentType("application/pdf");
                response.setContentLength(b.length);
                ServletOutputStream sos = response.getOutputStream();
                sos.write(b, 0, b.length);
                sos.flush();
                sos.close();
            } catch (Exception e) {
            }
    %>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

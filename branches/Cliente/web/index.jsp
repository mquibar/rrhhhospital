<%-- 
    Document   : index
    Created on : 29-oct-2010, 12:36:09
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="controllers.ctrlLogin" %>
<%!
        ctrlLogin c = new ctrlLogin();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="datos">
        <div align="center">User
        </div>
        <form id="form1" name="form1" method="post" action="">
            <div align="center">
              <input type="text" name="user" id="user" />
            <br />
            <br />
            Password
            <br />
              <input type="password" name="pass" id="pass"/>
            <br />
            <br />
          </div>
            <div align="center">
              <input type="submit" name="buttonSave" id="buttonSave" value="Login" />
              <br />
              <input type="submit" name="buttonCancel" id="buttonCancel" value="Salir" />
            </div>
        </form>
        <br />
      </div>
    </body>
</html>

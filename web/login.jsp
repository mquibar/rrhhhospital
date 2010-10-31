<%@page import="controllers.ctrlLogin" %>

<%!
    String getValue(ServletRequest request, String varName)
    {
        String varVal = request.getParameter(varName);
        return (varVal) == null ? "" : varVal;
    }
%>

<%
if (request.getParameter("buttonCancel") != null)
{
%>

    <jsp:forward page="./tools/messageBox.jsp">
    <jsp:param name="msg" value="Gracias por utilizar el sistema" />
    <jsp:param name="target" value="" />
    </jsp:forward>

<%
}
else
{

    ctrlLogin c = new ctrlLogin();

    String user = getValue(request, "user");
    String pass = getValue(request, "pass");

    String mensageEstado = "";

    if (request.getParameter("buttonSave") != null)
    {
        mensageEstado = c.login(user, pass);
    }

    if (mensageEstado != "" && mensageEstado.indexOf("Error:") == -1)
    {

%>

        <jsp:forward page="./tools/messageBox.jsp">
            <jsp:param name="msg" value="<%=mensageEstado%>" />
            <jsp:param name="target" value="home.html" />
        </jsp:forward>

<%
    }
    else
    {

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="./css/estilos.css" rel="stylesheet" type="text/css" />
<style type="text/css">
bodyLogin
{
	background-color: #FFF;
}
</style>
</head>

<body bgcolor="#FFFFFF"> 
<div class="noticias" id="noticias_2"><br />

  <div class="forms">
    <div class="izquierda" id="login">
      <div class="logo_login">
          <img src="img/Logo.jpg" alt="logo" width="402" height="316" align="absmiddle" />
      </div>
<%
    if(mensageEstado != "")
    {
        out.println("<p class='error'>" + mensageEstado + "</p>");
    }
%>
      <div class="datos">
        <div align="center">User 
        </div>
        <form id="form1" name="form1" method="post" action="">
            <div align="center">
              <input type="text" name="user" id="user" value='<%=user%>' />
            <br />
            <br />
            Password
            <br />
              <input type="text" name="pass" id="pass" value='<%=pass%>' />
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
      <br />
    </div>
  </div>
</div>
</body>
</html>

<%
    }
}%>


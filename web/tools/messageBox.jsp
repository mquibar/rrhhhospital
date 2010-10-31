<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title>Mensaje</title>

</head><body >

<div id="hidepage" style="position: absolute; left:0px; top:0px; background-color: #000000; height: 100%; width: 100%;"
onclick="javascript:window.location = '<%=request.getParameter("target")%>';">
<table width="100%" height="100%">
<tr>
<td align="center" valign="middle">
<table width="50%" align="center">
<tr>
<td align="center" style="background-color:#FFFFFF; border: 1px solid #666666; padding: 10px;">
<h1><%=request.getParameter("msg")%></h1>
Click para continuar
</td>
</tr>
</table>
</td>
</tr>
</table>
</div></body>
</html>

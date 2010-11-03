<%-- 
    Document   : TestAjax
    Created on : 31-oct-2010, 11:36:52
    Author     : Manuel
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <script language="javascript" type="text/javascript" src="./js/preguntar.js">
    </script>
</head>

<body onload="iniciar()">
    <h1>Hello World!</h1>
    <form>
        <a>Agrupamiento</a><select id="agrupamiento" onchange="listarTramo()">
        </select>

        <a>Tramo</a><select id="tramo">
        </select>
        <input type="text" id="te" value="" readonly="readonly" />
    </form>
</body>
</html>

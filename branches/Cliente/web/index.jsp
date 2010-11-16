<%-- 
    Document   : index
    Created on : 29-oct-2010, 12:36:09
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Ingreso al Sistema</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <link href="./js/jqueryjs/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="./js/jqueryjs/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="./js/jqueryjs/jquery.alerts.js"></script>)
        <style type="text/css">
            bodyLogin
            {
                background-color: #FFF;
            }
        </style>
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" src="./js/loginJs.js" type="text/javascript"></script>
    </head>

    <body bgcolor="#FFFFFF">
        <div class="noticias" id="noticias_2"><br />

            <div class="forms">
                <div class="izquierda" id="login">
                    <div class="logo_login">
                        <img src="img/Logo.jpg" alt="logo" width="402" height="316" align="absmiddle" />
                    </div>
                    <div class="datos">
                        <form id="form1" name="form1">
                            <!--<H1>LOGIN FORM</H1>-->
                            <table>
                                <tr>
                                    <td> Username  : </td><td> <input id="user" name="username" size=15 type="text" /> </td>
                                </tr>
                                <tr>
                                    <td> Password  : </td><td> <input id="password" name="password" size=15 type="password" /> </td>
                                </tr>
                            </table>
                            <input align="center" type="button" value="login" onclick="js_logIn()" />
                        </form>
                        <br />
                    </div>
                    <br />
                </div>
            </div>
        </div>
    </body>
</html>
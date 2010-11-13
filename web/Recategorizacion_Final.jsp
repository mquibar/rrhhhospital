<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Home</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/recategorizarJs.js"></script>
    </head>

    <body onload="js_recategor()">
        <div class="cabecera">
            <div class="logo"></div>
            <div class="user">
                <div class="user_2">User: </div>
                <div class="log_off">LogOff </div>
            </div>
        </div>
        <div class="noticias" id="noticias_2"> Recategorización<br />
            <div class="forms">
                <div class="izquierda"><br />
                    <form id="form1" name="form1" method="post" action="" >
                        <p>Seleccionar Empleado<br />
                            <br />
                            <select name="empleado" size="1" id="empleado" >

                            </select>
                        </p>
                        <p>
                            <input type="button" name="button2" id="button2" value="Seleccionar" onclick="js_lista_Agrupamiento()"/>
                        </p>
                        <hr color="#E3E3E3"/>
                        <p>Agrupamiento </p>
                        <p>
                            <select name="agrupamiento" size="1" id="agrupamiento" onchange="">
                            </select>
                        </p>
                        <p>Tramo</p>
                        <p>
                            <select name="tramo" size="1" id="tramo" onchange="">
                            </select>
                        </p>
                        <p>Categoria</p>
                        <p>
                            <select name="categoria" size="1" id="categoria">
                            </select>
                        </p>
                        <p>&nbsp;</p>
                        <p>
                            <input type="submit" name="buttonActualizar" id="buttonActualizar" value="Actualizar" onclick="sleep(5000)"/>
                        </p>
                        <p>
                            <input type="submit" name="buttonCancel" id="buttonCancel" value="Cancelar" />
                        </p>
                    </form>
                </div>
                <div class="derecha"></div>
            </div>
        </div>
    </body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Home</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <link href="./js/jquery.alerts-1.1/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/recategorizarJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/jquery/alerts/jquery/jquery-1.4.2.min.js"></script>
        <script language="javascript" type="text/javascript" src="./js/jquery/alerts/jquery/ui/jquery.ui.draggable.js"></script>
        <script language="javascript" type="text/javascript" src="./js/jquery/alerts/jquery/alerts.js"></script>
    </head>

    <body onload="js_recategor()">
        <div class="noticias" id="noticias_2"> Recategorización<br />
            <div class="forms">
                <div class="izquierda"><br />
                    <form id="form1" name="form1" method="post" action="" >
                        <p>Seleccionar Empleado
                            <select name="empleado" size="1" id="empleado" >
                            </select>
                        </p>
                        <p>
                            <input type="button" name="button2" id="button2" value="Seleccionar" onclick="js_lista_Agrupamiento()"/>
                        </p>
                        <hr color="#E3E3E3"/>
                        <p>Agrupamiento </p>
                        <p>
                            <select name="agrupamiento" size="1" id="agrupamiento" onchange="js_lista_tramo()">
                            </select>
                        </p>
                        <p>Tramo</p>
                        <p>
                            <select name="tramo" size="1" id="tramo" onchange="js_lista_catPosible()">
                            </select>
                        </p>
                        <p>Categoria</p>
                        <p>
                            <select name="categoria" size="1" id="categoria"  onchange="js_lista_clase()">
                            </select>
                        </p>
                        
                        <input id="btnListAll" type="button" value="Mostrar Todas" style="display: none" onclick="js_lista_catAll()"/>
                        <p>Clase</p>
                        <p>
                            <select name="clase" size="1" id="clase">
                            </select>
                        </p>
                        <p>&nbsp;</p>
                        <p>
                            <input type="button" name="buttonActualizar" id="buttonActualizar" value="Actualizar" onclick="js_save_recat()"/>
                        </p>
                        <p>
                            <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar" onclick="jAlert('Operacion Cancelada por el Usuario', 'Sistema Personal')"/>
                        </p>
                    </form>
                </div>
                <div class="derecha"></div>
            </div>
        </div>
    </body>
</html>
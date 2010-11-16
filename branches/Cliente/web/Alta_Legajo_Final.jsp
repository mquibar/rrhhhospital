<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Home</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="./js/asignarLegJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/tools.js"></script>
    </head>

    <body onload="js_begin_asignar()">
        <div class="noticias" id="noticias_2"> Alta Legajo<br />

            <div class="forms">
                <div class="izquierda"><br />
                    <form id="form1" name="form1">
                        <p>Empleado<br />
                        </p>
                        <p>
                            <select name="empleados" size="1" id="empleados" >
                            </select>
                        </p>
                        <p>
                            <input type="button" name="button" id="button" value="Seleccionar" onclick="js_agrupamiento_alegajo()"/>
                        </p>
                        <p>Legajo        </p>
                        <p>
                            <label>
                                <input type="text" name="legajo" id="legajo" />
                            </label>
                        </p>
                        <hr color="#E3E3E3"/>
                        <p>Agrupamiento        </p>
                        <p>
                            <select name="agrupamiento" size="1" id="agrupamiento" onclick="js_tramo_alegajo()">
                            </select>
                        </p>
                        <p>Tramo</p>
                        <p>
                            <select name="tramo" size="1" id="tramo" onclick="js_categoria_alegajo()">
                            </select>
                        </p>
                        <p>Categoria</p>
                        <p>
                            <select name="categoria" size="1" id="categoria" onclick="js_clase_alegajo()">
                            </select>
                        </p>
                        <p>Clase</p>
                        <p>
                            <select name="clase" size="1" id="categoria" >
                            </select>
                        </p>
                        <p>&nbsp;</p>
                        <p>
                            <input type="button" name="buttonActualizar" id="buttonActualizar" value="Actualizar" onclick="js_save_alegajo()"/>
                        </p>
                        <p>
                            <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar" onclick="js_cancel_operacion()"/>
                        </p>
                    </form>
                </div>
                <div class="derecha"></div>
            </div>
        </div>
    </body>
</html>
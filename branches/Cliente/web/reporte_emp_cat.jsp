<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Home</title>
    </head>

    <body>
        <div id="noticias_2"> Informes Empleados Por Categoria<br />
            <div class="forms">
                <div class="izquierda"><br />
                    <form id="form1" name="form1" method="post" action="" >
                        <p>Seleccionar Categoria a Listar</p>
                        <p>Agrupamiento </p>
                        <p>
                            <select name="agrupamiento" size="1" id="agrupamiento" onchange="js_lista_tramo_rpec()">
                            </select>
                        </p>
                        <p>Tramo</p>
                        <p>
                            <select name="tramo" size="1" id="tramo" onchange="js_lista_categoria_rpec()">
                            </select>
                        </p>
                        <p>Categoria</p>
                        <p>
                            <select name="categoria" size="1" id="categoria">
                            </select>
                        </p>

                        <p>&nbsp;</p>
                        <p>
                            <input type="button" name="buttonActualizar" id="btnImpRepor1" value="Imprimir" onclick="javascript:"/>
                        </p>
                        <p>
                            <input type="button" name="buttonActualizar" id="btnImpRepor2" value="Imprimir Todos" onclick="js_imprimir_todo_rpec()"/>
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
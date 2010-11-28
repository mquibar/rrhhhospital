<link href="./css/estilos.css" rel="stylesheet" type="text/css" />

<div class="noticias" id="noticias_2">Consultar Personal<br />
            <div class="forms">
                <div align="left"></div>
                <div class="izquierda">
                    <div align="left"><br />
                    </div>
                    <form id="form1" name="form1" method="post" action="">
                        <p align="left">EMPLEADO<br />
                        Nombre<br />
                            <label>
                                <input type="text" name="nombre" id="nombre" />
                            </label>
                            <br />
                            <br />
                        Apellido<br />
                            <input type="text" name="apellido" id="apellido" />
                        </p>
                        <p align="left">
                            <label>
                                <input type="button" name="buttonConsultar" id="buttonConsultar" onclick="consultarEmpleado()" value="Buscar"/>
                            </label>
                            <label>
                                <input type="button" name="buttonCancelar" id="buttonCancelar" value="Cancelar" onclick="js_cancel_operacion()" />
                            </label>
                        </p>
                        <p align="left">Empleado/s<br />
                            <select name="empleados" id="empleados" onchange="responderEmpleado()">
                                
                            </select>
                        </p>
                        <p align="left">Datos<br />
                            <label>
                                <textarea name="datos" id="datos" cols="45" rows="5"></textarea>
                            </label>
                            <br />
                            <br />
                            <br />
                        </p>
                    </form>
                </div>
            </div>
</div>

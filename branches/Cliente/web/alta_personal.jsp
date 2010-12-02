
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Alta Personal</title>
        <link href="./css/estilos.css" rel="stylesheet" type="text/css" />
        <script src="./tools/datepicker/datepickercontrol.js" type="text/javascript"></script>
        <script language="javascript" type="text/javascript" src="./js/createRequestJs.js"></script>
        <script language="javascript" type="text/javascript" src="./js/esperar.js"></script>
        <script language="javascript" type="text/javascript" src="./js/Personal.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validaciones.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesProfesional.js"></script>
        <script language="javascript" type="text/javascript" src="./js/validaciones/validacionesEmpleado.js"></script>
        <script language="javascript" type="text/javascript" src="./js/tools.js"></script>
        <script src="./tools/datepicker/datepickercontrol.js" type="text/javascript"></script>
        <link  href="./tools/datepicker/datepickercontrol.css" type="text/css" rel="stylesheet" />
        
    </head>

    <body onload="iniciarAltaPersonal()">
        <div class="noticias" id="noticias_2">Alta personal<br />
            <div class="forms">
                <form id="form1" name="form1" method="post" action="">
                    <div class="izquierda"><br />
			TIPO<br />
                        <br />
                        <select name="tipoEmpleado" size="1" id="tipoEmpleado" onchange="altaEspecifica ()">
                        </select>
                        <br />
                        <br />
			Nombre<br />
                        <label>
                            <input type="text" name="nombre" id="nombre"  />
                        </label>
                        <br />
                        <br />
			Apellido<br />
                        <label>
                            <input type="text" name="apellido" id="apellido"/>
                        </label>
                        <br />
                        <br />
			DNI<br />
                        <label>
                            <input type="text" name="dni" id="dni" />
                        </label>
                        <br />
                        <br />
			Fecha de nacimiento<br />
                        <label>
                            <input type="text" name="fechaNacimiento" id="DPC_edit1" />
                        </label>
                        <br />
                        <br />
			Teléfono<br />
                        <label>
                            <input type="text" name="telefono" id="telefono" />
                        </label>
                        <br />
                        <br />
			Matricula<br />
                        <label>
                            <input type="text" name="matricula" id="matricula"  />
                        </label>
                        <br />
                        <br />
			Cuil<br />
                        <label>
                            <input type="text" name="cuil" id="cuil"  />
                        </label>
                        <br />
                        <br />
			Título<br />
			<label>
			  <input type="text" name="titulo" id="titulo" />
			</label>
                        <br />
                        <br />
                  Numero Tarjeta<br />
                        <select name="ntarjeta" id="ntarjeta" >
                        </select>
                    </div>
                    <div class="derecha"><br />
		  DOMICILIO<br />
                        <br />
		  Calle<br />
                        <label>
                            <input type="text" name="calle" id="calle"/>
                        </label>
                        <br />
                        <br />
		  Numero<br />
                        <label>
                            <input type="text" name="numero" id="numero" />
                        </label>
                        <br />
                        <br />
		  Barrio<br />
                        <label>
                            <input type="text" name="barrio" id="barrio"  />
                        </label>
                        <br />
                        <br />
		  Piso<br />
                        <label>
                            <input type="text" name="piso" id="piso" />
                        </label>
                        <br />
                        <br />
		  Departamento<br />
                        <label>
                            <input type="text" name="departamento" id="departamento"  />
                        </label>
                        <br />
                        <br />
		  País<br />
                        <select name="pais" id="pais">
                        </select>
                        <br />
                        <br />
		  Provincia
                        <br />
                        <select name="provincia" id="provincia">
                        </select>
                        <br />
                        <br />
		  Localidad<br />
                        <select name="localidad" id="localidad" >
                        </select>
                        <br />
                    </div>
                    <div class="guardar">
                        <label>
                            <input type="button" name="buttonCancel" id="buttonCancel" onclick="js_cancel_operacion()" value="Cancelar" />
                        </label>
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>
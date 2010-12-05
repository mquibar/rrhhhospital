
        <div id="noticias_2"> Modificar Personal <br />
            <div class="forms">
                <form id="form1" name="form1" method="post" action="">
                    <div class="izquierda" style="height: 0px; width: 500px; padding-left: 200px;"><br />
			Seleccionar Empleado<br />
                        <br />
                        <select name="empleados" size="1" id="empleados" onchange="loadNuevaPagina()">
                        </select>
                        <br />
                        <label>
                            <input type="button" name="buttonTraer" id="buttonTraer" value="Consultar Empleado" onclick="loadPersonas()" />
                        </label>
                        <br />
			Nombre<br />
                        <label>
                            <input type="text" name="nombre" id="nombre" />
                        </label>
                        <br />
                        <br />
			Apellido<br />
                        <label>
                            <input type="text" name="apellido" id="apellido" />
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
                            <input type="text" name="fechaNacimiento" id="fechaNacimiento" />
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
                            <input type="text" name="matricula" id="matricula" />
                        </label>
                        <br />
                        <br />
			Cuil<br />
                        <label>
                            <input type="text" name="cuil" id="cuil" />
                        </label>
                    </div>
                    <div class="derecha" style="width: 900px;"><br />
		  Domicilio<br />
                        <br />
		  Calle<br />
                        <label>
                            <input type="text" name="calle" id="calle" />
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
                            <input type="text" name="barrio" id="barrio" />
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
                            <input type="text" name="departamento" id="departamento" />
                        </label>
                        <br />
                        <br />
		  Localidad<br />
                        <select name="localidad" id="localidad" >
                        </select>
                        <br />
                        <br />
		  Provincia
                        <br />
                        <select name="provincia" id="provincia" >
                        </select>
                        <br />
                        <br />
		  País<br />
                        <select name="pais" id="pais" >
                        </select>
                        <br />
                    </div>
                    <div class="guardar" style="width: 900px; heigth: 50px; padding-top: 150px;">
                        <label>
                            <input type="button" name="buttonCancel" id="buttonCancel" onclick="js_cancel_operacion()" value="Cancelar" />
                        </label>
                    </div>
                </form>

            </div>
        </div>


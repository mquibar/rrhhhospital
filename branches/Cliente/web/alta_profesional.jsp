<%@page import="controllers.ctrlConsultarDomicilio" %>
<%@page import="controllers.ctrlConsultarPersona" %>

<%

    ctrlConsultarDomicilio c = new ctrlConsultarDomicilio();
    ctrlConsultarPersona cp = new ctrlConsultarPersona();
    %>

    Alta Personal - Alta Profesional<br />
            <div class="forms">
                <form id="form1" name="form1" method="post" action="" >
                   <div class="izquierda" style="height: 0px; width: 500px; padding-left: 200px;"><br />
                        Datos Personales<br />
                        <br />
			Nombre<br />
                        <label><input type="text" name="nombre" id="nombre" /></label>
                        <br />
                        <br />
			Apellido<br />
                        <label><input type="text" name="apellido" id="apellido" /></label>
                        <br />
                        <br />
			Sexo<br /><select name="sexo" id="sexo" ><%= cp.listarSexo().toString()%></select>
                        <br />
                        <br />
			DNI<br />
                        <label><input type="text" name="dni" id="dni"  /></label>
                        <br />
                        <br />
			Fecha de nacimiento<br />
                        <label><input type="text" name="fechaNacimiento" id="DPC_edit1"   /></label>
                        <br />
                        <br />
			Teléfono<br />
                        <label><input type="text" name="telefono" id="telefono"  /></label>
                        <br />
                        <br />
			Matricula<br />
                        <label><input type="text" name="matricula" id="matricula"  /></label>
                        <br />
                        <br />
			Cuil<br />
                        <label><input type="text" name="cuil" id="cuil" /></label>
                        <br />
                        <br />
			Título<br />
			<label><input type="text" name="titulo" id="titulo" /></label>
                        <br />
                        <br />
                  Numero Tarjeta<br />
                  <select name="ntarjeta" id="ntarjeta" ><%= cp.listarTarjeta().toString()%></select>
                    </div>
                    <div class="derecha" style="width: 1450px;"><br />
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
                            <input type="text" name="barrio" id="barrio"  />
                        </label>
                        <br />
                        <br />
		  Piso<br />
                        <label>
                            <input type="text" name="piso" id="piso"  />
                        </label>
                        <br />
                        <br />
		  Departamento<br />
                        <label>
                            <input type="text" name="departamento" id="departamento" />
                        </label>
                        <br />
                        <br />
		  País<br />
                  <select name="pais" id="pais" >
                            <%= c.getPaises().toString()%>
                        </select>
                        <br />
                        <br />
		  Provincia
                        <br />
                        <select name="provincia" id="provincia" onchange="loadLocalidad()">
                             <%= c.getProvincia().toString()%>
                        </select>
                        <br />
                        <br />
		  Localidad<br />
                        <select name="localidad" id="localidad" >
                        </select>
                        <br />
                    </div>
                    <div class="guardar" style="width: 1500px; heigth: 50px; padding-top: 200px;">
                        <label>
                            <input type="button" name="buttonSave" id="buttonSave" value="Guardar" onclick="altaProfesional()" />
                        </label>
                        <label>
                            <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar" onclick="js_cancel_operacion()" />
                        </label>
                    </div>
                </form>

            </div>




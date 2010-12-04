        <div id="noticias_2"> Alta Legajo<br />

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
                            <select name="clase" size="1" id="clase" >
                            </select>
                        </p>
                        <p>&nbsp;</p>
                        <p>
                            <input type="button" name="buttonActualizar" id="buttonSave" value="Actualizar" onclick="js_save_alegajo()"/>
                        </p>
                        <p>
                            <input type="button" name="buttonCancel" id="buttonCancel" value="Cancelar" onclick="js_cancel_operacion()"/>
                        </p>
                    </form>
                </div>
                <div class="derecha"></div>
            </div>
        </div>

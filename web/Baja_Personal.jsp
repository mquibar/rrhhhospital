
<div id="noticias_2"> Baja Personal <br />
  <div class="forms">
    <div class="izquierda"><br />
      <br />
      EMPLEADO<br />
      <br />
      <select name="empleados" size="1" id="empleados" onchange="mostrarDatosParaDarBaja()">

      </select>
      <br />
      <br />
      <br />
      Datos<br />
      <label>
        <textarea name="datos" id="datos" cols="45" rows="5"></textarea>
      </label>
      <br />
      <br />
      <br />
      <label>
        <input type="button" name="Baja" id="button" value="Aceptar" onclick="darBaja()" />
      </label>
      <label>
          <input type="button" name="button2" id="button2" value="Cancelar" onclick="js_cancel_operacion()" />
      </label>
      <br />
      <br />
      <br />
    </div>
    <div class="derecha"></div>
  </div>
</div>

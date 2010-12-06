<% String base = "manejoHorarios/reporteHorario.jsp?tipoReporte=";
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div id="noticias_2"> Reportes Horarios<br />
  <div class="forms">
    <div class="izquierda">
      <p><a href="#" onclick="load('<%=base%>Cronograma_Asignado_por_Empleado','noticias');">
          Cronograma Asignado por Empleado</a></p>

      <p><a href="#" onclick="load('<%=base%>Informe_de_Asistencia_por_Empleado','noticias');">
          Informe de Asistencia por Empleado</a></p>

      <p><a href="#" onclick="load('<%=base%>Licencias_Concedidas_a_Empleado','noticias');">
          Licencias Concedidas a Empleado</a></p>

      <p>Cronograma de Horarios Asignados por Mes</p>
      <p>Resumen  de horas trabajadas y debidas por empleado</p>
      <p>Listado de empleados que no cumplen con horario asignado</p>
    </div>
    <div class="derecha"></div>
  </div>
</div>

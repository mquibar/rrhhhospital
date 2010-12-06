/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Expertos.horario.consultar.ExpConsultarAsignacionHorario;
import Expertos.horario.consultar.ExpConsultarLicencia;
import Expertos.horario.consultar.ExpConsultarRegistroPeriodo;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.reports.ExpReporteHorario;
import Tools.ManejaFechas;
import java.util.Date;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionAsignacionHorario;
import models.combos.ModelOptionEmpleado;
import models.combos.ModelOptionLicencia;
import models.combos.ModelOptionRegistroPeriodo;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author leoroot
 */
public class ctrlReporteHorario extends GeneralController
{
    private enum operaciones {
        Cronograma_Asignado_por_Empleado,
        Informe_de_Asistencia_por_Empleado,
        Licencias_Concedidas_a_Empleado,GUARDAR}


    ExpConsultarPersonal _expPers;
    ExpConsultarAsignacionHorario _expAH;
    ModelOptionEmpleado _mpers;

    public ctrlReporteHorario()
    {
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());

        try
        {
            _mpers = new ModelOptionEmpleado(_expPers.listarEmpleadoinOrder());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlReporteHorario: Error creando modelos: " + ex.toString());
        }

    }

    public List getEntidades(
            String idEmpleado,
            String fechaInicio,
            String fechaFin,
            String tipoReporte
            )
    {
       List ent = null;
       Empleado emp = getEmpleado(idEmpleado);
       Date fini = ManejaFechas.convertirString(fechaInicio);
       Date ffin =  ManejaFechas.convertirString(fechaFin);


        switch (operaciones.valueOf(tipoReporte)) {
            case Cronograma_Asignado_por_Empleado:
                ent = ((ExpConsultarAsignacionHorario) super.getExpert(ExpConsultarAsignacionHorario.class.getName())).informeCronograma(emp, fini,ffin);
                break;
            case Informe_de_Asistencia_por_Empleado:
                ent = ((ExpConsultarRegistroPeriodo) super.getExpert(ExpConsultarRegistroPeriodo.class.getName())).informeAsistencia(emp, fini,ffin);
                break;
            case Licencias_Concedidas_a_Empleado:
                ent = ((ExpConsultarLicencia) super.getExpert(ExpConsultarLicencia.class.getName())).informeLicencias(emp, fini,ffin);
                break;

        }
        
       System.out.println(
               "Generado reporte " + tipoReporte + " para empleado '" + emp.getApellido() +
               "' entre '" + fini + "' y '" + ffin + "': " +
               ent.size() + " registros");

       return ent;
    }

    public AbstractModelOptionList getOpcionesSelect(
            String idEmpleado,
            String fechaInicio,
            String fechaFin,
            String tipoReporte
        )
    {
        List ent = getEntidades(idEmpleado, fechaInicio, fechaFin, tipoReporte);
        
        switch (operaciones.valueOf(tipoReporte)) {
            case Cronograma_Asignado_por_Empleado:
                return new ModelOptionAsignacionHorario(ent);
            case Informe_de_Asistencia_por_Empleado:
                return new ModelOptionRegistroPeriodo(ent);
            case Licencias_Concedidas_a_Empleado:
                return new ModelOptionLicencia(ent);
            default:
                return null;
        }
    }

    public JasperPrint getReporteHorario(
            String idEmpleado,
            String fechaInicio,
            String fechaFin,
            String tipoReporte
            )
    {
       Empleado emp = getEmpleado(idEmpleado);
       Date fini = ManejaFechas.convertirString(fechaInicio);
       Date ffin =  ManejaFechas.convertirString(fechaFin);
       
       ExpReporteHorario exp = (ExpReporteHorario) super.getExpert(ExpReporteHorario.class.getName());
       return exp.getReporte(emp, fini, ffin, tipoReporte);
    }

    public String getOptionsEmpleado(String empleado)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";
        
        if(_mpers != null)
        {
            opt = _mpers.toString(empleado);
        }
        
        return  opt;
    }
    
    //Devuelve el id de combo
    public Empleado getEmpleado(String idEntidad)
    {
        return _mpers.getSelectedItem(idEntidad);
    }


}

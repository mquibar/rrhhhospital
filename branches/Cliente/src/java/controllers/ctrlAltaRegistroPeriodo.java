/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.horario.ExpAltaAsignacionHorario;
import Expertos.horario.ExpAltaRegistroPeriodo;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.horario.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionProfesional;
import models.combos.ModelOptionTipoHorario;

/**
 *
 * @author leoroot
 */
public class ctrlAltaRegistroPeriodo extends GeneralController
{
    ExpAltaRegistroPeriodo _expAlta;
    ExpConsultarPersonal _expPers;

    ModelOptionProfesional _mpers;

    public ctrlAltaRegistroPeriodo() {
        _expAlta = (ExpAltaRegistroPeriodo) super.getExpert(ExpAltaRegistroPeriodo.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());

       try
       {
            _mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
       }
       catch(Exception ex)
       {
           System.out.println("ctrlAltaRegistroPeriodo: Error creando modelos: " + ex.toString());
       }

    }

    public void iniciarAlta(
            String empleado,
            String fechaEntrada,
            String horaEntrada,
            String fechaSalida,
            String horaSalida,
            String vigente
            )
    {
         _expAlta.iniciarAlta(
             _mpers.getSelectedItem(empleado),
             ManejaFechas.convertirString(fechaEntrada),
             ManejaFechas.getHour(horaEntrada),
             ManejaFechas.convertirString(fechaSalida),
             ManejaFechas.getHour(horaSalida),
             true);
    }

    public String guardar() {return _expAlta.guardar();}
    
    public String getOptionsEmpleado(String empleado)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mpers != null)
        {
            opt = _mpers.toString(empleado);
        }

        return  opt;
    }


}

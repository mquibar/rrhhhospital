/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.ExpAltaAsignacionHorario;
import Expertos.ExpConsultarPersonal;
import Expertos.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionProfesional;
import models.combos.ModelOptionTipoHorario;

/**
 *
 * @author leoroot
 */
public class ctrlAltaAsignacionHorario extends GeneralController
{
    ExpAltaAsignacionHorario _expAlta;
    ExpConsultarTipoHorario _expTH;
    ExpConsultarPersonal _expPers;

    ModelOptionProfesional _mpers;
    ModelOptionTipoHorario _mth;

    public ctrlAltaAsignacionHorario() {
        _expAlta = (ExpAltaAsignacionHorario) super.getExpert(ExpAltaAsignacionHorario.class.getName());
        _expTH = (ExpConsultarTipoHorario) super.getExpert(ExpConsultarTipoHorario.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());

        _mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
        _mth = new ModelOptionTipoHorario(_expTH.listar());

    }

    public void iniciarAlta(
            String fechaInicio,
            String fechaFin,
            String idEmpleado,
            String idTipoHorario,
            String descripcion,
            String vigente
            )
    {
         /*_expAlta.iniciarAlta(
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             _mpers.getSelectedItem(idEmpleado),
             _mth.getSelectedItem(idTipoHorario),
             descripcion,
             true);*/
    }

    //public String guardar() {return _expAlta.guardar();}
    
    public String getOptionsEmpleado(String empleado)
    {
        return  _mpers.toString(empleado);
    }
    
    public String getOptionsTipoHorario(String tipoHorario)
    {
        return  _mth.toString(tipoHorario);
    }


}

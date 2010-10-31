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


    public ctrlAltaAsignacionHorario() {
        _expAlta = (ExpAltaAsignacionHorario) super.getExpert(ExpAltaAsignacionHorario.class.getName());
        _expTH = (ExpConsultarTipoHorario) super.getExpert(ExpConsultarTipoHorario.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
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
         _expAlta.iniciarAlta(
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             mpers.getSelectedItem(idEmpleado),
             mth.getSelectedItem(idTipoHorario),
             descripcion,
             true);
    }

    public String guardar() {return _expAlta.guardar();}

    ModelOptionProfesional mpers;
    public String getOptionsEmpleado(String empleado)
    {
        mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
        return  mpers.toString(empleado);
    }

    ModelOptionTipoHorario mth;
    public String getOptionsTipoHorario(String tipoHorario)
    {
        mth = new ModelOptionTipoHorario(_expTH.listar());
        return  mth.toString(tipoHorario);
    }


}

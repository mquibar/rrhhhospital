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
    ExpConsultarTipoHorario _expTH;
    ExpConsultarPersonal _expPers;

    ModelOptionProfesional _mpers;
    ModelOptionTipoHorario _mth;

    public ctrlAltaRegistroPeriodo() {
        _expAlta = (ExpAltaRegistroPeriodo) super.getExpert(ExpAltaRegistroPeriodo.class.getName());
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
//         _expAlta.iniciarAlta(
//             ManejaFechas.convertirString(fechaInicio),
//             ManejaFechas.convertirString(fechaFin),
//             _mpers.getSelectedItem(idEmpleado),
//             descripcion,
//             true);
    }

    public String guardar() {return _expAlta.guardar();}
    
    public String getOptionsEmpleado(String empleado)
    {
        return  _mpers.toString(empleado);
    }
    
    public String getOptionsTipoHorario(String tipoHorario)
    {
        return  _mth.toString(tipoHorario);
    }


}

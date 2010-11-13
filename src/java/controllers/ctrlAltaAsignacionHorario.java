/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.horario.ExpAltaAsignacionHorario;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.horario.ExpConsultarTipoHorario;
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

        try
        {
            _mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
            _mth = new ModelOptionTipoHorario(_expTH.listar());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlAltaAsignacionHorario: Error creando modelos: " + ex.toString());
        }

    }

    public String guardar(
            String idEntidad,
            String fechaInicio,
            String fechaFin,
            String idEmpleado,
            String idTipoHorario,
            String descripcion,
            String vigente
            )
    {
         _expAlta.iniciarAlta(
             idEntidad,
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             _mpers.getSelectedItem(idEmpleado),
             _mth.getSelectedItem(idTipoHorario),
             descripcion,
             true);

             return _expAlta.guardar();
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
    
    public String getOptionsTipoHorario(String tipoHorario)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mth != null)
        {
            opt = _mth.toString(tipoHorario);
        }

        return  opt;
    }


}

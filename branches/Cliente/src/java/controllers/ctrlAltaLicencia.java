/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.horario.ExpAltaLicencia;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.horario.ExpConsultarTipoLicencia;
import Tools.ManejaFechas;
import models.combos.ModelOptionProfesional;
import models.combos.ModelOptionTipoLicencia;

/**
 *
 * @author leoroot
 */
public class ctrlAltaLicencia extends GeneralController
{
    ExpAltaLicencia _expAlta;
    ExpConsultarTipoLicencia _expTL;
    ExpConsultarPersonal _expPers;

    ModelOptionProfesional _mpers;
    ModelOptionTipoLicencia _mtl;

    public ctrlAltaLicencia() {
        _expAlta = (ExpAltaLicencia) super.getExpert(ExpAltaLicencia.class.getName());
        _expTL = (ExpConsultarTipoLicencia) super.getExpert(ExpConsultarTipoLicencia.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());

        try
        {
            _mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
            _mtl = new ModelOptionTipoLicencia(_expTL.listar());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlAltaAsignacionHorario: Error creando modelos: " + ex.toString());
        }

    }

    public String guardar(
            String idEntidad,
            String idEmpleado,
            String idTipoLicencia,
            String fechaInicio,
            String fechaFin,
            String descripcion,
            String vigente
            )
    {
         _expAlta.iniciarAlta(
              idEntidad,
             _mpers.getSelectedItem(idEmpleado),
             _mtl.getSelectedItem(idTipoLicencia),
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             descripcion
             );

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
    
    public String getOptionsTipoLicencia(String tipoLicencia)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mtl != null)
        {
            opt = _mtl.toString(tipoLicencia);
        }

        return  opt;
    }


}

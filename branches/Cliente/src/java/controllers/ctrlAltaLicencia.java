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

        _mpers = new ModelOptionProfesional(_expPers.listarProfesionalinOrder());
        _mtl = new ModelOptionTipoLicencia(_expTL.listar());

    }

    public void iniciarAlta(
            String idEmpleado,
            String idTipoLicencia,
            String fechaInicio,
            String fechaFin,
            String descripcion,
            String vigente
            )
    {
         _expAlta.iniciarAlta(
             _mpers.getSelectedItem(idEmpleado),
             _mtl.getSelectedItem(idTipoLicencia),
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             descripcion
             );
    }

    public String guardar() {return _expAlta.guardar();}
    
    public String getOptionsEmpleado(String empleado)
    {
        return  _mpers.toString(empleado);
    }
    
    public String getOptionsTipoLicencia(String tipoLicencia)
    {
        return  _mtl.toString(tipoLicencia);
    }


}

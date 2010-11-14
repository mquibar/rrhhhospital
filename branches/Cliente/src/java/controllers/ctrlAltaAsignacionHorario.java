/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.AsignacionHorario;
import Entidades.TipoHorario;
import Expertos.horario.ExpAltaAsignacionHorario;
import Expertos.horario.ExpConsultarAsignacionHorario;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.horario.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionAsignacionHorario;
import models.combos.ModelOptionEmpleado;
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
    ExpConsultarAsignacionHorario _expAH;

    ModelOptionEmpleado _mpers;
    ModelOptionTipoHorario _mth;
    ModelOptionAsignacionHorario _mah;

    public ctrlAltaAsignacionHorario() {
            _expAlta = (ExpAltaAsignacionHorario) super.getExpert(ExpAltaAsignacionHorario.class.getName());
            _expTH = (ExpConsultarTipoHorario) super.getExpert(ExpConsultarTipoHorario.class.getName());
            _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
            _expAH = (ExpConsultarAsignacionHorario) super.getExpert(ExpConsultarAsignacionHorario.class.getName());

        try
        {
            _mpers = new ModelOptionEmpleado(_expPers.listarEmpleadoinOrder());
            _mth = new ModelOptionTipoHorario(_expTH.listar());
            _mah = new ModelOptionAsignacionHorario(_expAH.listar());
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
            String eliminado
            )
    {
         _expAlta.iniciarAlta(
             idNegocio(idEntidad),
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             _mpers.getSelectedItem(idEmpleado),
             _mth.getSelectedItem(idTipoHorario),
             descripcion,
             Boolean.parseBoolean(eliminado));

             return _expAlta.guardar();
    }

    String idNegocio(String idCombo)
    {
        AsignacionHorario th = getEntidad(idCombo);
        if(th == null)
        {
            return "";
        }
        else
        {
            return th.getId().toString();
        }
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

    public String getOptionsAsignacionHorario(String AsignacionHorario)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mah != null)
        {
            opt = _mah.toString(AsignacionHorario);
        }

        return  opt;
    }

    public TipoHorario getTipoHorarioSeleccionado(String idTipoHorario)
    {
        return _mth.getSelectedItem(idTipoHorario);
    }

    public String getFechaInicio(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFecha());
    }

    public String getFechaFin(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFecha());
    }

    //Devuelve el id de combo
    public String getEmpleado(String idEntidad)
    {
        return _mpers.getIdPresentacion(getEntidad(idEntidad).getIdEmpleado());
    }

    public String getTipoHorario(String idEntidad)
    {
        return _mth.getIdPresentacion(getEntidad(idEntidad).getIdTipoHorario());
    }

    public String getDescripcion(String idEntidad)
    {
        return getEntidad(idEntidad).getDescripcion();
    }

    public String getCombo()
    {
        return getOptionsAsignacionHorario("");
    }

    AsignacionHorario _ah = null;
    public AsignacionHorario getEntidad(String idEntidad)
    {
        if(_ah == null)
        {
            _ah = _mah.getSelectedItem(idEntidad);
        }

        return _ah;
    }

}

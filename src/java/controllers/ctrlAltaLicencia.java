/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Licencia;
import Expertos.horario.ExpAltaLicencia;
import Expertos.horario.consultar.ExpConsultarLicencia;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.horario.consultar.ExpConsultarTipoLicencia;
import Tools.ManejaFechas;
import models.combos.ModelOptionEmpleado;
import models.combos.ModelOptionLicencia;
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
    ExpConsultarLicencia _expL;

    ModelOptionEmpleado _mpers;
    ModelOptionTipoLicencia _mtl;
    ModelOptionLicencia _ml;

    public ctrlAltaLicencia() {
        _expAlta = (ExpAltaLicencia) super.getExpert(ExpAltaLicencia.class.getName());
        _expL = (ExpConsultarLicencia) super.getExpert(ExpConsultarLicencia.class.getName());
        _expTL = (ExpConsultarTipoLicencia) super.getExpert(ExpConsultarTipoLicencia.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());

        try
        {
            _ml = new ModelOptionLicencia(_expL.listar());
            _mtl = new ModelOptionTipoLicencia(_expTL.listar());
            _mpers = new ModelOptionEmpleado(_expPers.listarEmpleadoinOrder());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlAltaLicencia: Error creando modelos: " + ex.toString());
        }

    }

    public String guardar(
            String idEntidad,
            String idEmpleado,
            String idTipoLicencia,
            String fechaInicio,
            String fechaFin,
            String descripcion,
            String eliminada
            )
    {
         _expAlta.iniciarAlta(
             idNegocio(idEntidad),
             _mpers.getSelectedItem(idEmpleado),
             _mtl.getSelectedItem(idTipoLicencia),
             ManejaFechas.convertirString(fechaInicio),
             ManejaFechas.convertirString(fechaFin),
             descripcion, 
             Boolean.parseBoolean(eliminada));

            return _expAlta.guardar();
    }

    String idNegocio(String idCombo)
    {
        if(!idCombo.equals(""))
        {
            Licencia th = getEntidad(idCombo);
            if(th == null)
            {
                return "";
            }
            else
            {
                return th.getId().toString();
            }
        }
        else
        {
            return "";
        }
    }

    public String getOptionsEmpleado(String empleado)
    {
        System.out.println("ctrlAltaLicencia: getOptionsEmpleado...");
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mpers != null)
        {
            opt = _mpers.toString(empleado);
        }

        return  opt;
    }
    
    public String getOptionsTipoLicencia(String tipoLicencia)
    {
        System.out.println("ctrlAltaLicencia: getOptionsTipoLicencia...");
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mtl != null)
        {
            opt = _mtl.toString(tipoLicencia);
        }

        return  opt;
    }

    Licencia _ah = null;
    public Licencia getEntidad(String idEntidad)
    {
        if(_ah == null)
        {
            _ah = _ml.getSelectedItem(idEntidad);
        }

        return _ah;
    }

    public String getOptionsLicencia(String Licencia)
    {
        System.out.println("ctrlAltaLicencia: getOptionsLicencia...");
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_ml != null)
        {
            opt = _ml.toString(Licencia);
        }

        return  opt;
    }

    public String getCombo()
    {
        return getOptionsLicencia("");
    }

    public String getFechaInicio(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFechaInicio());
    }

    public String getFechaFin(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFechaFin());
    }

    public String getEmpleado(String idEntidad)
    {
        return _mpers.getIdPresentacion(getEntidad(idEntidad).getIdEmpleado());
    }

    public String getTipoLicencia(String idEntidad)
    {
        return _mtl.getIdPresentacion(getEntidad(idEntidad).getIdTipoLicencia());
    }

    public String getMotivo(String idEntidad)
    {
        return getEntidad(idEntidad).getMotivo();
    }

    public String getUrlModificar(String idEntidad)
    {
        return  "manejoHorarios/licencia_1.jsp?" +
               "idEntidad="+idEntidad+"&"+
               "empleado="+getEmpleado(idEntidad)+"&"+
               "tipoLicencia="+getTipoLicencia(idEntidad)+"&"+
               "fechaInicio="+getFechaInicio(idEntidad)+"&"+
               "fechaFin="+getFechaFin(idEntidad)+"&"+
               "motivo="+getMotivo(idEntidad);
    }

    public String getUrlEliminar(String idEntidad)
    {
        return getUrlModificar(idEntidad) + "&action=delete";
    }

}

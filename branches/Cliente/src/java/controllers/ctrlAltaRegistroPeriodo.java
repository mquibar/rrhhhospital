/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.RegistroPeriodo;
import Expertos.horario.ExpAltaRegistroPeriodo;
import Expertos.horario.consultar.ExpConsultarRegistroPeriodo;
import Expertos.personal.ExpConsultarPersonal;
import Tools.ManejaFechas;
import models.combos.ModelOptionEmpleado;
import models.combos.ModelOptionRegistroPeriodo;

/**
 *
 * @author leoroot
 */
public class ctrlAltaRegistroPeriodo extends GeneralController
{
    ExpAltaRegistroPeriodo _expAlta;
    ExpConsultarPersonal _expPers;
    ExpConsultarRegistroPeriodo _expRP;

    ModelOptionEmpleado _mpers;
    ModelOptionRegistroPeriodo _mrp;

    public ctrlAltaRegistroPeriodo() {
        _expAlta = (ExpAltaRegistroPeriodo) super.getExpert(ExpAltaRegistroPeriodo.class.getName());
        _expPers = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
        _expRP = (ExpConsultarRegistroPeriodo) super.getExpert(ExpConsultarRegistroPeriodo.class.getName());

       try
       {
            _mpers = new ModelOptionEmpleado(_expPers.listarEmpleadoinOrder());

            if(_expRP != null)
            {
                _mrp = new ModelOptionRegistroPeriodo(_expRP.listar());
            }
            else
            {
                System.out.println("ctrlAltaRegistroPeriodo: no se creo ExpConsultarRegistroPeriodo");
            }
       }
       catch(Exception ex)
       {
           System.out.println("ctrlAltaRegistroPeriodo: Error creando modelos: " + ex.toString());
       }

    }

    public String guardar(
            String idEntidad,
            String empleado,
            String fechaEntrada,
            String horaEntrada,
            String fechaSalida,
            String horaSalida,
            String eliminado
            )
    {
         _expAlta.iniciarAlta(
             idNegocio(idEntidad),
             _mpers.getSelectedItem(empleado),
             ManejaFechas.convertirString(fechaEntrada),
             ManejaFechas.getHour(horaEntrada),
             ManejaFechas.convertirString(fechaSalida),
             ManejaFechas.getHour(horaSalida),
             Boolean.parseBoolean(eliminado));

            return _expAlta.guardar();
    }

    String idNegocio(String idCombo)
    {
        if(!idCombo.equals(""))
        {
            RegistroPeriodo th = getEntidad(idCombo);
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
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mpers != null)
        {
            opt = _mpers.toString(empleado);
        }

        return  opt;
    }

    RegistroPeriodo _ah = null;
    public RegistroPeriodo getEntidad(String idEntidad)
    {
        if(_ah == null)
        {
            _ah = _mrp.getSelectedItem(idEntidad);
        }

        return _ah;
    }

    public String getFechaEntrada(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFechaEntrada());
    }

    public String getFechaSalida(String idEntidad)
    {
        return ManejaFechas.convertirDate(getEntidad(idEntidad).getFechaSalida());
    }

    public String getHoraEntrada(String idEntidad)
    {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraEntrada());
    }

    public String getHoraSalida(String idEntidad)
    {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraSalida());
    }

    public String getEmpleado(String idEntidad)
    {
        return _mpers.getIdPresentacion(getEntidad(idEntidad).getIdEmpleado());
    }

    public String getOptionsRegistroPeriodo(String RegistroPeriodo)
    {
        String opt = "<option>No Hay opciones disponibles</option>\n";

        if(_mrp != null)
        {
            opt = _mrp.toString(RegistroPeriodo);
        }

        return  opt;
    }

    public String getCombo()
    {
        return getOptionsRegistroPeriodo("");
    }

}

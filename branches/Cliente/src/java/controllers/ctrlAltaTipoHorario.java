/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.TipoHorario;
import Expertos.horario.ExpAltaTipoHorario;
import Expertos.horario.consultar.ExpConsultarTipoHorario;
import Tools.ManejaFechas;
import models.combos.ModelOptionTipoHorario;

/**
 *
 * @author leoroot
 */
public class ctrlAltaTipoHorario extends GeneralController {

    ExpAltaTipoHorario _expAlta;
    ExpConsultarTipoHorario _expTH;
    ModelOptionTipoHorario _mth;

    public ctrlAltaTipoHorario() {
        try {
            _expAlta = (ExpAltaTipoHorario) super.getExpert(ExpAltaTipoHorario.class.getName());
            _expTH = (ExpConsultarTipoHorario) super.getExpert(ExpConsultarTipoHorario.class.getName());
        } catch (Exception ex) {
            System.out.println("Error: No se pudo instanciar el experto: " + ex.getMessage());
        }

        try
        {
            _mth = new ModelOptionTipoHorario(_expTH.listar());
        }
        catch(Exception ex)
        {
            System.out.println("ctrlAltaTipoHorario: Error creando modelos: " + ex.toString());
        }

    }

    public String guardar(
            String idEntidad,
            String nombre,
            String descripcion,
            String horaEntrada,
            String horaSalida,
            String eliminado) {
        _expAlta.iniciarAlta(
                idNegocio(idEntidad),
                nombre,
                descripcion,
                ManejaFechas.getHour(horaEntrada),
                ManejaFechas.getHour(horaSalida),
                Boolean.parseBoolean(eliminado));

        return _expAlta.guardar();
    }

    String idNegocio(String idCombo) {
        TipoHorario th = getEntidad(idCombo);
        if (th == null) {
            return "";
        } else {
            return th.getId().toString();
        }
    }

    public String getHoraIngreso(String idEntidad) {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraIngreso());
    }

    public String getHoraSalida(String idEntidad) {
        return ManejaFechas.getHour(getEntidad(idEntidad).getHoraSalida());
    }

    public String getNombre(String idEntidad) {
        return getEntidad(idEntidad).getNombre();
    }

    public String getDescripcion(String idEntidad) {
        return getEntidad(idEntidad).getDescripcion();
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

    public TipoHorario getTipoHorarioSeleccionado(String idTipoHorario)
    {
        return _mth.getSelectedItem(idTipoHorario);
    }
    
    public String getCombo()
    {
        return getOptionsTipoHorario("");
    }

    TipoHorario _th = null;
    public TipoHorario getEntidad(String idEntidad) {
        if (_th == null) {
            _th = getTipoHorarioSeleccionado(idEntidad);
        }

        return _th;
    }

    public String getUrlModificar(String idEntidad)
    {
        return  "tipo_horario.jsp?" +
               "idEntidad="+idEntidad+"&"+
               "nombre="+getNombre(idEntidad)+"&"+
               "descripcion="+getDescripcion(idEntidad)+"&"+
               "horaEntrada="+getHoraIngreso(idEntidad)+"&"+
               "horaSalida="+getHoraSalida(idEntidad);
    }

    public String getUrlEliminar(String idEntidad)
    {
        return getUrlModificar(idEntidad) + "&action=delete";
    }

}

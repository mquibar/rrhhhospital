/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.TipoHorario;
import Expertos.horario.ExpAltaTipoHorario;
import Tools.ManejaFechas;

/**
 *
 * @author leoroot
 */
public class ctrlAltaTipoHorario extends GeneralController {

    ExpAltaTipoHorario _expAlta;

    public ctrlAltaTipoHorario() {
        try {
            _expAlta = (ExpAltaTipoHorario) super.getExpert(ExpAltaTipoHorario.class.getName());
        } catch (Exception ex) {
            System.out.println("Error: No se pudo instanciar el experto: " + ex.getMessage());
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

    public String getCombo() {
        return new ctrlAltaAsignacionHorario().getOptionsTipoHorario("");
    }
    TipoHorario _th = null;

    public TipoHorario getEntidad(String idEntidad) {
        if (_th == null) {
            _th = new ctrlAltaAsignacionHorario().getTipoHorarioSeleccionado(idEntidad);
        }

        return _th;
    }
}

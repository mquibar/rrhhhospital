/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Date;

/**
 *
 * @author Manuel
 */
public class DtoLicencia
{

    int _idEmpleado;

   public int getIdEmpleado() {
        return _idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this._idEmpleado = idEmpleado;
    }

    int _mes = 0;
    public int getMes() {
        return _mes;
    }

    public void setMes(int mes) {
        this._mes = mes;
    }

    private int _idTipoLicencia = 0;

    public int getIdTipoLicencia() {
        return _idTipoLicencia;
    }

    public void setIdTipoLicencia(int idTipoLicencia) {
        this._idTipoLicencia = idTipoLicencia;
    }
    private Date _fechaInicio = null;
    private Date _fechaFin = null;

    /**
     * @return the _fechaInicio
     */
    public Date getFechaInicio() {
        return _fechaInicio;
    }

    /**
     * @param fechaInicio the _fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this._fechaInicio = fechaInicio;
    }

    /**
     * @return the _fechaFin
     */
    public Date getFechaFin() {
        return _fechaFin;
    }

    /**
     * @param fechaFin the _fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this._fechaFin = fechaFin;
    }

}

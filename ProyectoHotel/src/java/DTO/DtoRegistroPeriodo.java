/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Manuel
 */
public class DtoRegistroPeriodo
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
}

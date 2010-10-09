/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Juan
 */
public class DTODomicilio {

    private String _provincia;
    private String _localidad;
    private String _pais;
    private String _calle;

    public String getCalle() {
        return _calle;
    }

    public void setCalle(String _calle) {
        this._calle = _calle;
    }

    public String getLocalidad() {
        return _localidad;
    }

    public void setLocalidad(String _localidad) {
        this._localidad = _localidad;
    }

    public String getPais() {
        return _pais;
    }

    public void setPais(String _pais) {
        this._pais = _pais;
    }

    public String getProvincia() {
        return _provincia;
    }

    public void setProvincia(String _provincia) {
        this._provincia = _provincia;
    }



}

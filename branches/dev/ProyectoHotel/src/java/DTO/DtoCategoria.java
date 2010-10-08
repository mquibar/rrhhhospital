/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Entidades.Tramo;

/**
 *
 * @author Manuel
 */
public class DtoCategoria {

    private String _nombre;
    private Tramo _tramo;

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Tramo getTramo() {
        return _tramo;
    }

    public void setTramo(Tramo _tramo) {
        this._tramo = _tramo;
    }

    
}

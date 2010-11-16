/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Entidades.ClaseVigente;

/**
 *
 * @author Desarrollo
 */
public class DtoClase {

    String _nombre=null;
    ClaseVigente _claseVigente = null;

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public ClaseVigente getClaseVigente() {
        return _claseVigente;
    }

    public void setClaseVigente(ClaseVigente _claseVigente) {
        this._claseVigente = _claseVigente;
    }
    
}

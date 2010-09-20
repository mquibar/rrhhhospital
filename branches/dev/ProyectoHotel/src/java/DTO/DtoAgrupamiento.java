/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Manuel
 */
public class DtoAgrupamiento {

    private String _nombre;

    public DtoAgrupamiento(String _nombre) {
        this._nombre = _nombre;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }
    
}

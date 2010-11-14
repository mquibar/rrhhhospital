/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Entidades.Provincia;

/**
 *
 * @author MARIANO
 */
public class DtoLocalidades {

    private String nombre=null;
    private Provincia provincia=null;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }


}

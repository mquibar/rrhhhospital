/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Entidades.Agrupamiento;

/**
 *
 * @author Manuel
 */
public class DtoTramo {

    private String nombre=null;
    private Agrupamiento agrupamiento=null;

    public Agrupamiento getAgrupamiento() {
        return agrupamiento;
    }

    public void setAgrupamiento(Agrupamiento agrupamiento) {
        this.agrupamiento = agrupamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Entidades.Agrupamiento;
import Entidades.Categoria;

/**
 *
 * @author Manuel
 */
public class DtoTramo {

    private String nombre=null;
    private Agrupamiento agrupamiento=null;
    private Categoria categoria = null;
    private boolean eliminado = false;

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}

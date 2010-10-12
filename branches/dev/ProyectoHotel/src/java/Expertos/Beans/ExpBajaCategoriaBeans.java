/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Categoria;
import Entidades.ClaseVigente;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioCategoria;
import java.util.List;

/**
 *
 * @author desarrollo
 */
public class ExpBajaCategoriaBeans {

    public List<Categoria> iniciarBaja(){
        return (new IntermediarioCategoria()).findAll();
    }

    public boolean eliminarCategoria(Categoria categoria)throws ExcepcionBajaCategoria{

        boolean eliminado = false;
        for (ClaseVigente cvgte : categoria.getClaseVigenteList()) {
            if(cvgte.getVigente())
                throw new ExcepcionBajaCategoria();
        }
        categoria.setEliminado(true);

        try {
            GestorConeccion.getInstance().beginTransaction();
            eliminado = (new IntermediarioCategoria()).actualizar(categoria);
            if(eliminado)
                GestorConeccion.getInstance().commitTransaction();
            else
                GestorConeccion.getInstance().rollbackTransaction();

        } catch (Exception e) {
            eliminado = false;
        }

        return eliminado;
    }
}

class ExcepcionBajaCategoria extends Exception{


    public ExcepcionBajaCategoria() {
        super("La Categoria no puede ser eliminada por la existencia personal " +
                "relaciondo a dicha categoria");
    }

}
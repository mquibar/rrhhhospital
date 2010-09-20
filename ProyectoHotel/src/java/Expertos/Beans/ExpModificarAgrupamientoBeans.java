/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAgrupamiento;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class ExpModificarAgrupamientoBeans {

    private Agrupamiento _agrupamiento;

    public List<Agrupamiento> inicioModificacion(){
        return (new IntermediarioAgrupamiento()).findInOrden("nombre");
    }

    public boolean cambiarNombre( Agrupamiento agrupamiento, String nombre){

        if( (new ExpConsultarCategoriaBeans()).consultarAgrupamientoByNombre(nombre) !=null )
            return false;
        agrupamiento.setNombre(nombre);
        try{
            GestorConeccion.getInstance().beginTransaction();
            if( (new IntermediarioAgrupamiento()).actualizar(agrupamiento) ){
                GestorConeccion.getInstance().commitTransaction();
                return true;
            }
            else{
                GestorConeccion.getInstance().rollbackTransaction();
                return false;
            }

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }

    }

}

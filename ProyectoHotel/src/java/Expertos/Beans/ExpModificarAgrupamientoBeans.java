/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Entidades.Tramo;
import Expertos.ExpModificarAgrupamiento;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioTramo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpModificarAgrupamientoBeans implements ExpModificarAgrupamiento{

    private Agrupamiento _agrupamiento;

    public List<Agrupamiento> inicioModificacion(){
        return new ArrayList<Agrupamiento>((new IntermediarioAgrupamiento()).findInOrden("nombre"));
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

    public boolean agregarTramo(Agrupamiento agrupamiento, String nombreTramo){
        if( (new ExpConsultarCategoriaBeans()).consultarTramoByNombre(nombreTramo) != null)
            return false;
        Tramo tramo = new Tramo();
        tramo.setNombre(nombreTramo);
        tramo.setAgrupamiento(agrupamiento);
        try{
            GestorConeccion.getInstance().beginTransaction();
            if( (new IntermediarioTramo()).guardar(tramo)){
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

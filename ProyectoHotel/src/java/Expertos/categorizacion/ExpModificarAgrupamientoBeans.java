/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Tramo;
import Expertos.categorizacion.ExpModificarAgrupamiento;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioTramo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpModificarAgrupamientoBeans implements ExpModificarAgrupamiento{

    private Agrupamiento _agrupamiento;

    @EJB
    Expertos.categorizacion.ExpConsultarCategoria _expertoConsulta;
    
    public List<Agrupamiento> inicioModificacion(){
        return new ArrayList<Agrupamiento>((new IntermediarioAgrupamiento()).findInOrden("nombre"));
    }

    public boolean cambiarNombre( Agrupamiento agrupamiento, String nombre){

        if( _expertoConsulta.consultarAgrupamientoByNombre(nombre) !=null )
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
        nombreTramo= nombreTramo.toUpperCase();
        if( _expertoConsulta.consultarTramoByNombre(agrupamiento, nombreTramo) != null)
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

    public List<Tramo> consultarTramos(Agrupamiento agrupamiento){
        return _expertoConsulta.consultaTramo(agrupamiento);
    }

    public List<Categoria> consultarCategoria(Tramo tramo){
        return _expertoConsulta.consultarCategoria(tramo);
    }
}

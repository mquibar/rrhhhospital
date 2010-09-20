/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Expertos.ExpAltaAgrupamiento;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAgrupamiento;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaAgrupamientoBeans implements ExpAltaAgrupamiento {

    private Agrupamiento _agrupamiento;

    public ExpAltaAgrupamientoBeans() {
        _agrupamiento = new Agrupamiento();
    }

    public boolean guardarNuevo(String nombre){
        boolean resultado = false;
        if((new ExpConsultarCategoriaBeans()).consultarAgrupamientoByNombre(nombre) != null)
            return resultado;
        GestorConeccion.getInstance().beginTransaction();
        try{
            if( (new IntermediarioAgrupamiento()).guardar(_agrupamiento) ){
                resultado = true;
                GestorConeccion.getInstance().commitTransaction();
            }
            else{
                resultado = false;
                GestorConeccion.getInstance().rollbackTransaction();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            resultado = false;
        }
        return resultado;
    }
}

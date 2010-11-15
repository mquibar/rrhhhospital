/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Intermediarios.GestorConeccion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author MARIANO
 */

@Stateless
public class ExpBajaEmpleadoBeans implements ExpBajaEmpleado {

    public ExpBajaEmpleadoBeans() {
    }

    /**
     * Lista los empleados del hospital
     *
     * @return: Hash map de los empleados del hospital
     */
    public Map<String, List> listarEmpleados(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("EMPLEADO", (new Intermediarios.IntermediarioEmpleado()).findAll());
        return lista;
    }


    /**
     * Realiza la baja del empleado determinado, el cual es pasado por parametro
     *
     * @param empleado: empleado a ser dado de baja
     * @return: true, si el empleado fue dado de baja exitosamente
     */
   public boolean darBajaEmpleado (Empleado empleado) {

       empleado.setEliminado(true);

       try{
            GestorConeccion.getInstance().beginTransaction();
            if( (new Intermediarios.IntermediarioEmpleado()).actualizar(empleado) ){
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

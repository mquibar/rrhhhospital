/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
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

   public Map<String, List> listarEmpleados(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("EMPLEADO", (new Intermediarios.IntermediarioEmpleado()).findAll());
        return lista;
    }

   public boolean darBajaEmpleado (Empleado empleado) {

       empleado.setEliminado(Boolean.TRUE);

       return (new Intermediarios.IntermediarioEmpleado()).actualizar(empleado);
   }

}

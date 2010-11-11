/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.personal.ExpModificarEmpleado;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */

@Stateless
public class ExpModificarEmpleadoBeans extends ExpModificarPersonaBeans implements ExpModificarEmpleado {

    public ExpModificarEmpleadoBeans() {
    }
    
    public List<Empleado> listarEmpleados(){
        return ((new Intermediarios.IntermediarioEmpleado()).findAll());
    }
    
    public boolean modificarEmpleado (Empleado empleado, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo Sexo, String cuil) {
        
            empleado.setCuil(cuil);
            return super.modificarDatosPersonales(empleado, nombre, apellido, dni, fechaNacimiento, 
                    telefono, barrio, calle, numero, piso, departamanto, localidad, provincia, pais, Sexo);
            
            
            
            
            
        
    }



}

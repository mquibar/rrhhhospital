/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.ExpAltaEmpleado;
import Intermediarios.IntermediarioEmpleado;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAltaEmpleadoBeans extends ExpAltaPersonalBeans implements ExpAltaEmpleado {

    public ExpAltaEmpleadoBeans() {
        _persona = new Empleado();
    }

    public void agregarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean iniciarAlta(String nombre, String apellido, String dni, Date fechaNacimiento,
            long telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo Sexo, String cuil) {

        ((Empleado) _persona).setCuil(cuil);
        ((Empleado) _persona).setFechaIngreso(new Date());
        
        return super.iniciarAlta(nombre, apellido, dni, fechaNacimiento, telefono, barrio,
                calle, numero, piso, departamanto, localidad, provincia, pais, Sexo);
    }

    public boolean agregarLegajo(Empleado empleado, int legajo) {
        empleado.setLegajo(legajo);
        return (new IntermediarioEmpleado()).actualizar(empleado);
    }

}
